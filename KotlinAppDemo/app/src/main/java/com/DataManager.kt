package com.example.kotlinappdemo

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.kotlinappdemo.models.ListData
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

object DataManager {

    var data = emptyArray<ListData>()
    var isDataLoaded = MutableStateFlow(false)
    private val client = OkHttpClient()

    fun fetchJsonDataFromFile(context:Context){
        val inputStrm = context.assets.open("jsonData.json")
        val size : Int = inputStrm.available()
        val buffer = ByteArray(size)
        inputStrm.read(buffer)
        inputStrm.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<ListData>::class.java)

        run("https://fakestoreapi.com/products")
        isDataLoaded.value = true
    }
    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
        })
    }
}



//const val BASE_URL = "https://imdb-API.com/"
//
//@Module
//@InstallIn(SingletonComponent::class)
//class RetrofitInstanceModule {
//
//    @Provides
//    @Singleton
//    fun theRetrofitInstance() : APIService {
//        val API : APIService by lazy {
//            Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(APIService::class.java)
//        }
//        return API
//    }
//
//}
