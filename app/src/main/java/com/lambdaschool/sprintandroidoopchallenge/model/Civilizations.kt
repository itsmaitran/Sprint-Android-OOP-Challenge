package com.lambdaschool.sprintandroidoopchallenge.model

import com.google.gson.annotations.SerializedName

class Civilizations (
    name: String,
    expansion: String,
    isFavorite: Boolean,
    @SerializedName("army_type") val armyType: String,
    @SerializedName("team_bonus") val teamBonus: String

) : AgeOfEmpires(name, expansion, isFavorite) {

    override fun info(): String = "Civilization: $name\nExpansion: $expansion\nArmy Type: $armyType\nTeam Bonus: $teamBonus"

    override fun toString(): String {
        return "$name has an army type of $armyType and their team bonus would be $teamBonus."
    }
}