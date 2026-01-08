package com.ysmjjsy.goya.core.crypto;

import com.ysmjjsy.goya.core.utils.CryptoUtils;

/**
 * <p></p>
 *
 * @author goya
 * @since 2025/10/9 16:36
 */
public class Sm4CryptoProcessor implements ISymmetricCryptoProcessor {

    @Override
    public String createKey() {
        return CryptoUtils.createSm4key();
    }

    @Override
    public String decrypt(String data, String key) {
        return CryptoUtils.decryptSm4(data, key);
    }

    @Override
    public String encrypt(String data, String key) {
        return CryptoUtils.encryptSm4(data, key);
    }
}
