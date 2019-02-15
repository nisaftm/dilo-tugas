package com.minerva.dilo.ui.main.item

import com.minerva.dilo.R
import com.minerva.dilo.data.Data
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_rv_main.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class JadwalItem(val data: Data, val listener: (Data) -> Unit) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val itemView = viewHolder.itemView
        val dateFormat : DateFormat=SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val newFormat: DateFormat=SimpleDateFormat("E, dd MMM yyyy")

        var date = dateFormat.parse(data.date)
        
        itemView.tvitemdate.text=newFormat.format(date)
        itemView.tvitemhome.text= data.home_team.name
        itemView.tvitemhomescore.text= data.home_team_score.toString()
        itemView.tvitemvisitor.text=data.visitor_team.name
        itemView.tvitemvisitorscore.text=data.visitor_team_score.toString()
        
        itemView.setOnClickListener { 
            listener(data)
        }
    }

    override fun getLayout(): Int {
        return R.layout.item_rv_main
    }

}
