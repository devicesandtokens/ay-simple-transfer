package com.lovisgod.simpletransfer.network

import com.lovisgod.simpletransfer.utils.KIMONO_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

class Clientbuilder {
    companion object  Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .client(okHttp())
                .addConverterFactory(JaxbConverterFactory.create())
                .baseUrl(KIMONO_BASE_URL)
                .build()

            return retrofit.create(ApiService::class.java)
        }

        fun okHttp(): OkHttpClient {
            val builder = OkHttpClient().newBuilder()
            builder.connectTimeout(50, TimeUnit.SECONDS)
            builder.readTimeout(50, TimeUnit.SECONDS)
            builder.writeTimeout(50, TimeUnit.SECONDS)
            return builder.build()
        }
    }
}