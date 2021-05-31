package com.example.healthh.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.healthhome.DB.ModelData

class DBHelper(context: Context) : SQLiteOpenHelper(context, "health.db", null, 1) {

    val tableName : String = "how_table"
    val id : String = "Id"
    val title : String = "Title"
    val desc : String = "Description"

    val name : String = "pressure_table"
    val id_pressure : String = "Id_Pressure"
    val pressure_up : String = "Up"
    val pressure_down : String = "Down"
    val pulse : String = "Pulse"
    val state : String = "State"

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE $tableName ($id INTEGER PRIMARY KEY AUTOINCREMENT, $title INTEGER NOT NULL, $desc INTEGER NOT NULL)")
        p0?.execSQL("CREATE TABLE $name ($id_pressure INTEGER PRIMARY KEY AUTOINCREMENT, $pressure_up INTEGER NOT NULL, $pressure_down INTEGER NOT NULL, $pulse INTEGER NOT NULL, $state INTEGER NOT NULL)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $tableName")
        onCreate(p0)
    }

    fun onDeleteDB(){
        writableDatabase.execSQL("DROP TABLE IF EXISTS $tableName")
    }

    fun addData(data: ModelData) : Boolean{
        val contentValues: ContentValues = ContentValues()

        contentValues.put(title, data.getTitle())
        contentValues.put(desc, data.getDesc())

        return this.writableDatabase.insert(tableName, null, contentValues) != 1L
    }

    fun addData_Pressure(
        data: ModelPressure
    ) : Boolean{
        val contentValues: ContentValues = ContentValues()

        contentValues.put(pressure_up, data.getPressure_up())
        contentValues.put(pressure_down, data.getPressure_down())
        contentValues.put(pulse, data.getPulse())
        contentValues.put(state, data.getState())

        return  this.writableDatabase.insert(name, null, contentValues) != 1L
    }

    fun deleteData(data : ModelData) : Boolean {
        return this.writableDatabase.delete(tableName, "$title = '${data.getTitle()}'AND $desc = '${data.getDesc()}'", null) != -1
    }

    fun updateData(data : ModelData, newData : ModelData) : Boolean{

        val contentValues : ContentValues = ContentValues()

        contentValues.put(title, newData.getTitle())
        contentValues.put(desc, newData.getDesc())

        return this.writableDatabase.update(tableName, contentValues, "$title = '${data.getTitle()}'AND $desc = '${data.getDesc()}'", null) != -1
    }

    fun showDataPressure(): MutableList<ModelPressure>{
        val cursor : Cursor = this.readableDatabase.query(name, arrayOf(id_pressure, pressure_up, pressure_down, pulse, state), null, null, null, null, null)
        val massData : MutableList<ModelPressure> = arrayListOf()

        if (cursor != null){
            if (cursor.moveToFirst()){
                do{
                    massData.add(ModelPressure(cursor.getInt(cursor.getColumnIndex(id_pressure)), cursor.getString(cursor.getColumnIndex(pressure_up)),cursor.getString(cursor.getColumnIndex(pressure_down)), cursor.getString(cursor.getColumnIndex(pulse)), cursor.getString(cursor.getColumnIndex(state))))
                }while (cursor.moveToNext())
            }
        }

        return massData
    }

    fun showData(): MutableList<ModelData> {
        val cursor : Cursor = this.readableDatabase.query(tableName, arrayOf(id, title, desc), null, null, null, null, null)
        val massData : MutableList<ModelData> = arrayListOf()

        if(cursor != null) {
            if(cursor.moveToFirst()){
                do{
                    massData.add(ModelData(cursor.getInt(cursor.getColumnIndex(id)), cursor.getString(cursor.getColumnIndex(title)), cursor.getString(cursor.getColumnIndex(desc))))
                }while (cursor.moveToNext())
            }
        }
        return massData

    }






}