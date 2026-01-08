package com.ysmjjsy.goya.core.exception.error;

import com.ysmjjsy.goya.core.enums.I18nEnum;

/**
 * <p>error code</p>
 *
 * @author goya
 * @since 2026/1/7 22:54
 */
public interface ErrorCode extends I18nEnum {

    /**
     * code
     *
     * @return code
     */
    String getCode();

    /**
     * message
     *
     * @return message
     */
    String getMessage();

    /**
     * category
     *
     * @return category
     */
    ErrorCategoryEnum getCategory();

    default String getI18nKey() {
        return "error." + getCode();
    }
}
