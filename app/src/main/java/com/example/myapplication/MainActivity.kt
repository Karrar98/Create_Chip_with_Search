package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.SearchView
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFile()
        setup()

    }

    fun openFile() {
        val inputStream = assets.open("country_vaccinations.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        buffer.forEachLine {
            val currentVaccineData = CsvParser().parserData(it)
            DataManger.addVaccineDetails(currentVaccineData)
        }
    }

    fun setup() {
        binding.apply {
            searchViewCountry.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    createChip(query!![0])
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }

            })
        }
    }

    fun ChipGroup.addChip(label: String){
        Chip(this@MainActivity).apply {
            id = View.generateViewId()
            text = label
            isClickable = true
            isCheckable = true
            isCheckedIconVisible = false
            isFocusable = true
            binding.chipGroupCountry.addView(this)
        }
    }

    private fun createChip(firstCharCountry: Char) {
        binding.chipGroupCountry.removeAllViews()
        DataManger.getCountries(firstCharCountry).forEach {
            binding.chipGroupCountry.addChip(it)
        }
    }
}