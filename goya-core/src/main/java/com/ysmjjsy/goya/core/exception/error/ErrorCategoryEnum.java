package com.ysmjjsy.goya.core.exception.error;

import com.ysmjjsy.goya.core.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>error category</p>
 *
 * @author goya
 * @since 2026/1/7 22:49
 */
@Getter
@AllArgsConstructor
public enum ErrorCategoryEnum implements BaseEnum<String> {

    /**
     * validation error
     */
    VALIDATION("validation", "validation error"),

    /**
     * authentication error
     */
    AUTHENTICATION("authentication", "authentication error"),

    /**
     * authorization error
     */
    AUTHORIZATION("authorization", "authorization error"),

    /**
     * business error
     */
    BUSINESS("business", "business error"),

    /**
     * concurrency error
     */
    CONCURRENCY("concurrency", "concurrency error"),

    /**
     * external error
     */
    EXTERNAL("external", "external error"),

    /**
     * system error
     */
    SYSTEM("system", "system error"),

    ;
    private final String code;
    private final String description;

    @Override
    public String getI18nKey() {
        return "error.category." + code;
    }
}
