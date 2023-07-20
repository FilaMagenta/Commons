package com.arnyminerz.filamagenta.commons.utils

import java.nio.ByteBuffer
import java.util.UUID

/**
 * The size of a UUID in bytes.
 *
 * The UUID_SIZE constant represents the number of bytes required to store a universally unique identifier (UUID).
 * A UUID is a 128-bit value typically represented as a sequence of 32 hexadecimal digits separated by hyphens.
 * This constant defines the size of the binary representation of a UUID, which is fixed at 16 bytes.
 *
 * @since 1.0.0
 */
private const val UUID_SIZE = 16

/**
 * Converts the UUID to a byte array representation.
 *
 * @return The byte array representation of the UUID.
 */
val UUID.bytes: ByteArray
    get() {
        val bb = ByteBuffer.wrap(ByteArray(UUID_SIZE))
        bb.putLong(mostSignificantBits)
        bb.putLong(leastSignificantBits)
        return bb.array()
    }

/**
 * Converts a byte array to a UUID.
 *
 * @return the UUID representation of the byte array
 */
fun ByteArray.toUUID(): UUID {
    val bb = ByteBuffer.wrap(this)
    val msb = bb.getLong()
    val lsb = bb.getLong()
    return UUID(msb, lsb)
}
