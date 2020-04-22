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

	@PostMapping(value = "login")
	@ResponseBody
	public MyJson login(Employee employee, HttpSession session) {
		return actionService.login(employee, session);
	}

	@GetMapping(value = "logout")
	@ResponseBody
	public MyJson logout(HttpSession session) {
		return actionService.logout(session);
	}
}
