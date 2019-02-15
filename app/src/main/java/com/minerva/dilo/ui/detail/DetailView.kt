package com.minerva.dilo.ui.detail

import com.minerva.dilo.data.DetailResponse

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun getDetailGames(data: DetailResponse)

}
