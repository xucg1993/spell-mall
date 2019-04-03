package com.rcloud.spelldao.dao.withdrawal;

import com.rcloud.spellentity.entity.withdrawal.WithdrawalEntity;
import com.rcloud.spellentity.entity.withdrawal.WithdrawalEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WithdrawalEntityMapper {
    int countByExample(WithdrawalEntityExample example);

    int deleteByExample(WithdrawalEntityExample example);

    int deleteByPrimaryKey(Integer mwId);

    int insert(WithdrawalEntity record);

    int insertSelective(WithdrawalEntity record);

    List<WithdrawalEntity> selectByExample(WithdrawalEntityExample example);

    WithdrawalEntity selectByPrimaryKey(Integer mwId);

    int updateByExampleSelective(@Param("record") WithdrawalEntity record, @Param("example") WithdrawalEntityExample example);

    int updateByExample(@Param("record") WithdrawalEntity record, @Param("example") WithdrawalEntityExample example);

    int updateByPrimaryKeySelective(WithdrawalEntity record);

    int updateByPrimaryKey(WithdrawalEntity record);
}