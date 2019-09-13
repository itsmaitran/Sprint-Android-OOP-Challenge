package com.lambdaschool.sprintandroidoopchallenge.model

import java.io.Serializable

abstract class AgeOfEmpires (

    open val name: String,
    open val expansion: String,
    open var isFavorite: Boolean

) : Serializable {

    open fun info(): String = "Age of Empires II"

    override fun toString(): String {
        return "AgeOfEmpires(Name: $name\nExpansion: $expansion"
    }
}