package com.example.lab08

import android.R
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab08.databinding.ActivityMainBinding
import java.util.Calendar
import java.util.Calendar.DAY_OF_MONTH

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    val pizzaSize = arrayListOf("Small", "Medium", "Large", "Extra Large") //max size array = 3 since counter starts from 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            // Bila seekbar diubah
            // Code ini akan dipanggil
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                // Update nilai sizeTextView dengan nilai Small, Medium, etc.
                // P1 - position user dari seekbar
                binding.sizeTextView.text = pizzaSize[p1]
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                println("Start tracking")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                println("Stop tracking")
            }

        }
        )

        binding.scheduleButton.setOnClickListener {
            // Create an Intent to start the DetailActivity and pass data
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", binding.nameEditText.text.toString())
            intent.putExtra("phone", binding.phoneEditText.text.toString())
            intent.putExtra("size", binding.sizeTextView.text.toString())
            intent.putExtra("date", binding.dateTextView.text.toString())
            intent.putExtra("time", binding.timeTextView.text.toString())
            startActivity(intent)
        }

        binding.dateButton.setOnClickListener {
            // Dapatkan tarikh hari ini
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

            // Create a DatePickerDialog
            val myDatePicker = DatePickerDialog(this, android.R.style.ThemeOverlay,
                // Listener - Bila date dipilih
                // i3 - day, i2 - month, i - year
                // Month mula dari 0, jadi tambahkan 1 utk Januari
                DatePickerDialog.OnDateSetListener {datePicker, i, i2, i3 ->
                    binding.dateTextView.text = "$i3/${i2+1}/$i"
                }, year, month, day // Default date utk diset pada datepicker bila ia dibuka
            )

            // Show the datePicker
            myDatePicker.show()
        }

        binding.timeButton.setOnClickListener{
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            val myTimepicker = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener{
                timePicker, i, i2 ->
                // i - hour, i2 - minute
                binding.timeTextView.text = "$i:$i2"
            }, hour, minute, false)

            myTimepicker.show()
        }

            }


        }






