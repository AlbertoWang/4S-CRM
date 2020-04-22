package cn.edu.cqu.CRM.Dao;

import cn.edu.cqu.CRM.Pojo.UserType;
import cn.edu.cqu.CRM.Pojo.UserTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserTypeMapper {
	long countByExample(UserTypeExample example);

	int deleteByExample(UserTypeExample example);

	int deleteByPrimaryKey(Integer userTypeId);

	int insert(UserType record);

	int insertSelective(UserType record);

	List<UserType> selectByExample(UserTypeExample example);

	UserType selectByPrimaryKey(Integer userTypeId);

	int updateByExampleSelective(@Param("record") UserType record, @Param("example") UserTypeExample example);

	int updateByExample(@Param("record") UserType record, @Param("example") UserTypeExample example);

	int updateByPrimaryKeySelective(UserType record);

	int updateByPrimaryKey(UserType record);
}