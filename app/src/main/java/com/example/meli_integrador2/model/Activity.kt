package com.example.meli_integrador2.model

data class Activity(
    val activity        : String,
    val type            : String? = null,
    val price           : Float,
    val participants    : Int,
    val error : String? = null
)
