package com.lovisgod.simpletransfer.repo

import com.lovisgod.simpletransfer.data.TokenPassportResponse
import com.lovisgod.simpletransfer.data.TransferResponse
import com.lovisgod.simpletransfer.network.Clientbuilder
import com.lovisgod.simpletransfer.network.ResponseHelper
import com.lovisgod.simpletransfer.network.TokenBuilder
import com.lovisgod.simpletransfer.network.safeApiCall
import com.lovisgod.simpletransfer.utils.StringConverter
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class Repository {

    var knClient = Clientbuilder.create()
    var tokenClient = TokenBuilder.create()

    suspend fun getToken(xmlbody: String): Response<TokenPassportResponse> {
        val body = StringConverter().toBody(xmlbody)
        return tokenClient.getToken(body)
    }

    suspend fun makeTransfer(xmlbody: String, token: String): ResponseHelper<TransferResponse> {
        val body = StringConverter().toBody(xmlbody)
        return  safeApiCall(Dispatchers.IO) {
            knClient.makeTransfer(body, token)
        }
    }
}