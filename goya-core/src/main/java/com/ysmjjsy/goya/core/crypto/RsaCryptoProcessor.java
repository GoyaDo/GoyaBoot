package com.ysmjjsy.goya.core.crypto;

import com.ysmjjsy.goya.core.utils.CryptoUtils;

/**
 * <p>RSA 加密算法处理器</p>
 *
 * @author goya
 * @since 2025/10/9 16:34
 */
public class RsaCryptoProcessor implements IAsymmetricCryptoProcessor {

    @Override
    public SecretKey createSecretKey() {
        CryptoUtils.KeyDTO key = CryptoUtils.createRsaKey();
        return SecretKey.generateKey(key.privateKey(),key.publicKey());
    }

    @Override
    public String decrypt(String content, String privateKey) {
        return CryptoUtils.decryptRsa(content, privateKey);
    }

    @Override
    public String encrypt(String content, String publicKey) {
        return CryptoUtils.encryptRsa(content, publicKey);
    }
}
