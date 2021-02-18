package com.lovisgod.simpletransfer.network

import com.lovisgod.simpletransfer.data.TokenPassportResponse
import com.lovisgod.simpletransfer.data.TransferResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @POST("kimonoservice/amex")
    suspend fun makeTransfer(@Body body : RequestBody, @Header("Authorization") token: String): Response<TransferResponse>

    @Headers("Content-Type: application/xml")
    @POST("requesttoken/perform-process")
    suspend fun getToken(@Body body: RequestBody): Response<TokenPassportResponse>
}