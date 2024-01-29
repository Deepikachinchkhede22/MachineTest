package com.bitcodetech.machiinetest.models
import java.io.Serializable

data class Book(
    val image : String,
    val title : String,
    val subtitle : String,
    val isbn13 : String,
    val price : String,
    val url : String
):Serializable



