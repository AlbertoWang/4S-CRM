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

	// 获取全部用户种类，用于前端选择
	MyJson getAllUserTypes();

	// 获取全部员工权限，用于前端选择
	MyJson getAllEmployeePermissions();

	// 更新员工信息
	MyJson updateEmployeeInfo(EmployeeInfo employeeInfo);

}
