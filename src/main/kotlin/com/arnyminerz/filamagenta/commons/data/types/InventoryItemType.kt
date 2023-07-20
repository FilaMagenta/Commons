package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getInstant
import com.arnyminerz.filamagenta.commons.utils.jsonOf
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.Instant
import org.json.JSONObject

data class InventoryItemType(
    override val id: Long,
    override val timestamp: Instant,
    val name: String,
    val unitPrice: Double
) : DataType(id, timestamp) {
    companion object: JsonSerializer<InventoryItemType> {
        override suspend fun fromJson(json: JSONObject): InventoryItemType = InventoryItemType(
            json.getLong("id"),
            json.getInstant("timestamp"),
            json.getString("name"),
            json.getDouble("unit_price")
        )
    }

    override fun toJSON(): JSONObject = jsonOf(
        "id" to id,
        "timestamp" to timestamp,
        "name" to name,
        "unit_price" to unitPrice
    )
}
