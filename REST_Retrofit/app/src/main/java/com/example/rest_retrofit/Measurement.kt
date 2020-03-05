package com.example.rest_retrofit

import java.io.Serializable
import java.util.*

data class Measurement (
    var comment: String?,
    var geo: String?,
    var id: Long?,
    var label: String,
    var measurementType :String,
    var timeStamp: Long,
    var unit :String?,
    var userEmail: String,
    var value :Double
): Serializable