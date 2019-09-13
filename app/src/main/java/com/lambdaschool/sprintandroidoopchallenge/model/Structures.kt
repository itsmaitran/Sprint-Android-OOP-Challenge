package com.lambdaschool.sprintandroidoopchallenge.model

import com.google.gson.annotations.SerializedName

data class Structures (

    @SerializedName("build_time") val buildTime: Int,
    @SerializedName("hit_points") val hitPoints: Int,
    @SerializedName("line_of_sight") val lineOfSight: Int,
    val armor: String

) : AgeOfEmpiresApiObject() {

    override fun info(): String = "Build Time: $buildTime\nHit Points: $hitPoints\nLine of Sight: $lineOfSight\nArmor: $armor"

    override fun toString(): String {
        return "$name has a build time of $buildTime, hit points of $hitPoints, a line of sight of $lineOfSight, and an armor rating of $armor."
    }
}