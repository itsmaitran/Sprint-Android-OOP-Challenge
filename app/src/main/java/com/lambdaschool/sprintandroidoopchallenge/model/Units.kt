package com.lambdaschool.sprintandroidoopchallenge.model

class Units (
    name: String,
    expansion: String,
    isFavorite: Boolean,
    val range: String,
    val attack: Int,
    val armor: String,
    val accuracy: String

) : AgeOfEmpires(name, expansion, isFavorite) {

    override fun info(): String = "Expansion: $expansion\nRange: $range\nAttack: $attack\nArmor: $armor\nAccuracy: $accuracy"

    override fun toString(): String {
        return "$name has a range of $range, an attack of $attack, an armor rating of $armor, and an accuracy of $accuracy."
    }
}