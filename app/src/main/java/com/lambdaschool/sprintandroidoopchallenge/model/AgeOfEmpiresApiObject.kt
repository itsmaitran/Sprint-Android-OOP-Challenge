package com.lambdaschool.sprintandroidoopchallenge.model

import java.io.Serializable

abstract class AgeOfEmpiresApiObject (

    open var id: Int = 0,
    open val name: String? = null,
    open val expansion: String? = null

) : Serializable {

    open fun info(): String = "Age of Empires II object"

    override fun toString(): String {
        return "AgeOfEmpiresApiObjec(ID: $id\nName: $name\nExpansion: $expansion"
    }
}