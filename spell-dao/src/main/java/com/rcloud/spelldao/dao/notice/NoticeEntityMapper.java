package com.rcloud.spelldao.dao.notice;

import com.rcloud.spellentity.entity.notice.NoticeEntity;
import com.rcloud.spellentity.entity.notice.NoticeEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeEntityMapper {
    int countByExample(NoticeEntityExample example);

    int deleteByExample(NoticeEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoticeEntity record);

    int insertSelective(NoticeEntity record);

    List<NoticeEntity> selectByExample(NoticeEntityExample example);

    NoticeEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NoticeEntity record, @Param("example") NoticeEntityExample example);

    int updateByExample(@Param("record") NoticeEntity record, @Param("example") NoticeEntityExample example);

    int updateByPrimaryKeySelective(NoticeEntity record);

    int updateByPrimaryKey(NoticeEntity record);
}