package com.arnyminerz.filamagenta.commons.utils.serialization

import org.json.JSONObject

interface JsonSerializable {
    fun toJSON(): JSONObject
}
