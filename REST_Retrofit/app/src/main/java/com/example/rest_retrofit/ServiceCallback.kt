package com.example.rest_retrofit

interface ServiceCallback {
    fun onSuccess(measurements: ArrayList<Measurement>)

    fun onError(throwable: Throwable)
}


