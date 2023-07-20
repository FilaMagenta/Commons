package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getByteArray
import com.arnyminerz.filamagenta.commons.utils.getInstant
import com.arnyminerz.filamagenta.commons.utils.getStringOrNull
import com.arnyminerz.filamagenta.commons.utils.getUUID
import com.arnyminerz.filamagenta.commons.utils.jsonOf
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.Instant
import java.util.UUID
import org.json.JSONObject

data class EventPaymentType(
    override val id: Long,
    override val timestamp: Instant,
    val uuid: UUID,
    val amount: Double,
    val signature: ByteArray,
    val externalReference: String?,
    val eventId: Long,
    val userId: Long
): DataType(id, timestamp) {
    companion object: JsonSerializer<EventPaymentType> {
        override suspend fun fromJson(json: JSONObject): EventPaymentType = EventPaymentType(
            json.getLong("id"),
            json.getInstant("timestamp"),
            json.getUUID("uuid"),
            json.getDouble("amount"),
            json.getByteArray("signature"),
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EventPaymentType

        if (id != other.id) return false
        if (timestamp != other.timestamp) return false
        if (uuid != other.uuid) return false
        if (amount != other.amount) return false
        if (!signature.contentEquals(other.signature)) return false
        if (externalReference != other.externalReference) return false
        if (eventId != other.eventId) return false
        if (userId != other.userId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + timestamp.hashCode()
        result = 31 * result + uuid.hashCode()
        result = 31 * result + amount.hashCode()
        result = 31 * result + signature.contentHashCode()
        result = 31 * result + (externalReference?.hashCode() ?: 0)
        result = 31 * result + eventId.hashCode()
        result = 31 * result + userId.hashCode()
        return result
    }
}
