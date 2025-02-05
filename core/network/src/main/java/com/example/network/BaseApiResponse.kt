package com.example.network

import kotlinx.serialization.Serializable


@Serializable
data class BaseApiResponse<T>(
    val data: T?,
    val message: String?,
    val errors: HashMap<String, List<String>>? = null
)
