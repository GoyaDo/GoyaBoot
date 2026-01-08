package com.ysmjjsy.goya.core.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/7 23:51
 */
@Getter
@AllArgsConstructor
public enum CryptoErrorCodeEnum implements ErrorCode {

    CRYPTO_ERROR("CRYPTO_ERROR", "Crypto error"),
    ;
    private final String code;
    private final String message;

    @Override
    public ErrorCategoryEnum getCategory() {
        return ErrorCategoryEnum.SYSTEM;
    }
}
