package cn.edu.cqu.CRM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping(value = "getEmployees")
	@ResponseBody
	public MyJson getEmployees(@RequestParam(required = true, value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize,
			String employeeName) {
		return adminService.getEmployees(pageNum, pageSize, employeeName);
	}

}
