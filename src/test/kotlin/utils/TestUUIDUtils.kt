package utils

import com.arnyminerz.filamagenta.commons.utils.base64Encode
import java.util.Base64
import java.util.UUID
import kotlin.test.Test
import kotlin.test.assertEquals

class TestUUIDUtils {
    @Test
    fun `test UUID to Base64 encoding`() {
        val uuid = UUID.randomUUID()
        val base64 = uuid.base64Encode()

        val decoded = Base64.getDecoder().decode(base64).decodeToString()

        assertEquals(uuid.toString(), decoded)
    }
}
