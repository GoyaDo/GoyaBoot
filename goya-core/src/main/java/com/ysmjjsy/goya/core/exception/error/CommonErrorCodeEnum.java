package com.ysmjjsy.goya.core.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/8 21:59
 */
@Getter
@AllArgsConstructor
public enum CommonErrorCodeEnum implements ErrorCode {

    COMMON_ERROR("COMMON_ERROR", "Common error"),
    ;
    private final String code;
    private final String message;

    @Override
    public ErrorCategoryEnum getCategory() {
        return ErrorCategoryEnum.SYSTEM;
    }
}
