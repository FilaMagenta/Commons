package com.arnyminerz.filamagenta.commons.data.security.permissions

object TestPermissions : PermissionsList() {
    object Test : Permission()

    object Nested : PermissionsList() {
        object NestedPermission : Permission()
    }
}
