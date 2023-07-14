package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getIntOrNull
import com.arnyminerz.filamagenta.commons.utils.getRSAPrivateKeyOrNull
import com.arnyminerz.filamagenta.commons.utils.getRSAPublicKey
import com.arnyminerz.filamagenta.commons.utils.getZonedDateTime
import com.arnyminerz.filamagenta.commons.utils.getZonedDateTimeOrNull
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import com.arnyminerz.filamagenta.commons.utils.toJSON
import java.security.PrivateKey
import java.security.PublicKey
import java.time.ZonedDateTime
import org.json.JSONObject

data class EventType(
    val name: String,
    val description: String,
    val date: ZonedDateTime,
    val until: ZonedDateTime?,
    val reservations: ZonedDateTime?,
    val maxGuests: Int? = MAX_GUESTS_DEFAULT,
    /** The public encryption key for the event. Using for transferring data securely. */
    val publicKey: PublicKey,
    /**
     * The private encryption key for the event. Using for transferring data securely.
     *
     * May be null if the user is not admin while client, for example.
     */
    val privateKey: PrivateKey?
) : DataType {
    companion object : JsonSerializer<EventType> {
        /**
         * The default value for the maximum allowed amount of guests
         */
        val MAX_GUESTS_DEFAULT: Int? = null

        override suspend fun fromJson(json: JSONObject): EventType = EventType(
            json.getString("name"),
            json.getString("description"),
            json.getZonedDateTime("date"),
            json.getZonedDateTimeOrNull("until"),
            json.getZonedDateTimeOrNull("reservations"),
            json.getIntOrNull("max_guests"),
            json.getJSONObject("key_pair").getRSAPublicKey("public"),
            json.getJSONObject("key_pair").getRSAPrivateKeyOrNull("private")
        )
    }

    override fun toString(): String = toJSON().toString()

    override fun toJSON(): JSONObject = JSONObject().apply {
        put("name", name)
        put("description", description)
        put("date", date.toString())
        put("until", until?.toString())
        put("reservations", reservations?.toString())
        put("max_guests", maxGuests)
        put(
            "key_pair",
            JSONObject().apply {
                put("public", publicKey.toJSON())
                put("private", privateKey?.toJSON())
            }
        )
    }
}
