package com.example.apptinhtuoi

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNgay.setOnClickListener{
            selectDate()
        }
    }
    private fun selectDate() {

        val cal = Calendar.getInstance()
        Log.wtf("AppTinhtuoi",cal.toString())
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        Log.wtf("AppTinhtuoi","$day/${month+1}/$year")

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
            view,sYear,sMonth,sDayOfMonth ->
            Toast.makeText(this,"$sDayOfMonth/${sMonth+1}/$sYear",Toast.LENGTH_SHORT).show()

            val dateBith = "$sDayOfMonth/${sMonth+1}/$sYear"
            txtDateSelected.text = dateBith

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
            val NgaySinh = sdf.parse(dateBith)
            val NgaySinhTheoPhut = NgaySinh.time/60000

            val currDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currDateInMinute = currDate.time/60000

            val diff = currDateInMinute - NgaySinhTheoPhut
            txtAgeInMinute.text = diff.toString()

        },year,month,day).show()
    }
}