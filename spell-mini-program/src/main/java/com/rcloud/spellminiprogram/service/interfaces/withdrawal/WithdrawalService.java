package com.rcloud.spellminiprogram.service.interfaces.withdrawal;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.withdrawal.WithdrawalEntity;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.22
 */
public interface WithdrawalService {


    int save(WithdrawalEntity entity);

    int update(WithdrawalEntity entity);

    WithdrawalEntity getWithdrawal(Integer mwId);

    List<WithdrawalEntity> list(WithdrawalEntity entity);

    PageInfo<WithdrawalEntity> listPage(WithdrawalEntity entity);


}
