package com.ysmjjsy.goya.core.exception;

import com.ysmjjsy.goya.core.exception.error.CommonErrorCodeEnum;

import java.io.Serial;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/7 23:46
 */
public class CommonException extends AbstractRuntimeException{
    @Serial
    private static final long serialVersionUID = -1658369210895863964L;

    public CommonException(CommonErrorCodeEnum errorCode) {
        super(errorCode);
    }

    public CommonException(CommonErrorCodeEnum errorCode, String message) {
        super(errorCode, message);
    }

    public CommonException(CommonErrorCodeEnum errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public CommonException(CommonErrorCodeEnum errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }
}
