package com.example.heroesoftime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.round
import kotlin.math.roundToInt

class battleView : AppCompatActivity() {


    var character1 = character(0.0, 10.0, 100.0, 10.0, 50.0, 50.0, 0.0, 0.0)
    var character2 = character(0.0, 10.0, 100.0, 10.0, 50.0, 50.0, 0.0, 0.0)
    var character3 = character(0.0, 10.0, 100.0, 10.0, 50.0, 50.0, 0.0, 0.0)
    var character4 = character(0.0, 10.0, 100.0, 10.0, 50.0, 50.0, 0.0, 0.0)

    var character11 = character(0.0, 10.0, 100.0, 10.0, 50.0, 50.0,0.0, 0.0)
    var character22 = character(0.0, 10.0, 100.0, 10.0, 50.0, 50.0,0.0, 0.0)
    var character33 = character(0.0, 10.0, 100.0, 10.0, 50.0, 50.0,0.0, 0.0)
    var character44 = character(0.0, 10.0, 100.0, 10.0, 50.0, 50.0,0.0, 0.0)


    var hero = character(100.0, 10.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    var boar = character(10000.0, 40.0, 100.0, 10.0, 50.0, 50.0, 0.0, 0.0)

    var randomCh = 0


    var heroHp: Double = 0.0
    var mercenary1Hp: Double = 0.0
    var mercenary2Hp = 0.0
    var mercenary3Hp = 0.0
    var mercenary4Hp = 0.0


    var enemy1Hp = 0.0
    var enemy2Hp = 0.0
    var enemy3Hp = 0.0
    var enemy4Hp = 0.0
    var enemy5Hp = 0.0


    var starter = 0
    var isTimerActive = true
    var isTeam1Dead = false
    var isTeam2Dead = false


    lateinit var heroHpTxt: TextView
    lateinit var mercenary1HpTxt: TextView
    lateinit var mercenary2HpTxt: TextView
    lateinit var mercenary3HpTxt: TextView
    lateinit var mercenary4HpTxt: TextView

    lateinit var enemy1HpTxt: TextView
    lateinit var enemy2HpTxt: TextView
    lateinit var enemy3HpTxt: TextView
    lateinit var enemy4HpTxt: TextView
    lateinit var enemy5HpTxt: TextView


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


    var armorCoeficent = 0.0



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
    var snapshotAllow = false



    lateinit var auth: FirebaseAuth
    lateinit var savedDataOfUser: heroDataClass
    lateinit var database: FirebaseFirestore
    lateinit var data: fightingHp


    lateinit var listOfTeam1: ArrayList<character>
    lateinit var listOfTeam2: ArrayList<character>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle_view)



        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser





        heroHpTxt = findViewById(R.id.heroHpTxt)
        mercenary1HpTxt = findViewById(R.id.mercenary1Txt)
        mercenary2HpTxt = findViewById(R.id.mercenary2Txt)
        mercenary3HpTxt = findViewById(R.id.mercenary3Txt)
        mercenary4HpTxt = findViewById(R.id.mercenary4Txt)
        enemy1HpTxt = findViewById(R.id.enemy1HpTxt)
        enemy2HpTxt = findViewById(R.id.enemy2HpTxt)
        enemy3HpTxt = findViewById(R.id.enemy3HpTxt)
        enemy4HpTxt = findViewById(R.id.enemy4HpTxt)
        enemy5HpTxt = findViewById(R.id.enemy5HpTxt)





        listOfTeam1 = arrayListOf()
        listOfTeam2 = arrayListOf()


        listOfTeam1.add(hero)
        listOfTeam1.add(character1)
        listOfTeam1.add(character2)
        listOfTeam1.add(character3)
        listOfTeam1.add(character4)

        listOfTeam2.add(boar)
        listOfTeam2.add(character11)
        listOfTeam2.add(character22)
        listOfTeam2.add(character33)
        listOfTeam2.add(character44)





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


                            // apply armor to hero and mercenaries

                            listOfTeam1[0].totalArmor = savedDataOfUser.heroTotalArmor

                            // apply damage for hero and mercenaries

                            listOfTeam1[0].damage = savedDataOfUser.itemWeaponDamage

                            // apply strenght of hero and mercenaries

                            listOfTeam1[0].strenght = savedDataOfUser.heroStrenght.toDouble() +
                                    savedDataOfUser.itemsAddedStrenght

                            // apply vitality of hero and mercenaries

                            listOfTeam1[0].vitality = savedDataOfUser.heroVitality.toDouble() +
                                    savedDataOfUser.itemsAddedVitality

                            // apply speed

                            listOfTeam1[0].speed =  savedDataOfUser.heroSpeed.toDouble() +
                                    savedDataOfUser.itemsAddedSpeed

                            // apply mana

                            listOfTeam1[0].mana = savedDataOfUser.heroMana.toDouble() +
                                    savedDataOfUser.itemsAddedMana


                            // apply strenght to damage

                            listOfTeam1[0].damage += (listOfTeam1[0].strenght/2)

                            // apply current hp to battle

                            listOfTeam1[0].hp = savedDataOfUser.heroCurrentHp





                            // apply percentage of critical chance to hero and mercenaries

                            listOfTeam1[0].criticalChance = (savedHeroCritical.toDouble()) * 4.0


                            // apply warcry hp increase to hero

                            listOfTeam1[0].hp += ((listOfTeam1[0].hp * (2.0 * savedHeroWarcry))/100.0)

                            // fury

                            listOfTeam1[0].damage += ((listOfTeam1[0].damage * (10.0 * savedHeroFury))/100.0)

                            // poison

                            listOfTeam1[0].damage += ((listOfTeam1[0].damage * (10.0 * savedHeroPoisonBlade))/100.0)

                            // temerary

                            listOfTeam2[0].damage -= (((savedHeroTemerary.toDouble() * 4) * listOfTeam2[0].damage)/100)
                            listOfTeam2[1].damage -= (((savedHeroTemerary.toDouble() * 4) * listOfTeam2[1].damage)/100)
                            listOfTeam2[2].damage -= (((savedHeroTemerary.toDouble() * 4) * listOfTeam2[2].damage)/100)
                            listOfTeam2[3].damage -= (((savedHeroTemerary.toDouble() * 4) * listOfTeam2[3].damage)/100)
                            listOfTeam2[4].damage -= (((savedHeroTemerary.toDouble() * 4) * listOfTeam2[4].damage)/100)


                            // destructive spirit

                            listOfTeam2[0].speed -= (((savedHeroDestructiveSpirit.toDouble() * 5) * listOfTeam2[0].speed)/100)
                            listOfTeam2[1].speed -= (((savedHeroDestructiveSpirit.toDouble() * 5) * listOfTeam2[1].speed)/100)
                            listOfTeam2[2].speed -= (((savedHeroDestructiveSpirit.toDouble() * 5) * listOfTeam2[2].speed)/100)
                            listOfTeam2[3].speed -= (((savedHeroDestructiveSpirit.toDouble() * 5) * listOfTeam2[3].speed)/100)
                            listOfTeam2[4].speed -= (((savedHeroDestructiveSpirit.toDouble() * 5) * listOfTeam2[4].speed)/100)


                            // hard skin

                            listOfTeam1[0].totalArmor += (((savedDataOfUser.hardSkin * 5) * listOfTeam1[0].totalArmor)/100)

                            heroHpTxt.text = "${listOfTeam1[0].hp.roundToInt()} HP"
                            enemy1HpTxt.text = "${listOfTeam2[0].hp.roundToInt()} HP"




                            snapshotAllow = true



                        }
                    }
                }
        }




        var handlerOfHandler = true


        if (user != null) {

            database.collection("users").document(user.uid).collection("userData")
                .document("battleField").collection("data")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            data = document.toObject()!!


                            if (snapshotAllow && handlerOfHandler) {

                                Handler().postDelayed({

                                    heroHpTxt.text = "${heroHp.roundToInt()} HP"
                                    mercenary1HpTxt.text = "${mercenary1Hp.roundToInt()} HP"
                                    mercenary2HpTxt.text = "${mercenary2Hp.roundToInt()} HP"
                                    mercenary3HpTxt.text = "${mercenary3Hp.roundToInt()} HP"
                                    mercenary4HpTxt.text = "${mercenary4Hp.roundToInt()} HP"

                                    enemy1HpTxt.text = "${enemy1Hp.roundToInt()} HP"
                                    enemy2HpTxt.text = "${enemy2Hp.roundToInt()} HP"
                                    enemy3HpTxt.text = "${enemy3Hp.roundToInt()} HP"
                                    enemy4HpTxt.text = "${enemy4Hp.roundToInt()} HP"
                                    enemy5HpTxt.text = "${enemy5Hp.roundToInt()} HP"

                                    handlerOfHandler = false

                                }, 2000)



                            } else if (snapshotAllow && !handlerOfHandler) {

                                heroHpTxt.text = "${heroHp.roundToInt()} HP"
                                mercenary1HpTxt.text = "${mercenary1Hp.roundToInt()} HP"
                                mercenary2HpTxt.text = "${mercenary2Hp.roundToInt()} HP"
                                mercenary3HpTxt.text = "${mercenary3Hp.roundToInt()} HP"
                                mercenary4HpTxt.text = "${mercenary4Hp.roundToInt()} HP"

                                enemy1HpTxt.text = "${enemy1Hp.roundToInt()} HP"
                                enemy2HpTxt.text = "${enemy2Hp.roundToInt()} HP"
                                enemy3HpTxt.text = "${enemy3Hp.roundToInt()} HP"
                                enemy4HpTxt.text = "${enemy4Hp.roundToInt()} HP"
                                enemy5HpTxt.text = "${enemy5Hp.roundToInt()} HP"

                            }


                        }
                    }
                }
        }










        var isWarriorSpiritActive = true




        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {

                starter ++

                if (starter > 1) {

                    if (listOfTeam1[0].hp < (listOfTeam1[0].vitality) && listOfTeam1[0].hp > 0 && isWarriorSpiritActive) {
                        listOfTeam1[0].hp += ((savedHeroWarriorSpirit.toDouble() * 3) * (listOfTeam1[0].vitality * 10))/100
                        isWarriorSpiritActive = false
                    }

                    for (teamOneCharacter in listOfTeam1) {
                        while (true) {
                            randomCh = (0..4).random()
                            if (listOfTeam2[randomCh].hp > 0) {
                                break
                            }
                            if (listOfTeam2[0].hp <= 0 && listOfTeam2[1].hp <= 0 && listOfTeam2[2].hp <= 0 &&
                                listOfTeam2[3].hp <= 0 && listOfTeam2[4].hp <= 0
                            ) {
                                isTeam2Dead = true
                                break
                            }
                        }


                        if (teamOneCharacter.hp > 0 && !isTeam2Dead) {

                            var x1D = 0.0
                            var x1Int = 0
                            var randomH = 0

                            if (teamOneCharacter.speed >= listOfTeam2[randomCh].speed) {
                                x1D = (teamOneCharacter.speed / listOfTeam2[randomCh].speed)
                                x1Int = round(x1D).toInt()
                                randomH = (0..x1Int).random()
                            } else if (teamOneCharacter.speed < listOfTeam2[randomCh].speed) {
                                x1D = (listOfTeam2[randomCh].speed / teamOneCharacter.speed)
                                x1Int = round(x1D).toInt()
                                randomH = (0..x1Int).random()
                            }

                            if (randomH > 0 && teamOneCharacter.speed >= listOfTeam2[randomCh].speed) {

                                val randomC = (1..100).random()

                                if (randomC <= teamOneCharacter.criticalChance) {
                                    listOfTeam2[randomCh].hp -= (teamOneCharacter.damage / ((listOfTeam2[randomCh].totalArmor/100)+1)) * 4
                                } else if (randomC > teamOneCharacter.criticalChance) {
                                    listOfTeam2[randomCh].hp -= (teamOneCharacter.damage / ((listOfTeam2[randomCh].totalArmor / 100) + 1))
                                }

                            } else if (randomH == 0 && teamOneCharacter.speed < listOfTeam2[randomCh].speed) {

                                val randomC = (1..100).random()

                                if (randomC <= teamOneCharacter.criticalChance) {
                                    listOfTeam2[randomCh].hp -= (teamOneCharacter.damage / ((listOfTeam2[randomCh].totalArmor/100)+1)) * 4
                                } else if (randomC > teamOneCharacter.criticalChance) {
                                    listOfTeam2[randomCh].hp -= (teamOneCharacter.damage / ((listOfTeam2[randomCh].totalArmor / 100) + 1))
                                }

                            }

                        }

                    }



                    for (teamTwoCharacter in listOfTeam2) {
                        while (true) {
                            randomCh = (0..4).random()
                            if (listOfTeam1[randomCh].hp > 0) {
                                break
                            }
                            if (listOfTeam1[0].hp <= 0 && listOfTeam1[1].hp <= 0 && listOfTeam1[2].hp <= 0 &&
                                listOfTeam1[3].hp <= 0 && listOfTeam1[4].hp <= 0
                            ) {
                                isTeam1Dead = true
                                break
                            }
                        }


                        if (teamTwoCharacter.hp > 0 && !isTeam1Dead) {
                            var randomC = (1..100).random()

                            if (randomC <= teamTwoCharacter.criticalChance) {
                                listOfTeam1[randomCh].hp -= (teamTwoCharacter.damage / ((listOfTeam1[randomCh].totalArmor/100)+1)) * 4
                            } else if (randomC > teamTwoCharacter.criticalChance) {
                                listOfTeam1[randomCh].hp -= (teamTwoCharacter.damage / ((listOfTeam1[randomCh].totalArmor / 100) + 1))
                            }
                        }

                    }



                    heroHp = listOfTeam1[0].hp
                    mercenary1Hp = listOfTeam1[1].hp
                    mercenary2Hp = listOfTeam1[2].hp
                    mercenary3Hp = listOfTeam1[3].hp
                    mercenary4Hp = listOfTeam1[4].hp

                    enemy1Hp = listOfTeam2[0].hp
                    enemy2Hp = listOfTeam2[1].hp
                    enemy3Hp = listOfTeam2[2].hp
                    enemy4Hp = listOfTeam2[3].hp
                    enemy5Hp = listOfTeam2[4].hp


                    if (listOfTeam1[0].hp <= 0 && listOfTeam1[1].hp <= 0 && listOfTeam1[2].hp <= 0 &&
                        listOfTeam1[3].hp <= 0 && listOfTeam1[4].hp <= 0
                    ) {
                        isTeam1Dead = true
                    }

                    if (listOfTeam2[0].hp <= 0 && listOfTeam2[1].hp <= 0 && listOfTeam2[2].hp <= 0 &&
                        listOfTeam2[3].hp <= 0 && listOfTeam2[4].hp <= 0
                    ) {
                        isTeam2Dead = true
                    }



                    if (isTimerActive) {
                        updateHp()
                    }

                    if (isTeam1Dead) {
                        isTimerActive = false
                    } else if (isTeam2Dead) {
                        isTimerActive = false
                    }


                }
            }
        }, 0, 2000)


    }


    fun setUpHeroStats() {




    }


    fun updateHp() {


        auth = Firebase.auth
        val user = auth.currentUser


        var refresh = fightingHp(
            heroHp = heroHp,
            mercenary1Hp = mercenary1Hp,
            mercenary2Hp = mercenary2Hp,
            mercenary3Hp = mercenary3Hp,
            mercenary4Hp = mercenary4Hp,
            enemy1Hp = enemy1Hp,
            enemy2Hp = enemy2Hp,
            enemy3Hp = enemy3Hp,
            enemy4Hp = enemy4Hp,
            enemy5Hp = enemy5Hp
        )


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData")
                .document("battleField").collection("data").document("list").set(refresh)


                .addOnCompleteListener {


                }
        }


    }


}