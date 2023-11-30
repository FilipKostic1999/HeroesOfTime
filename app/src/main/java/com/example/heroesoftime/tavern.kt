package com.example.heroesoftime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.heroesoftime.classes.heroDataClass
import com.example.heroesoftime.classes.missions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class tavern : AppCompatActivity() {



    lateinit var mission1 : ImageView
    lateinit var mission2 : ImageView
    lateinit var mission3 : ImageView
    lateinit var mission4 : ImageView
    lateinit var mission5 : ImageView
    lateinit var mission6 : ImageView
    lateinit var mission7 : ImageView
    lateinit var mission8 : ImageView
    lateinit var mission9 : ImageView
    lateinit var mission10 : ImageView
    lateinit var armortavern : ImageView






    lateinit var goldtaverntxt : TextView
    lateinit var diamondtaverntxt : TextView
    lateinit var taverntext : TextView
    lateinit var progrestavern : TextView


    lateinit var collectBtn : Button


    lateinit var auth : FirebaseAuth
    lateinit var database : FirebaseFirestore
    lateinit var savedtavern : missions





    var progres1 : Int =  0
    var progres2 : Int =  0
    var progres3 : Int =  0
    var progres4 : Int =  0
    var progres5 : Int =  0
    var progres6 : Int =  0
    var progres7 : Int =  0
    var progres8 : Int =  0
    var progres9 : Int =  0
    var progres10 : Int =  0

    var collectedAmount = 0
    var collectedDiamonds = 0



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
    var itemsVitality = 0.0
    var itemsStrenght = 0.0
    var itemsSpeed = 0.0
    var itemsMana = 0.0
    var itemDamage = 0.0
    var heroCurrentHp = 0.0


    var armorCoeficent = 0.0
    var location = 0
    var goldVictory = 0



    var savedHeroGold : Int = 0
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
    var savedHeroImage = 1








    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tavern)



        mission1 = findViewById(R.id.mission1)
        mission2 = findViewById(R.id.mission2)
        mission3 = findViewById(R.id.mission3)
        mission4 = findViewById(R.id.mission4)
        mission5 = findViewById(R.id.mission5)
        mission6 = findViewById(R.id.mission6)
        mission7 = findViewById(R.id.mission7)
        mission8 = findViewById(R.id.mission8)
        mission9 = findViewById(R.id.mission9)
        mission10 = findViewById(R.id.mission10)
        armortavern = findViewById(R.id.armortavern)
        taverntext = findViewById(R.id.taverntext)
        goldtaverntxt = findViewById(R.id.goldtaverntxt)
        diamondtaverntxt = findViewById(R.id.diamondtaverntxt)
        collectBtn = findViewById(R.id.collectBtn)
        progrestavern = findViewById(R.id.progrestavern)


        mission2.isVisible = false
        mission3.isVisible = false
        mission4.isVisible = false
        mission5.isVisible = false
        mission6.isVisible = false
        mission7.isVisible = false
        mission8.isVisible = false
        mission9.isVisible = false
        mission10.isVisible = false
        armortavern.isVisible = false
        collectBtn.isVisible = false




        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser




        if (user != null) {

            database.collection("users").document(user.uid).collection("userData")
                .document("VillageOfHopeM").collection("Missions")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedtavern = document.toObject()!!

                            progres1 = savedtavern.mission1
                            progres2 = savedtavern.mission2
                            progres3 = savedtavern.mission3
                            progres4 = savedtavern.mission4
                            progres5 = savedtavern.mission5
                            progres6 = savedtavern.mission6
                            progres7 = savedtavern.mission7
                            progres8 = savedtavern.mission8
                            progres9 = savedtavern.mission9
                            progres10 = savedtavern.mission10


                            if (progres1 >= 10) {
                                collectBtn.isVisible = true
                                collectedAmount = 15
                                collectedDiamonds = 0
                                progrestavern.text = "Progres: $progres1"
                            } else if (progres1 < 0) {
                                mission1.setImageResource(R.drawable.vimage)
                                mission2.isVisible = true
                                collectBtn.isVisible = false
                            }

                            if (progres2 >= 20 && progres1 < 0) {
                                collectBtn.isVisible = true
                                collectedAmount = 45
                                collectedDiamonds = 0
                                progrestavern.text = "Progres: $progres2"
                            } else if (progres2 < 0 && progres1 < 0) {
                                mission2.setImageResource(R.drawable.vimage)
                                mission3.isVisible = true
                                collectBtn.isVisible = false
                            }

                            if (progres3 >= 15 && progres2 < 0) {
                                collectBtn.isVisible = true
                                collectedAmount = 80
                                collectedDiamonds = 0
                                progrestavern.text = "Progres: $progres3"
                            } else if (progres3 < 0 && progres2 < 0) {
                                mission3.setImageResource(R.drawable.vimage)
                                mission4.isVisible = true
                                collectBtn.isVisible = false
                            }

                            if (progres4 >= 1 && progres3 < 0) {
                                collectBtn.isVisible = true
                                collectedAmount = 100
                                collectedDiamonds = 0
                                progrestavern.text = "Progres: $progres4"
                            } else if (progres4 < 0 && progres3 < 0) {
                                mission4.setImageResource(R.drawable.vimage)
                                mission5.isVisible = true
                                collectBtn.isVisible = false
                            }

                            if (progres5 >= 40 && progres4 < 0) {
                                collectBtn.isVisible = true
                                collectedAmount = 200
                                collectedDiamonds = 0
                                progrestavern.text = "Progres: $progres5"
                            } else if (progres5 < 0 && progres4 < 0) {
                                mission5.setImageResource(R.drawable.vimage)
                                mission6.isVisible = true
                                collectBtn.isVisible = false
                            }


                            if (progres6 >= 20 && progres5 < 0) {
                                collectBtn.isVisible = true
                                collectedAmount = 220
                                collectedDiamonds = 0
                                progrestavern.text = "Progres: $progres6"
                            } else if (progres6 < 0 && progres5 < 0) {
                                mission6.setImageResource(R.drawable.vimage)
                                mission7.isVisible = true
                                collectBtn.isVisible = false
                            }


                            if (progres7 >= 50 && progres6 < 0) {
                                collectBtn.isVisible = true
                                collectedAmount = 280
                                collectedDiamonds = 0
                                progrestavern.text = "Progres: $progres7"
                            } else if (progres7 < 0 && progres6 < 0) {
                                mission7.setImageResource(R.drawable.vimage)
                                mission8.isVisible = true
                                collectBtn.isVisible = false
                            }


                            if (progres8 >= 1 && progres7 < 0) {
                                collectBtn.isVisible = true
                                collectedAmount = 350
                                collectedDiamonds = 0
                                progrestavern.text = "Progres: $progres8"
                            } else if (progres8 < 0 && progres7 < 0) {
                                mission8.setImageResource(R.drawable.vimage)
                                mission9.isVisible = true
                                collectBtn.isVisible = false
                            }


                            if (progres9 >= 45 && progres8 < 0) {
                                collectBtn.isVisible = true
                                collectedAmount = 150
                                collectedDiamonds = 0
                                progrestavern.text = "Progres: $progres9"
                            } else if (progres9 < 0 && progres8 < 0) {
                                mission9.setImageResource(R.drawable.vimage)
                                mission10.isVisible = true
                                collectBtn.isVisible = false
                            }


                            if (progres10 >= 1 && progres9 < 0) {
                                collectBtn.isVisible = true
                                collectedAmount = 400
                                collectedDiamonds = 0
                                progrestavern.text = "Progres: $progres10"
                            } else if (progres10 < 0 && progres9 < 0) {
                                mission10.setImageResource(R.drawable.vimage)
                                collectBtn.isVisible = false
                            }



                        }
                    }
                }
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
                            savedHeroImage = savedDataOfUser.heroIconId

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

                            savedHeroTotalArmor = savedDataOfUser.heroTotalArmor
                            itemsVitality = savedDataOfUser.itemsAddedVitality
                            itemsStrenght = savedDataOfUser.itemsAddedStrenght
                            itemsSpeed = savedDataOfUser.itemsAddedSpeed
                            itemsMana = savedDataOfUser.itemsAddedMana
                            itemDamage = savedDataOfUser.itemWeaponDamage
                            heroCurrentHp = savedDataOfUser.heroCurrentHp




                        }
                    }
                }
        }








        collectBtn.setOnClickListener {
            save()
            saveHero()
        }




        mission1.setOnClickListener {
            taverntext.text = "Our village is poor and there is a lack of food in the capital. Please hunt down" +
                    "10 boars in the forest"
            goldtaverntxt.text = "15"
        }

        mission2.setOnClickListener {
            taverntext.text = "A rich stranger from abroad wants us to provide wolf skin for his decorations" +
                    "and he is ready to pay us a good deal. Hunt 20 wolves in the mountain"
            goldtaverntxt.text = "45"
        }

        mission3.setOnClickListener {
            taverntext.text = "There are too many criminals lately in this village. Their refuge is the illegal camp" +
                    "Take down 15 criminals"
            goldtaverntxt.text = "80"
        }


        mission4.setOnClickListener {
            taverntext.text = "Take dow the boss of the illegal camp. These criminals are going to keep comming and the village" +
                    "will stay poor if we dont stop them"
            goldtaverntxt.text = "100"
        }


        mission5.setOnClickListener {
            taverntext.text = "The bears are pillaging our food. We cant afford that to keep happening. Go to the lake" +
                    "and kill 40 bears"
            goldtaverntxt.text = "200"
        }

        mission6.setOnClickListener {
            taverntext.text = "The asassins are killing our already weak guards. This village is doomed without the guards" +
                    "who protect the people. Kill at least 20 asassins in the assasins camp"
            goldtaverntxt.text = "220"
        }

        mission7.setOnClickListener {
            taverntext.text = "The asassins will not stop until their boss is killed and their camp destroied." +
                    "Kill all the asassins in the camp that you can find. There are 50 asassins left there"
            goldtaverntxt.text = "280"
        }


        mission8.setOnClickListener {
            taverntext.text = "Kill the asassin boss in their camp"
            goldtaverntxt.text = "350"
        }

        mission9.setOnClickListener {
            taverntext.text = "The criminals are comming back. Now that you have stopped them, a new group of" +
                    "criminals has taken over their old camp. Kill 45 of them to show them that the village" +
                    "is now a safe place and that they cant do as they please any longer"
            goldtaverntxt.text = "150"
        }

        mission10.setOnClickListener {
            taverntext.text = "The village is now a safer place and is growing economically thanks to you. there arent many heores here because the" +
                    "village is poor and cant afford to pay them well. We have one more mission for you, " +
                    "there is a new powerful criminal that used to be a hero from the village of wealth." +
                    "Kill him and we will reward you with a strong armor and a good amount of gold"
            goldtaverntxt.text = "400"
        }






    }


   fun save() {

       auth = Firebase.auth
       val user = auth.currentUser

       var collected = false


       if (progres1 >= 10 && !collected) {
           progres1 = -1
           collected = true
       }
       if (progres2 >= 10 && progres1 < 0 && !collected) {
           progres2 = -1
           collected = true
       }
       if (progres3 >= 10 && progres2 < 0 && !collected) {
           progres3 = -1
           collected = true
       }
       if (progres4 >= 10 && progres3 < 0 && !collected) {
           progres4 = -1
           collected = true
       }
       if (progres5 >= 10 && progres4 < 0 && !collected) {
           progres5 = -1
           collected = true
       }
       if (progres6 >= 10 && progres5 < 0 && !collected) {
           progres6 = -1
           collected = true
       }
       if (progres7 >= 10 && progres6 < 0 && !collected) {
           progres7 = -1
           collected = true
       }
       if (progres8 >= 10 && progres7 < 0 && !collected) {
           progres8 = -1
           collected = true
       }
       if (progres9 >= 10 && progres8 < 0 && !collected) {
           progres9 = -1
           collected = true
       }
       if (progres10 >= 10 && progres9 < 0 && !collected) {
           progres10 = -1
           collected = true
       }



       var heroData = missions(mission1 = progres1, mission2 = progres2, mission3 = progres3, mission4 = progres4,
       mission5 = progres5, mission6 = progres6, mission7 = progres7, mission8 = progres8, mission9 = progres9, mission10 = progres10)


       if (user != null) {
           database.collection("users").document(user.uid).collection("userData").
           document("VillageOfHopeM").collection("Missions").document("Data").set(heroData)


               .addOnCompleteListener {


               }
       }



    }




    fun saveHero() {

        auth = Firebase.auth
        val user = auth.currentUser


        savedHeroGold += collectedAmount
        collectedAmount = 0


        var heroData = heroDataClass(heroIconId = savedHeroImage, heroLevel = savedHeroLevel, heroExperience = 1, heroArmorId = savedHeroArmor,
            heroRobeId = savedHeroRobe, heroGloveId = savedHeroGloves, heroShoesId = savedHeroShoes,
            heroShieldId = savedHeroShield, heroBeltId = savedHeroBelt,
            heroHelmetId = savedHeroHelmet, heroWeaponId = savedHeroWeapon,
            heroInventorySlot1 = savedHeroInventorySlot1, heroInventorySlot2 = savedHeroInventorySlot2,
            heroInventorySlot3 = savedHeroInventorySlot3, heroInventorySlot4 = savedHeroInventorySlot4,
            heroInventorySlot5 = savedHeroInventorySlot5, heroGold = savedHeroGold, heroRingId1 = savedHeroRing1,
            heroRingId2 = savedHeroRing2, heroAmuletId = savedHeroAmulet, heroTotalArmor = savedHeroTotalArmor,
            itemsAddedVitality = itemsVitality, itemsAddedStrenght = itemsStrenght, itemsAddedSpeed = itemsSpeed,
            itemsAddedMana = itemsMana, itemWeaponDamage = itemDamage, heroCurrentHp = heroCurrentHp,
            heroVitality = savedHeroVitality, heroStrenght = savedHeroStrenght, heroSpeed = savedHeroSpeed,
            heroMana = savedHeroMana, hardSkin = savedHeroHardSkin)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Hero").set(heroData)


                .addOnCompleteListener {


                }
        }




    }




}