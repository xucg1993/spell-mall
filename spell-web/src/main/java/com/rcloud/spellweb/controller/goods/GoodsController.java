package com.rcloud.spellweb.controller.goods;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.goods.GoodsEntity;
import com.rcloud.spellutils.utils.BaseUtils;
import com.rcloud.spellutils.utils.OSSClientUtils;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
     * 新增商品
     *
     * @param entity
     * @return
     */
    @PostMapping(CONTROLLER_NAME)
    public String save(GoodsEntity entity) {
        loggerInfo("新增商品");
        //生成id
        entity.setGoodsId(BaseUtils.generateElevenNum());

        int save = goodsService.save(entity);

        if (save > 0) {
            loggerInfo(SAVE_SUCCESS);
            return ResultJson.getResultJsonSuccess(SAVE_SUCCESS);
        }

        loggerError(SAVE_FAIL);
        return ResultJson.getResultJsonFail(SAVE_FAIL);
    }

    /**
     * 修改商品
     *
     * @param entity
     * @return
     */
    @PutMapping(CONTROLLER_NAME)
    public String update(GoodsEntity entity) {
        loggerInfo("修改商品");
        int update = goodsService.update(entity);

        if (update > 0) {
            loggerInfo(UPDATE_SUCCESS);
            return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
        }

        loggerError(UPDATE_FAIL);
        return ResultJson.getResultJsonFail(UPDATE_FAIL);
    }


    /**
     * 商品列表  带分页
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/page")
    public String listPage(GoodsEntity entity) {

        loggerInfo("商品列表 带分页");

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

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, entity);
    }


    /**
     * 上传商品图片
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadImage")
    public String uploadImage(MultipartFile file) throws Exception {

        loggerInfo("上传商品图片");

        //上传图片
        String uploadFile = OSSClientUtils.uploadFile(file);

        return ResultJson.getResultJsonSuccess(ResultJson.MSG_SUCCESS, uploadFile);
    }

    /**
     * 上传多个商品图片
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadImages")
    public String uploadImage(MultipartFile[] file) throws Exception {

        if (file == null || file.length <= 0) {
            return ResultJson.getResultJsonFail("请选择上传图片");
        }

        loggerInfo("上传多图片");

        StringBuffer buffer = new StringBuffer();

        int length = file.length;
        for (int i = 0; i < length; i++) {
            String uploadFile = OSSClientUtils.uploadFile(file[i]);

            buffer.append(uploadFile).append(i < length - 1 ? "," : "");
        }
        //上传图片

        return ResultJson.getResultJsonSuccess(ResultJson.MSG_SUCCESS, buffer.toString());
    }

}
