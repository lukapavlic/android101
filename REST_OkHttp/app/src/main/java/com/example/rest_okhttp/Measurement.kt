package com.example.rest_okhttp

import java.io.Serializable
import java.util.*

data class Measurement (
    var comment: String,
    var geo: String?,
    var id: Int?,
    var label: String,
    var type :String,
    var timeStamp: Long,
    var units :String?,
    var userEmail: String,
    var value :Double
): Serializable