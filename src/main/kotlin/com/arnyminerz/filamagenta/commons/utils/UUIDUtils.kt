package com.arnyminerz.filamagenta.commons.utils

import java.util.Base64
import java.util.UUID

/**
 * Encodes the UUID as a base64 encoded byte array.
 *
 * @return The base64 encoded byte array representation of the UUID.
 */
fun UUID.base64Encode(): ByteArray {
    val encoder = Base64.getEncoder()
    val bytes = toString().toByteArray()
    return encoder.encode(bytes)
}
