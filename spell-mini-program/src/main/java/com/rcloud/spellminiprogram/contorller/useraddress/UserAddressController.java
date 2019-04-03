package com.rcloud.spellminiprogram.contorller.useraddress;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.useraddress.UserAddressEntity;
import com.rcloud.spellminiprogram.common.annotation.CheckLogin;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellminiprogram.service.interfaces.useraddress.UserAddressService;
import com.rcloud.spellutils.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.08
 */
@RestController
public class UserAddressController extends BaseController {


    @Autowired
    protected UserAddressService userAddressService;

    public static final String CONTROLLER_NAME = "userAddress";


    /**
     * 新增
     *
     * @param entity
     * @return
     */
    @CheckLogin
    @PostMapping(CONTROLLER_NAME)
    public String save(UserAddressEntity entity) {

        entity.setUserId(userService.findUserIdByToken());

        if (entity.getIsDefault() != null && entity.getIsDefault().equals(1)) {
            userAddressService.updateDefault(entity);
        }
        //查询地址数量
        UserAddressEntity query = new UserAddressEntity();
        query.setUserId(userService.findUserIdByToken());
        int count = userAddressService.count(query);
        if (count <= 0) {
            entity.setIsDefault(1);
        } else if (count >= 5) {
            return ResultJson.getResultJsonFail(ResultJson.CODE_3, "地址超过五个");
        }

        int save = userAddressService.save(entity);

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
    @Transactional(rollbackFor = Exception.class)
    public String update(UserAddressEntity entity) {

        entity.setUserId(userService.findUserIdByToken());

        if (entity.getIsDefault() != null && entity.getIsDefault().equals(1)) {
            userAddressService.updateDefault(entity);
        }
        int update = userAddressService.update(entity);

        if (update > 0) {
            return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
        }
        return ResultJson.getResultJsonFail(UPDATE_FAIL);
    }

    @CheckLogin
    @GetMapping(CONTROLLER_NAME)
    public String list(UserAddressEntity entity) {

        entity.setUserId(userService.findUserIdByToken());

        List<UserAddressEntity> listPage = userAddressService.list(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }

    @GetMapping(CONTROLLER_NAME + "/page")
    public String listPage(UserAddressEntity entity) {

        entity.setUserId(userService.findUserIdByToken());

        PageInfo<UserAddressEntity> listPage = userAddressService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }

    /**
     * 查询详情
     *
     * @param addressId
     * @return
     */
    @CheckLogin
    @GetMapping(CONTROLLER_NAME + "/id")
    public String getUserAddress(String addressId) {
        UserAddressEntity userAddress = userAddressService.getUserAddress(addressId);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, userAddress);
    }

    /**
     * 获取默认收货地址
     *
     * @return
     */
    @CheckLogin
    @GetMapping(CONTROLLER_NAME + "/default")
    public String getAddressByDefault() {

        String userId = userService.findUserIdByToken();

        UserAddressEntity address = userAddressService.getUserAddressByDefault(userId);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, address);
    }
}
