package com.rcloud.spellweb.controller.notice;

import com.rcloud.spellcommon.common.ArgsUtils;
import com.rcloud.spellcommon.common.exception.ArgsException;
import com.rcloud.spellentity.entity.notice.NoticeEntity;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class NoticeController extends BaseController {


    private static final Logger logger = LoggerFactory.getLogger("公告控制层");

    /**
     * 新增
     *
     * @param entity
     * @return
     */
    @GetMapping("save")
    public String save(NoticeEntity entity) throws ArgsException {

        logger.info("新增公告");

        //检查参数
        ArgsUtils.checkObj(entity, new String[]{"content"});

        Integer integer = noticeService.save(entity);

        if (integer > 0) {
            return ResultJson.getResultJsonSuccess("新增成功");
        }

        return ResultJson.getResultJsonFail("新增失败");
    }


    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @GetMapping("update")
    public String update(NoticeEntity entity) {

        logger.info("修改公告");

        Integer integer = noticeService.update(entity);

        if (integer > 0) {
            return ResultJson.getResultJsonSuccess("修改成功");
        }

        return ResultJson.getResultJsonFail("修改失败");
    }


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
