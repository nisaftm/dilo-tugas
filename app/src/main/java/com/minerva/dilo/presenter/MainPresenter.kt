package com.minerva.dilo.presenter

import android.util.Log
import com.google.gson.Gson
import com.minerva.dilo.api.ApiRepository
import com.minerva.dilo.api.BasketballGames
import com.minerva.dilo.data.GamesResponse
import com.minerva.dilo.ui.main.MainView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(val view: MainView,
                    val apiRepository: ApiRepository,
                    val gson: Gson
) {
    fun getGames(){
        view.showLoading()
        
        doAsync { 
            val data = gson.fromJson(apiRepository
                .doRequest(BasketballGames.getGames()), 
                GamesResponse::class.java)
            
            uiThread { 
                view.hideLoading()
                view.getListGames(data.data)
                Log.d("MainPresenter","data: $data")
            }
        }
    }


}
