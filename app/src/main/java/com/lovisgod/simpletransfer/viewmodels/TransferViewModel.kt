package com.lovisgod.simpletransfer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lovisgod.simpletransfer.repo.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransferViewModel: ViewModel() {
    var repo = Repository()
    fun getToken () = liveData(Dispatchers.Main) {
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
        val response = repo.getToken(xmlString)
            response?.let {
                if (it.isSuccessful) {
                    var token = it.body()?.token.toString()
                    emit(token)
                }
            }

    }

    fun makeTransfer(token: String, amount: Int) = liveData(Dispatchers.IO) {
        var xmlString = """<transferRequest>
                                <terminalInformation>
                                     <batteryInformation>100</batteryInformation>
                                     <currencyCode>566</currencyCode>
                                     <languageInfo>EN</languageInfo>
                                     <merchantId>203900000000007</merchantId>
                                     <merhcantLocation>ABCD STATE GOVERNMENT  ON LANG</merhcantLocation>
                                     <posConditionCode>00</posConditionCode>
                                     <posDataCode>510101511344101</posDataCode>
                                     <posEntryMode>051</posEntryMode>
                                     <posGeoCode>00234000000000566</posGeoCode>
                                     <printerStatus>1</printerStatus>
                                     <terminalId>20390007</terminalId>
                                     <terminalType>22</terminalType>
                                     <transmissionDate>2020-09-18T10:52:26</transmissionDate>
                                     <uniqueId>3H661643</uniqueId>
                                </terminalInformation>
                                <cardData>
                                    <cardSequenceNumber>01</cardSequenceNumber>
                                    <emvData>
                                        <AmountAuthorized>000000000001</AmountAuthorized>
                                        <AmountOther>000000000000</AmountOther>
                                        <ApplicationInterchangeProfile>3900</ApplicationInterchangeProfile>
                                        <atc>04A0</atc>
                                        <Cryptogram>5F928661B1A2ECDD</Cryptogram>
                                        <CryptogramInformationData>80</CryptogramInformationData>
                                        <CvmResults>440302</CvmResults>
                                        <iad>0110A7C003020000E87C00000000000000FF</iad>
                                        <TransactionCurrencyCode>566</TransactionCurrencyCode>
                                        <TerminalVerificationResult>0000008000</TerminalVerificationResult>
                                        <TerminalCountryCode>566</TerminalCountryCode>
                                        <TerminalType>22</TerminalType>
                                        <TerminalCapabilities>E0F8C8</TerminalCapabilities>
                                        <TransactionDate>200806</TransactionDate>
                                        <TransactionType>00</TransactionType>
                                        <UnpredictableNumber>2E170407</UnpredictableNumber>
                                        <DedicatedFileName>A0000000041010</DedicatedFileName>
                                    </emvData>
                                    <track2>
                                        <pan>53994100000000005</pan>
                                        <expiryMonth>05</expiryMonth>
                                        <expiryYear>22</expiryYear>
                                        <track2>53994100000000005D2205201000000000</track2>
                                    </track2>
                                </cardData>
                                <originalTransmissionDateTime>2020-09-18T10:52:26</originalTransmissionDateTime>
                                <stan>000018</stan>
                                <fromAccount>Default</fromAccount>
                                <toAccount></toAccount>
                                <minorAmount>${amount * 100}</minorAmount>
                                <receivingInstitutionId>627821</receivingInstitutionId>
                                <surcharge>1075</surcharge>
                                <pinData>
                                    <ksnd>605</ksnd>
                                    <ksn></ksn>
                                    <pinType>Dukpt</pinType>
                                    <pinBlock></pinBlock>
                                </pinData>
                                <keyLabel>000006</keyLabel>
                                <destinationAccountNumber>2000000001</destinationAccountNumber>
                                 <extendedTransactionType>6101</extendedTransactionType>
</transferRequest>"""
        var response = repo.makeTransfer(xmlbody = xmlString, token = token)
        response?.let {
            if (it.isSuccessful) {
                emit(it.body())
            }
        }
    }
}