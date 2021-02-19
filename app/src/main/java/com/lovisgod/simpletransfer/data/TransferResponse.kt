package com.lovisgod.simpletransfer.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement


@Root(name = "transferResponse", strict = false)
data class TransferResponse (
    @field:Element(required = false, name = "description")
    @param:Element(required = false, name = "description")
    var description: String? = "",
    @field:Element(required = false, name = "field39")
    @param:Element(required = false, name = "field39")
    var field39: String? = "",
    @field:Element(required = false, name = "authId")
    @param:Element(required = false, name = "authId")
    var authId : String? = "",
    @field:Element(required = false, name = "hostEmvData")
    @param:Element(required = false, name = "hostEmvData")
    var hostEmvData : HostEmvData? = null,
    @field:Element(required = false, name = "referenceNumber")
    @param:Element(required = false, name = "referenceNumber")
    var referenceNumber : String? = "",
    @field:Element(required = false, name = "stan")
    @param:Element(required = false, name = "stan")
    var stan: Int? = 0,
    @field:Element(required = false, name = "transactionChannelName")
    @param:Element(required = false, name = "transactionChannelName")
    var transactionChannelName: String? = "",
    @field:Element(required = false, name = "wasReceive")
    @param:Element(required = false, name = "wasReceive")
    var wasReceive: Boolean? = false,
    @field:Element(required = false, name = "wasSend")
    @param:Element(required = false, name = "wasSend")
    var wasSend: Boolean? = false

)


@Root(name = "hostEmvData")
data class HostEmvData (
    @field:Element(required = false, name = "AmountAuthorized")
    @param:Element(required = false, name = "AmountAuthorized")
    var AmountAuthorized: Int? = 0,
    @field:Element(required = false, name = "AmountOther")
    @param:Element(required = false, name = "AmountOther")
    var AmountOther: Int? = 0,
    @field:Element(required = false, name = "atc")
    @param:Element(required = false, name = "atc")
    var atc: String? = "",
    @field:Element(required = false, name = "iad")
    @param:Element(required = false, name = "iad")
    var iad: String? = "",
    @field:Element(required = false, name = "rc")
    @param:Element(required = false, name = "rc")
    var rc: String? = ""
)