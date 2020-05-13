package cn.edu.cqu.CRM.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.cqu.CRM.Dao.EmployeeInfoMapper;
import cn.edu.cqu.CRM.Dao.EmployeeMapper;
import cn.edu.cqu.CRM.Dao.EmployeePermissionMapper;
import cn.edu.cqu.CRM.Dao.UserTypeMapper;
import cn.edu.cqu.CRM.Pojo.Employee;
import cn.edu.cqu.CRM.Pojo.EmployeeExample;
import cn.edu.cqu.CRM.Pojo.EmployeeInfo;
import cn.edu.cqu.CRM.Pojo.EmployeeInfoExample;
import cn.edu.cqu.CRM.Pojo.EmployeePermission;
import cn.edu.cqu.CRM.Pojo.EmployeePermissionExample;
import cn.edu.cqu.CRM.Pojo.UserType;
import cn.edu.cqu.CRM.Pojo.UserTypeExample;
import cn.edu.cqu.CRM.Service.AdminService;
import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@Component
public class AdminServiceImpl implements AdminService {

	private final String DATABASE_ERR = "数据库出错";

	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	EmployeeInfoMapper employeeInfoMapper;
	@Autowired
	UserTypeMapper userTypeMapper;
	@Autowired
	EmployeePermissionMapper employeePermissionMapper;

	private Employee employeeViewToTable(EmployeeInfo employeeInfo) {
		Employee employee = new Employee();
		if (employeeInfo.getEmployeeName() != null)
			employee.setEmployeeName(employeeInfo.getEmployeeName());
		if (employeeInfo.getEmployeeTel() != null)
			employee.setEmployeeTel(employeeInfo.getEmployeeTel());
		if (employeeInfo.getEmployeeId() != null)
			employee.setEmployeeId(employeeInfo.getEmployeeId());
		try {
			if (employeeInfo.getUserTypeName() != null) {
				UserTypeExample userTypeExample = new UserTypeExample();
				userTypeExample.or().andUserTypeNameEqualTo(employeeInfo.getUserTypeName());
				List<UserType> userTypes = userTypeMapper.selectByExample(userTypeExample);
				if (userTypes.size() == 0) {
					System.err.println("数据库 UserType 表出错");
					return null;
				}
				employee.setUserTypeId(userTypes.get(0).getUserTypeId());
			}

			if (employeeInfo.getPermissionName() != null) {
				EmployeePermissionExample employeePermissionExample = new EmployeePermissionExample();
				employeePermissionExample.or().andPermissionNameEqualTo(employeeInfo.getPermissionName());
				List<EmployeePermission> employeePermissions = employeePermissionMapper
						.selectByExample(employeePermissionExample);
				if (employeePermissions.size() == 0) {
					System.err.println("数据库 EmployeePermission 表出错");
					return null;
				}
				employee.setPermissionId(employeePermissions.get(0).getPermissionId());
			}
			return employee;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public MyJson signup(EmployeeInfo employeeInfo, String employeeAccount) {
		Employee employee = employeeViewToTable(employeeInfo);
		employee.setEmployeeAccount(employeeAccount);
		employee.setEmployeePassword("123456");
		try {
			employeeMapper.insert(employee);
			return new MyJson("注册成功");
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

	@Override
	public MyJson getEmployees(int pageNum, int pageSize, String employeeName) {
		EmployeeInfoExample employeeInfoExample = new EmployeeInfoExample();
		if (employeeName == null) {
			// 查询全部员工信息
			employeeInfoExample.or();
		} else {
			employeeInfoExample.or().andEmployeeNameLike("%" + employeeName + "%");
		}
		try {
			PageHelper.startPage(pageNum, pageSize);
			PageInfo<EmployeeInfo> pageInfo = new PageInfo<EmployeeInfo>(
					employeeInfoMapper.selectByExample(employeeInfoExample));
			return new MyJson(pageInfo);
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

	@Override
	public MyJson getAllUserTypes() {
		UserTypeExample userTypeExample = new UserTypeExample();
		userTypeExample.or();
		try {
			return new MyJson(userTypeMapper.selectByExample(userTypeExample));
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

	@Override
	public MyJson getAllEmployeePermissions() {
		EmployeePermissionExample employeePermissionExample = new EmployeePermissionExample();
		employeePermissionExample.or();
		try {
			return new MyJson(employeePermissionMapper.selectByExample(employeePermissionExample));
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

	@Override
	public MyJson updateEmployeeInfo(EmployeeInfo employeeInfo) {
		Employee employee = employeeViewToTable(employeeInfo);
		EmployeeExample employeeExample = new EmployeeExample();
		employeeExample.or().andEmployeeIdEqualTo(employee.getEmployeeId());
		try {
			employeeMapper.updateByExampleSelective(employee, employeeExample);
			return new MyJson("更新成功");
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

}
