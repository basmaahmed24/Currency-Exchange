package com.example.currencyexchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

public fun cur(a:Double,b:Double): Double{

        return a/b
    }
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var flag: String = "JOD"
        val arr= arrayOf("Choose your currency","JOD","EUR","AED","JPY")
        val spinnerVal: Spinner = findViewById(R.id.spinner)
        val button: Button = findViewById(R.id.button)
        val res: TextView = findViewById(R.id.result)
        var aum: EditText = findViewById(R.id.ednum1)


        val MyAdapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,arr)
        spinnerVal.adapter= MyAdapter
        spinnerVal.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                flag=arr.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        button.setOnClickListener{
            var x: Double =aum.text.toString().toDouble();

            if(flag=="JOD"){
                res.text=String.format("%.2f $", cur(x,0.71))
            }
            if(flag=="EUR"){
                res.text= String.format("%.2f $", cur(x,0.93))
            }
            if (flag=="AED"){
                res.text= String.format("%.2f $ ",cur(x,3.67))
            }
            if(flag=="JPY"){
                res.text=String.format("%.2f $",cur(x,131.84))
            }
        }

    }
}