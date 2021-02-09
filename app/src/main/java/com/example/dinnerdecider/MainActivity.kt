package com.example.dinnerdecider

import android.content.SharedPreferences
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dinnerdecider.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var data: SharedPreferences
    lateinit var editData: SharedPreferences.Editor

    lateinit var food: String
    var choice: Int = 0

    //latent var choice =999
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        data = applicationContext.getSharedPreferences("mychoice", MODE_PRIVATE)

        Toast.makeText(applicationContext,"onCreate",Toast.LENGTH_SHORT).show()

        binding.button.setOnClickListener {
            //(retrieved==600)
            choice = Random.nextInt(0, 6)
            when (choice) {
                0 -> {
                    food = "Chips"
                    binding.backgroud.setBackgroundColor(Color.BLUE)
                    binding.backgroud.setBackgroundResource(R.drawable.chips)
                }
                1 -> {
                    food = "Rice"
                    binding.backgroud.setBackgroundColor(Color.GREEN)
                    binding.backgroud.setBackgroundResource(R.drawable.pilau)
                }
                2 -> {
                    food = "Ugali"
                    binding.backgroud.setBackgroundColor(Color.RED)
                    binding.backgroud.setBackgroundResource(R.drawable.ugali)
                }
                3 -> {
                    food = "Spaghetti"
                    binding.backgroud.setBackgroundColor(Color.MAGENTA)
                    binding.backgroud.setBackgroundResource(R.drawable.spaghetti)
                }
                4 -> {
                    food = "Chapati"
                    binding.backgroud.setBackgroundColor(Color.CYAN)
                    binding.backgroud.setBackgroundResource(R.drawable.chapati)
                }


                5 -> {
                    food = "Pilau"
                    binding.backgroud.setBackgroundColor(Color.GRAY)
                    binding.backgroud.setBackgroundResource(R.drawable.pilau)


                }


                else -> food = "We could not decide"

            }
            binding.textView.text = food
        }


    }

    override fun onStart() {
        super.onStart()
        retrieve()
    }


    override fun onStop() {
        super.onStop()
        savedata()
    }

    fun savedata(){
        editData = data.edit()
        editData.putInt("mychoice", choice)
        editData.commit()
    }
    fun retrieve(){
        var lastChoice:Int = data.getInt("mychoice",0)

        when (lastChoice) {
            0 -> {
                food = "Chips"
                binding.backgroud.setBackgroundColor(Color.BLUE)
                binding.backgroud.setBackgroundResource(R.drawable.chips)
            }
            1 -> {
                food = "Rice"
                binding.backgroud.setBackgroundColor(Color.GREEN)
                binding.backgroud.setBackgroundResource(R.drawable.pilau)
            }
            2 -> {
                food = "Ugali"
                binding.backgroud.setBackgroundColor(Color.RED)
                binding.backgroud.setBackgroundResource(R.drawable.ugali)
            }
            3 -> {
                food = "Spaghetti"
                binding.backgroud.setBackgroundColor(Color.MAGENTA)
                binding.backgroud.setBackgroundResource(R.drawable.spaghetti)
            }
            4 -> {
                food = "Chapati"
                binding.backgroud.setBackgroundColor(Color.CYAN)
                binding.backgroud.setBackgroundResource(R.drawable.chapati)
            }


            5 -> {
                food = "Pilau"
                binding.backgroud.setBackgroundColor(Color.GRAY)
                binding.backgroud.setBackgroundResource(R.drawable.pilau)


            }


            else -> food = "We could not decide"

        }
        binding.textView.text = food
    }

}