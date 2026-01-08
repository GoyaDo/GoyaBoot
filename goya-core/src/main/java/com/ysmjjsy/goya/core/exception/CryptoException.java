package com.ysmjjsy.goya.core.exception;

import com.ysmjjsy.goya.core.exception.error.CryptoErrorCodeEnum;
import com.ysmjjsy.goya.core.exception.error.ErrorCode;

import java.io.Serial;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/7 23:46
 */
public class CryptoException extends AbstractRuntimeException{
    @Serial
    private static final long serialVersionUID = -1658369210895863964L;

    public CryptoException(CryptoErrorCodeEnum errorCode) {
        super(errorCode);
    }

    public CryptoException(CryptoErrorCodeEnum errorCode, String message) {
        super(errorCode, message);
    }

    public CryptoException(CryptoErrorCodeEnum errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public CryptoException(CryptoErrorCodeEnum errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public CryptoException(String message) {
        super(message);
    }

    public CryptoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptoException(Throwable cause) {
        super(cause);
    }
}
