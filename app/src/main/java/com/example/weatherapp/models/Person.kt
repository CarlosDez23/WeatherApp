package com.example.weatherapp.models

/**
 * Con esto marcamos que hereda de la clase animal y le pasamos
 * los parámetros que sean necesarios para el constructor de la
 * clase padre. Es igual que llamar  a super() en Java
 */
class Person (var firstName: String, var lastName: String) : Animal(firstName) {
    init{
        //Cuerpo del constructor
    }
}