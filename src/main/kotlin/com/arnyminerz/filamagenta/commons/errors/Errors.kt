package com.arnyminerz.filamagenta.commons.errors

import com.arnyminerz.filamagenta.commons.errors.Error
import io.ktor.http.HttpStatusCode

@Suppress("PropertyWrapping", "MaximumLineLength", "ArgumentListWrapping", "MaxLineLength", "MagicNumber")
object Errors {
    val EndpointNotFound = Error(1, "Endpoint not found", HttpStatusCode.NotFound)
    val Internal = Error(2, "Internal server exception", HttpStatusCode.InternalServerError)
    val EventNotFound = Error(3, "Could not find event.", HttpStatusCode.BadRequest)
    val TableNotFound = Error(4, "Could not find table.", HttpStatusCode.BadRequest)
    val UserNotFound = Error(5, "Could not find user.", HttpStatusCode.BadRequest)
    val QrCodeTooLarge = Error(6, "QR Code too large.", HttpStatusCode.InternalServerError)

    val MissingNifBody = Error(10, "Request doesn't contain the required 'nif' argument.", HttpStatusCode.BadRequest)
    val MissingNameBody = Error(11, "Request doesn't contain the required 'name' argument.", HttpStatusCode.BadRequest)
    val MissingSurnameBody = Error(12, "Request doesn't contain the required 'surname' argument.", HttpStatusCode.BadRequest)
    val MissingEmailBody = Error(13, "Request doesn't contain the required 'email' argument.", HttpStatusCode.BadRequest)
    val MissingPasswordBody = Error(14, "Request doesn't contain the required 'password' argument.", HttpStatusCode.BadRequest)
    val MissingDescriptionBody = Error(15, "Request doesn't contain the required 'description' argument.", HttpStatusCode.BadRequest)
    val MissingDateBody = Error(16, "Request doesn't contain the required 'date' argument.", HttpStatusCode.BadRequest)
    val MissingPriceBody = Error(17, "Request doesn't contain the required 'price' argument.", HttpStatusCode.BadRequest)
    val MissingAmountBody = Error(18, "Request doesn't contain the required 'amount' argument.", HttpStatusCode.BadRequest)
    val MissingUserIdBody = Error(19, "Request doesn't contain the required 'user_id' argument.", HttpStatusCode.BadRequest)
    val MissingCategoryBody = Error(20, "Request doesn't contain the required 'category' argument.", HttpStatusCode.BadRequest)
    val MissingAgeMinBody = Error(21, "Request doesn't contain the required 'age_min' argument.", HttpStatusCode.BadRequest)
    val MissingAgeMaxBody = Error(22, "Request doesn't contain the required 'age_max' argument.", HttpStatusCode.BadRequest)
    val MissingVotesBody = Error(23, "Request doesn't contain the required 'votes' argument.", HttpStatusCode.BadRequest)
    val MissingDianaBody = Error(24, "Request doesn't contain the required 'diana' argument.", HttpStatusCode.BadRequest)
    val MissingDiana2Body = Error(25, "Request doesn't contain the required 'diana_2' argument.", HttpStatusCode.BadRequest)
    val MissingEsquadraBody = Error(26, "Request doesn't contain the required 'esquadra' argument.", HttpStatusCode.BadRequest)
    val MissingEntradaBody = Error(27, "Request doesn't contain the required 'entrada' argument.", HttpStatusCode.BadRequest)
    val MissingProcessoBody = Error(28, "Request doesn't contain the required 'processo' argument.", HttpStatusCode.BadRequest)
    val MissingAlardoBody = Error(29, "Request doesn't contain the required 'alardo' argument.", HttpStatusCode.BadRequest)
    val MissingPaysDinaBody = Error(30, "Request doesn't contain the required 'pays_dina' argument.", HttpStatusCode.BadRequest)
    val MissingPaysMigAnyAndMusicsBody = Error(31, "Request doesn't contain the required 'pays_mig_any_and_musics' argument.", HttpStatusCode.BadRequest)
    val MissingAssaigBody = Error(32, "Request doesn't contain the required 'pays_assaig' argument.", HttpStatusCode.BadRequest)
    val MissingPaysEntradetaBody = Error(33, "Request doesn't contain the required 'pays_entradeta' argument.", HttpStatusCode.BadRequest)
    val MissingPaysEsmorzarGloriaBody = Error(34, "Request doesn't contain the required 'pays_esmorzar_gloria' argument.", HttpStatusCode.BadRequest)
    val MissingPaysEsmorzarFestesBody = Error(35, "Request doesn't contain the required 'pays_esmorzar_festes' argument.", HttpStatusCode.BadRequest)
    val MissingPaysDinarEntradaBody = Error(36, "Request doesn't contain the required 'pays_dinar_entrada' argument.", HttpStatusCode.BadRequest)
    val MissingPaysDinarSantJordiBody = Error(37, "Request doesn't contain the required 'pays_dinar_sant_jordi' argument.", HttpStatusCode.BadRequest)
    val MissingPaysSoparSantJordiBody = Error(38, "Request doesn't contain the required 'pays_sopar_sant_jordi' argument.", HttpStatusCode.BadRequest)
    val MissingPaysDinarTronsBody = Error(39, "Request doesn't contain the required 'pays_dinar_trons' argument.", HttpStatusCode.BadRequest)
    val MissingRoleBody = Error(40, "Request doesn't contain the required 'role' argument.", HttpStatusCode.BadRequest)

    val NifAlreadyRegistered = Error(100, "The given NIF is already registered in the database.", HttpStatusCode.BadRequest)

    val Unauthorized = Error(110, "Token is not valid or has expired.", HttpStatusCode.Unauthorized)
    val NifNotFound = Error(111, "The given NIF was not found in the database.", HttpStatusCode.BadRequest)
    val WrongPassword = Error(112, "Wrong NIF or password.", HttpStatusCode.BadRequest)
    val MissingPermission = Error(113, "You are not authorized to perform this operation", HttpStatusCode.Forbidden)
    val MissingUsagePermission = Error(114, "The user doesn't have the usage permission: Not confirmed", HttpStatusCode.Forbidden)

    val AssistanceAlreadyConfirmed = Error(120, "Assistance already confirmed.", HttpStatusCode.BadRequest)
    val UserAlreadyInTable = Error(121, "You are already in a table.", HttpStatusCode.BadRequest)
    val UserNotInTable = Error(122, "The user is not in the table.", HttpStatusCode.BadRequest)
    val UserNotAssistingEvent = Error(123, "The user has still not confirmed assistance to event.", HttpStatusCode.BadRequest)

    val NifInvalid = Error(130, "The given NIF is not valid.", HttpStatusCode.BadRequest)
    val EmailInvalid = Error(131, "The given email is not valid.", HttpStatusCode.BadRequest)
    val CategoryInvalid = Error(132, "The given category is not valid.", HttpStatusCode.BadRequest)
    val CategoryIllegal = Error(133, "The given category can't be modified.", HttpStatusCode.BadRequest)
}
