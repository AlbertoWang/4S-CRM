package cn.edu.cqu.CRM.Dao;

import cn.edu.cqu.CRM.Pojo.Employee;
import cn.edu.cqu.CRM.Pojo.EmployeeExample;
import cn.edu.cqu.CRM.Pojo.EmployeeKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {
	long countByExample(EmployeeExample example);

	int deleteByExample(EmployeeExample example);

	int deleteByPrimaryKey(EmployeeKey key);

	int insert(Employee record);

	int insertSelective(Employee record);

	List<Employee> selectByExample(EmployeeExample example);

	Employee selectByPrimaryKey(EmployeeKey key);

	int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

	int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

	int updateByPrimaryKeySelective(Employee record);

	int updateByPrimaryKey(Employee record);
}