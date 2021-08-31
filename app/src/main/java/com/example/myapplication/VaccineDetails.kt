package com.example.myapplication

data class VaccineDetails(
    var country : String,
    var iso_code : String,
    var date : String,
    var total_vaccinations : Double,
    var people_vaccinated : Double,
    var people_fully_vaccinated : Double,
    var daily_vaccinations_raw : Double,
    var daily_vaccinations : Double,
    var total_vaccinations_per_hundred : Double,
    var people_vaccinated_per_hundred : Double,
    var people_fully_vaccinated_per_hundred : Double,
    var daily_vaccinations_per_million : Double) {
}