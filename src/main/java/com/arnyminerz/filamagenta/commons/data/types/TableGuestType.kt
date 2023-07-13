package com.arnyminerz.filamagenta.commons.data.types

import org.json.JSONObject

data class TableGuestType(
    val name: String,
    val surname: String,
    val nif: String,
    val responsibleId: Int,
    val tableId: Int
) : DataType {
    override fun toJSON(): JSONObject = JSONObject().apply {
        put("name", name)
        put("surname", surname)
        put("nif", nif)
        put("responsible", responsibleId)
        put("table", tableId)
    }
}
