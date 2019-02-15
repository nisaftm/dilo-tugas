package com.minerva.dilo.ui.main

import com.minerva.dilo.data.Data

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun getListGames(data: List<Data>)
}
