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

	@Override
	public MyJson signup(EmployeeInfo employeeInfo, String employeeAccount) {
		Employee employee = new Employee();
		employee.setEmployeeAccount(employeeAccount);
		employee.setEmployeeName(employeeInfo.getEmployeeName());
		employee.setEmployeeTel(employeeInfo.getEmployeeTel());
		employee.setEmployeePassword("00000");
		UserTypeExample userTypeExample = new UserTypeExample();
		userTypeExample.or().andUserTypeNameEqualTo(employeeInfo.getUserTypeName());
		EmployeePermissionExample employeePermissionExample = new EmployeePermissionExample();
		employeePermissionExample.or().andPermissionNameEqualTo(employeeInfo.getPermissionName());
		try {
			List<UserType> userTypes = userTypeMapper.selectByExample(userTypeExample);
			if (userTypes.size() == 0) {
				return new MyJson(false, "不存在的用户类型");
			}
			List<EmployeePermission> employeePermissions = employeePermissionMapper
					.selectByExample(employeePermissionExample);
			if (employeePermissions.size() == 0) {
				return new MyJson(false, "不存在的用户权限");
			}
			employee.setUserTypeId(userTypes.get(0).getUserTypeId());
			employee.setPermissionId(employeePermissions.get(0).getPermissionId());
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

}
