package cn.edu.cqu.CRM.Service.ServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.cqu.CRM.Dao.BuyInfoMapper;
import cn.edu.cqu.CRM.Dao.CustomerMapper;
import cn.edu.cqu.CRM.Dao.MaintainInfoMapper;
import cn.edu.cqu.CRM.Dao.RepairInfoMapper;
import cn.edu.cqu.CRM.Pojo.BuyInfo;
import cn.edu.cqu.CRM.Pojo.BuyInfoExample;
import cn.edu.cqu.CRM.Pojo.BuyInfoExample.Criteria;
import cn.edu.cqu.CRM.Pojo.Customer;
import cn.edu.cqu.CRM.Pojo.CustomerExample;
import cn.edu.cqu.CRM.Service.UserService;
import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@Component
public class UserServiceImpl implements UserService {

	private final String DATABASE_ERR = "数据库出错";

	@Autowired
	CustomerMapper customerMapper;
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

}
