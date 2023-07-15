package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getIntOrNull
import com.arnyminerz.filamagenta.commons.utils.getZonedDateTime
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.ZonedDateTime
import org.json.JSONObject

data class TransactionType(
    override val id: Long,
    override val timestamp: ZonedDateTime,
    val date: ZonedDateTime,
    val amount: Int,
    val pricePerUnit: Double,
    val description: String,
    val userId: Int,
    val itemId: Int?
) : DataType(id, timestamp) {
    companion object: JsonSerializer<TransactionType> {
        override suspend fun fromJson(json: JSONObject): TransactionType = TransactionType(
            json.getLong("id"),
            json.getZonedDateTime("timestamp"),
            json.getZonedDateTime("date"),
            json.getInt("amount"),
            json.getDouble("price_per_unit"),
            json.getString("description"),
            json.getInt("user_id"),
            json.getIntOrNull("item_id")
        )
    }

    val balance: Double
        get() = amount * pricePerUnit

    override fun toJSON(): JSONObject = JSONObject().apply {
        put("id", id)
        put("timestamp", timestamp.toString())
        put("date", date.toString())
        put("amount", amount)
        put("price_per_unit", pricePerUnit)
        put("description", description)
        put("user_id", userId)
        put("item_id", itemId)
    }
}
