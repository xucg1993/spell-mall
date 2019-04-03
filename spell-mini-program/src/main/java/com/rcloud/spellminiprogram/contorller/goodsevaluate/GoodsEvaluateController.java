package com.rcloud.spellminiprogram.contorller.goodsevaluate;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.goodsevaluate.GoodsEvaluateEntity;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellminiprogram.service.interfaces.goodsevaluate.GoodsEvaluateService;
import com.rcloud.spellutils.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品评论
 *
 * @author xuchenguang
 * @since 2019.01.10
 */
@RestController
public class GoodsEvaluateController extends BaseController {

    @Autowired
    protected GoodsEvaluateService goodsEvaluateService;

    private static final String CONTROLLER_NAME = "goodsEvaluate";

    /**
     * 评论
     *
     * @param entity
     * @return
     */
    @PostMapping(CONTROLLER_NAME)
    public String save(GoodsEvaluateEntity entity) {
        loggerInfo("用户评论");

        int save = goodsEvaluateService.save(entity);
        if (save > 0) {
            return ResultJson.getResultJsonSuccess(SAVE_SUCCESS);
        }

        return ResultJson.getResultJsonFail(SAVE_FAIL);
    }


    @GetMapping(CONTROLLER_NAME + "/page")
    public String listPage(GoodsEvaluateEntity entity) {

        loggerInfo("用户评论列表");

        PageInfo<GoodsEvaluateEntity> listPage = goodsEvaluateService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }
}
