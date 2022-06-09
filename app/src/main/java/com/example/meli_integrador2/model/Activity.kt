package com.example.meli_integrador2.model

/**
  POJO conversion class
 */
data class Activity(
    val activity        : String,
    val type            : String? = null,
    val price           : Float,
    val participants    : Int,
    val error : String? = null
)
