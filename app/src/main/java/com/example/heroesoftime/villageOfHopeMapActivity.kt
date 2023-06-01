package com.example.heroesoftime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlin.math.roundToInt

class villageOfHopeMapActivity : AppCompatActivity() {






    lateinit var goldTxt : TextView
    lateinit var heroViewTxt : TextView
    lateinit var heroSavedImg : ImageView
    lateinit var heroAttributesTxt : TextView
    lateinit var villageOfHopeForest : TextView
    lateinit var villageOfHopeMapTabTxt : TextView
    lateinit var villageOfHopeMapTabBtn : Button
    lateinit var mercenaries : TextView
    lateinit var villageOfHopeMountain : TextView
    lateinit var villageOfHopeCaves : TextView
    lateinit var villageOfHopeCamp2 : TextView
    lateinit var villageOfHopeCamp : TextView
    lateinit var villageOfHopeLake : TextView




    lateinit var villageOfHopeEntrance : TextView
    lateinit var auth : FirebaseAuth
    lateinit var database : FirebaseFirestore
    lateinit var savedDataOfUser : heroDataClass


    var savedHeroTotalArmor = 0.0
    var savedHeroVitality = 5
    var savedHeroStrenght = 5
    var savedHeroMana = 5
    var savedHeroSpeed = 5

    var savedHeroWarcry = 0
    var savedHeroCritical = 1
    var savedHeroFury = 0
    var savedHeroPoisonBlade = 0
    var savedHeroWarriorSpirit = 0
    var savedHeroTemerary = 0
    var savedHeroDestructiveSpirit = 0
    var savedHeroHardSkin = 0




    var savedHeroGold = 0
    var savedHeroArmor = 0
    var savedHeroRobe = 0
    var savedHeroGloves = 0
    var savedHeroShoes = 0
    var savedHeroShield = 0
    var savedHeroBelt = 0
    var savedHeroHelmet = 0
    var savedHeroWeapon = 0
    var savedHeroRing1 = 0
    var savedHeroRing2 = 0
    var savedHeroAmulet = 0
    var savedHeroInventorySlot1 = 0
    var savedHeroInventorySlot2 = 0
    var savedHeroInventorySlot3 = 0
    var savedHeroInventorySlot4 = 0
    var savedHeroInventorySlot5 = 0
    var savedHeroLevel = 1
    var heroImage = 0
    var selectedDungeon = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_village_of_hope_map)




        heroSavedImg = findViewById(R.id.heroSavedImg)
        goldTxt = findViewById(R.id.goldTxt)
        heroViewTxt = findViewById(R.id.heroViewTxt)
        villageOfHopeMapTabTxt = findViewById(R.id.villageOfHopeMapTabTxt)
        villageOfHopeMapTabBtn = findViewById(R.id.villageOfHopeMapTabBtn)
        mercenaries = findViewById(R.id.mercenaries)
        villageOfHopeMountain = findViewById(R.id.villageOfHopeMountain)
        villageOfHopeCamp = findViewById(R.id.villageOfHopeCamp)
        villageOfHopeCamp2 = findViewById(R.id.villageOfHopeCamp2)
        villageOfHopeCaves = findViewById(R.id.villageOfHopeCaves)
        villageOfHopeLake = findViewById(R.id.villageOfHopeLake)




        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser


        villageOfHopeEntrance = findViewById(R.id.villageOfHopeEntrance)
        heroAttributesTxt = findViewById(R.id.heroAttributesTxt)
        villageOfHopeForest = findViewById(R.id.villageOfHopeForest)



        val sharedLocation = getSharedPreferences("Location", AppCompatActivity.MODE_PRIVATE)
        var Location = sharedLocation.getInt("Location", 0)






        if (user != null) {

            database.collection("users").document(user.uid).collection("userData")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedDataOfUser = document.toObject()!!

                            savedHeroGold = savedDataOfUser.heroGold

                            savedHeroArmor = savedDataOfUser.heroArmorId
                            savedHeroRobe = savedDataOfUser.heroRobeId
                            savedHeroGloves = savedDataOfUser.heroGloveId
                            savedHeroShoes = savedDataOfUser.heroShoesId
                            savedHeroShield = savedDataOfUser.heroShieldId
                            savedHeroBelt = savedDataOfUser.heroBeltId
                            savedHeroHelmet = savedDataOfUser.heroHelmetId
                            savedHeroWeapon = savedDataOfUser.heroWeaponId
                            savedHeroRing1 = savedDataOfUser.heroRingId1
                            savedHeroRing2 = savedDataOfUser.heroRingId2
                            savedHeroAmulet = savedDataOfUser.heroAmuletId

                            savedHeroLevel = savedDataOfUser.heroLevel

                            savedHeroInventorySlot1 = savedDataOfUser.heroInventorySlot1
                            savedHeroInventorySlot2 = savedDataOfUser.heroInventorySlot2
                            savedHeroInventorySlot3 = savedDataOfUser.heroInventorySlot3
                            savedHeroInventorySlot4 = savedDataOfUser.heroInventorySlot4
                            savedHeroInventorySlot5 = savedDataOfUser.heroInventorySlot5


                            savedHeroWarcry = savedDataOfUser.warCry
                            savedHeroCritical = savedDataOfUser.critical
                            savedHeroFury = savedDataOfUser.fury
                            savedHeroPoisonBlade = savedDataOfUser.poisonBlade
                            savedHeroWarriorSpirit = savedDataOfUser.warriorSpirit
                            savedHeroTemerary = savedDataOfUser.temerary
                            savedHeroDestructiveSpirit = savedDataOfUser.destructiveSpirit
                            savedHeroHardSkin = savedDataOfUser.hardSkin

                            savedHeroVitality = savedDataOfUser.heroVitality
                            savedHeroStrenght = savedDataOfUser.heroStrenght
                            savedHeroSpeed = savedDataOfUser.heroSpeed
                            savedHeroMana = savedDataOfUser.heroMana


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





        villageOfHopeCamp2.setOnClickListener {

            villageOfHopeMapTabTxt.text = "There are minor criminals here"
            Location = 4

            val editLocation = sharedLocation.edit()
            editLocation.putInt("Location", Location)
            editLocation.commit()

        }




        villageOfHopeCamp.setOnClickListener {

            villageOfHopeMapTabTxt.text = "There are assassins here"
            Location = 5

            val editLocation = sharedLocation.edit()
            editLocation.putInt("Location", Location)
            editLocation.commit()


        }




        villageOfHopeLake.setOnClickListener {
            villageOfHopeMapTabTxt.text = "There are many small bears here"
            Location = 6

            val editLocation = sharedLocation.edit()
            editLocation.putInt("Location", Location)
            editLocation.commit()

        }





        villageOfHopeCaves.setOnClickListener {
            villageOfHopeMapTabTxt.text = "There are small bears and wolves here"
            Location = 3

            val editLocation = sharedLocation.edit()
            editLocation.putInt("Location", Location)
            editLocation.commit()
        }




        villageOfHopeMountain.setOnClickListener {
            villageOfHopeMapTabTxt.text = "Forest, there are small wolves and boars here"
            Location = 2

            val editLocation = sharedLocation.edit()
            editLocation.putInt("Location", Location)
            editLocation.commit()

        }



        mercenaries.setOnClickListener {
                val intent = Intent(this, mercenaryActivity :: class.java)
                startActivity(intent)
        }




        villageOfHopeMapTabBtn.setOnClickListener {

            if (Location >= 1) {
                val intent = Intent(this, battleView :: class.java)
                startActivity(intent)
            }
        }



        villageOfHopeForest.setOnClickListener {


            villageOfHopeMapTabTxt.text = "Forest, there are small boars here"
            Location = 1

            val editLocation = sharedLocation.edit()
            editLocation.putInt("Location", Location)
            editLocation.commit()


        }



        heroAttributesTxt.setOnClickListener {

            val intent = Intent(this, attributesActivity :: class.java)
            startActivity(intent)


        }



        villageOfHopeEntrance.setOnClickListener {

            val intent = Intent(this, villageOfHopeActivity :: class.java)
            startActivity(intent)



        }


        heroViewTxt.setOnClickListener {

            val intent = Intent(this, heroViewActivity :: class.java)
            startActivity(intent)


        }








    }
}