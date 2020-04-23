package cn.edu.cqu.CRM.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.cqu.CRM.Pojo.BuyInfo;
import cn.edu.cqu.CRM.Pojo.MaintainInfo;
import cn.edu.cqu.CRM.Pojo.RepairInfo;
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

	/*
	 * 买车相关响应
	 */
	// 按客户手机号/员工名/日期获取购买记录
	@GetMapping(value = "getBuyInfos")
	@ResponseBody
	public MyJson getBuyInfos(@RequestParam(required = true, value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize, Long customerTel,
			String employeeName, Date recordDay) {
		return userSerivce.getBuyInfos(pageNum, pageSize, customerTel, employeeName, recordDay);
	}

	// 新增客户购买记录
	@PostMapping(value = "addBuyInfo")
	@ResponseBody
	public MyJson addBuyInfo(BuyInfo buyInfo) {
		return userSerivce.addBuyInfo(buyInfo);
	}

	/*
	 * 保养相关响应
	 */
	// 按客户手机号/员工名/日期获取保养记录
	@GetMapping(value = "getMaintainInfos")
	@ResponseBody
	public MyJson getMaintainInfos(@RequestParam(required = true, value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize, Long customerTel,
			String employeeName, Date recordDay) {
		return userSerivce.getMaintainInfos(pageNum, pageSize, customerTel, employeeName, recordDay);
	}

	// 新增客户保养记录
	@PostMapping(value = "addMaintainInfo")
	@ResponseBody
	public MyJson addMaintainInfo(MaintainInfo maintainInfo) {
		return userSerivce.addMaintainInfo(maintainInfo);
	}

	/*
	 * 维修相关响应
	 */

	// 按客户手机号/员工名/日期获取保养记录
	@GetMapping(value = "getRepairInfos")
	@ResponseBody
	public MyJson getRepairInfos(@RequestParam(required = true, value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize, Long customerTel,
			String employeeName, Date recordDay) {
		return userSerivce.getRepairInfos(pageNum, pageSize, customerTel, employeeName, recordDay);
	}

	// 新增客户保养记录
	@PostMapping(value = "addRepairInfo")
	@ResponseBody
	public MyJson addRepairInfo(RepairInfo repairInfo) {
		return userSerivce.addRepairInfo(repairInfo);
	}

}
