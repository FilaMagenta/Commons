package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getInstant
import com.arnyminerz.filamagenta.commons.utils.getInstantOrNull
import com.arnyminerz.filamagenta.commons.utils.getLongOrNull
import com.arnyminerz.filamagenta.commons.utils.getRSAPrivateKeyOrNull
import com.arnyminerz.filamagenta.commons.utils.getRSAPublicKey
import com.arnyminerz.filamagenta.commons.utils.jsonOf
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import com.arnyminerz.filamagenta.commons.utils.toJSON
import java.security.PrivateKey
import java.security.PublicKey
import java.time.Instant
import org.json.JSONObject

data class EventType(
    override val id: Long,
    override val timestamp: Instant,
    val name: String,
    val description: String,
    val date: Instant,
    val until: Instant?,
    val reservations: Instant?,
    val maxGuests: Long? = MAX_GUESTS_DEFAULT,
    /** The public encryption key for the event. Using for transferring data securely. */
    val publicKey: PublicKey,
    /**
     * The private encryption key for the event. Using for transferring data securely.
     *
     * May be null if the user is not admin while client, for example.
     */
    val privateKey: PrivateKey?
) : DataType(id, timestamp) {
    companion object : JsonSerializer<EventType> {
        /**
         * The default value for the maximum allowed amount of guests
         */
        val MAX_GUESTS_DEFAULT: Long? = null

        override suspend fun fromJson(json: JSONObject): EventType = EventType(
            json.getLong("id"),
            json.getInstant("timestamp"),
            json.getString("name"),
            json.getString("description"),
            json.getInstant("date"),
            json.getInstantOrNull("until"),
            json.getInstantOrNull("reservations"),
            json.getLongOrNull("max_guests"),
            json.getJSONObject("key_pair").getRSAPublicKey("public"),
            json.getJSONObject("key_pair").getRSAPrivateKeyOrNull("private")
        )
    }

    override fun toString(): String = toJSON().toString()

    override fun toJSON(): JSONObject = jsonOf(
        "id" to id,
        "timestamp" to timestamp,
        "name" to name,
        "description" to description,
        "date" to date,
        "until" to until,
        "reservations" to reservations,
        "max_guests" to maxGuests,
        "key_pair" to jsonOf(
            "public" to publicKey.toJSON(),
            "private" to privateKey?.toJSON()
        )
    )
}
