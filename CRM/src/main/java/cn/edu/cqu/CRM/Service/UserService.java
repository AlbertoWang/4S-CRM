package cn.edu.cqu.CRM.Service;

import java.util.Date;

import org.springframework.stereotype.Service;

import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@Service
public interface UserService {

	// 按客户手机号获取客户信息
	MyJson getCustomers(int pageNum, int pageSize, Long customerTel);

	// 按客户手机号/员工名/日期获取购买记录
	MyJson getBuyInfos(int pageNum, int pageSize, Long customerTel, String employeeName, Date recordDay);

}
