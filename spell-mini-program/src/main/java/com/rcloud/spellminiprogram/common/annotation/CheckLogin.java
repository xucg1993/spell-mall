package com.rcloud.spellminiprogram.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 检查登录
 *
 * @author xuchenguang
 * @since 2019.01.01
 */
@Target({FIELD, METHOD})
@Retention(RUNTIME)
@Documented
@Inherited
public @interface CheckLogin {
}
