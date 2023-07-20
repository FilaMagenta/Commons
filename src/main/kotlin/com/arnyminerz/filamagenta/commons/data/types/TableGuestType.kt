package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getInstant
import com.arnyminerz.filamagenta.commons.utils.jsonOf
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.Instant
import org.json.JSONObject

data class TableGuestType(
    override val id: Long,
    override val timestamp: Instant,
    val name: String,
    val surname: String,
    val nif: String,
    val responsibleId: Long,
    val tableId: Long
) : DataType(id, timestamp) {
    companion object: JsonSerializer<TableGuestType> {
        override suspend fun fromJson(json: JSONObject): TableGuestType = TableGuestType(
            json.getLong("id"),
            json.getInstant("timestamp"),
            json.getString("name"),
            json.getString("surname"),
            json.getString("nif"),
            json.getLong("responsible"),
            json.getLong("table")
        )
    }

    override fun toJSON(): JSONObject = jsonOf(
        "id" to id,
        "timestamp" to timestamp,
        "name" to name,
        "surname" to surname,
        "nif" to nif,
        "responsible" to responsibleId,
        "table" to tableId
    )
}
