package com.ysmjjsy.goya.core.crypto;

import com.ysmjjsy.goya.core.utils.CryptoUtils;

/**
 * <p>国密 SM2 算法处理</p>
 *
 * @author goya
 * @since 2025/10/9 16:35
 */
public class Sm2CryptoProcessor implements IAsymmetricCryptoProcessor {

    @Override
    public SecretKey createSecretKey() {
        CryptoUtils.KeyDTO key = CryptoUtils.createSm2Key();
        return SecretKey.generateKey(key.privateKey(), key.publicKey());
    }

    @Override
    public String decrypt(String content, String privateKey) {
        return CryptoUtils.decryptSm2(content, privateKey);
    }

    @Override
    public String encrypt(String content, String publicKey) {
        return CryptoUtils.encryptSm2(content, publicKey);
    }

}
