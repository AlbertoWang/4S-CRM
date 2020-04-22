package cn.edu.cqu.CRM.Service;

import org.springframework.stereotype.Service;

import cn.edu.cqu.CRM.Pojo.EmployeeInfo;
import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@Service
public interface AdminService {

	// 注册新账号
	MyJson signup(EmployeeInfo employeeInfo, String employeeAccount);

	// 获取员工信息 (若未输入员工姓名则返回全部员工信息)
	MyJson getEmployees(int pageNum, int pageSize, String employeeName);

}
