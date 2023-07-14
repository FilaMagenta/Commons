package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import org.json.JSONObject

data class TableGuestType(
    val name: String,
    val surname: String,
    val nif: String,
    val responsibleId: Int,
    val tableId: Int
) : DataType {
    companion object: JsonSerializer<TableGuestType> {
        override suspend fun fromJson(json: JSONObject): TableGuestType = TableGuestType(
            json.getString("name"),
            json.getString("surname"),
            json.getString("nif"),
            json.getInt("responsible"),
            json.getInt("table")
        )
    }

    override fun toJSON(): JSONObject = JSONObject().apply {
        put("name", name)
        put("surname", surname)
        put("nif", nif)
        put("responsible", responsibleId)
        put("table", tableId)
    }
}
