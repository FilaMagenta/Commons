package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getZonedDateTime
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.ZonedDateTime
import org.json.JSONObject

data class InventoryItemType(
    override val id: Long,
    override val timestamp: ZonedDateTime,
    val name: String,
    val unitPrice: Double
) : DataType(id, timestamp) {
    companion object: JsonSerializer<InventoryItemType> {
        override suspend fun fromJson(json: JSONObject): InventoryItemType = InventoryItemType(
            json.getLong("id"),
            json.getZonedDateTime("timestamp"),
            json.getString("name"),
            json.getDouble("unit_price")
        )
    }

    override fun toJSON(): JSONObject = JSONObject().apply {
        put("id", id)
        put("timestamp", timestamp.toString())
        put("name", name)
        put("unit_price", unitPrice)
    }
}
