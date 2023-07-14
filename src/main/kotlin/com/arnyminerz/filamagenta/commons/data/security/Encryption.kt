package com.arnyminerz.filamagenta.commons.data.security

import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.Cipher

object Encryption {
    private const val CIPHER_TRANSFORMATION = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding"

    /**
     * The maximum size of a chunk for encryption.
     */
    const val MAX_CHUNK_SIZE = 214

    /**
     * Encrypts the given data using the passed public key.
     */
    fun encrypt(publicKey: PublicKey, data: ByteArray): ByteArray {
        val cipher = Cipher.getInstance(CIPHER_TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, publicKey)
        return cipher.doFinal(data)
    }

    /**
     * Decrypts a previously encrypted message using the passed private key.
     */
    fun decrypt(privateKey: PrivateKey, data: ByteArray): ByteArray {
        val cipher = Cipher.getInstance(CIPHER_TRANSFORMATION)
        cipher.init(Cipher.DECRYPT_MODE, privateKey)
        return cipher.doFinal(data)
    }
}
