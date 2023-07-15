package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.data.Category
import com.arnyminerz.filamagenta.commons.utils.getEnum
import com.arnyminerz.filamagenta.commons.utils.getZonedDateTime
import com.arnyminerz.filamagenta.commons.utils.jsonOf
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.ZonedDateTime
import org.json.JSONObject

/**
 * Creates a relationship between an event and a price. Each price is also associated with a category. This way, events
 * might have multiple prices, one for each category.
 *
 * If no entries are created for an event, it's considered free. There cannot exist multiple entries for the same
 * category and event.
 *
 * "Default" prices, those are, the ones for "the rest of categories", must be set with [Category.UNKNOWN].
 *
 * @param id The ID of the type in the database.
 * @param timestamp The last update time of the type.
 * @param price The price in the common currency (usually EURO) of the event.
 * @param category The category associated with this price.
 * @param eventId The ID of the event this price makes reference on.
 */
data class EventPriceType(
    override val id: Long,
    override val timestamp: ZonedDateTime,
    val price: Double,
    val category: Category,
    val eventId: Long
): DataType(id, timestamp) {
    companion object: JsonSerializer<EventPriceType> {
        override suspend fun fromJson(json: JSONObject): EventPriceType = EventPriceType(
            json.getLong("id"),
            json.getZonedDateTime("timestamp"),
            json.getDouble("price"),
            json.getEnum("category"),
            json.getLong("event_id")
        )
    }

    override fun toJSON(): JSONObject = jsonOf(
        "id" to id,
        "timestamp" to timestamp,
        "price" to price,
        "category" to category,
        "event_id" to eventId
    )
}
