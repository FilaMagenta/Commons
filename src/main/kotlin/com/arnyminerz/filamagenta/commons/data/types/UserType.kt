package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.data.security.permissions.Role
import com.arnyminerz.filamagenta.commons.utils.getEnum
import com.arnyminerz.filamagenta.commons.utils.getStringOrNull
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import org.json.JSONObject

data class UserType(
    val nif: String,
    val role: Role,
    val name: String,
    val surname: String,
    val email: String,
    val birthday: String? = null
) : DataType {
    companion object: JsonSerializer<UserType> {
        override suspend fun fromJson(json: JSONObject): UserType = UserType(
            json.getString("nif"),
            json.getEnum("name"),
            json.getString("name"),
            json.getString("surname"),
            json.getString("email"),
            json.getStringOrNull("birthday")
        )
    }

    override fun toJSON(): JSONObject = JSONObject().apply {
        put("nif", nif)
        put("role", role.name)
        put("name", name)
        put("surname", surname)
        put("email", email)
        put("birthday", birthday)
    }

    override fun toString(): String = toJSON().toString()
}
