package com.minerva.dilo.presenter

import com.google.gson.Gson
import com.minerva.dilo.api.ApiRepository
import com.minerva.dilo.api.BasketballGames
import com.minerva.dilo.data.DetailResponse
import com.minerva.dilo.ui.detail.DetailView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter(val view: DetailView,
                      val apiRepository: ApiRepository,
                      val gson: Gson) {
    fun getDetail(id: Int) {
        view.showLoading()
        
        doAsync { 
            val data = gson.fromJson(apiRepository
                    .doRequest(BasketballGames.getDetail(id)), DetailResponse::class.java)
            
            uiThread { 
                view.hideLoading()
                view.getDetailGames(data)
                
            }
            
        }
    }


}
