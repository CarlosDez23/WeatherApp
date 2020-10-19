package com.example.weatherapp.domain

public interface Command<out T>{
    fun execute(): T
}