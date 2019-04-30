package com.chat.mapper;

import com.chat.pojo.TbGroupmembers;
import com.chat.pojo.TbGroupmembersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGroupmembersMapper {
    int countByExample(TbGroupmembersExample example);

    int deleteByExample(TbGroupmembersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbGroupmembers record);

    int insertSelective(TbGroupmembers record);

    List<TbGroupmembers> selectByExample(TbGroupmembersExample example);

    TbGroupmembers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbGroupmembers record, @Param("example") TbGroupmembersExample example);

    int updateByExample(@Param("record") TbGroupmembers record, @Param("example") TbGroupmembersExample example);

    int updateByPrimaryKeySelective(TbGroupmembers record);

    int updateByPrimaryKey(TbGroupmembers record);
}