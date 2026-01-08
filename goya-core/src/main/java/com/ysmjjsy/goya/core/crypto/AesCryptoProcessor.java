package com.ysmjjsy.goya.core.crypto;

import com.ysmjjsy.goya.core.utils.CryptoUtils;

/**
 * <p>AES 加密算法处理器</p>
 *
 * @author goya
 * @since 2025/10/9 16:33
 */
public class AesCryptoProcessor implements ISymmetricCryptoProcessor {

    @Override
    public String createKey() {
       return CryptoUtils.createAesKey();
    }

    @Override
    public String decrypt(String data, String key) {
        return CryptoUtils.decryptAes(data, key);
    }

    @Override
    public String encrypt(String data, String key) {
        return CryptoUtils.encryptAes(data, key);
    }
}