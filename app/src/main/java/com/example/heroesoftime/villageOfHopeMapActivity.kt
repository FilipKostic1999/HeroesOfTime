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

class villageOfHopeMapActivity : AppCompatActivity() {






    lateinit var goldTxt : TextView
    lateinit var heroSavedImg : ImageView




    lateinit var villageOfHopeEntrance : TextView
    lateinit var auth : FirebaseAuth
    lateinit var database : FirebaseFirestore
    lateinit var savedDataOfUser : heroDataClass


    var savedHeroGold = 0
    var heroImage = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_village_of_hope_map)




        heroSavedImg = findViewById(R.id.heroSavedImg)
        goldTxt = findViewById(R.id.goldTxt)




        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser


        villageOfHopeEntrance = findViewById(R.id.villageOfHopeEntrance)


        villageOfHopeEntrance.setOnClickListener {

            val intent = Intent(this, villageOfHopeActivity :: class.java)
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
                                heroSavedImg.setImageResource(R.drawable.malewarrior)
                            } else if (heroImage == 2) {
                                heroSavedImg.setImageResource(R.drawable.femaleasassin)
                            } else if (heroImage == 3) {
                                heroSavedImg.setImageResource(R.drawable.femalewarrior)
                            } else if (heroImage == 4) {
                                heroSavedImg.setImageResource(R.drawable.hatavatar)
                            } else if (heroImage == 5) {
                                heroSavedImg.setImageResource(R.drawable.maleadventurer)
                            }

                        }
                    }
                }
        }






    }
}