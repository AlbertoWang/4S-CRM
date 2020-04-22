package cn.edu.cqu.CRM.Service;

import org.springframework.stereotype.Service;

import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@Service
public interface UserService {

	// 按客户手机号获取客户信息
	MyJson getCustomers(int pageNum, int pageSize, Long customerTel);

}
