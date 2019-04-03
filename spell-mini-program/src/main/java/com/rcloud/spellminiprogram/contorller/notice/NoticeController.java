package com.rcloud.spellminiprogram.contorller.notice;

import com.rcloud.spellentity.entity.notice.NoticeEntity;
import com.rcloud.spellminiprogram.service.interfaces.notice.NoticeService;
import com.rcloud.spellutils.utils.ResultJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 公告
 *
 * @author xuchenguang
 * @since 2018.11.25
 */
@RestController
@RequestMapping("notice")
public class NoticeController {


    private static final Logger logger = LoggerFactory.getLogger("公告控制层");

    @Autowired
    NoticeService noticeService;

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    @GetMapping("list")
    public String list(NoticeEntity entity) {

        logger.info("查询公告列表");

        List<NoticeEntity> entityList = noticeService.list(entity);

        return ResultJson.getResultJsonSuccess(entityList);

    }
}
