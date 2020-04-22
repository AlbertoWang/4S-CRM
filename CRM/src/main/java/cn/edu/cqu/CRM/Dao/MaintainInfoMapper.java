package cn.edu.cqu.CRM.Dao;

import cn.edu.cqu.CRM.Pojo.MaintainInfo;
import cn.edu.cqu.CRM.Pojo.MaintainInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaintainInfoMapper {
	long countByExample(MaintainInfoExample example);

	int deleteByExample(MaintainInfoExample example);

	int insert(MaintainInfo record);

	int insertSelective(MaintainInfo record);

	List<MaintainInfo> selectByExample(MaintainInfoExample example);

	int updateByExampleSelective(@Param("record") MaintainInfo record, @Param("example") MaintainInfoExample example);

	int updateByExample(@Param("record") MaintainInfo record, @Param("example") MaintainInfoExample example);
}