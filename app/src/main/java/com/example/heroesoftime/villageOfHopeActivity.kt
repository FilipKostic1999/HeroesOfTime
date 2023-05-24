package com.example.heroesoftime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class villageOfHopeActivity : AppCompatActivity() {


    lateinit var villageOfHopeArmorShop : TextView
    lateinit var villageOfHopeWeaponShop : TextView
    lateinit var villageOfHopeRingShop : TextView
    lateinit var heroViewTxt : TextView


    lateinit var goldTxt : TextView
    lateinit var heroSavedImage : ImageView




    lateinit var villageOfHopeEntrance : TextView
    lateinit var auth : FirebaseAuth
    lateinit var database : FirebaseFirestore
    lateinit var savedDataOfUser : heroDataClass


    var savedHeroGold = 0
    var heroImage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_village_of_hope)


        villageOfHopeArmorShop = findViewById(R.id.villageOfHopeArmorShop)
        villageOfHopeWeaponShop = findViewById(R.id.villageOfHopeWeaponShop)
        villageOfHopeRingShop = findViewById(R.id.villageOfHopeRingShop)
        goldTxt = findViewById(R.id.goldTxt)
        heroSavedImage = findViewById(R.id.heroSavedImage)
        heroViewTxt = findViewById(R.id.heroViewTxt)



        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser


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

        villageOfHopeRingShop.setOnClickListener {

            selectedShopType = 3

            val editShopType = sharedSelectorShopType.edit()
            editShopType.putInt("SelectorShopType", selectedShopType)
            editShopType.commit()

            val intent = Intent(this, shopsActivity :: class.java)
            startActivity(intent)


        }


        heroViewTxt.setOnClickListener {

            val intent = Intent(this, heroViewActivity :: class.java)
            startActivity(intent)


        }




        if (user != null) {

            database.collection("users").document(user.uid).collection("userData")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedDataOfUser = document.toObject()!!

                            savedHeroGold = savedDataOfUser.heroGold
                            heroImage = savedDataOfUser.heroIconId
                            goldTxt.text = "$savedHeroGold"

                            if (heroImage == 1) {
                                heroSavedImage.setImageResource(R.drawable.malewarrior)
                            } else if (heroImage == 2) {
                                heroSavedImage.setImageResource(R.drawable.femaleasassin)
                            } else if (heroImage == 3) {
                                heroSavedImage.setImageResource(R.drawable.femalewarrior)
                            } else if (heroImage == 4) {
                                heroSavedImage.setImageResource(R.drawable.hatavatar)
                            } else if (heroImage == 5) {
                                heroSavedImage.setImageResource(R.drawable.maleadventurer)
                            }

                        }
                    }
                }
        }



    }




}