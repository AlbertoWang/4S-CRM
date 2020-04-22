package cn.edu.cqu.CRM.Dao;

import cn.edu.cqu.CRM.Pojo.BuyInfo;
import cn.edu.cqu.CRM.Pojo.BuyInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BuyInfoMapper {
	long countByExample(BuyInfoExample example);

	int deleteByExample(BuyInfoExample example);

	int insert(BuyInfo record);

	int insertSelective(BuyInfo record);

	List<BuyInfo> selectByExample(BuyInfoExample example);

	int updateByExampleSelective(@Param("record") BuyInfo record, @Param("example") BuyInfoExample example);

	int updateByExample(@Param("record") BuyInfo record, @Param("example") BuyInfoExample example);
}