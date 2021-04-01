package com.app.daggerapp.data.repository

import com.app.daggerapp.R
import com.app.daggerapp.data.model.ChildModel
import java.util.*

object ChildDataFactory{

    private val random = Random()

    private val titles =  arrayListOf( "Aviator", "Now you can See me", "God Father", "Mission Impossible", "3 idiots")

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomImage() : Int{
        return R.drawable.ic_launcher_background
    }

    fun getChildren(count : Int) : List<ChildModel>{
        val children = mutableListOf<ChildModel>()
        repeat(count){
            val child = ChildModel(randomImage(), randomTitle())
            children.add(child)
        }
        return children
    }


}