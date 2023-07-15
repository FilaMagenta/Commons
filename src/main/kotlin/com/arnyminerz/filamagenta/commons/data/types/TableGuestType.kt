package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.getZonedDateTime
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.ZonedDateTime
import org.json.JSONObject

data class TableGuestType(
    override val id: Long,
    override val timestamp: ZonedDateTime,
    val name: String,
    val surname: String,
    val nif: String,
    val responsibleId: Int,
    val tableId: Int
) : DataType(id, timestamp) {
    companion object: JsonSerializer<TableGuestType> {
        override suspend fun fromJson(json: JSONObject): TableGuestType = TableGuestType(
            json.getLong("id"),
            json.getZonedDateTime("timestamp"),
            json.getString("name"),
            json.getString("surname"),
            json.getString("nif"),
            json.getInt("responsible"),
            json.getInt("table")
        )
    }

    override fun toJSON(): JSONObject = JSONObject().apply {
        put("id", id)
        put("timestamp", timestamp)
        put("name", name)
        put("surname", surname)
        put("nif", nif)
        put("responsible", responsibleId)
        put("table", tableId)
    }
}
