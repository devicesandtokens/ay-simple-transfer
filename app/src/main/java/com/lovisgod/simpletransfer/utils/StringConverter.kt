package com.lovisgod.simpletransfer.utils

import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okio.ByteString


open class StringConverter  {

   open  fun fromBody(body: ResponseBody): String {
        return ByteString.read(body.byteStream(), body.contentLength().toInt()).utf8()
    }

    open fun toBody(value: Any): RequestBody {
        return RequestBody.create(MediaType.parse("text/plain"), value.toString())
    }
}