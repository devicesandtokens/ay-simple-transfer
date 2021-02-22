package com.lovisgod.simpletransfer.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun <T>     safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend ()
-> Response<T>): ResponseHelper<T> {
    return withContext(dispatcher) {
        try {
            val response = apiCall.invoke()
            if (response.isSuccessful) {
                ResponseHelper.Success(response.body()!!)
            } else {
                ResponseHelper.Success(response.body()!!)
            }
        } catch (e: Throwable) {
            println("input message ${e.message}")
            e.printStackTrace()
            ResponseHelper.NetworkError(message = e.message.toString())
        }
    }
}

//private fun convertErrorBody(response: ResponseBody?): ErrorResponse? {
//    return try {
//        val gson = Gson()
//        gson.fromJson(response?.string(), ErrorResponse::class.java)
//    }
//    catch (exception: Exception) {
//        Log.d("TAG", "errorcode is this ${exception.message}")
//        null
//    }
//}

sealed class ResponseHelper<out T> {
    data class Success<out T>(val value: T): ResponseHelper<T>()
//    data class  GenericError(val code: Int? = null, val error: ErrorResponse? = null): ResponseHelper<Nothing>()
    data class NetworkError(var message: String = "Error during operation please check your network"): ResponseHelper<Nothing>()
}