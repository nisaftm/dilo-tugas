package com.minerva.dilo.data

data class Data(
        val date: String,
        val home_team: HomeTeam,
        val home_team_score: Int,
        val id: Int,
        val period: Int,
        val season: Int,
        val status: String,
        val time: String,
        val visitor_team: VisitorTeam,
        val visitor_team_score: Int
)
