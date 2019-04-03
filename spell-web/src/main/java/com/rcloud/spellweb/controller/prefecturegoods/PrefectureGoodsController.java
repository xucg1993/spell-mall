package com.rcloud.spellweb.controller.prefecturegoods;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.goods.GoodsEntity;
import com.rcloud.spellentity.entity.prefecturegoods.PrefectureGoodsEntity;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专区商品
 *
 * @author xuchenguang
 * @since 2019.01.07
 */
@RestController
public class PrefectureGoodsController extends BaseController {


    private static final String CONTROLLER_NAME = "prefectureGoods";


    /**
     * 新增
     *
     * @param entity
     * @return
     */
    @PostMapping(CONTROLLER_NAME)
    public String save(PrefectureGoodsEntity entity) {

        int save = prefectureGoodsService.save(entity);

        if (save > 0) {
            return ResultJson.getResultJsonSuccess(SAVE_SUCCESS);
        }

        return ResultJson.getResultJsonFail(SAVE_FAIL);
    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @PutMapping(CONTROLLER_NAME)
    public String update(PrefectureGoodsEntity entity) {

        int update = prefectureGoodsService.update(entity);

        if (update > 0) {
            return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
        }

        return ResultJson.getResultJsonFail(UPDATE_FAIL);
    }

    /**
     * 删除
     *
     * @param pgId
     * @return
     */
    @DeleteMapping(CONTROLLER_NAME)
    public String delete(Integer pgId) {
        int delete = prefectureGoodsService.delete(pgId);

        if (delete > 0) {
            return ResultJson.getResultJsonSuccess("解绑成功");
        }
        return ResultJson.getResultJsonFail("解绑失败");
    }


    /**
     * 无分页 列表
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME)
    public String list(PrefectureGoodsEntity entity) {

        List<PrefectureGoodsEntity> list = prefectureGoodsService.list(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, list);
    }

    /**
     * 分页 列表
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/page")
    public String listPage(PrefectureGoodsEntity entity) {

        PageInfo<PrefectureGoodsEntity> listPage = prefectureGoodsService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }


    /**
     * 详情
     *
     * @param pgId
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/id")
    public String getPrefectureGoods(Integer pgId) {

        PrefectureGoodsEntity entity = prefectureGoodsService.getPrefectureGoods(pgId);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, entity);
    }


    /**
     * 获取未绑定的商品 分页
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/goods")
    public String getGoodsList(PrefectureGoodsEntity entity) {
        PageInfo<GoodsEntity> list = prefectureGoodsService.getGoodsList(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, list);
    }
}
