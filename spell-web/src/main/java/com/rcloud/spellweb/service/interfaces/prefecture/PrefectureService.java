package com.rcloud.spellweb.service.interfaces.prefecture;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.prefecture.PrefectureEntity;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
public interface PrefectureService {


    int save(PrefectureEntity entity);

    int update(PrefectureEntity entity);

    List<PrefectureEntity> list(PrefectureEntity entity);

    PageInfo<PrefectureEntity> listPage(PrefectureEntity entity);

    PrefectureEntity getPrefectureEntity(Integer prefectureId);
}
