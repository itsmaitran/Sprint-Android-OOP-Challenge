package com.lambdaschool.sprintandroidoopchallenge.model

import com.google.gson.annotations.SerializedName

class Technologies (

    val description: String,
    val age: String,
    @SerializedName("build_time") val buildTime: Int

) : AgeOfEmpiresApiObject() {

    override fun info(): String = "Description: $description\nAge: $age\nBuild Time: $buildTime"

    override fun toString(): String {
        return "Name$name:\nDescription:$description\nExpansion: $expansion\nAge: $age"
    }
}