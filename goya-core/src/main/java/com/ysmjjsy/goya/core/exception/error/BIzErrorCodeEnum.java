package com.ysmjjsy.goya.core.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/8 22:01
 */
@Getter
@AllArgsConstructor
public enum BIzErrorCodeEnum implements ErrorCode {

    BUSINESS_ERROR("BUSINESS_ERROR", "Business error"),
    ;
    private final String code;
    private final String message;

    @Override
    public ErrorCategoryEnum getCategory() {
        return ErrorCategoryEnum.BUSINESS;
    }
}
