package com.example.blinkitclone.model

import java.io.Serializable

data class Product(
    val name: String,
    val price: Int,
    val image: Int,
    var quantity: Int = 0
) : Serializable