package com.rcloud.spellcommon.common.exception;

import com.rcloud.spellutils.utils.ResultJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * 异常处理
 *
 * @author xuchenguang
 * @since 2018.09.04
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger("异常处理通知");

    /**
     * 数据库异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLException.class)
    public String sqlException(SQLException ex) {
        logger.error(ex.toString());
        return ResultJson.getResultJsonError("数据库错误", ex.toString());
    }

    /**
     * 服务器异常处理
     *
     * @param runtimeException
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public String runtimeExceptionHandler(RuntimeException runtimeException) {
        logger.error("服务器运行异常:" + runtimeException.toString());
        return ResultJson.getResultJsonError("服务器运行异常", runtimeException.toString());
    }

    /**
     * 空指针异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {
        logger.error("空指针异常:" + exception.toString());
        return ResultJson.getResultJsonError("空指针异常", exception.toString());
    }

    /**
     * 参数异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ArgsException.class)
    public String argsExceptionHandler(ArgsException ex) {
        logger.error("参数异常:" + ex.toString());
        return ResultJson.getResultJsonError(ResultJson.ARGS_EXCEPTION, "参数异常", ex.toString());
    }

    /**
     * 操作异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(CurrencyException.class)
    public String currencyException(CurrencyException ex) {
        logger.error("操作异常:" + ex.toString());
        return ResultJson.getResultJsonError(ResultJson.CURRENCY_EXCEPTION, "操作异常", ex.toString());
    }

    /**
     * 登录异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(CheckLoginException.class)
    public String argsExceptionHandler(CheckLoginException ex) {
        logger.error("登录异常:" + ex.toString());
        return ResultJson.getResultJsonError(ResultJson.CHECK_LOGIN_EXCEPTION, "登录异常", ex.toString());
    }
}
