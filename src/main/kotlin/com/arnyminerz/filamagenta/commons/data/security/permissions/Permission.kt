package com.arnyminerz.filamagenta.commons.data.security.permissions

sealed class Permission {
    override fun toString(): String = this::class.simpleName ?: super.toString()
}
