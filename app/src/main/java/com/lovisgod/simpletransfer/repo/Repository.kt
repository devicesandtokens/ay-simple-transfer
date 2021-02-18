package com.lovisgod.simpletransfer.repo

import com.lovisgod.simpletransfer.data.TokenPassportResponse
import com.lovisgod.simpletransfer.data.TransferResponse
import com.lovisgod.simpletransfer.network.Clientbuilder
import com.lovisgod.simpletransfer.network.TokenBuilder
import com.lovisgod.simpletransfer.utils.StringConverter
import retrofit2.Response

class Repository {

    var knClient = Clientbuilder.create()
    var tokenClient = TokenBuilder.create()

    suspend fun getToken(xmlbody: String): Response<TokenPassportResponse> {
        val body = StringConverter().toBody(xmlbody)
        println(body)
        return tokenClient.getToken(body)
    }

    suspend fun makeTransfer(xmlbody: String, token: String): Response<TransferResponse> {
        val body = StringConverter().toBody(xmlbody)
        return tokenClient.makeTransfer(body, token)
    }
}