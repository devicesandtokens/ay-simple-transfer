package com.lovisgod.simpletransfer.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lovisgod.simpletransfer.repo.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransferViewModel: ViewModel() {
    var repo = Repository()
    fun getToken () = liveData(Dispatchers.Main) {
            println("getting here")
            var xmlString = """<tokenPassportRequest>
	                                <terminalInformation>
		                                <batteryInformation/>
		                                <cellStationId/>
		                                <currencyCode/>
		                                <languageInfo/>
                                        <merchantId>203900000000007</merchantId>
		                                <merhcantLocation/>
		                                <posConditionCode/>
		                                <posDataCode/>
		                                <posEntryMode/>
		                                <posGeoCode/>
		                                <printerStatus/>
		                                <terminalId>20390007</terminalId>
		                                <terminalType/>
		                                <transmissionDate/>
		                                <uniqueId/>
	                                </terminalInformation>
</tokenPassportRequest>"""
        println(xmlString)
            val response = repo.getToken(xmlString)
        println(response)
            response?.let {
                if (it.isSuccessful) {
                    println(it.body()?.responseMessage.toString())
                    var token = it.body()?.token.toString()
                    emit(token)
                }
            }

    }
}