package com.example.heroesoftime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class villageOfHopeMapActivity : AppCompatActivity() {


    lateinit var villageOfHopeEntrance : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_village_of_hope_map)


        villageOfHopeEntrance = findViewById(R.id.villageOfHopeEntrance)


        villageOfHopeEntrance.setOnClickListener {

            val intent = Intent(this, villageOfHopeActivity :: class.java)
            startActivity(intent)



        }





    }
}