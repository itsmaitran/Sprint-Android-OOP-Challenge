package com.lambdaschool.sprintandroidoopchallenge.model

import com.google.gson.annotations.SerializedName

data class Units (
    val range: Int,
    val attack: Int,
    val armor: String,
    val accuracy: String

) : AgeOfEmpiresApiObject() {

    override fun info(): String = "Range: $range\nAttack: $attack\nArmor: $armor\nAccuracy: $accuracy"

    override fun toString(): String {
        return "$name has a range of $range, an attack of $attack, an armor rating of $armor, and an accuracy of $accuracy."
    }
}