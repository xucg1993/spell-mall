package com.rcloud.spellminiprogram.contorller.goods;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.goods.GoodsEntity;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellutils.utils.ResultJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品控制层
 *
 * @author xuchenguang
 * @since 2019.01.06
 */
@RestController
public class GoodsController extends BaseController {


    public static final String CONTROLLER_NAME = "goods";


    /**
     * 商品列表  带分页
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/page")
    public String listPage(GoodsEntity entity) {

        loggerInfo("商品列表 带分页");
        //已上架商品
        entity.setIsStatus(2);

        PageInfo<GoodsEntity> listPage = goodsService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }

    /**
     * 商品列表
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME)
    public String list(GoodsEntity entity) {

        loggerInfo("商品列表 带分页");
        //已上架商品
        entity.setIsStatus(2);

        List<GoodsEntity> listPage = goodsService.list(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }

    /**
     * 查询商品详情
     *
     * @param goodsId
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/id")
    public String getGoods(String goodsId) {

        loggerInfo("商品详情");

        GoodsEntity entity = goodsService.getGoods(goodsId);
        /*if (entity != null) {
            GoodsEvaluateEntity goodsEvaluateEntity = new GoodsEvaluateEntity();
            goodsEvaluateEntity.setGoodsId(entity.getGoodsId());
            //获取商品评价
            PageInfo<GoodsEvaluateEntity> listPage = goodsEvaluateService.listPage(goodsEvaluateEntity);
            if (!listPage.getList().isEmpty()) {
                entity.setGoodsEvaluateEntity(listPage.getList().get(0));
            }
        }*/
        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, entity);
    }

}
