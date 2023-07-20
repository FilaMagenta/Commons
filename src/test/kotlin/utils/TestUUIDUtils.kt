package utils

import com.arnyminerz.filamagenta.commons.utils.bytes
import com.arnyminerz.filamagenta.commons.utils.toUUID
import java.util.UUID
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TestUUIDUtils {
    @Test
    fun `test UUID to ByteArray`() {
        val uuid = UUID.randomUUID()
        val uuidBytes = uuid.bytes
        val uuidBack = uuidBytes.toUUID()

        assertEquals(uuid, uuidBack)
    }

    @Test
    fun `test UUID native method doesn't recreate original UUID`() {
        val u = UUID.randomUUID()
        val uBytes: ByteArray = u.bytes
        val u2 = UUID.nameUUIDFromBytes(uBytes)

        assertNotEquals(u, u2)
    }
}
