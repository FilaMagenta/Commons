package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.data.Category
import com.arnyminerz.filamagenta.commons.data.security.permissions.Role
import com.arnyminerz.filamagenta.commons.utils.getEnum
import com.arnyminerz.filamagenta.commons.utils.getInstant
import com.arnyminerz.filamagenta.commons.utils.jsonOf
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import org.json.JSONObject

data class UserType(
    override val id: Long,
    override val timestamp: Instant,
    val nif: String,
    val category: Category,
    val role: Role,
    val name: String,
    val surname: String,
    val email: String,
    val birthday: LocalDate? = null,
) : DataType(id, timestamp) {
    companion object: JsonSerializer<UserType> {
        override suspend fun fromJson(json: JSONObject): UserType = UserType(
            json.getLong("id"),
            json.getInstant("timestamp"),
            json.getString("nif"),
            json.getEnum("category"),
            json.getEnum("role"),
            json.getString("name"),
            json.getString("surname"),
            json.getString("email"),
            json.getInstant("birthday").atZone(ZoneId.systemDefault()).toLocalDate()
        )
    }

    override fun toJSON(): JSONObject = jsonOf(
        "id" to id,
        "timestamp" to timestamp,
        "nif" to nif,
        "category" to category,
        "role" to role,
        "name" to name,
        "surname" to surname,
        "email" to email,
        "birthday" to birthday
    )

    override fun toString(): String = toJSON().toString()
}
