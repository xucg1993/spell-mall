package com.rcloud.spellweb.service.interfaces.notice;


import com.rcloud.spellentity.entity.notice.NoticeEntity;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2018.11.25
 */
public interface NoticeService {


    /**
     * 保存
     *
     * @param entity
     * @return
     */
    Integer save(NoticeEntity entity);


    /**
     * 修改
     *
     * @param entity
     * @return
     */
    Integer update(NoticeEntity entity);


    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    List<NoticeEntity> list(NoticeEntity entity);
}
