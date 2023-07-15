package com.arnyminerz.filamagenta.commons.data.types

import com.arnyminerz.filamagenta.commons.utils.serialization.JsonSerializable
import java.time.ZonedDateTime

/**
 * Provides a common class for all the types of data.
 *
 * @param id The ID of the DataType in the database.
 * @param timestamp The last update time of the DataType. Every time the contents are updated, this field should be
 * updated as well.
 */
abstract class DataType(
    open val id: Long,
    open val timestamp: ZonedDateTime
) : JsonSerializable
