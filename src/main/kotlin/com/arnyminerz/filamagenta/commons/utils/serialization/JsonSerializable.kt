package com.arnyminerz.filamagenta.commons.utils.serialization

import org.json.JSONException
import org.json.JSONObject

/**
 * Indicates that the parent object can be converted into a [JSONObject]. Needs to implement [toJSON].
 *
 * @see JsonSerializer
 */
interface JsonSerializable {
    /**
     * Converts the current class into a [JSONObject].
     *
     * @return A [JSONObject] with all the data of the class.
     *
     * @throws [JSONException] If some field cannot be serialized into JSON.
     */
    fun toJSON(): JSONObject
}
