package com.rcloud.spellweb.service.impl.notice;

import com.rcloud.spelldao.dao.notice.NoticeEntityMapper;
import com.rcloud.spellentity.entity.notice.NoticeEntity;
import com.rcloud.spellentity.entity.notice.NoticeEntityExample;
import com.rcloud.spellweb.service.interfaces.notice.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2018.11.25
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeEntityMapper noticeEntityMapper;


    @Override
    public Integer save(NoticeEntity entity) {
        return noticeEntityMapper.insertSelective(entity);
    }


    @Override
    public Integer update(NoticeEntity entity) {
        return noticeEntityMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<NoticeEntity> list(NoticeEntity entity) {

        NoticeEntityExample example = new NoticeEntityExample();

        NoticeEntityExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(entity.getTitle())) {
            criteria.andTitleEqualTo(entity.getTitle());
        }

        example.setOrderByClause("sequence ASC");

        return noticeEntityMapper.selectByExample(example);
    }
}
