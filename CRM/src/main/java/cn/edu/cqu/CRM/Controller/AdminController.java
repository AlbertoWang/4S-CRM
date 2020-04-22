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

	// 注册新员工账号
	@PostMapping(value = "signup")
	@ResponseBody
	public MyJson signup(EmployeeInfo employeeInfo, String employeeAccount) {
		return adminService.signup(employeeInfo, employeeAccount);
	}

	// 按姓名包含字符获取员工信息 (若不输入姓名则返回全部员工信息)
	@GetMapping(value = "getEmployees")
	@ResponseBody
	public MyJson getEmployees(@RequestParam(required = true, value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize,
			String employeeName) {
		return adminService.getEmployees(pageNum, pageSize, employeeName);
	}

	// 获取用户类型供前端选择
	@GetMapping(value = "getAllUserTypes")
	@ResponseBody
	public MyJson getAllUserTypes() {
		return adminService.getAllUserTypes();
	}

	// 获取员工权限供前端选额
	@GetMapping(value = "getAllEmployeePermissions")
	@ResponseBody
	public MyJson getAllEmployeePermissions() {
		return adminService.getAllEmployeePermissions();
	}

	// 更新员工信息
	@PostMapping(value = "updateEmployeeInfo")
	@ResponseBody
	public MyJson updateEmployeeInfo(EmployeeInfo employeeInfo) {
		return adminService.updateEmployeeInfo(employeeInfo);
	}

}
