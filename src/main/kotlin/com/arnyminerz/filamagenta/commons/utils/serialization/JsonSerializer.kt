package com.arnyminerz.filamagenta.commons.utils.serialization

import org.json.JSONException
import org.json.JSONObject

/**
 * Usually implemented in companion objects. Provides a way to convert a [JSONObject] into [Result]. May be used
 * together with [JsonSerializable], for serializing and deserializing a data class.
 *
 * @param Result The resulting data type. Usually a [JsonSerializable].
 */
interface JsonSerializer<Result> {
    /**
     * Takes the data contained in [json], and converts into a [Result].
     *
     * @return The deserialized [Result] from the data in [json].
     *
     * @throws JSONException If a field is not valid or cannot be serialized.
     * @throws NullPointerException If a field was expected but is not present in [json].
     */
    suspend fun fromJson(json: JSONObject): Result
}
