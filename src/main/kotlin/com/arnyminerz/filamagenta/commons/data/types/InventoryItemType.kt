package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import org.json.JSONObject

data class InventoryItemType(
    val name: String,
    val unitPrice: Double
) : DataType {
    companion object: JsonSerializer<InventoryItemType> {
        override suspend fun fromJson(json: JSONObject): InventoryItemType = InventoryItemType(
            json.getString("name"),
            json.getDouble("unit_price")
        )
    }

    override fun toJSON(): JSONObject = JSONObject().apply {
        put("name", name)
        put("unit_price", unitPrice)
    }
}
