package com.example.firsttest.mvvmlibrary.base

import android.util.Log
import android.util.MalformedJsonException
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.google.gson.JsonParseException
import kotlinx.coroutines.*
import org.json.JSONException
import retrofit2.HttpException
import java.text.ParseException


/*
修改       确认修改
*/
open class BaseViewModel : ViewModel() {
    //成功数据
    private lateinit var successMutableLiveData: MutableLiveData<Any>

    //失败数据
    private val errorMutableLiveData: MutableLiveData<Any> by lazy { MutableLiveData<Any>() }

    private val coroutineScope: CoroutineScope by lazy { CoroutineScope(Dispatchers.Main) }

    fun <T> requestHttp(
        successMutableLiveData: MutableLiveData<Any>,
        block: suspend CoroutineScope.() -> BaseResponse<T>
    ) {
        this.successMutableLiveData = successMutableLiveData
        coroutineScope.launch {
            val withContext: Int
            var baseResponse: BaseResponse<T>? = null
            try {
                withContext = withContext(Dispatchers.IO) {
                    baseResponse = block()
                    block().status
                }
                if (withContext == 0) {
                    if (baseResponse != null) {
                        successMutableLiveData.postValue(baseResponse!!.data)
                        Log.e("TAG", "requestHttp1: "+baseResponse!!.data )
                    } else {
                        successMutableLiveData.postValue(withContext)
                        Log.e("TAG", "requestHttp2: "+baseResponse!!.data )
                    }
                } else {
                    errorMutableLiveData.postValue(baseResponse?.message)
                    Log.e("TAG", "requestHttp3: "+baseResponse!!.data )
                }
            } catch (e: Exception) {
                when (e) {
                    is HttpException -> {
                        errorMutableLiveData.postValue("网络请求异常==$e")
                    }
                    is JsonParseException,
                    is JSONException,
                    is ParseException,
                    is MalformedJsonException -> {
                        errorMutableLiveData.postValue("网络解析错误==$e")
                    }
                }

            }
            if (baseResponse != null) {
                if (baseResponse!!.status != 0) {
                    errorMutableLiveData.postValue(baseResponse!!.message)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        if (coroutineScope.isActive) {
            coroutineScope.cancel()
        }
    }

    fun onSuccess(): MutableLiveData<Any> {
        return successMutableLiveData
    }

    fun onError(): MutableLiveData<Any> {
        return errorMutableLiveData
    }

    fun <T> subscribe(
        owner: LifecycleOwner,
        successData: MutableLiveData<in T>,
        errorData: MutableLiveData<Any>,
        onSuccess: (T) -> Unit,
        onError: (any: Any?) -> Unit
    ) {
        successData.observe(owner, Observer {
            onSuccess(it as T)
        })
        errorData.observe(owner, Observer {
            onError(it)
        })
    }
}