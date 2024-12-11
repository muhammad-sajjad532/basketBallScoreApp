package com.example.basketballscoreapp.model

class BasketballScoreModel {
    var teamAScore: Int = 0
    var teamBScore: Int = 0

    fun addPointsToTeamA(points: Int) {
        teamAScore += points
    }

    fun addPointsToTeamB(points: Int) {
        teamBScore += points
    }
}
