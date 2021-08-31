package com.example.myapplication

object DataManger {
    private val listVaccineDetails = mutableListOf<VaccineDetails>()

    fun addVaccineDetails(vaccineData: VaccineDetails) = listVaccineDetails.add(vaccineData)

    fun getListCountry() = listVaccineDetails.map { it.country }.toMutableSet()

    fun getCountries(firstChar: Char) = getListCountry().filter {
        it.startsWith(
            firstChar.toUpperCase()
        )
    }.toMutableSet()
}