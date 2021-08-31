package com.example.myapplication

import com.example.myapplication.Constants.ColumnVaccineData.COUNTRY
import com.example.myapplication.Constants.ColumnVaccineData.DAILY_VACCINATIONS
import com.example.myapplication.Constants.ColumnVaccineData.DAILY_VACCINATIONS_PER_MILLION
import com.example.myapplication.Constants.ColumnVaccineData.DAILY_VACCINATIONS_RAW
import com.example.myapplication.Constants.ColumnVaccineData.DATE
import com.example.myapplication.Constants.ColumnVaccineData.ISO_CODE
import com.example.myapplication.Constants.ColumnVaccineData.PEOPLE_FULLY_VACCINATED
import com.example.myapplication.Constants.ColumnVaccineData.PEOPLE_FULLY_VACCINATED_PER_HUNDRED
import com.example.myapplication.Constants.ColumnVaccineData.PEOPLE_VACCINATED
import com.example.myapplication.Constants.ColumnVaccineData.TOTAL_VACCINATIONS
import com.example.myapplication.Constants.ColumnVaccineData.TOTAL_VACCINATIONS_PER_HUNDRED
import com.example.myapplication.VaccineDetails

class CsvParser {
    fun parserData(line : String) : VaccineDetails {
        val token =  line.split(",")
        return VaccineDetails(
            country = token[COUNTRY],
            iso_code = token[ISO_CODE],
            date = token[DATE],
            total_vaccinations = token[TOTAL_VACCINATIONS].toDoubleOrNull() ?: 0.0,
            people_vaccinated = token[PEOPLE_VACCINATED].toDoubleOrNull() ?: 0.0,
            people_fully_vaccinated = token[PEOPLE_FULLY_VACCINATED].toDoubleOrNull() ?: 0.0,
            daily_vaccinations_raw = token[DAILY_VACCINATIONS_RAW].toDoubleOrNull() ?: 0.0,
            daily_vaccinations = token[DAILY_VACCINATIONS].toDoubleOrNull() ?: 0.0,
            total_vaccinations_per_hundred = token[TOTAL_VACCINATIONS_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
            people_vaccinated_per_hundred = token[Constants.ColumnVaccineData.PEOPLE_VACCINATED_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
            people_fully_vaccinated_per_hundred = token[PEOPLE_FULLY_VACCINATED_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
            daily_vaccinations_per_million = token[DAILY_VACCINATIONS_PER_MILLION].toDoubleOrNull() ?: 0.0,
        )
    }
}