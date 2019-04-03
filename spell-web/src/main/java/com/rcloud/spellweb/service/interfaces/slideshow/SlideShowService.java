package com.rcloud.spellweb.service.interfaces.slideshow;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.slideshow.SlideShowEntity;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.06
 */
public interface SlideShowService {

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    int save(SlideShowEntity entity);

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    int update(SlideShowEntity entity);

    /**
     * 列表  无分页
     *
     * @param entity
     * @return
     */
    List<SlideShowEntity> list(SlideShowEntity entity);

    /**
     * 列表 分页
     *
     * @param entity
     * @return
     */
    PageInfo<SlideShowEntity> listPage(SlideShowEntity entity);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    SlideShowEntity getSlideShow(String id);
}
