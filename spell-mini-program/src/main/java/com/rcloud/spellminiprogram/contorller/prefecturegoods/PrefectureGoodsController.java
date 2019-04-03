package com.rcloud.spellminiprogram.contorller.prefecturegoods;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.prefecturegoods.PrefectureGoodsEntity;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellminiprogram.service.interfaces.prefecturegoods.PrefectureGoodsService;
import com.rcloud.spellutils.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专区商品
 *
 * @author xuchenguang
 * @since 2019.01.07
 */
@RestController
public class PrefectureGoodsController extends BaseController {


    @Autowired
    protected PrefectureGoodsService prefectureGoodsService;

    private static final String CONTROLLER_NAME = "prefectureGoods";


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
     * 爆款
     *
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/faddish")
    public String faddish() {

        HashMap<String, Object> map = getPrefectureGoodsGroup(1);

        return ResultJson.getResultJsonSuccess(map);
    }

    /**
     * 水果
     *
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/fruits")
    public String fruits() {

        HashMap<String, Object> map = getPrefectureGoodsGroup(2);

        return ResultJson.getResultJsonSuccess(map);
    }


    /**
     * 推荐
     *
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/recommend")
    public String recommend() {
        PrefectureGoodsEntity entity = new PrefectureGoodsEntity();
        entity.setPrefectureId(6);
        entity.setPageNum(1);
        entity.setPageSize(4);
        PageInfo<PrefectureGoodsEntity> list = prefectureGoodsService.listPage(entity);

        List<PrefectureGoodsEntity> goodsEntityList = list.getList();
//        GoodsEntity goodsEntity = new GoodsEntity();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        if (goodsEntityList != null) {
            PrefectureGoodsEntity goodsEntity = goodsEntityList.get(0);
            goodsEntityList.remove(0);
            map.put("prefectureEntity", goodsEntity.getPrefectureEntity());
            map.put("goodsEntity", goodsEntity.getGoodsEntity());
            map.put("goodsEntityList", goodsEntityList);
        }
        dataMap.put("data",map);

        return ResultJson.getResultJsonSuccess(dataMap);
    }

    /**
     * 分组
     *
     * @return
     */
    private HashMap<String, Object> getPrefectureGoodsGroup(Integer prefectureId) {

        PrefectureGoodsEntity entity = new PrefectureGoodsEntity();
        entity.setPrefectureId(prefectureId);
        entity.setIsShow(2);

        HashMap<String, Object> map = new HashMap<>();
        int count = prefectureGoodsService.count(entity);

//        int ceil = (int) Math.ceil(((double) count / 3));
        int ceil = 3;

        List<List<PrefectureGoodsEntity>> newGoodsList = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < ceil; i++) {
            entity.setPageNum(j++);
            entity.setPageSize(3);
            PageInfo<PrefectureGoodsEntity> listPage = prefectureGoodsService.listPage(entity);
            newGoodsList.add(listPage.getList());

            if (map.get("prefectureId") == null && map.get("prefectureName") == null) {
                map.put("prefectureId", listPage.getList().get(i).getPrefectureId());
                map.put("prefectureName", listPage.getList().get(i).getPrefectureEntity().getPrefectureName());
            }
        }
        map.put("num", ceil);
        map.put("list", newGoodsList);

        return map;
    }
}
