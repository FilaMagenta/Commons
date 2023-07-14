package com.arnyminerz.filamagenta.commons.data.types

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
