package cn.edu.cqu.CRM.Service;

import org.springframework.stereotype.Service;

import cn.edu.cqu.CRM.Pojo.EmployeeInfo;
import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@Service
public interface AdminService {

	// 注册新账号
	MyJson signup(EmployeeInfo employeeInfo, String employeeAccount);

}
