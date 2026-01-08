package com.ysmjjsy.goya.core.enums;

/**
 * <p>code enum interface</p>
 *
 * @param <C> code type
 * @author goya
 * @since 2026/1/7 22:44
 */
public interface CodeEnum<C> extends IEnum{

    /**
     * get code
     *
     * @return code
     */
    C getCode();
}
