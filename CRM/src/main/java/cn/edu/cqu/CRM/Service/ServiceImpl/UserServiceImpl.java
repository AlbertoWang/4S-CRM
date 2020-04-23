package cn.edu.cqu.CRM.Service.ServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.cqu.CRM.Dao.BuyInfoMapper;
import cn.edu.cqu.CRM.Dao.BuyRecordMapper;
import cn.edu.cqu.CRM.Dao.CustomerMapper;
import cn.edu.cqu.CRM.Dao.EmployeeMapper;
import cn.edu.cqu.CRM.Dao.MaintainInfoMapper;
import cn.edu.cqu.CRM.Dao.MaintainRecordMapper;
import cn.edu.cqu.CRM.Dao.RepairInfoMapper;
import cn.edu.cqu.CRM.Dao.RepairRecordMapper;
import cn.edu.cqu.CRM.Pojo.BuyInfo;
import cn.edu.cqu.CRM.Pojo.BuyInfoExample;
import cn.edu.cqu.CRM.Pojo.BuyInfoExample.Criteria;
import cn.edu.cqu.CRM.Pojo.BuyRecord;
import cn.edu.cqu.CRM.Pojo.Customer;
import cn.edu.cqu.CRM.Pojo.CustomerExample;
import cn.edu.cqu.CRM.Pojo.Employee;
import cn.edu.cqu.CRM.Pojo.EmployeeExample;
import cn.edu.cqu.CRM.Pojo.MaintainInfo;
import cn.edu.cqu.CRM.Pojo.MaintainInfoExample;
import cn.edu.cqu.CRM.Pojo.MaintainRecord;
import cn.edu.cqu.CRM.Service.UserService;
import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@Component
public class UserServiceImpl implements UserService {

	private final String DATABASE_ERR = "数据库出错";

	@Autowired
	CustomerMapper customerMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	BuyRecordMapper buyRecordMapper;
	@Autowired
	MaintainRecordMapper maintainRecordMapper;
	@Autowired
	RepairRecordMapper repairRecordMapper;
	@Autowired
	BuyInfoMapper buyInfoMapper;
	@Autowired
	MaintainInfoMapper maintainInfoMapper;
	@Autowired
	RepairInfoMapper repairInfoMapper;

	@Override
	public MyJson getCustomers(int pageNum, int pageSize, Long customerTel) {
		CustomerExample customerExample = new CustomerExample();
		if (customerTel == null) {
			// 未输入客户手机号
			customerExample.or();
		} else {
			customerExample.or().andCustomerTelEqualTo(customerTel);
		}
		try {
			PageHelper.startPage(pageNum, pageSize);
			PageInfo<Customer> pageInfo = new PageInfo<Customer>(customerMapper.selectByExample(customerExample));
			return new MyJson(pageInfo);
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public MyJson getBuyInfos(int pageNum, int pageSize, Long customerTel, String employeeName, Date recordDay) {
		BuyInfoExample buyInfoExample = new BuyInfoExample();
		Criteria criteria = buyInfoExample.createCriteria();
		if (customerTel != null) {
			// 已输入客户手机号
			criteria.andCustomerTelEqualTo(customerTel);
		}
		if (employeeName != null) {
			// 已输入员工姓名
			criteria.andEmployeeNameLike("%" + employeeName + "%");
		}
		if (recordDay != null) {
			// 已输入日期
			criteria.andRecordTimeBetween(
					new Date(recordDay.getYear(), recordDay.getMonth(), recordDay.getDate(), 0, 0, 0),
					new Date(recordDay.getYear(), recordDay.getMonth(), recordDay.getDate(), 23, 59, 59));
		}
		buyInfoExample.or(criteria);
		try {
			PageHelper.startPage(pageNum, pageSize);
			PageInfo<BuyInfo> pageInfo = new PageInfo<BuyInfo>(buyInfoMapper.selectByExample(buyInfoExample));
			return new MyJson(pageInfo);
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

	@Override
	public MyJson addBuyInfo(BuyInfo buyInfo) {
		// 员工是否存在
		EmployeeExample employeeExample = new EmployeeExample();
		employeeExample.or().andEmployeeNameEqualTo(buyInfo.getEmployeeName())
				.andEmployeeTelEqualTo(buyInfo.getEmployeeTel());
		// 客户是否存在
		CustomerExample customerExample = new CustomerExample();
		customerExample.or().andCustomerNameEqualTo(buyInfo.getCustomerName())
				.andCustomerTelEqualTo(buyInfo.getCustomerTel());
		BuyRecord buyRecord = new BuyRecord();
		buyRecord.setCarType(buyInfo.getCarType());
		buyRecord.setRecordItem(buyInfo.getRecordItem());
		buyRecord.setRecordTime(new Date());
		try {
			List<Employee> employees = employeeMapper.selectByExample(employeeExample);
			if (employees.size() == 0) {
				// 员工不存在, 报错
				return new MyJson(false, "不存在的员工");
			} else {
				// 员工存在, 插入外键
				buyRecord.setEmployeeId(employees.get(0).getEmployeeId());
				buyRecord.setEmployeeAccount(employees.get(0).getEmployeeAccount());
			}
			List<Customer> customers = customerMapper.selectByExample(customerExample);
			if (customers.size() == 0) {
				// 客户不存在, 插入新客户数据
				Customer customer = new Customer();
				customer.setCustomerName(buyInfo.getCustomerName());
				customer.setCustomerAddress(buyInfo.getCustomerAddress());
				customer.setCustomerGender(buyInfo.getCustomerGender());
				customer.setCustomerTel(buyInfo.getCustomerTel());
				// 并插入外键
				customers = customerMapper.selectByExample(customerExample);
				buyRecord.setCustomerId(customers.get(0).getCustomerId());
			} else {
				// 客户存在, 插入外键
				buyRecord.setCustomerId(customers.get(0).getCustomerId());
			}
			// 插入数据
			buyRecordMapper.insert(buyRecord);
			return new MyJson("操作成功");
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public MyJson getMaintainInfos(int pageNum, int pageSize, Long customerTel, String employeeName, Date recordDay) {
		MaintainInfoExample maintainInfoExample = new MaintainInfoExample();
		cn.edu.cqu.CRM.Pojo.MaintainInfoExample.Criteria criteria = maintainInfoExample.createCriteria();
		if (customerTel != null) {
			// 已输入客户手机号
			criteria.andCustomerTelEqualTo(customerTel);
		}
		if (employeeName != null) {
			// 已输入员工姓名
			criteria.andEmployeeNameLike("%" + employeeName + "%");
		}
		if (recordDay != null) {
			// 已输入日期
			criteria.andRecordTimeBetween(
					new Date(recordDay.getYear(), recordDay.getMonth(), recordDay.getDate(), 0, 0, 0),
					new Date(recordDay.getYear(), recordDay.getMonth(), recordDay.getDate(), 23, 59, 59));
		}
		maintainInfoExample.or(criteria);
		try {
			PageHelper.startPage(pageNum, pageSize);
			PageInfo<MaintainInfo> pageInfo = new PageInfo<MaintainInfo>(
					maintainInfoMapper.selectByExample(maintainInfoExample));
			return new MyJson(pageInfo);
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

	@Override
	public MyJson addMaintainInfo(MaintainInfo maintainInfo) {
		// 员工是否存在
		EmployeeExample employeeExample = new EmployeeExample();
		employeeExample.or().andEmployeeNameEqualTo(maintainInfo.getEmployeeName())
				.andEmployeeTelEqualTo(maintainInfo.getEmployeeTel());
		// 客户是否存在
		CustomerExample customerExample = new CustomerExample();
		customerExample.or().andCustomerNameEqualTo(maintainInfo.getCustomerName())
				.andCustomerTelEqualTo(maintainInfo.getCustomerTel());
		MaintainRecord maintainRecord = new MaintainRecord();
		maintainRecord.setCarType(maintainInfo.getCarType());
		maintainRecord.setRecordItem(maintainInfo.getRecordItem());
		maintainRecord.setRecordTime(new Date());
		try {
			List<Employee> employees = employeeMapper.selectByExample(employeeExample);
			if (employees.size() == 0) {
				// 员工不存在, 报错
				return new MyJson(false, "不存在的员工");
			} else {
				// 员工存在, 插入外键
				maintainRecord.setEmployeeId(employees.get(0).getEmployeeId());
				maintainRecord.setEmployeeAccount(employees.get(0).getEmployeeAccount());
			}
			List<Customer> customers = customerMapper.selectByExample(customerExample);
			if (customers.size() == 0) {
				// 客户不存在, 插入新客户数据
				Customer customer = new Customer();
				customer.setCustomerName(maintainInfo.getCustomerName());
				customer.setCustomerAddress(maintainInfo.getCustomerAddress());
				customer.setCustomerGender(maintainInfo.getCustomerGender());
				customer.setCustomerTel(maintainInfo.getCustomerTel());
				// 并插入外键
				customers = customerMapper.selectByExample(customerExample);
				maintainRecord.setCustomerId(customers.get(0).getCustomerId());
			} else {
				// 客户存在, 插入外键
				maintainRecord.setCustomerId(customers.get(0).getCustomerId());
			}
			maintainRecordMapper.insert(maintainRecord);
			return new MyJson("操作成功");
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

}
