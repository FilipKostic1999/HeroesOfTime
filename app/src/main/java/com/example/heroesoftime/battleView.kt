package com.example.heroesoftime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
    var smalBoar = character(100.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var smalWolf = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var smalWolf2 = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var smalBear = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var smalBear2 = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var smalBear3 = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var bandit1 = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var bandit2 = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var bandit3 = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var asassin1 = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var asassin2 = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)
    var asassin3 = character(140.0, 18.0, 100.0, 40.0, 50.0, 50.0, 0.0, 0.0)




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
    lateinit var statsText:  TextView

    lateinit var enemy1HpTxt: TextView
    lateinit var enemy2HpTxt: TextView
    lateinit var enemy3HpTxt: TextView
    lateinit var enemy4HpTxt: TextView
    lateinit var enemy5HpTxt: TextView

    lateinit var heroDungeonImg : ImageView
    lateinit var mercenary1DungeonImg : ImageView
    lateinit var mercenary2DungeonImg : ImageView
    lateinit var mercenary3DungeonImg : ImageView
    lateinit var mercenary4DungeonImg : ImageView

    lateinit var enemy1 : ImageView
    lateinit var enemy2 : ImageView
    lateinit var enemy3 : ImageView
    lateinit var enemy4 : ImageView
    lateinit var enemy5 : ImageView


    lateinit var backBtn: Button
    lateinit var fightAgainBtn: Button


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
    var heroCurrentMana = 0
    var snapshotAllow = false



    var savedMArmor = 0
    var savedMRobe = 0
    var savedMGloves = 0
    var savedMShoes = 0
    var savedMShield = 0
    var savedMBelt = 0
    var savedMHelmet = 0
    var savedMWeapon = 0
    var savedMRing1 = 0
    var savedMRing2 = 0
    var savedMAmulet = 0

    var savedMHp : Double = 0.0
    var savedMVitality = 0
    var savedMStrenght = 0
    var savedMSpeed = 0
    var savedMMana = 0
    var critical = 0





    var savedM2Armor = 0
    var savedM2Robe = 0
    var savedM2Gloves = 0
    var savedM2Shoes = 0
    var savedM2Shield = 0
    var savedM2Belt = 0
    var savedM2Helmet = 0
    var savedM2Weapon = 0
    var savedM2Ring1 = 0
    var savedM2Ring2 = 0
    var savedM2Amulet = 0

    var savedM2Hp : Double = 0.0
    var savedM2Vitality = 0
    var savedM2Strenght = 0
    var savedM2Speed = 0
    var savedM2Mana = 0
    var criticalM2 = 0




    var savedM3Armor = 0
    var savedM3Robe = 0
    var savedM3Gloves = 0
    var savedM3Shoes = 0
    var savedM3Shield = 0
    var savedM3Belt = 0
    var savedM3Helmet = 0
    var savedM3Weapon = 0
    var savedM3Ring1 = 0
    var savedM3Ring2 = 0
    var savedM3Amulet = 0

    var savedM3Hp : Double = 0.0
    var savedM3Vitality = 0
    var savedM3Strenght = 0
    var savedM3Speed = 0
    var savedM3Mana = 0
    var criticalM3 = 0




    var savedM4Armor = 0
    var savedM4Robe = 0
    var savedM4Gloves = 0
    var savedM4Shoes = 0
    var savedM4Shield = 0
    var savedM4Belt = 0
    var savedM4Helmet = 0
    var savedM4Weapon = 0
    var savedM4Ring1 = 0
    var savedM4Ring2 = 0
    var savedM4Amulet = 0

    var savedM4Hp : Double = 0.0
    var savedM4Vitality = 0
    var savedM4Strenght = 0
    var savedM4Speed = 0
    var savedM4Mana = 0
    var criticalM4 = 0



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







    lateinit var auth: FirebaseAuth
    lateinit var savedtavern : missions
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
        statsText = findViewById(R.id.statsText)
        enemy1HpTxt = findViewById(R.id.enemy1HpTxt)
        enemy2HpTxt = findViewById(R.id.enemy2HpTxt)
        enemy3HpTxt = findViewById(R.id.enemy3HpTxt)
        enemy4HpTxt = findViewById(R.id.enemy4HpTxt)
        enemy5HpTxt = findViewById(R.id.enemy5HpTxt)

        heroDungeonImg = findViewById(R.id.heroImg)
        mercenary1DungeonImg = findViewById(R.id.mercenary1)
        mercenary2DungeonImg = findViewById(R.id.mercenary2)
        mercenary3DungeonImg = findViewById(R.id.mercenary3)
        mercenary4DungeonImg = findViewById(R.id.mercenary4)

        enemy1 = findViewById(R.id.enemy1)
        enemy2 = findViewById(R.id.enemy2)
        enemy3 = findViewById(R.id.enemy3)
        enemy4 = findViewById(R.id.enemy4)
        enemy5 = findViewById(R.id.enemy5)

        backBtn = findViewById(R.id.backBtn)
        fightAgainBtn = findViewById(R.id.fightAgainBtn)





        listOfTeam1 = arrayListOf()
        listOfTeam2 = arrayListOf()



        statsText.isVisible = false
        mercenary1DungeonImg.isVisible = false
        mercenary2DungeonImg.isVisible = false
        mercenary3DungeonImg.isVisible = false
        mercenary4DungeonImg.isVisible = false
        mercenary1HpTxt.isVisible = false
        mercenary2HpTxt.isVisible = false
        mercenary3HpTxt.isVisible = false
        mercenary4HpTxt.isVisible = false

        enemy2.isVisible = false
        enemy3.isVisible = false
        enemy4.isVisible = false
        enemy5.isVisible = false
        enemy2HpTxt.isVisible = false
        enemy3HpTxt.isVisible = false
        enemy4HpTxt.isVisible = false
        enemy5HpTxt.isVisible = false

        backBtn.isVisible = false
        backBtn.isEnabled = false
        fightAgainBtn.isVisible = false
        fightAgainBtn.isEnabled = false




        val sharedLocation = getSharedPreferences("Location", AppCompatActivity.MODE_PRIVATE)
        var Location = sharedLocation.getInt("Location", 0)


        location = Location



        setDungeon()




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
                            heroCurrentMana = savedDataOfUser.heroCurrentMana


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

                            if (savedDataOfUser.heroMana >= ((listOfTeam1[0].hp * (2.0 * savedHeroWarcry))/100.0)) {
                                listOfTeam1[0].hp += ((listOfTeam1[0].hp * (2.0 * savedHeroWarcry))/100.0)
                                heroCurrentMana -= ((listOfTeam1[0].hp * (2.0 * savedHeroWarcry))/100.0).roundToInt()
                            }

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


                            if (savedHeroImage == 1) {
                                heroDungeonImg.setImageResource(R.drawable.malewarrior)
                            } else if (savedHeroImage == 2) {
                                heroDungeonImg.setImageResource(R.drawable.femaleasassin)
                            } else if (savedHeroImage == 3) {
                                heroDungeonImg.setImageResource(R.drawable.femalewarrior)
                            } else if (savedHeroImage == 4) {
                                heroDungeonImg.setImageResource(R.drawable.hatavatar)
                            } else if (savedHeroImage == 5) {
                                heroDungeonImg.setImageResource(R.drawable.maleadventurer)
                            }





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


                            if (isTeam1Dead) {
                                isTimerActive = true
                                backBtn.isVisible = true
                                backBtn.isEnabled = true
                                fightAgainBtn.isVisible = true
                                fightAgainBtn.isEnabled = true
                            } else if (isTeam2Dead) {
                                isTimerActive = true
                                backBtn.isVisible = true
                                backBtn.isEnabled = true
                                fightAgainBtn.isVisible = true
                                fightAgainBtn.isEnabled = true
                            }




                        }
                    }
                }
        }





        if (user != null) {

            database.collection("users").document(user.uid).collection("userData").
            document("Mercenaries Data").collection("mercenary1")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedDataOfUser = document.toObject()!!


                                savedMArmor = savedDataOfUser.heroArmorId
                                savedMRobe = savedDataOfUser.heroRobeId
                                savedMGloves = savedDataOfUser.heroGloveId
                                savedMShoes = savedDataOfUser.heroShoesId
                                savedMShield = savedDataOfUser.heroShieldId
                                savedMBelt = savedDataOfUser.heroBeltId
                                savedMHelmet = savedDataOfUser.heroHelmetId
                                savedMWeapon = savedDataOfUser.heroWeaponId
                                savedMRing1 = savedDataOfUser.heroRingId1
                                savedMRing2 = savedDataOfUser.heroRingId2
                                savedMAmulet = savedDataOfUser.heroAmuletId


                                savedMHp = savedDataOfUser.heroCurrentHp
                                savedMVitality = savedDataOfUser.heroVitality
                                savedMStrenght = savedDataOfUser.heroStrenght
                                savedMSpeed = savedDataOfUser.heroSpeed
                                savedMMana = savedDataOfUser.heroMana
                                critical = savedDataOfUser.critical




                            listOfTeam1[1].totalArmor = savedDataOfUser.heroTotalArmor
                            listOfTeam1[1].hp = savedDataOfUser.heroCurrentHp
                            listOfTeam1[1].damage = savedDataOfUser.itemWeaponDamage + (savedDataOfUser.heroStrenght.toDouble() +
                                    savedDataOfUser.itemsAddedStrenght)/2
                            listOfTeam1[1].speed = savedDataOfUser.itemsAddedSpeed + savedDataOfUser.itemsAddedSpeed
                            listOfTeam1[1].criticalChance = savedDataOfUser.critical*4.0


                            if (listOfTeam1[1].hp > 0) {
                                mercenary1DungeonImg.isVisible = true
                                mercenary1HpTxt.isVisible = true
                            }

                            if (listOfTeam1[2].hp > 0) {
                                mercenary2DungeonImg.isVisible = true
                                mercenary2HpTxt.isVisible = true
                            }

                            if (listOfTeam1[3].hp > 0) {
                                mercenary3DungeonImg.isVisible = true
                                mercenary3HpTxt.isVisible = true
                            }

                            if (listOfTeam1[4].hp > 0) {
                                mercenary4DungeonImg.isVisible = true
                                mercenary4HpTxt.isVisible = true
                            }

                            mercenary1HpTxt.text = "${listOfTeam1[1].hp.roundToInt()} HP"




                        }
                    }
                }
        }







        if (user != null) {

            database.collection("users").document(user.uid).collection("userData").
            document("Mercenaries Data").collection("mercenary2")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedDataOfUser = document.toObject()!!


                            savedM2Armor = savedDataOfUser.heroArmorId
                            savedM2Robe = savedDataOfUser.heroRobeId
                            savedM2Gloves = savedDataOfUser.heroGloveId
                            savedM2Shoes = savedDataOfUser.heroShoesId
                            savedM2Shield = savedDataOfUser.heroShieldId
                            savedM2Belt = savedDataOfUser.heroBeltId
                            savedM2Helmet = savedDataOfUser.heroHelmetId
                            savedM2Weapon = savedDataOfUser.heroWeaponId
                            savedM2Ring1 = savedDataOfUser.heroRingId1
                            savedM2Ring2 = savedDataOfUser.heroRingId2
                            savedM2Amulet = savedDataOfUser.heroAmuletId


                            savedM2Hp = savedDataOfUser.heroCurrentHp
                            savedM2Vitality = savedDataOfUser.heroVitality
                            savedM2Strenght = savedDataOfUser.heroStrenght
                            savedM2Speed = savedDataOfUser.heroSpeed
                            savedM2Mana = savedDataOfUser.heroMana
                            criticalM2 = savedDataOfUser.critical




                            listOfTeam1[2].totalArmor = savedDataOfUser.heroTotalArmor
                            listOfTeam1[2].hp = savedDataOfUser.heroCurrentHp
                            listOfTeam1[2].damage = savedDataOfUser.itemWeaponDamage + (savedDataOfUser.heroStrenght.toDouble() +
                                    savedDataOfUser.itemsAddedStrenght)/2
                            listOfTeam1[2].speed = savedDataOfUser.itemsAddedSpeed + savedDataOfUser.itemsAddedSpeed
                            listOfTeam1[2].criticalChance = savedDataOfUser.critical*4.0


                            if (listOfTeam1[2].hp > 0) {
                                mercenary2DungeonImg.isVisible = true
                                mercenary2HpTxt.isVisible = true
                            }


                            mercenary2HpTxt.text = "${listOfTeam1[2].hp.roundToInt()} HP"




                        }
                    }
                }
        }




        if (user != null) {

            database.collection("users").document(user.uid).collection("userData").
            document("Mercenaries Data").collection("mercenary3")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedDataOfUser = document.toObject()!!


                            savedM3Armor = savedDataOfUser.heroArmorId
                            savedM3Robe = savedDataOfUser.heroRobeId
                            savedM3Gloves = savedDataOfUser.heroGloveId
                            savedM3Shoes = savedDataOfUser.heroShoesId
                            savedM3Shield = savedDataOfUser.heroShieldId
                            savedM3Belt = savedDataOfUser.heroBeltId
                            savedM3Helmet = savedDataOfUser.heroHelmetId
                            savedM3Weapon = savedDataOfUser.heroWeaponId
                            savedM3Ring1 = savedDataOfUser.heroRingId1
                            savedM3Ring2 = savedDataOfUser.heroRingId2
                            savedM3Amulet = savedDataOfUser.heroAmuletId


                            savedM3Hp = savedDataOfUser.heroCurrentHp
                            savedM3Vitality = savedDataOfUser.heroVitality
                            savedM3Strenght = savedDataOfUser.heroStrenght
                            savedM3Speed = savedDataOfUser.heroSpeed
                            savedM3Mana = savedDataOfUser.heroMana
                            criticalM3 = savedDataOfUser.critical




                            listOfTeam1[3].totalArmor = savedDataOfUser.heroTotalArmor
                            listOfTeam1[3].hp = savedDataOfUser.heroCurrentHp
                            listOfTeam1[3].damage = savedDataOfUser.itemWeaponDamage + (savedDataOfUser.heroStrenght.toDouble() +
                                    savedDataOfUser.itemsAddedStrenght)/2
                            listOfTeam1[3].speed = savedDataOfUser.itemsAddedSpeed + savedDataOfUser.itemsAddedSpeed
                            listOfTeam1[3].criticalChance = savedDataOfUser.critical*4.0


                            if (listOfTeam1[3].hp > 0) {
                                mercenary3DungeonImg.isVisible = true
                                mercenary3HpTxt.isVisible = true
                            }


                            mercenary3HpTxt.text = "${listOfTeam1[3].hp.roundToInt()} HP"




                        }
                    }
                }
        }




        if (user != null) {

            database.collection("users").document(user.uid).collection("userData").
            document("Mercenaries Data").collection("mercenary4")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedDataOfUser = document.toObject()!!


                            savedM4Armor = savedDataOfUser.heroArmorId
                            savedM4Robe = savedDataOfUser.heroRobeId
                            savedM4Gloves = savedDataOfUser.heroGloveId
                            savedM4Shoes = savedDataOfUser.heroShoesId
                            savedM4Shield = savedDataOfUser.heroShieldId
                            savedM4Belt = savedDataOfUser.heroBeltId
                            savedM4Helmet = savedDataOfUser.heroHelmetId
                            savedM4Weapon = savedDataOfUser.heroWeaponId
                            savedM4Ring1 = savedDataOfUser.heroRingId1
                            savedM4Ring2 = savedDataOfUser.heroRingId2
                            savedM4Amulet = savedDataOfUser.heroAmuletId


                            savedM4Hp = savedDataOfUser.heroCurrentHp
                            savedM4Vitality = savedDataOfUser.heroVitality
                            savedM4Strenght = savedDataOfUser.heroStrenght
                            savedM4Speed = savedDataOfUser.heroSpeed
                            savedM4Mana = savedDataOfUser.heroMana
                            criticalM4 = savedDataOfUser.critical




                            listOfTeam1[4].totalArmor = savedDataOfUser.heroTotalArmor
                            listOfTeam1[4].hp = savedDataOfUser.heroCurrentHp
                            listOfTeam1[4].damage = savedDataOfUser.itemWeaponDamage + (savedDataOfUser.heroStrenght.toDouble() +
                                    savedDataOfUser.itemsAddedStrenght)/2
                            listOfTeam1[4].speed = savedDataOfUser.itemsAddedSpeed + savedDataOfUser.itemsAddedSpeed
                            listOfTeam1[4].criticalChance = savedDataOfUser.critical*4.0


                            if (listOfTeam1[4].hp > 0) {
                                mercenary4DungeonImg.isVisible = true
                                mercenary4HpTxt.isVisible = true
                            }


                            mercenary4HpTxt.text = "${listOfTeam1[4].hp.roundToInt()} HP"




                        }
                    }
                }
        }






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




                        }
                    }
                }
        }










        enemy1.setOnClickListener {
            statsText.text = "HP: ${listOfTeam2[0].hp.roundToInt()}, Damage: ${listOfTeam2[0].damage.roundToInt()}, Speed: ${listOfTeam2[0].speed.roundToInt()}," +
                    " Armor: ${listOfTeam2[0].totalArmor.roundToInt()}"
            statsText.isVisible = true
        }


        enemy2.setOnClickListener {
            statsText.text = "HP: ${listOfTeam2[1].hp.roundToInt()}, Damage: ${listOfTeam2[1].damage.roundToInt()}, Speed: ${listOfTeam2[1].speed.roundToInt()}," +
                    " Armor: ${listOfTeam2[1].totalArmor.roundToInt()}"
            statsText.isVisible = true
        }


        enemy3.setOnClickListener {
            statsText.text = "HP: ${listOfTeam2[2].hp.roundToInt()}, Damage: ${listOfTeam2[2].damage.roundToInt()}, Speed: ${listOfTeam2[2].speed.roundToInt()}," +
                    " Armor: ${listOfTeam2[2].totalArmor.roundToInt()}"
            statsText.isVisible = true
        }


        enemy4.setOnClickListener {
            statsText.text = "HP: ${listOfTeam2[3].hp.roundToInt()}, Damage: ${listOfTeam2[3].damage.roundToInt()}, Speed: ${listOfTeam2[3].speed.roundToInt()}," +
                    " Armor: ${listOfTeam2[3].totalArmor.roundToInt()}"
            statsText.isVisible = true
        }



        enemy5.setOnClickListener {
            statsText.text = "HP: ${listOfTeam2[4].hp.roundToInt()}, Damage: ${listOfTeam2[4].damage.roundToInt()}, Speed: ${listOfTeam2[4].speed.roundToInt()}," +
                    " Armor: ${listOfTeam2[4].totalArmor.roundToInt()}"
            statsText.isVisible = true
        }



        backBtn.setOnClickListener {
            val intent = Intent(this, villageOfHopeMapActivity :: class.java)
            startActivity(intent)
        }


        fightAgainBtn.setOnClickListener {
            val intent = Intent(this, battleView :: class.java)
            startActivity(intent)
        }










        var isWarriorSpiritActive = true


        val scope = CoroutineScope(Dispatchers.Default)

        scope.launch {
            while (!isTeam1Dead && !isTeam2Dead) {


                starter ++

                if (starter > 1) {

                    if (listOfTeam1[0].hp < (listOfTeam1[0].vitality) && listOfTeam1[0].hp > 0 && isWarriorSpiritActive) {
                        if (heroCurrentMana >= ((savedHeroWarriorSpirit.toDouble() * 3) * (listOfTeam1[0].vitality * 10))/100) {
                            listOfTeam1[0].hp += ((savedHeroWarriorSpirit.toDouble() * 3) * (listOfTeam1[0].vitality * 10))/100
                            heroCurrentMana -= (((savedHeroWarriorSpirit.toDouble() * 3) * (listOfTeam1[0].vitality * 10))/100).roundToInt()
                            isWarriorSpiritActive = false
                        }
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


                            var x1D = 0.0
                            var x1Int = 0
                            var randomH = 0

                            if (teamTwoCharacter.speed >= listOfTeam1[randomCh].speed) {
                                x1D = (teamTwoCharacter.speed / listOfTeam1[randomCh].speed)
                                x1Int = round(x1D).toInt()
                                randomH = (0..x1Int).random()
                            } else if (teamTwoCharacter.speed < listOfTeam1[randomCh].speed) {
                                x1D = (listOfTeam1[randomCh].speed / teamTwoCharacter.speed)
                                x1Int = round(x1D).toInt()
                                randomH = (0..x1Int).random()
                            }

                            if (randomH > 0 && teamTwoCharacter.speed >= listOfTeam1[randomCh].speed) {

                                val randomC = (1..100).random()

                                if (randomC <= teamTwoCharacter.criticalChance) {
                                    listOfTeam1[randomCh].hp -= (teamTwoCharacter.damage / ((listOfTeam1[randomCh].totalArmor/100)+1)) * 4
                                } else if (randomC > teamTwoCharacter.criticalChance) {
                                    listOfTeam1[randomCh].hp -= (teamTwoCharacter.damage / ((listOfTeam1[randomCh].totalArmor / 100) + 1))
                                }

                            } else if (randomH == 0 && teamTwoCharacter.speed < listOfTeam1[randomCh].speed) {

                                val randomC = (1..100).random()

                                if (randomC <= teamTwoCharacter.criticalChance) {
                                    listOfTeam1[randomCh].hp -= (teamTwoCharacter.damage / ((listOfTeam1[randomCh].totalArmor/100)+1)) * 4
                                } else if (randomC > teamTwoCharacter.criticalChance) {
                                    listOfTeam1[randomCh].hp -= (teamTwoCharacter.damage / ((listOfTeam1[randomCh].totalArmor / 100) + 1))
                                }

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
                    }

                    if (isTeam2Dead) {
                        isTimerActive = false
                        saveMissionsVillageOfHope()
                        victoryGold()
                        save()
                    }


                }
                delay(2000L) // Delay of 1000ms (1 second)
            }
        }



    }











    fun saveMissionsVillageOfHope() {

        auth = Firebase.auth
        val user = auth.currentUser


        if (location == 1 && !isTeam1Dead && progres1 > -1) {
            progres1 += 1
        }
        if (location == 2 && !isTeam1Dead && progres2 > -1) {
            progres2 += 1
        }
        if (location == 4 && !isTeam1Dead && progres3 > -1) {
            progres3 += 3
        }
        if (location == 7 && !isTeam1Dead && progres4 > -1) {
            progres4 += 1
        }
        if (location == 6 && !isTeam1Dead && progres5 > -1) {
            progres5 += 3
        }
        if (location == 5 && !isTeam1Dead && progres6 > -1) {
            progres6 += 3
        }
        if (location == 5 && !isTeam1Dead && progres7 > -1) {
            progres7 += 3
        }
        if (location == 8 && !isTeam1Dead && progres8 > -1) {
            progres8 += 1
        }
        if (location == 4 && !isTeam1Dead && progres9 > -1) {
            progres9 += 3
        }
        if (location == 9 && !isTeam1Dead && progres10 > -1) {
            progres10 += 1
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





    fun victoryGold() {


        if (isTeam2Dead) {
            savedHeroGold += goldVictory
        }




    }




    fun save() {



        auth = Firebase.auth
        val user = auth.currentUser


        heroCurrentHp = listOfTeam1[0].hp


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





    fun setDungeon() {


        // hero and mercenaries

        listOfTeam1.add(hero)
        listOfTeam1.add(character1)
        listOfTeam1.add(character2)
        listOfTeam1.add(character3)
        listOfTeam1.add(character4)





        // enemies of forest dungeon

        if (location == 1) {
            listOfTeam2.add(smalBoar)
            enemy1.setImageResource(R.drawable.snalboar)
            listOfTeam2.add(character11)
            listOfTeam2.add(character22)
            listOfTeam2.add(character33)
            listOfTeam2.add(character44)
                goldVictory = 1
        }


        // enemies of forest dungeon

        if (location == 2) {
            listOfTeam2.add(smalWolf)
            enemy1.setImageResource(R.drawable.smalwolf)
            listOfTeam2.add(smalBoar)
            enemy2.setImageResource(R.drawable.snalboar)
            listOfTeam2.add(character22)
            listOfTeam2.add(character33)
            listOfTeam2.add(character44)
            goldVictory = 7
        }


// enemies of forest dungeon

        if (location == 3) {
            listOfTeam2.add(smalBear)
            enemy1.setImageResource(R.drawable.smalbear)
            listOfTeam2.add(smalWolf)
            enemy2.setImageResource(R.drawable.smalwolf)
            listOfTeam2.add(smalWolf2)
            enemy3.setImageResource(R.drawable.smalwolf)
            listOfTeam2.add(character33)
            listOfTeam2.add(character44)
            goldVictory = 1
        }



        if (location == 4) {
            listOfTeam2.add(bandit1)
            enemy1.setImageResource(R.drawable.bandit)
            listOfTeam2.add(bandit2)
            enemy2.setImageResource(R.drawable.bandit)
            listOfTeam2.add(bandit3)
            enemy3.setImageResource(R.drawable.bandit)
            listOfTeam2.add(character33)
            listOfTeam2.add(character44)
            goldVictory = 1
        }



        if (location == 5) {
            listOfTeam2.add(asassin1)
            enemy1.setImageResource(R.drawable.asassins)
            listOfTeam2.add(asassin2)
            enemy2.setImageResource(R.drawable.asassins)
            listOfTeam2.add(asassin3)
            enemy3.setImageResource(R.drawable.asassins)
            listOfTeam2.add(bandit1)
            enemy4.setImageResource(R.drawable.bandit)
            listOfTeam2.add(bandit2)
            enemy5.setImageResource(R.drawable.bandit)
            goldVictory = 1
        }



        if (location == 6) {
            listOfTeam2.add(smalBear)
            enemy1.setImageResource(R.drawable.smalbear)
            listOfTeam2.add(smalBear2)
            enemy2.setImageResource(R.drawable.smalbear)
            listOfTeam2.add(smalBear3)
            enemy3.setImageResource(R.drawable.smalbear)
            listOfTeam2.add(character33)
            enemy4.setImageResource(R.drawable.bandit)
            listOfTeam2.add(character44)
            enemy5.setImageResource(R.drawable.bandit)
            goldVictory = 1
        }



        if (listOfTeam2[1].hp > 0) {
            enemy2.isVisible = true
            enemy2HpTxt.isVisible = true
        }

        if (listOfTeam2[2].hp > 0) {
            enemy3.isVisible = true
            enemy3HpTxt.isVisible = true
        }

        if (listOfTeam2[3].hp > 0) {
            enemy4.isVisible = true
            enemy4HpTxt.isVisible = true
        }

        if (listOfTeam2[4].hp > 0) {
            enemy5.isVisible = true
            enemy5HpTxt.isVisible = true
        }


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