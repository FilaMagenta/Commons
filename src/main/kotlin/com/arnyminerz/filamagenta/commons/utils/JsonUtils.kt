package com.arnyminerz.filamagenta.commons.utils

import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializable
import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializer
import java.time.ZonedDateTime
import java.time.format.DateTimeParseException
import java.util.Base64
import java.util.UUID
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Get the string associated with a key.
 * @param key A key string.
 * @param emptyIsNull If true, stored empty values will be considered as if there was no value stored at all.
 * @return A string which is the value, or null, if there isn't any stored value with the given key.
 */
fun JSONObject.getStringOrNull(key: String, emptyIsNull: Boolean = false): String? = try {
    if (has(key)) getString(key).takeIf { if (!emptyIsNull) true else it.isNotEmpty() } else null
} catch (_: JSONException) {
    null
}

/**
 * Get the integer associated with a key.
 * @param key A key string.
 * @return An integer which is the value, or null, if there isn't any stored value with the given key.
 */
@Deprecated(
    "Int should not be used. Use Long instead.",
    replaceWith = ReplaceWith("getLongOrNull")
)
fun JSONObject.getIntOrNull(key: String): Int? = try {
    if (has(key)) getInt(key) else null
} catch (_: JSONException) {
    null
}

/**
 * Get the long associated with a key.
 * @param key A key string.
 * @return A long which is the value, or null, if there isn't any stored value with the given key.
 */
fun JSONObject.getLongOrNull(key: String): Long? = try {
    if (has(key)) getLong(key) else null
} catch (_: JSONException) {
    null
}

/**
 * Get the float associated with a key.
 * @param key A key string.
 * @return A float which is the value, or null, if there isn't any stored value with the given key.
 */
@Deprecated(
    "Float should not be used. Use Double instead.",
    replaceWith = ReplaceWith("getDoubleOrNull")
)
fun JSONObject.getFloatOrNull(key: String): Float? = try {
    if (has(key)) getFloat(key) else null
} catch (_: JSONException) {
    null
}

/**
 * Get the double associated with a key.
 * @param key A key string.
 * @return A double which is the value, or null, if there isn't any stored value with the given key.
 */
fun JSONObject.getDoubleOrNull(key: String): Double? = try {
    if (has(key)) getDouble(key) else null
} catch (_: JSONException) {
    null
}

/**
 * Get the boolean associated with a key.
 * @param key A key string.
 * @return A boolean which is the value, or null, if there isn't any stored value with the given key.
 */
fun JSONObject.getBooleanOrNull(key: String): Boolean? = try {
    if (has(key)) getBoolean(key) else null
} catch (_: JSONException) {
    null
}

/**
 * Get the JSONObject associated with a key.
 * @param key A key string.
 * @return A JSONObject which is the value, or null, if there isn't any stored value with the given key.
 */
fun JSONObject.getJSONObjectOrNull(key: String): JSONObject? = try {
    if (has(key)) getJSONObject(key) else null
} catch (_: JSONException) {
    null
}

/**
 * Gets the [ZonedDateTime] object associated with a key. Fetches a String first, and converts to [ZonedDateTime] using
 * [ZonedDateTime.parse].
 *
 * @throws JSONException          If there is no string value for the key.
 * @throws DateTimeParseException If the text cannot be parsed.
 */
fun JSONObject.getZonedDateTime(key: String): ZonedDateTime =
    getString(key).let { ZonedDateTime.parse(it) }

/**
 * Gets the [ZonedDateTime] object associated with a key. Fetches a String first, and converts to [ZonedDateTime] using
 * [ZonedDateTime.parse].
 *
 * @return A [ZonedDateTime] which is the value, or null, if there isn't any stored value with the given key.
 */
fun JSONObject.getZonedDateTimeOrNull(key: String): ZonedDateTime? = try {
    if (has(key)) getString(key).let { ZonedDateTime.parse(it) } else null
} catch (_: JSONException) {
    null
} catch (_: DateTimeParseException) {
    null
}

/**
 * Gets the [T] object associated with a key. Fetches a [String] first, converts it into [JSONObject], and uses
 * [serializer] to convert it into a [T].
 *
 * @throws JSONException If there is no string value for the key, or the stored value is not a [JSONObject].
 *
 * @return A [T] object which is the serialization of the [String] stored at [key].
 */
suspend fun <T: JsonSerializable> JSONObject.getSerializable(key: String, serializer: JsonSerializer<T>): T =
    getString(key).let { serializer.fromJson(JSONObject(it)) }

/**
 * Gets the [T] object associated with a key. Fetches a [String] first, converts it into [JSONObject], and uses
 * [serializer] to convert it into a [T].
 *
 * @throws JSONException If there is no string value for the key, or the stored value is not a [JSONObject].
 *
 * @return A [T] object which is the serialization of the [String] stored at [key].
 */
suspend fun <T: JsonSerializable> JSONObject.getSerializableOrNull(key: String, serializer: JsonSerializer<T>): T? =
    getStringOrNull(key)?.let {
        try {
            serializer.fromJson(JSONObject(it))
        } catch (_: Exception) {
            // fromJson can throw a lot of different exceptions, so catch all of them
            null
        }
    }

/**
 * Gets the property of [T] named with the [String] value stored at [key].
 *
 * @throws JSONException If there is no string value for the key.
 * @throws NullPointerException If the value stored at [key] is not a valid entry name of [T].
 *
 * @return The property of [T] stored at [key].
 */
inline fun <reified T: Enum<T>> JSONObject.getEnum(key: String): T =
    getString(key).let { name -> enumValues<T>().find { it.name == name }!! }

/**
 * Gets the property of [T] named with the [String] value stored at [key].
 *
 * @throws JSONException If there is no string value for the key.
 * @throws NullPointerException If the value stored at [key] is not a valid entry name of [T].
 *
 * @return The property of [T] stored at [key] or null if any error occurs.
 */
inline fun <reified T: Enum<T>> JSONObject.getEnumOrNull(key: String): T? =
    getStringOrNull(key)?.let { name -> enumValues<T>().find { it.name == name } }

/**
 * Gets the UUID stored at [key]. Must follow the format specified in [UUID.toString].
 *
 * @throws JSONException If there is no string value for the key.
 *
 * @return The UUID stored at [key].
 */
fun JSONObject.getUUID(key: String): UUID =
    getString(key).let { UUID.fromString(it) }

/**
 * Retrieves the value associated with the specified key as a byte array from a JSON object.
 *
 * @param key The key to retrieve the value for.
 *
 * @return The byte array value associated with the key.
 */
fun JSONObject.getByteArray(key: String): ByteArray =
    getString(key).let { Base64.getDecoder().decode(it) }

/**
 * Puts a byte array value into this JSONObject using the specified key.
 *
 * @param key The key to associate with the value.
 * @param value The byte array value to be stored.
 */
fun JSONObject.putByteArray(key: String, value: ByteArray): JSONObject =
    put(key, Base64.getEncoder().encodeToString(value))

fun jsonOf(vararg pairs: Pair<String, Any?>) =
    JSONObject().apply {
        for ((key, value) in pairs)
            when (value) {
                is JsonSerializable -> put(key, value.toJSON())
                is ZonedDateTime -> put(key, value.toString())
                is Enum<*> -> put(key, value.name)
                is UUID -> put(key, value.toString())
                is ByteArray -> putByteArray(key, value)
                else -> put(key, value)
            }
    }

/**
 * Converts the list into a JSON array.
 */
fun <T : JsonSerializable> Iterable<T>.toJSONArray(): JSONArray = JSONArray().apply {
    for (item in this@toJSONArray)
        put(item.toJSON())
}
