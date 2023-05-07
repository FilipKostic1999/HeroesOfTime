package com.example.heroesoftime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class villageOfHopeActivity : AppCompatActivity() {


    lateinit var villageOfHopeArmorShop : TextView
    lateinit var villageOfHopeWeaponShop : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_village_of_hope)


        villageOfHopeArmorShop = findViewById(R.id.villageOfHopeArmorShop)
        villageOfHopeWeaponShop = findViewById(R.id.villageOfHopeWeaponShop)


        val sharedSelectorShopType = getSharedPreferences("SelectorShopType", AppCompatActivity.MODE_PRIVATE)
        var selectedShopType = sharedSelectorShopType.getInt("SelectorShopType", 0)


        // Shop type 1 is armor shop, type 2 is weapons shop, type 3 is jewels shop and type 4 is farmacy shop


        villageOfHopeArmorShop.setOnClickListener {
            selectedShopType = 1

            val editShopType = sharedSelectorShopType.edit()
            editShopType.putInt("SelectorShopType", selectedShopType)
            editShopType.commit()

            val intent = Intent(this, shopsActivity :: class.java)
            startActivity(intent)

        }


        villageOfHopeWeaponShop.setOnClickListener {

            selectedShopType = 2

            val editShopType = sharedSelectorShopType.edit()
            editShopType.putInt("SelectorShopType", selectedShopType)
            editShopType.commit()

            val intent = Intent(this, shopsActivity :: class.java)
            startActivity(intent)


        }



    }
}