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
    lateinit var villageOfHopeTavern : TextView
    lateinit var vofhopeMHp : TextView
    lateinit var vofhopeMmana2 : TextView
    lateinit var vofhopeMHExp : TextView
    lateinit var diamondsAmount : TextView
    lateinit var level : TextView


    lateinit var goldTxt : TextView
    lateinit var heroSavedImage : ImageView



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
    var selectedDungeon = 0





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
        villageOfHopeTavern = findViewById(R.id.villageOfHopeTavern)
        vofhopeMHp = findViewById(R.id.vofhopeMHp)
        vofhopeMmana2 = findViewById(R.id.vofhopeMmana2)
        vofhopeMHExp = findViewById(R.id.vofhopeMHExp)
        diamondsAmount = findViewById(R.id.diamondsAmount)
        level = findViewById(R.id.level)




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




        villageOfHopeTavern.setOnClickListener {
            val intent = Intent(this, tavern :: class.java)
            startActivity(intent)
        }






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

                            var displayhp = (savedDataOfUser.heroVitality + savedDataOfUser.itemsAddedVitality)*10
                            var displayMana = (savedDataOfUser.heroMana + savedDataOfUser.itemsAddedMana)*10

                            vofhopeMHp.text = "HP: ${savedDataOfUser.heroCurrentHp}/$displayhp"
                            vofhopeMmana2.text = "MP: ${savedDataOfUser.heroCurrentMana}/$displayMana"
                            vofhopeMHExp.text = "Exp: ${savedDataOfUser.heroExperience}"
                            diamondsAmount.text = "${savedDataOfUser.heroDiamonds}"
                            level.text = "${savedDataOfUser.heroLevel}"


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