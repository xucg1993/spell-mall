package com.rcloud.spelldao.dao.slideshow;

import com.rcloud.spellentity.entity.slideshow.SlideShowEntity;
import com.rcloud.spellentity.entity.slideshow.SlideShowEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlideShowEntityMapper {
    int countByExample(SlideShowEntityExample example);

    int deleteByExample(SlideShowEntityExample example);

    int deleteByPrimaryKey(String id);

    int insert(SlideShowEntity record);

    int insertSelective(SlideShowEntity record);

    List<SlideShowEntity> selectByExample(SlideShowEntityExample example);

    SlideShowEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SlideShowEntity record, @Param("example") SlideShowEntityExample example);

    int updateByExample(@Param("record") SlideShowEntity record, @Param("example") SlideShowEntityExample example);

    int updateByPrimaryKeySelective(SlideShowEntity record);

    int updateByPrimaryKey(SlideShowEntity record);
}