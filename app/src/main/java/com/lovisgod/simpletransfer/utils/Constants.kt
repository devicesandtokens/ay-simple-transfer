package com.lovisgod.simpletransfer.utils

import com.lovisgod.simpletransfer.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

val KIMONO_BASE_URL = "https://qa.interswitchng.com/kmw/"
val TOKEN_BASE_URL = "https://saturn.interswitchng.com:443/kimonotms/"


val sLogLevel =
    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE


val interceptor = HttpLoggingInterceptor()