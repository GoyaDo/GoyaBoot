package com.ysmjjsy.goya.core.exception;

import com.ysmjjsy.goya.core.exception.error.BIzErrorCodeEnum;

import java.io.Serial;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/8 22:01
 */
public class BizException extends AbstractRuntimeException{
    @Serial
    private static final long serialVersionUID = -1658369210895863964L;

    public BizException(BIzErrorCodeEnum errorCode) {
        super(errorCode);
    }

    public BizException(BIzErrorCodeEnum errorCode, String message) {
        super(errorCode, message);
    }

    public BizException(BIzErrorCodeEnum errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BizException(BIzErrorCodeEnum errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}
