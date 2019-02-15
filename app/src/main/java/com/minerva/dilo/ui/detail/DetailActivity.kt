package com.minerva.dilo.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import com.google.gson.Gson
import com.minerva.dilo.R
import com.minerva.dilo.api.ApiRepository
import com.minerva.dilo.data.DetailResponse
import com.minerva.dilo.presenter.DetailPresenter
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity(), DetailView {
    override fun getDetailGames(data: DetailResponse) {
        pbdetail.visibility= GONE
        showData(data)
        
    }

    private fun showData(data: DetailResponse) {
        val dateFormat : DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val newFormat: DateFormat = SimpleDateFormat("E, dd MMM yyyy")

        var date = dateFormat.parse(data.date)

        tvtanggal.text=newFormat.format(date)

        tvscorehome.text=data.home_team_score.toString()
        tvscorevisitor.text=data.visitor_team_score.toString()

        tvabbreviationhome.text=data.home_team.abbreviation
        tvabbreviationvisitor.text=data.visitor_team.abbreviation

        tvcityhome.text=data.home_team.city
        tvcityvisitor.text=data.visitor_team.city

        tvconferencehome.text=data.home_team.conference
        tvconferencevisitor.text=data.visitor_team.conference

        tvdivisionhome.text= data.home_team.division
        tvdivisionvisitor.text= data.visitor_team.division

        tvfullnamehome.text = data.home_team.full_name
        tvfullnamevisitor.text = data.visitor_team.full_name

        tvteamhome.text=data.home_team.name
        tvteamvisitor.text=data.visitor_team.name
    }

    override fun showLoading() {
        pbdetail.visibility=VISIBLE
    }

    override fun hideLoading() {
        pbdetail.visibility= GONE
    }
    

    private lateinit var presenter : DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        val id = intent.getIntExtra("item", 0)
        val request = ApiRepository()
        val gson=Gson()
        
        presenter = DetailPresenter(this, request, gson)
        presenter.getDetail(id)
        
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            
            else -> super.onOptionsItemSelected(item)
        }
    }
}
