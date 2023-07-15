package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.data.Category
import com.arnyminerz.filamagenta.commons.data.security.permissions.Role
import com.arnyminerz.filamagenta.commons.utils.getEnum
import com.arnyminerz.filamagenta.commons.utils.getStringOrNull
import com.arnyminerz.filamagenta.commons.utils.getZonedDateTime
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.ZonedDateTime
import org.json.JSONObject

data class UserType(
    override val id: Long,
    override val timestamp: ZonedDateTime,
    val nif: String,
    val category: Category,
    val role: Role,
    val name: String,
    val surname: String,
    val email: String,
    val birthday: String? = null,
) : DataType(id, timestamp) {
    companion object: JsonSerializer<UserType> {
        override suspend fun fromJson(json: JSONObject): UserType = UserType(
            json.getLong("id"),
            json.getZonedDateTime("timestamp"),
            json.getString("nif"),
            json.getEnum("category"),
            json.getEnum("role"),
            json.getString("name"),
            json.getString("surname"),
            json.getString("email"),
            json.getStringOrNull("birthday")
        )
    }

    override fun toJSON(): JSONObject = JSONObject().apply {
        put("id", id)
        put("timestamp", timestamp.toString())
        put("nif", nif)
        put("category", category.name)
        put("role", role.name)
        put("name", name)
        put("surname", surname)
        put("email", email)
        put("birthday", birthday)
    }

    override fun toString(): String = toJSON().toString()
}
