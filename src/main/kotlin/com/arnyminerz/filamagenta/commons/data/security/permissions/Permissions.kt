package com.arnyminerz.filamagenta.commons.data.security.permissions

object Permissions : PermissionsList() {
    object Usage : Permission()

    object Inventory : PermissionsList() {
        object Create : Permission()
    }

    object Events : PermissionsList() {
        object Create : Permission()

        object SetPrice : Permission()
    }

    object Transactions : PermissionsList() {
        object Create : Permission()
    }

    object Users : PermissionsList() {
        object ChangeCategory : Permission()

        object ChangeRole : Permission()

        object UpdateCategoryInfo : Permission()

        object List : Permission()
    }
}
