package com.ysmjjsy.goya.core.utils;

import com.ysmjjsy.goya.core.constants.SymbolConst;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/8 22:37
 */
@UtilityClass
public class GoyaStringUtils {

    /**
     * 拼接逗号
     * @param value
     * @return
     */
    public static String joinComma(String[] value) {
        return StringUtils.join(value, SymbolConst.COMMA);
    }
    /**
     * 驼峰转下划线
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append("_").append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
