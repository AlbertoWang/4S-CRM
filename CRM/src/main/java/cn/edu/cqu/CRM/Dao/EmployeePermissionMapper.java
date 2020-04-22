package cn.edu.cqu.CRM.Dao;

import cn.edu.cqu.CRM.Pojo.EmployeePermission;
import cn.edu.cqu.CRM.Pojo.EmployeePermissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeePermissionMapper {
	long countByExample(EmployeePermissionExample example);

	int deleteByExample(EmployeePermissionExample example);

	int deleteByPrimaryKey(Integer permissionId);

	int insert(EmployeePermission record);

	int insertSelective(EmployeePermission record);

	List<EmployeePermission> selectByExample(EmployeePermissionExample example);

	EmployeePermission selectByPrimaryKey(Integer permissionId);

	int updateByExampleSelective(@Param("record") EmployeePermission record,
			@Param("example") EmployeePermissionExample example);

	int updateByExample(@Param("record") EmployeePermission record,
			@Param("example") EmployeePermissionExample example);

	int updateByPrimaryKeySelective(EmployeePermission record);

	int updateByPrimaryKey(EmployeePermission record);
}