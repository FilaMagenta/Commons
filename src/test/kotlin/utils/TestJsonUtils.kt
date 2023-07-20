package utils

import com.arnyminerz.filamagenta.commons.utils.getByteArray
import com.arnyminerz.filamagenta.commons.utils.getInstant
import com.arnyminerz.filamagenta.commons.utils.jsonOf
import com.arnyminerz.filamagenta.commons.utils.putByteArray
import com.arnyminerz.filamagenta.commons.utils.putInstant
import java.time.ZonedDateTime
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import org.json.JSONObject
import org.junit.jupiter.api.Test

class TestJsonUtils {
    @Test
    fun `test JSONObject_getByteArray`() {
        val json = JSONObject()
        val bytes = ByteArray(10) { it.toByte() }
        json.putByteArray("bytes", bytes)
        assertContentEquals(bytes, json.getByteArray("bytes"))
    }

    @Test
    fun `test jsonOf with ByteArray`() {
        val bytes = ByteArray(10) { it.toByte() }
        val json = jsonOf(
            "bytes" to bytes
        )
        assertContentEquals(bytes, json.getByteArray("bytes"))
    }

    @Test
    fun `test JSONObject_getInstant`() {
        val dateTime = ZonedDateTime.now()
        val instant = dateTime.toInstant()
        val json = JSONObject()
        json.putInstant("instant", instant)
        assertEquals(instant, json.getInstant("instant"))
    }

    @Test
    fun `test jsonOf with Instant`() {
        val dateTime = ZonedDateTime.now()
        val instant = dateTime.toInstant()
        val json = jsonOf(
            "instant" to instant
        )
        assertEquals(instant, json.getInstant("instant"))
    }
}
