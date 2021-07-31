package com.example.lib

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.*
import kotlin.concurrent.thread

/**
 * 实现的功能, 下载图片并缓存
 *
 * 依赖
 * implementation "com.squareup.okhttp3:okhttp:3.14.4"
 *
 * typealias
 * SAM 转换 (单一抽象方法转换)
 * by lazy
 * apply函数
 * contract 契约
 * closeable use
 * also函数
 */
fun main() {
    // This will make the async call.
    callAsync {
        println("End 0")
        // This will return immediately from cache.
        callAsync {
            println("End 1")
        }
    }

}

fun callAsync(callback: (Bitmap) -> Unit) {
    val bitmap = asyncBitmap(
        "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png"
    ) { bitmap ->
        println("Async: $bitmap")
        callback(bitmap)
    }
    println("Main $bitmap")
    if (bitmap != null) {
        callback(bitmap)
    }
}

typealias Bitmap = ByteArray

object Cache {
    private val map = WeakHashMap<String, Bitmap>()

    fun get(key: String): Bitmap? {
        return map[key]
    }

    fun put(key: String, bitmap: Bitmap) {
        map[key] = bitmap
    }
}

fun download(url: String): Bitmap {
    return getAsStream(url).use { inputStream ->
        val bos = ByteArrayOutputStream()
        inputStream.copyTo(bos)
        bos.toByteArray()
    }
}

fun getAsStream(url: String): InputStream =
    httpClient.newCall(
        Request.Builder().get().url(url).build()
    ).execute().body()?.byteStream() ?: throw IOException("No body")

fun asyncBitmap(
    url: String,
    callback: (Bitmap) -> Unit
): Bitmap? {
    return when (val bitmap = Cache.get(url)) {
        null -> {
            thread {
                download(url)
                    .also { Cache.put(url, it) }
                    .also(callback)
            }
            null
        }
        else -> bitmap
    }
}

/**
 * OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
 *  @Override
 *  public Response intercept(Chain chain) throws IOException {
 *      return return chain.proceed(chain.request());;
 *  }
 * }).build();
 */
val httpClient: OkHttpClient by lazy {
    OkHttpClient.Builder().addInterceptor {
        it.proceed(it.request()).apply {
            println("request: ${this.code()}")
        }
    }.build()
}