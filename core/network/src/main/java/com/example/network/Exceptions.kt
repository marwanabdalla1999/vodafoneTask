package com.example.network


/**
 * Exception represents IO exception or Http exception with code [HTTP_GATEWAY_TIMEOUT]
 */
object NetworkException : Exception("Network Exception")

/**
 * Exception represents Http Exception with error body of [ErrorBodyResponse]
 */
open class GeneralHttpException(
    val validationErrors: HashMap<String, List<String>>?,
    val errorMsg: String?
) : Exception("General Http Exception")

/**
 * Exception represents unauthorized user
 */
class UnauthorizedException : Exception("Unauthorized Exception")

/**
 * Exception represents any unknown Exception
 */
class UnknownException(message: String) : Exception(message)

/**
 * Exception represents parsing error
 * */
class ParsingException(message: String) : Exception(message)
