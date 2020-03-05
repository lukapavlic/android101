package com.example.rest_volley

import java.io.Serializable

data class Measurement (
    var comment: String,
    var geo: String?,
    var id: Long?,
    var label: String,
    var type :String,
    var timeStamp: Long,
    var unit :String?,
    var userEmail: String,
    var value :Double
): Serializable