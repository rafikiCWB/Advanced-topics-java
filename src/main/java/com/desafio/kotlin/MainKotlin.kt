package com.desafio.kotlin

import java.time.LocalDate

fun main() {

    val listaPerson = ArrayList<PersonKotlin>()
    listaPerson.add(PersonKotlin("Rafael", 28, LocalDate.of(1996,6,21)))
    println(listaPerson)
}