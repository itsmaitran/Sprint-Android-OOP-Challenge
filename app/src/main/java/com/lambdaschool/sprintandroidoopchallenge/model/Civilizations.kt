package com.lambdaschool.sprintandroidoopchallenge.model

import com.google.gson.annotations.SerializedName

data class Civilizations (

    @SerializedName("army_type") val armyType: String,
    @SerializedName("team_bonus") val teamBonus: String

) : AgeOfEmpiresApiObject() {

    override fun info(): String = "Army Type: $armyType\nTeam Bonus: $teamBonus"

    override fun toString(): String {
        return "$name has an army type of $armyType and their team bonus would be $teamBonus."
    }
}