package cn.edu.cqu.CRM.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.cqu.CRM.Pojo.Employee;
import cn.edu.cqu.CRM.Service.ActionService;
import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@RestController
public class ActionController {

	@Autowired
	ActionService actionService;

	// 登录
	@PostMapping(value = "login")
	@ResponseBody
	public MyJson login(Employee employee, HttpSession session) {
		return actionService.login(employee, session);
	}

	// 登出
	@GetMapping(value = "logout")
	@ResponseBody
	public MyJson logout(HttpSession session) {
		return actionService.logout(session);
	}

	// 修改密码
	@PostMapping(value = "changePsw")
	@ResponseBody
	public MyJson changePsw(String employeeAccount, String employeePassword, String employeeNewPassowrd) {
		return actionService.changePsw(employeeAccount, employeePassword, employeeNewPassowrd);
	}

	// 获取当前登录的员工对象
	@GetMapping(value = "getEmployee")
	@ResponseBody
	public MyJson getEmployee(HttpSession session) {
		return new MyJson((Employee) session.getAttribute("employee"));
	}
}
