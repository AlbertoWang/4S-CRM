package cn.edu.cqu.CRM.Service.ServiceImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.edu.cqu.CRM.Dao.EmployeeMapper;
import cn.edu.cqu.CRM.Pojo.Employee;
import cn.edu.cqu.CRM.Pojo.EmployeeExample;
import cn.edu.cqu.CRM.Service.ActionService;
import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@Component
public class ActionServiceImpl implements ActionService {

	private final String DATABASE_ERR = "数据库出错";
	private final String NO_ACCOUNT = "无此账号";
	private final String WRONG_PASSWORD = "密码错误";
	private final String SUCCESS = "操作成功";

	private final String MANAGER = "manager";
	private final String SALER = "saler";
	private final String SERVIER = "servier";

	@Autowired
	EmployeeMapper employeeMapper;

	@Override
	public MyJson login(Employee employee, HttpSession session) {
		EmployeeExample employeeExample = new EmployeeExample();
		employeeExample.or().andEmployeeAccountEqualTo(employee.getEmployeeAccount());
		try {
			List<Employee> employees = employeeMapper.selectByExample(employeeExample);
			if (employees.size() == 0) {
				// 无此账号
				return new MyJson(false, NO_ACCOUNT);
			}
			if (employee.getEmployeePassword().equals(employees.get(0).getEmployeePassword())) {
				session.setAttribute("employee", employees.get(0));
				switch (employees.get(0).getUserTypeId().intValue()) {
				case 1:
					return new MyJson(MANAGER);
				case 2:
					return new MyJson(SERVIER);
				case 3:
					return new MyJson(SALER);
				default:
					return new MyJson(DATABASE_ERR);
				}
			}
			// 密码错误
			return new MyJson(false, WRONG_PASSWORD);
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

	@Override
	public MyJson logout(HttpSession session) {
		session.invalidate();
		return new MyJson(SUCCESS);
	}

	@Override
	public MyJson changePsw(String employeeAccount, String employeePassword, String employeeNewPassowrd) {
		EmployeeExample employeeExample = new EmployeeExample();
		employeeExample.or().andEmployeeAccountEqualTo(employeeAccount);
		try {
			List<Employee> employees = employeeMapper.selectByExample(employeeExample);
			if (employees.size() == 0) {
				// 账号不存在
				return new MyJson(false, NO_ACCOUNT);
			}
			if (!employeePassword.equals(employees.get(0).getEmployeePassword())) {
				// 旧密码错误
				return new MyJson(false, WRONG_PASSWORD);
			}
			Employee employee = new Employee();
			employee.setEmployeeId(employees.get(0).getEmployeeId());
			employee.setEmployeeAccount(employees.get(0).getEmployeeAccount());
			employee.setEmployeePassword(employeeNewPassowrd);
			// 修改密码
			employeeMapper.updateByPrimaryKeySelective(employee);
			return new MyJson(SUCCESS);
		} catch (Exception e) {
			System.err.println(e);
			return new MyJson(false, DATABASE_ERR);
		}
	}

}
