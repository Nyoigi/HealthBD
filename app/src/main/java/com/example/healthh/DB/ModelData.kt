package com.example.healthhome.DB

import android.app.Activity

class ModelData (title : String, desc: String) {
    private var Title : String = ""
    private var Desc : String = ""
    private var Id : Int = 0


    init {

        Title = title
        Desc = desc
    }

    constructor(id : Int, title: String, desc: String) : this(title, desc){
        Id = id
    }



    fun getId() : Int{
        return Id
    }


    fun getTitle() : String{
        return Title
    }

    fun getDesc() : String{
        return Desc
    }

    fun setId(id: Int){
        Id = id
    }

    fun setTitle(title: String){
        Title = title
    }

    fun setDesc(desc: String){
        Desc = desc
    }
}