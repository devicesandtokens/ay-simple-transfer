package com.lovisgod.simpletransfer.data

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement


@XmlRootElement(name = "transferResponse")
data class TransferResponse (
    @XmlElement(required = false, name = "description")
    var description: String? = "",
    @XmlElement(required = false, name = "field39")
    var field39: String? = "",
    @XmlElement(required = false, name = "authId")
    var authId : String? = "",
    @XmlElement(required = false, name = "hostEmvData")
    var hostEmvData : HostEmvData? = null,
    @XmlElement(required = false, name = "stan")
    var stan: Int? = 0,
    @XmlElement(required = false, name = "transactionChannelName")
    var transactionChannelName: String? = "",
    @XmlElement(required = false, name = "wasReceive")
    var wasReceive: Boolean? = false,
    @XmlElement(required = false, name = "wasSend")
    var wasSend: Boolean? = false

)


@XmlRootElement(name = "hostEmvData")
class HostEmvData {
    @XmlElement(required = false, name = "AmountAuthorized")
    var AmountAuthorized: Int? = 0
    @XmlElement(required = false, name = "AmountOther")
    var AmountOther: Int? = 0
    @XmlElement(required = false, name = "atc")
    var atc: String? = ""
    @XmlElement(required = false, name = "iad")
    var iad: String? = ""
    @XmlElement(required = false, name = "rc")
    var rc: String? = ""
}