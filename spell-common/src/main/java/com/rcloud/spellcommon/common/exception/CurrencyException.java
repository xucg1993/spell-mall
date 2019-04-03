package com.rcloud.spellcommon.common.exception;

/**
 * @author : QuanBai
 * @Date : Created in 2018/4/25 17:52
 */
public class CurrencyException extends Exception {

    private Integer status;

    public CurrencyException(String msg) {
        super(msg);
    }

    public CurrencyException(Integer status, String msg) {
        super(msg);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
