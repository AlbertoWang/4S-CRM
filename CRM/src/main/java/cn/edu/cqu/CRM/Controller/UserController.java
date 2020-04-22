package cn.edu.cqu.CRM.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.cqu.CRM.Service.UserService;
import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@RestController
public class UserController {

	@Autowired
	UserService userSerivce;

	// 按客户手机号获取客户信息
	@GetMapping(value = "getCustomers")
	@ResponseBody
	public MyJson getCustomers(@RequestParam(required = true, value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize, Long customerTel) {
		return userSerivce.getCustomers(pageNum, pageSize, customerTel);
	}

	// 按客户手机号/员工名/日期获取购买记录
	@GetMapping(value = "getBuyInfos")
	@ResponseBody
	public MyJson getBuyInfos(@RequestParam(required = true, value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize, Long customerTel,
			String employeeName, Date recordDay) {
		return userSerivce.getBuyInfos(pageNum, pageSize, customerTel, employeeName, recordDay);
	}

}
