package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getInstant
import com.arnyminerz.filamagenta.commons.utils.getLongOrNull
import com.arnyminerz.filamagenta.commons.utils.jsonOf
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.Instant
import org.json.JSONObject

data class TransactionType(
    override val id: Long,
    override val timestamp: Instant,
    val date: Instant,
    val amount: Long,
    val pricePerUnit: Double,
    val description: String,
    val userId: Long,
    val itemId: Long?
) : DataType(id, timestamp) {
    companion object: JsonSerializer<TransactionType> {
        override suspend fun fromJson(json: JSONObject): TransactionType = TransactionType(
            json.getLong("id"),
            json.getInstant("timestamp"),
            json.getInstant("date"),
            json.getLong("amount"),
            json.getDouble("price_per_unit"),
            json.getString("description"),
            json.getLong("user_id"),
            json.getLongOrNull("item_id")
        )
    }

    val balance: Double = amount * pricePerUnit

    override fun toJSON(): JSONObject = jsonOf(
        "id" to id,
        "timestamp" to timestamp,
        "date" to date,
        "amount" to amount,
        "price_per_unit" to pricePerUnit,
        "description" to description,
        "user_id" to userId,
        "item_id" to itemId
    )
}
