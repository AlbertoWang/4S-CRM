package cn.edu.cqu.CRM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.cqu.CRM.Pojo.EmployeeInfo;
import cn.edu.cqu.CRM.Service.AdminService;
import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping(value = "signup")
	@ResponseBody
	public MyJson signup(EmployeeInfo employeeInfo, String employeeAccount) {
		return adminService.signup(employeeInfo, employeeAccount);
	}

}
