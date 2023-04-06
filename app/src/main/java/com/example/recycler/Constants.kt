package com.example.recycler

lateinit var MAIN: MainActivity

const val BASE_URL: String = "https://mobile-api.dev2.flnet.su/gate/"
const val SEARCH_MAX_SYMBOLS: Int = 15

operator fun Boolean.inc() = !this