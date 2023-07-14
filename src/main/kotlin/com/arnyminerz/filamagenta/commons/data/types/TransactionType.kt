package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getZonedDateTime
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.ZonedDateTime
import org.json.JSONObject

data class TransactionType(
    val timestamp: ZonedDateTime,
    val date: ZonedDateTime,
    val amount: Int,
    val pricePerUnit: Float,
    val description: String,
    val userId: Int,
    val itemId: Int?
) : DataType {
    companion object: JsonSerializer<TransactionType> {
        override suspend fun fromJson(json: JSONObject): TransactionType = TransactionType(
            json.getZonedDateTime("timestamp"),
            json.getZonedDateTime("date"),
            json.getInt("amount"),
            json.getFloat("price_per_unit"),
            json.getString("description"),
            json.getInt("user_id"),
            json.getInt("item_id")
        )
    }

    override fun toJSON(): JSONObject = JSONObject().apply {
        put("timestamp", timestamp.toString())
        put("date", date.toString())
        put("amount", amount)
        put("price_per_unit", pricePerUnit)
        put("description", description)
        put("user_id", userId)
        put("item_id", itemId)
    }
}
