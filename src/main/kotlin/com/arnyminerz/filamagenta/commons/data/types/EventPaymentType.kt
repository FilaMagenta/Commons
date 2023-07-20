package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getStringOrNull
import com.arnyminerz.filamagenta.commons.utils.getUUID
import com.arnyminerz.filamagenta.commons.utils.getZonedDateTime
import com.arnyminerz.filamagenta.commons.utils.jsonOf
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.ZonedDateTime
import java.util.UUID
import org.json.JSONObject

data class EventPaymentType(
    override val id: Long,
    override val timestamp: ZonedDateTime,
    val uuid: UUID,
    val amount: Double,
    val signature: String,
    val externalReference: String?,
    val eventId: Long,
    val userId: Long
): DataType(id, timestamp) {
    companion object: JsonSerializer<EventPaymentType> {
        override suspend fun fromJson(json: JSONObject): EventPaymentType = EventPaymentType(
            json.getLong("id"),
            json.getZonedDateTime("timestamp"),
            json.getUUID("uuid"),
            json.getDouble("amount"),
            json.getString("signature"),
            json.getStringOrNull("external_reference"),
            json.getLong("event_id"),
            json.getLong("user_id")
        )
    }

    override fun toJSON(): JSONObject = jsonOf(
        "id" to id,
        "timestamp" to timestamp,
        "uuid" to uuid,
        "amount" to amount,
        "signature" to signature,
        "external_reference" to externalReference,
        "event_id" to eventId,
        "user_id" to userId
    )
}
