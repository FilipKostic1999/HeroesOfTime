package com.example.heroesoftime

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

class attributesActivity : AppCompatActivity() {




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


    var availablePoints = 0
    var availableAbilityPoints = 0




    lateinit var saveBtn : Button
    lateinit var vitalityAmountTxt : TextView
    lateinit var strenghtAmountTxt : TextView
    lateinit var speedAmountTxt : TextView
    lateinit var manaAmountTxt : TextView
    lateinit var warcryTxt : TextView
    lateinit var criticalTxt : TextView
    lateinit var furyTxt : TextView
    lateinit var poisonBladeTxt : TextView
    lateinit var warriorSpiritTxt : TextView
    lateinit var temeraryTxt : TextView
    lateinit var destructiveSpiritTxt : TextView
    lateinit var hardSkinTxt : TextView
    lateinit var pointsTxt : TextView
    lateinit var vitalityPlus : ImageView
    lateinit var strenghtPlus : ImageView
    lateinit var speedPlus : ImageView
    lateinit var manaPlus : ImageView

    lateinit var warcryPlus : ImageView
    lateinit var criticalPlus : ImageView
    lateinit var furyPlus : ImageView
    lateinit var poisonBladePlus : ImageView
    lateinit var warriorSpiritPlus : ImageView
    lateinit var temeraryPlus : ImageView
    lateinit var destructiveSpiritPlus : ImageView
    lateinit var hardSkinPlus : ImageView
    lateinit var heroImage : ImageView



    lateinit var auth : FirebaseAuth
    lateinit var database : FirebaseFirestore
    lateinit var savedDataOfUser : heroDataClass


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attributes)


        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser


        saveBtn = findViewById(R.id.saveBtn)
        vitalityAmountTxt = findViewById(R.id.vitalityAmountTxt)
        strenghtAmountTxt = findViewById(R.id.strenghtAmountTxt)
        speedAmountTxt = findViewById(R.id.speedAmountTxt)
        manaAmountTxt = findViewById(R.id.manaAmountTxt)
        warcryTxt = findViewById(R.id.warcryTxt)
        criticalTxt = findViewById(R.id.criticalTxt)
        furyTxt = findViewById(R.id.furyTxt)
        poisonBladeTxt = findViewById(R.id.poisonBladeTxt)
        warriorSpiritTxt = findViewById(R.id.warriorSpiritTxt)
        temeraryTxt = findViewById(R.id.temeraryTxt)
        destructiveSpiritTxt = findViewById(R.id.destructiveSpiritTxt)
        hardSkinTxt = findViewById(R.id.hardSkinTxt)
        pointsTxt = findViewById(R.id.pointsTxt)
        vitalityPlus = findViewById(R.id.vitalityPlus)
        strenghtPlus = findViewById(R.id.strenghtPlus)
        speedPlus = findViewById(R.id.speedPlus)
        manaPlus = findViewById(R.id.manaPlus)
        warcryPlus = findViewById(R.id.warcryPlus)
        criticalPlus = findViewById(R.id.criticalPlus)
        furyPlus = findViewById(R.id.furyPlus)
        poisonBladePlus = findViewById(R.id.poisonBladePlus)
        warriorSpiritPlus = findViewById(R.id.warriorSpiritPlus)
        temeraryPlus = findViewById(R.id.temeraryPlus)
        destructiveSpiritPlus = findViewById(R.id.destructiveSpiritPlus)
        hardSkinPlus = findViewById(R.id.hardSkinPlus)
        heroImage = findViewById(R.id.heroImage)



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



                            vitalityAmountTxt.text = "$savedHeroVitality"
                            strenghtAmountTxt.text = "$savedHeroStrenght"
                            speedAmountTxt.text = "$savedHeroSpeed"
                            manaAmountTxt.text = "$savedHeroMana"

                            warcryTxt.text = "$savedHeroWarcry/5"
                            criticalTxt.text = "$savedHeroCritical/10"
                            furyTxt.text = "$savedHeroFury/5"
                            poisonBladeTxt.text = "$savedHeroPoisonBlade/5"
                            warriorSpiritTxt.text = "$savedHeroWarriorSpirit/5"
                            temeraryTxt.text = "$savedHeroTemerary/10"
                            destructiveSpiritTxt.text = "$savedHeroDestructiveSpirit/5"
                            hardSkinTxt.text = "$savedHeroHardSkin/5"



                             availablePoints = (((savedHeroLevel - 1)*5)+40) - (savedHeroVitality +
                                    savedHeroStrenght + savedHeroSpeed + savedHeroMana)

                             availableAbilityPoints = (((savedHeroLevel - 1)*1)+1) - (savedHeroWarcry +
                                    savedHeroCritical + savedHeroFury + savedHeroPoisonBlade +
                                    savedHeroWarriorSpirit + savedHeroTemerary + savedHeroDestructiveSpirit +
                                    savedHeroHardSkin)


                            pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"



                            if (savedHeroImage == 1) {
                                heroImage.setImageResource(R.drawable.malewarrior)
                            } else if (savedHeroImage == 2) {
                                heroImage.setImageResource(R.drawable.femaleasassin)
                            } else if (savedHeroImage == 3) {
                                heroImage.setImageResource(R.drawable.femalewarrior)
                            } else if (savedHeroImage == 4) {
                                heroImage.setImageResource(R.drawable.hatavatar)
                            } else if (savedHeroImage == 5) {
                                heroImage.setImageResource(R.drawable.maleadventurer)
                            }



                        }
                    }
                }
        }




        saveBtn.setOnClickListener {

            save()


        }

        vitalityPlus.setOnClickListener {
            if (availablePoints > 0) {
                savedHeroVitality ++
                availablePoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                vitalityAmountTxt.text = "$savedHeroVitality"
            }
        }

        strenghtPlus.setOnClickListener {
            if (availablePoints > 0) {
                savedHeroStrenght ++
                availablePoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                strenghtAmountTxt.text = "$savedHeroStrenght"
            }
        }

        speedPlus.setOnClickListener {
            if (availablePoints > 0) {
                savedHeroSpeed ++
                availablePoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                speedAmountTxt.text = "$savedHeroSpeed"
            }
        }

        manaPlus.setOnClickListener {
            if (availablePoints > 0) {
                savedHeroMana ++
                availablePoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                manaAmountTxt.text = "$savedHeroMana"
            }
        }

        warcryPlus.setOnClickListener {
            if (availableAbilityPoints > 0) {
                savedHeroWarcry ++
                availableAbilityPoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                warcryTxt.text = "$savedHeroWarcry/5"
            }
        }

        criticalPlus.setOnClickListener {
            if (availableAbilityPoints > 0) {
                savedHeroCritical ++
                availableAbilityPoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                criticalTxt.text = "$savedHeroCritical/10"
            }
        }

        furyPlus.setOnClickListener {
            if (availableAbilityPoints > 0) {
                savedHeroFury ++
                availableAbilityPoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                furyTxt.text = "$savedHeroFury/5"
            }
        }

        poisonBladePlus.setOnClickListener {
            if (availableAbilityPoints > 0) {
                savedHeroPoisonBlade ++
                availableAbilityPoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                poisonBladeTxt.text = "$savedHeroPoisonBlade/5"
            }
        }

        warriorSpiritPlus.setOnClickListener {
            if (availableAbilityPoints > 0) {
                savedHeroWarriorSpirit ++
                availableAbilityPoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                warriorSpiritTxt.text = "$savedHeroWarriorSpirit/5"
            }
        }

        temeraryPlus.setOnClickListener {
            if (availableAbilityPoints > 0) {
                savedHeroTemerary ++
                availableAbilityPoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                temeraryTxt.text = "$savedHeroTemerary/10"
            }
        }

        destructiveSpiritPlus.setOnClickListener {
            if (availableAbilityPoints > 0) {
                savedHeroDestructiveSpirit ++
                availableAbilityPoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                destructiveSpiritTxt.text = "$savedHeroDestructiveSpirit/5"
            }
        }

        hardSkinPlus.setOnClickListener {
            if (availableAbilityPoints > 0) {
                savedHeroHardSkin ++
                availableAbilityPoints --
                pointsTxt.text = "Points: $availablePoints Special: $availableAbilityPoints"
                hardSkinTxt.text = "$savedHeroHardSkin/5"
            }
        }








    }




    fun save() {



        auth = Firebase.auth
        val user = auth.currentUser

        var heroData = heroDataClass(heroIconId = savedHeroImage, heroLevel = savedHeroLevel, heroExperience = 1, heroArmorId = savedHeroArmor,
            heroRobeId = savedHeroRobe, heroGloveId = savedHeroGloves, heroShoesId = savedHeroShoes,
            heroShieldId = savedHeroShield, heroBeltId = savedHeroBelt,
            heroHelmetId = savedHeroHelmet, heroWeaponId = savedHeroWeapon,
            heroInventorySlot1 = savedHeroInventorySlot1, heroInventorySlot2 = savedHeroInventorySlot2,
            heroInventorySlot3 = savedHeroInventorySlot3, heroInventorySlot4 = savedHeroInventorySlot4,
            heroInventorySlot5 = savedHeroInventorySlot5, heroGold = savedHeroGold, heroRingId1 = savedHeroRing1,
            heroRingId2 = savedHeroRing2, heroAmuletId = savedHeroAmulet, warCry = savedHeroWarcry,
        critical = savedHeroCritical, fury = savedHeroFury, poisonBlade = savedHeroPoisonBlade,
        warriorSpirit = savedHeroWarriorSpirit, temerary = savedHeroTemerary, destructiveSpirit = savedHeroDestructiveSpirit,
        hardSkin = savedHeroHardSkin, heroVitality = savedHeroVitality, heroStrenght = savedHeroStrenght,
        heroMana = savedHeroMana, heroSpeed = savedHeroSpeed, heroCurrentHp = 100.0, heroName = "",
        heroCurrentMana = 100, heroCurrentLocation = 1, heroDiamonds = 0)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Hero").set(heroData)


                .addOnCompleteListener {


                }
        }



    }









}