package com.rcloud.spellweb.service.impl.slideshow;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.slideshow.SlideShowEntityMapper;
import com.rcloud.spellentity.entity.slideshow.SlideShowEntity;
import com.rcloud.spellentity.entity.slideshow.SlideShowEntityExample;
import com.rcloud.spellweb.service.interfaces.slideshow.SlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.06
 */
@Service
public class SlideShowServiceImpl implements SlideShowService {

    @Autowired
    SlideShowEntityMapper mapper;

    @Override
    public int save(SlideShowEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int update(SlideShowEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<SlideShowEntity> list(SlideShowEntity entity) {

        SlideShowEntityExample example = new SlideShowEntityExample();
        SlideShowEntityExample.Criteria criteria = example.createCriteria();
        //排序
        example.setOrderByClause("sequence ASC");

        //状态 启用
        criteria.andIsStatusEqualTo(1);

        List<SlideShowEntity> list = mapper.selectByExample(example);

        return list;
    }

    @Override
    public PageInfo<SlideShowEntity> listPage(SlideShowEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        SlideShowEntityExample example = new SlideShowEntityExample();
        SlideShowEntityExample.Criteria criteria = example.createCriteria();
        //排序
        example.setOrderByClause("sequence ASC");

        //状态 启用
        criteria.andIsStatusEqualTo(1);

        List<SlideShowEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public SlideShowEntity getSlideShow(String id) {
        return mapper.selectByPrimaryKey(id);
    }
}
