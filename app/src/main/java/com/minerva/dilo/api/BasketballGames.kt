package com.minerva.dilo.api

import android.net.Uri

object BasketballGames {
    private val URLAKSES = "https://www.balldontlie.io/"
    fun getGames(): String{
        return Uri.parse(URLAKSES).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("games")
            .build().toString()
    }

    fun getDetail(id: Int): String {
        return Uri.parse(URLAKSES).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("games")
                .appendPath(id.toString())
                .build().toString()
    }

}
