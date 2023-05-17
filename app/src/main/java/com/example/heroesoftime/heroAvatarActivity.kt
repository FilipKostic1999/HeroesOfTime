package com.example.heroesoftime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class heroAvatarActivity : AppCompatActivity() {







    lateinit var hero1 : ImageView
    lateinit var hero2 : ImageView
    lateinit var hero3 : ImageView
    lateinit var hero4 : ImageView
    lateinit var hero5 : ImageView
    lateinit var check : ImageView
    lateinit var check2 : ImageView
    lateinit var check3 : ImageView
    lateinit var check4 : ImageView
    lateinit var check5 : ImageView
    lateinit var heroName : EditText
    lateinit var nextButton : Button

    var heroId = 1
    var heroNameTxt = ""
    var shopRefresh = true



    lateinit var auth : FirebaseAuth
    lateinit var database : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_avatar)


        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser




        check = findViewById(R.id.check)
        check2 = findViewById(R.id.check2)
        check3 = findViewById(R.id.check3)
        check4 = findViewById(R.id.check4)
        check5 = findViewById(R.id.check5)
        hero1 = findViewById(R.id.hero1)
        hero2 = findViewById(R.id.hero2)
        hero3 = findViewById(R.id.hero3)
        hero4 = findViewById(R.id.hero4)
        hero5 = findViewById(R.id.hero5)
        heroName = findViewById(R.id.heroName)
        nextButton = findViewById(R.id.nextButton)


        check.isVisible = false
        check2.isVisible =  false
        check3.isVisible = false
        check4.isVisible = false
        check5.isVisible = false


        hero1.setOnClickListener {
            heroId = 1
            check.isVisible = true
            check2.isVisible =  false
            check3.isVisible = false
            check4.isVisible = false
            check5.isVisible = false
        }


        hero2.setOnClickListener {
            heroId = 2
            check.isVisible = false
            check2.isVisible =  true
            check3.isVisible = false
            check4.isVisible = false
            check5.isVisible = false
        }


        hero3.setOnClickListener {
            heroId = 3
            check.isVisible = false
            check2.isVisible =  false
            check3.isVisible = true
            check4.isVisible = false
            check5.isVisible = false
        }


        hero4.setOnClickListener {
            heroId = 4
            check.isVisible = false
            check2.isVisible =  false
            check3.isVisible = false
            check4.isVisible = true
            check5.isVisible = false
        }

        hero5.setOnClickListener {
            heroId = 5
            check.isVisible = false
            check2.isVisible =  false
            check3.isVisible = false
            check4.isVisible = false
            check5.isVisible = true
        }


        nextButton.setOnClickListener {

            heroNameTxt = heroName.text.toString()

            shopSetUp()
            save()


        }












    }


    fun shopSetUp() {



        auth = Firebase.auth
        val user = auth.currentUser


        var shopArmors = shopItemsClass(shopRefresh = shopRefresh)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Shop1").collection("ArmorShop").document("ArmorItems").set(shopArmors)


                .addOnCompleteListener {


                }
        }



        var shopWeapons = shopItemsClass(shopRefresh = shopRefresh)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Shop1").collection("WeaponShop").document("WeaponItems").set(shopWeapons)


                .addOnCompleteListener {


                }
        }




        var shopRings = shopItemsClass(shopRefresh = shopRefresh)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Shop1").collection("RingShop").document("RingItems").set(shopRings)


                .addOnCompleteListener {


                }
        }





    }




    fun save() {



        auth = Firebase.auth
        val user = auth.currentUser

        var heroData = heroDataClass(heroIconId = heroId, heroLevel = 1, heroExperience = 1, heroArmorId = 0,
            heroRobeId = 7, heroGloveId = 0, heroShoesId = 19,
            heroShieldId = 0, heroBeltId = 0,
            heroHelmetId = 0, heroWeaponId = 43,
            heroInventorySlot1 = 0, heroInventorySlot2 = 0,
            heroInventorySlot3 = 0, heroInventorySlot4 = 0,
            heroInventorySlot5 = 0, heroGold = 0, heroRingId1 = 0,
            heroRingId2 = 0, heroAmuletId = 0, hardSkin = 0, heroCurrentHp = 100.0, heroCurrentMana = 100,
        heroName = heroNameTxt, heroSpeed = 5, heroStrenght = 5, heroVitality = 10, heroMana = 5)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Hero").set(heroData)


                .addOnCompleteListener {


                }
        }


        val intent = Intent(this, villageOfHopeMapActivity::class.java)

        startActivity(intent)



    }




}