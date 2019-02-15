package com.minerva.dilo.ui.main

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.google.gson.Gson
import com.minerva.dilo.R
import com.minerva.dilo.api.ApiRepository
import com.minerva.dilo.data.Data
import com.minerva.dilo.presenter.MainPresenter
import com.minerva.dilo.ui.detail.DetailActivity
import com.minerva.dilo.ui.main.item.JadwalItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), MainView {
    override fun showLoading() {
        pbmain.visibility=VISIBLE
    }

    override fun hideLoading() {
        pbmain.visibility= GONE
    }

    override fun getListGames(data: List<Data>) {
        pbmain.visibility= GONE
        adapterGames.clear()
        adapterGames.addAll(data.map {item->
            JadwalItem(item){
                startActivity<DetailActivity>("item" to it.id)
            }
        })
        adapterGames.notifyDataSetChanged()
    }

    private var adapterGames= GroupAdapter<ViewHolder>()

    private val activity: Activity=this

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this, request, gson)
        presenter.getGames()
        
        rvmainjadwal.apply { 
            layoutManager=LinearLayoutManager(activity)
            adapter = adapterGames
        }
    }
}
