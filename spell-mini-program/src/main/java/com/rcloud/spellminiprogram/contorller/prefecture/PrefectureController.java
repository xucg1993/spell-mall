package com.rcloud.spellminiprogram.contorller.prefecture;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.prefecture.PrefectureEntity;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellminiprogram.service.interfaces.prefecture.PrefectureService;
import com.rcloud.spellutils.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 专区
 *
 * @author xuchenguang
 * @since 2019.01.07
 */
@RestController
public class PrefectureController extends BaseController {


    @Autowired
    protected PrefectureService prefectureService;

    private static final String CONTROLLER_NAME = "prefecture";

    /**
     * 无分页
     *
     * @param entity
     * @return
     */
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

    /**
     * 三个专区
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/three")
    public String three() {

        PrefectureEntity entity = new PrefectureEntity();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        entity.setIntList(integerList);
        entity.setIsStatus(2);

        List<PrefectureEntity> list = prefectureService.list(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, list);
    }
}
