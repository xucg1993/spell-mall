package com.rcloud.spellweb.controller.prefecture;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.prefecture.PrefectureEntity;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 专区
 *
 * @author xuchenguang
 * @since 2019.01.07
 */
@RestController
public class PrefectureController extends BaseController {


    private static final String CONTROLLER_NAME = "prefecture";


    /**
     * 新增专区
     *
     * @param entity
     * @return
     */
    @PostMapping(CONTROLLER_NAME)
    public String save(PrefectureEntity entity) {

        int save = prefectureService.save(entity);

        if (save > 0) {
            loggerInfo(SAVE_SUCCESS);
            return ResultJson.getResultJsonSuccess(SAVE_SUCCESS);
        }
        loggerInfo(SAVE_FAIL);
        return ResultJson.getResultJsonFail(SAVE_FAIL);
    }


    /**
     * 修改专区
     *
     * @param entity
     * @return
     */
    @PutMapping(CONTROLLER_NAME)
    public String update(PrefectureEntity entity) {

        int update = prefectureService.update(entity);

        if (update > 0) {
            loggerInfo(UPDATE_SUCCESS);
            return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
        }
        loggerInfo(UPDATE_FAIL);
        return ResultJson.getResultJsonFail(UPDATE_FAIL);
    }


    @GetMapping(CONTROLLER_NAME)
    public String list(PrefectureEntity entity) {

        List<PrefectureEntity> list = prefectureService.list(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, list);
    }


    @GetMapping(CONTROLLER_NAME + "/page")
    public String listPage(PrefectureEntity entity) {

        PageInfo<PrefectureEntity> listPage = prefectureService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }


    @GetMapping(CONTROLLER_NAME + "/id")
    public String getPrefecture(Integer prefectureId) {

        PrefectureEntity entity = prefectureService.getPrefectureEntity(prefectureId);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, entity);
    }
}
