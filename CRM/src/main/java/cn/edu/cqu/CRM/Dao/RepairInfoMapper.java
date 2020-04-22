package cn.edu.cqu.CRM.Dao;

import cn.edu.cqu.CRM.Pojo.RepairInfo;
import cn.edu.cqu.CRM.Pojo.RepairInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RepairInfoMapper {
	long countByExample(RepairInfoExample example);

	int deleteByExample(RepairInfoExample example);

	int insert(RepairInfo record);

	int insertSelective(RepairInfo record);

	List<RepairInfo> selectByExample(RepairInfoExample example);

	int updateByExampleSelective(@Param("record") RepairInfo record, @Param("example") RepairInfoExample example);

	int updateByExample(@Param("record") RepairInfo record, @Param("example") RepairInfoExample example);
}