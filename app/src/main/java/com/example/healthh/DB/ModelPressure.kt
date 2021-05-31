package com.example.healthh.DB

class ModelPressure(pressure_up: String, pressre_down: String, pulse: String, state: String) {

    private var Id_pressure : Int = 0
    private var Pressure_up : String = ""
    private var Pressure_down : String = ""
    private var Pulse : String = ""
    private var State : String = ""

    constructor(id_pressure : Int, pressure_up: String, pressure_down: String, pulse: String, state : String) : this(pressure_up, pressure_down, pulse, state){
        Id_pressure = id_pressure
    }

    fun getId_pressure() : Int{
        return Id_pressure
    }

    fun getPressure_up() : String{
        return Pressure_up
    }

    fun getPressure_down() : String{
        return Pressure_down
    }

    fun getPulse() : String{
        return Pulse
    }

    fun getState() : String{
        return State
    }
}