package com.rcloud.spellcommon.common.exception;

/**
 * @author xuchenguang
 * @since 2018.09.04
 */
public class ArgsException extends Exception {

    public ArgsException(String msg) {
        super("缺少参数 :" + msg);
    }
}
