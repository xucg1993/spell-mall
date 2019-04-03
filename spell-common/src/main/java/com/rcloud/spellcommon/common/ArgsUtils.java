package com.rcloud.spellcommon.common;

import com.rcloud.spellcommon.common.exception.ArgsException;
import org.apache.commons.lang3.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @author : QuanBai
 * @Date : Created in 2018/4/25 15:08
 */

public class ArgsUtils {

    public static void checkObj(Object t, String... strings) throws ArgsException {

        String check = "";
        if (strings == null) {
            if (t == null || t.equals("")) {

                throw new ArgsException("缺少参数");
            }
            return;
        }

        Class clazz = t.getClass();

        try {
            for (String s : strings) {

                PropertyDescriptor pd = new PropertyDescriptor(s, clazz);
                Method getMethod = pd.getReadMethod();
                Object o = getMethod.invoke(t);

                if (o == null) {

                    if (check == "") {

                        check += s;
                    } else {

                        check += "," + s;
                    }

                }

            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(check)) {
            throw new ArgsException(check);
        }

    }
}
