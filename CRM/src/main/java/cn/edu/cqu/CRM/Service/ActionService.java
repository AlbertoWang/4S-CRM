package cn.edu.cqu.CRM.Service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.edu.cqu.CRM.Pojo.Employee;
import cn.edu.cqu.CRM.Utils.DataFormat.MyJson;

@Service
public interface ActionService {

	// 用户登录
	MyJson login(Employee employee, HttpSession session);

	// 用户退出
	MyJson logout(HttpSession session);

}
