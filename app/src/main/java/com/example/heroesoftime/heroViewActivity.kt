package com.example.heroesoftime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class heroViewActivity : AppCompatActivity() {



    var noIdArmor = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var noIdWeapon = weaponClass(0, "", 0, 0, 0, 0, 0, 0, 0)

    var heroArmorSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroRobeSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroGloveSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroShieldSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroShoesSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroHelmetSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroBeltSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroWeaponSlotAtributes = weaponClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroRingSlot1Attributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroRingSlot2Attributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroAmuletSlotAttributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)





    var heroArmorSlotAtributesm = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroRobeSlotAtributesm = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroGloveSlotAtributesm = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroShieldSlotAtributesm = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroShoesSlotAtributesm = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroHelmetSlotAtributesm = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroBeltSlotAtributesm = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroWeaponSlotAtributesm = weaponClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroRingSlot1Attributesm = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroRingSlot2Attributesm = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroAmuletSlotAttributesm = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)








    var inventoryAtributesSlot1 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var inventoryAtributesSlot2 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var inventoryAtributesSlot3 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var inventoryAtributesSlot4 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var inventoryAtributesSlot5 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)




    var leatherArmor1 = armorClass(1, "Leather armor", 18, 0, 0, 0, 0, 60, 1)
    var leatherArmor2 = armorClass(2, "Leather armor", 22, 0,0,2,2, 100, 1)
    var leatherArmor3 = armorClass(3, "Leather armor", 15, 2, 0, 0, 0, 80, 1)
    var leatherArmor4 = armorClass(4, "Leather armor", 25, 1,1,2,2, 90, 1)
    var rareLeatherArmor1 = armorClass(5, "Rare leather armor", 38, 5, 2, 1, 3, 220, 1)
    var rareLeatherArmor2 = armorClass(6, "Rare leather armor", 34, 6,4,0,2, 210, 1)


    var leatherRobe1 = armorClass(7, "Leather robe", 5, 1, 0, 0, 0, 20, 2)
    var leatherRobe2 = armorClass(8, "Leather robe", 6, 0,2,0,1, 34, 2)
    var leatherRobe3 = armorClass(9, "Leather robe", 4, 2, 0, 2, 2, 30, 2)
    var leatherRobe4 = armorClass(10, "Leather robe", 8, 2,2,2,0, 50, 2)
    var rareLeatherRobe1 = armorClass(11, "Rare leather robe", 15, 4, 2, 2, 2, 120, 2)
    var rareLeatherRobe2 = armorClass(12, "Rare leather robe", 12, 0,4,0,2, 80, 2)


    var leatherGloves1 = armorClass(13, "Leather gloves", 3, 0, 0, 0, 0, 16, 3)
    var leatherGloves2 = armorClass(14, "Leather gloves", 6, 0,0,2,2, 32, 3)
    var leatherGloves3 = armorClass(15, "Leather gloves", 4, 1, 1, 0, 0, 26, 3)
    var leatherGloves4 = armorClass(16, "Leather gloves", 7, 2,0,2,0, 40, 3)
    var rareLeatherGloves1 = armorClass(17, "Rare leather gloves", 14, 4, 2, 2, 2, 80, 3)
    var rareLeatherGloves2 = armorClass(18, "Rare leather gloves", 13, 3,6,0,0, 70, 3)



    var leatherShoes1 = armorClass(19, "Leather shoes", 8, 1, 0, 0, 0, 40, 4)
    var leatherShoes2 = armorClass(20, "Leather shoes", 12, 0,3,0,2, 70, 4)
    var leatherShoes3 = armorClass(21, "Leather shoes", 15, 2, 2, 0, 0, 80, 4)
    var leatherShoes4 = armorClass(22, "Leather shoes", 19, 2,0,2,2, 90, 4)
    var rareLeatherShoes1 = armorClass(23, "Rare leather shoes", 24, 3, 0, 0, 5, 110, 4)
    var rareLeatherShoes2 = armorClass(24, "Rare leather shoes", 21, 6,4,0,0, 150, 4)



    var leatherShield1 = armorClass(25, "Leather shield", 24, 0, 0, 0, 0, 140, 5)
    var leatherShield2 = armorClass(26, "Leather shield", 29, 1,0,0,0, 170, 5)
    var leatherShield3 = armorClass(27, "Leather shield", 18, 4, 0, 0, 0, 200, 5)
    var leatherShield4 = armorClass(28, "Leather shield", 32, 0,4,0,2, 200, 5)
    var rareLeatherShield1 = armorClass(29, "Rare leather shield", 44, 4, 0, 0, 4, 220, 5)
    var rareLeatherShield2 = armorClass(30, "Rare leather shield", 40, 5,4,0,4, 280, 5)



    var leatherBelt1 = armorClass(31, "Leather belt", 4, 1, 0, 0, 0, 20, 6)
    var leatherBelt2 = armorClass(32, "Leather belt", 7, 0,0,0,2, 24, 6)
    var leatherBelt3 = armorClass(33, "Leather belt", 8, 2, 0, 0, 2, 40, 6)
    var leatherBelt4 = armorClass(34, "Leather belt", 10, 0,0,0,0, 34, 6)
    var rareLeatherBelt1 = armorClass(35, "Rare leather belt", 12, 3, 1, 0, 3, 64, 6)
    var rareLeatherBelt2 = armorClass(36, "Rare leather belt", 18, 2,6,0,0, 94, 6)



    var leatherHelmet1 = armorClass(37, "Leather helmet", 7, 0, 0, 0, 0, 24, 7)
    var leatherHelmet2 = armorClass(38, "Leather helmet", 10, 0,0,0,0, 28, 7)
    var leatherHelmet3 = armorClass(39, "Leather helmet", 11, 2, 0, 2, 0, 42, 7)
    var leatherHelmet4 = armorClass(40, "Leather helmet", 16, 1,1,2,0, 58, 7)
    var rareLeatherHelmet1 = armorClass(41, "Rare leather helmet", 18, 4, 0, 1, 1, 72, 7)
    var rareLeatherHelmet2 = armorClass(42, "Rare leather helmet", 21, 2,2,2,0, 90, 7)


    var knife1 = weaponClass(43, "Knife", 3, 0, 0, 0, 0, 28, 8)
    var knife2 = weaponClass(44, "Knife", 2, 0, 1, 0, 1, 26, 8)
    var knife3 = weaponClass(45, "Knife", 3, 2, 0, 0, 0, 48, 8)
    var bow1 = weaponClass(46, "Bow", 6, 0,2,0,2, 122, 8)
    var bow2 = weaponClass(47, "Bow", 6, 0,0,0,2, 90, 8)
    var rareKnife = weaponClass(48, "Rare knife", 6, 0, 0, 2, 0, 92, 8)
    var strongBow = weaponClass(49, "Strong bow", 18, 2,1,2,0, 280, 8)
    var strongWarknife = weaponClass(50, "Strong warknife", 14, 4, 0, 0, 0, 240, 8)
    var sword = weaponClass(51, "Sword", 16, 0,0,0,0, 190, 8)
    var throwingKnifes1 = weaponClass(52, "Throwing knifes", 4, 0, 0, 0, 0, 32, 8)
    var throwingKnifes2 = weaponClass(53, "Throwing knifes", 5, 0, 0, 0, 0, 48, 8)
    var throwingKnifes3 = weaponClass(54, "Throwing knifes", 4, 0, 4, 0, 0, 68, 8)
    var warKnife1 = weaponClass(55, "War knife", 8, 0,0,0,0, 64, 8)
    var warKnife2 = weaponClass(56, "War knife", 8, 1,0,0,0, 92, 8)


    var pinkRing1 = armorClass(57, "Villagers´ Ring", 0, 2, 1, 0, 0, 50, 9)
    var pinkRing2 = armorClass(58, "Villagers´ Ring", 0, 3, 0, 0, 0, 60, 9)
    var pinkRing3 = armorClass(59, "Villagers´ Ring", 0, 0, 5, 0, 0, 80, 9)
    var rarePinkRing1 = armorClass(60, "Rare Ring", 0, 3, 3, 2, 0, 164, 9)
    var rarePinkRing2 = armorClass(61, "Rare´ Ring", 0, 4, 0, 0, 4, 224, 9)


    var amulet1 = armorClass(62, "Amulet", 0, 0, 2, 2, 0, 80, 10)
    var amulet2 = armorClass(63, "Amulet", 0, 0, 6, 0, 0, 90, 10)
    var amulet3 = armorClass(64, "Amulet", 0, 4, 0, 0, 0, 88, 10)
    var rareAmulet1 = armorClass(65, "Rare Amulet", 0, 0, 0, 0, 6, 120, 10)
    var rareAmulet2 = armorClass(66, "Rare Amulet", 0, 2, 0, 4, 0, 110, 10)




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
    var isButtonLogicActive = true



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
    var ChS = 0



    var selectedSlotInShopView = 0
    var selectedItemInShopPrice = 0


    lateinit var m1Btn : Button
    lateinit var m2Btn : Button
    lateinit var m3Btn : Button
    lateinit var m4Btn : Button




    lateinit var heroArmorSlot : ImageView
    lateinit var heroHelmetSlot : ImageView
    lateinit var heroBeltSlot : ImageView
    lateinit var heroShoesSlot : ImageView
    lateinit var heroRobeSlot : ImageView
    lateinit var heroShieldSlot : ImageView
    lateinit var heroGloveSlot : ImageView
    lateinit var heroWeaponSlot : ImageView
    lateinit var heroRingSlot1 : ImageView
    lateinit var heroRingSlot2 : ImageView
    lateinit var heroAmuletSlot : ImageView

    lateinit var inventorySlot1 : ImageView
    lateinit var inventorySlot2 : ImageView
    lateinit var inventorySlot3 : ImageView
    lateinit var inventorySlot4 : ImageView
    lateinit var inventorySlot5 : ImageView


    lateinit var armorTxt : TextView
    lateinit var vitalityTxt : TextView
    lateinit var speedTxt : TextView
    lateinit var strenghtTxt : TextView
    lateinit var manaTxt : TextView
    lateinit var priceTxt : TextView
    lateinit var nameTxt : TextView


    lateinit var equipButton : Button
    lateinit var removeButton : Button
    lateinit var heroBtn : Button




    lateinit var listOfAllAmulets : ArrayList<armorClass>
    lateinit var listOfAllRings : ArrayList<armorClass>
    lateinit var listOfAllArmors : ArrayList<armorClass>
    lateinit var listOfAllWeapons : ArrayList<weaponClass>
    lateinit var listOfRingItems : ArrayList<armorClass>
    lateinit var listOfAmuletItems : ArrayList<armorClass>
    lateinit var listOfArmorItems : ArrayList<armorClass>
    lateinit var listOfWeaponItems : ArrayList<weaponClass>



    lateinit var auth : FirebaseAuth
    lateinit var database : FirebaseFirestore
    lateinit var savedDataOfUser : heroDataClass
    lateinit var savedShopData : shopItemsClass



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_view)




        heroArmorSlot = findViewById(R.id.heroArmorSlot)
        heroHelmetSlot = findViewById(R.id.heroHelmetSlot)
        heroBeltSlot = findViewById(R.id.heroBeltSlot)
        heroShoesSlot = findViewById(R.id.heroShoesSlot)
        heroRobeSlot = findViewById(R.id.heroRobeSlot)
        heroShieldSlot = findViewById(R.id.heroShieldSlot)
        heroGloveSlot = findViewById(R.id.heroesGloveSlot)
        heroWeaponSlot = findViewById(R.id.heroWeaponSlot)
        heroRingSlot1 = findViewById(R.id.heroRingSlot1)
        heroRingSlot2 = findViewById(R.id.heroRingSlot2)
        heroAmuletSlot = findViewById(R.id.heroAmuletSlot)

        inventorySlot1 = findViewById(R.id.inventorySlot1)
        inventorySlot2 = findViewById(R.id.inventorySlot2)
        inventorySlot3 = findViewById(R.id.inventorySlot3)
        inventorySlot4 = findViewById(R.id.inventorySlot4)
        inventorySlot5 = findViewById(R.id.inventorySlot5)


        heroArmorSlot = findViewById(R.id.heroArmorSlot)
        heroHelmetSlot = findViewById(R.id.heroHelmetSlot)
        heroBeltSlot = findViewById(R.id.heroBeltSlot)
        heroShoesSlot = findViewById(R.id.heroShoesSlot)
        heroRobeSlot = findViewById(R.id.heroRobeSlot)
        heroShieldSlot = findViewById(R.id.heroShieldSlot)
        heroGloveSlot = findViewById(R.id.heroesGloveSlot)
        heroWeaponSlot = findViewById(R.id.heroWeaponSlot)
        heroRingSlot1 = findViewById(R.id.heroRingSlot1)
        heroRingSlot2 = findViewById(R.id.heroRingSlot2)
        heroAmuletSlot = findViewById(R.id.heroAmuletSlot)



        m1Btn = findViewById(R.id.m1Btn)
        m2Btn = findViewById(R.id.m2Btn)
        m3Btn = findViewById(R.id.m3Btn)
        m4Btn = findViewById(R.id.m4Btn)

        armorTxt = findViewById(R.id.armorTxt)
        vitalityTxt = findViewById(R.id.vitalityTxt)
        speedTxt = findViewById(R.id.speedTxt)
        strenghtTxt = findViewById(R.id.strenghtTxt)
        manaTxt = findViewById(R.id.manaTxt)
        priceTxt = findViewById(R.id.priceTxt)
        nameTxt = findViewById(R.id.nameTxt)

        equipButton = findViewById(R.id.equipButton)
        removeButton = findViewById(R.id.removeButton)
        heroBtn = findViewById(R.id.heroBtn)



        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser



        listOfRingItems = arrayListOf()
        listOfAmuletItems = arrayListOf()
        listOfAllAmulets = arrayListOf()
        listOfAllRings = arrayListOf()
        listOfAllArmors = arrayListOf()
        listOfAllWeapons = arrayListOf()
        listOfArmorItems = arrayListOf()
        listOfWeaponItems = arrayListOf()



        removeButton.isEnabled = false
        equipButton.isEnabled = false


        val sharedCh = getSharedPreferences("Ch", AppCompatActivity.MODE_PRIVATE)
        var Ch = sharedCh.getInt("Ch", 1)




        listAllItems()


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



                                showHeroItems()   // always update the view ifs when new items are added in game
                                showHeroInventory()  // always update the view ifs when new items are added in game



                        }
                    }
                }
        }


        var ChSelector = Ch - 1
        ChS = Ch - 1


        if (user != null) {

            database.collection("users").document(user.uid).collection("userData").
            document("Mercenaries Data").collection("mercenary$ChSelector")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedDataOfUser = document.toObject()!!

                            if (Ch >= 2) {

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







                                showMercenaryItems()   // always update the view ifs when new items are added in game
                                showHeroInventory()  // always update the view ifs when new items are added in game
                            }


                        }
                    }
                }
        }







        heroBtn.setOnClickListener {
            Ch = 1

            val editCh = sharedCh.edit()
            editCh.putInt("Ch", Ch)
            editCh.commit()

            val intent = Intent(this, heroViewActivity :: class.java)
            startActivity(intent)
        }






        m1Btn.setOnClickListener {
            Ch = 2

            val editCh = sharedCh.edit()
            editCh.putInt("Ch", Ch)
            editCh.commit()

            val intent = Intent(this, heroViewActivity :: class.java)
            startActivity(intent)
        }


        m2Btn.setOnClickListener {
            Ch = 3

            val editCh = sharedCh.edit()
            editCh.putInt("Ch", Ch)
            editCh.commit()

            val intent = Intent(this, heroViewActivity :: class.java)
            startActivity(intent)
        }


        m3Btn.setOnClickListener {
            Ch = 4

            val editCh = sharedCh.edit()
            editCh.putInt("Ch", Ch)
            editCh.commit()

            val intent = Intent(this, heroViewActivity :: class.java)
            startActivity(intent)
        }


        m4Btn.setOnClickListener {
            Ch = 5

            val editCh = sharedCh.edit()
            editCh.putInt("Ch", Ch)
            editCh.commit()

            val intent = Intent(this, heroViewActivity :: class.java)
            startActivity(intent)
        }




        removeButton.setOnClickListener {

            if (Ch == 1) {
                moveToIn()    // no updates
                save()    // no updates
            } else if (Ch >= 2) {
                moveMinv()    // no updates
                saveM()     // no updates
                save()
            }


            removeButton.isEnabled = false


        }



        equipButton.setOnClickListener {

            if (Ch == 1) {
                equip()  // no updates
                save() // no updates
            } else if (Ch >= 2) {
                equipM()
                saveM()
                save()
            }



        }



        // logic needed for showing the mercenaries item attributes

        heroArmorSlot.setOnClickListener {
            nameTxt.text = "${heroArmorSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroArmorSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroArmorSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroArmorSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroArmorSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroArmorSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroArmorSlotAtributes.price/2}"

            selectedSlotInShopView = 1

            selectedItemInShopPrice = heroArmorSlotAtributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }

        heroRobeSlot.setOnClickListener {
            nameTxt.text = "${heroRobeSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroRobeSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroRobeSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroRobeSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroRobeSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroRobeSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroRobeSlotAtributes.price/2}"

            selectedSlotInShopView = 2

            selectedItemInShopPrice = heroRobeSlotAtributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }

        heroGloveSlot.setOnClickListener {
            nameTxt.text = "${heroGloveSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroGloveSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroGloveSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroGloveSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroGloveSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroGloveSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroGloveSlotAtributes.price/2}"

            selectedSlotInShopView = 3

            selectedItemInShopPrice = heroGloveSlotAtributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }

        heroShoesSlot.setOnClickListener {
            nameTxt.text = "${heroShoesSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroShoesSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroShoesSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroShoesSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroShoesSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroShoesSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroShoesSlotAtributes.price/2}"

            selectedSlotInShopView = 4

            selectedItemInShopPrice = heroShoesSlotAtributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }

        heroShieldSlot.setOnClickListener {
            nameTxt.text = "${heroShieldSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroShieldSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroShieldSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroShieldSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroShieldSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroShieldSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroShieldSlotAtributes.price/2}"

            selectedSlotInShopView = 5

            selectedItemInShopPrice = heroShieldSlotAtributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }

        heroBeltSlot.setOnClickListener {
            nameTxt.text = "${heroBeltSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroBeltSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroBeltSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroBeltSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroBeltSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroBeltSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroBeltSlotAtributes.price/2}"

            selectedSlotInShopView = 6

            selectedItemInShopPrice = heroBeltSlotAtributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }

        heroHelmetSlot.setOnClickListener {
            nameTxt.text = "${heroHelmetSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroHelmetSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroHelmetSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroHelmetSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroHelmetSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroHelmetSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroHelmetSlotAtributes.price/2}"

            selectedSlotInShopView = 7

            selectedItemInShopPrice = heroHelmetSlotAtributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }

        heroWeaponSlot.setOnClickListener {
            nameTxt.text = "${heroWeaponSlotAtributes.weaponName}"
            armorTxt.text = "Damage: ${heroWeaponSlotAtributes.damage}"
            vitalityTxt.text = "Vitality: ${heroWeaponSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroWeaponSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroWeaponSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroWeaponSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroWeaponSlotAtributes.price/2}"

            selectedSlotInShopView = 8

            selectedItemInShopPrice = heroWeaponSlotAtributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }


        heroRingSlot1.setOnClickListener {


            nameTxt.text = "${heroRingSlot1Attributes.armorName}"
            armorTxt.text = "Armor: ${heroRingSlot1Attributes.armor}"
            vitalityTxt.text = "Vitality: ${heroRingSlot1Attributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroRingSlot1Attributes.strenght}"
            speedTxt.text = "Speed: ${heroRingSlot1Attributes.speed}"
            manaTxt.text = "Mana: ${heroRingSlot1Attributes.mana}"
            priceTxt.text = "Price: ${heroRingSlot1Attributes.price/2}"

            selectedSlotInShopView = 9

            selectedItemInShopPrice = heroRingSlot1Attributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }



        heroRingSlot2.setOnClickListener {

            nameTxt.text = "${heroRingSlot2Attributes.armorName}"
            armorTxt.text = "Armor: ${heroRingSlot2Attributes.armor}"
            vitalityTxt.text = "Vitality: ${heroRingSlot2Attributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroRingSlot2Attributes.strenght}"
            speedTxt.text = "Speed: ${heroRingSlot2Attributes.speed}"
            manaTxt.text = "Mana: ${heroRingSlot2Attributes.mana}"
            priceTxt.text = "Price: ${heroRingSlot2Attributes.price/2}"

            selectedSlotInShopView = 10

            selectedItemInShopPrice = heroRingSlot2Attributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }



        heroAmuletSlot.setOnClickListener {

            nameTxt.text = "${heroAmuletSlotAttributes.armorName}"
            armorTxt.text = "Armor: ${heroAmuletSlotAttributes.armor}"
            vitalityTxt.text = "Vitality: ${heroAmuletSlotAttributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroAmuletSlotAttributes.strenght}"
            speedTxt.text = "Speed: ${heroAmuletSlotAttributes.speed}"
            manaTxt.text = "Mana: ${heroAmuletSlotAttributes.mana}"
            priceTxt.text = "Price: ${heroAmuletSlotAttributes.price/2}"

            selectedSlotInShopView = 11

            selectedItemInShopPrice = heroAmuletSlotAttributes.price

            removeButton.isEnabled = true
            equipButton.isEnabled = false

        }



        inventorySlot1.setOnClickListener {
            nameTxt.text = "${inventoryAtributesSlot1.armorName}"
            armorTxt.text = "Armor: ${inventoryAtributesSlot1.armor}"
            vitalityTxt.text = "Vitality: ${inventoryAtributesSlot1.vitality}"
            strenghtTxt.text = "Strenght: ${inventoryAtributesSlot1.strenght}"
            speedTxt.text = "Speed: ${inventoryAtributesSlot1.speed}"
            manaTxt.text = "Mana: ${inventoryAtributesSlot1.mana}"
            var shopedItemPrice = inventoryAtributesSlot1.price/2
            priceTxt.text = "Price: $shopedItemPrice"

            selectedSlotInShopView = 12

            selectedItemInShopPrice = inventoryAtributesSlot1.price


            equipButton.isEnabled = true


        }

        inventorySlot2.setOnClickListener {
            nameTxt.text = "${inventoryAtributesSlot2.armorName}"
            armorTxt.text = "Armor: ${inventoryAtributesSlot2.armor}"
            vitalityTxt.text = "Vitality: ${inventoryAtributesSlot2.vitality}"
            strenghtTxt.text = "Strenght: ${inventoryAtributesSlot2.strenght}"
            speedTxt.text = "Speed: ${inventoryAtributesSlot2.speed}"
            manaTxt.text = "Mana: ${inventoryAtributesSlot2.mana}"
            var shopedItemPrice = inventoryAtributesSlot2.price/2
            priceTxt.text = "Price: ${shopedItemPrice}"

            selectedSlotInShopView = 13

            selectedItemInShopPrice = inventoryAtributesSlot2.price


            equipButton.isEnabled = true


        }

        inventorySlot3.setOnClickListener {
            nameTxt.text = "${inventoryAtributesSlot3.armorName}"
            armorTxt.text = "Armor: ${inventoryAtributesSlot3.armor}"
            vitalityTxt.text = "Vitality: ${inventoryAtributesSlot3.vitality}"
            strenghtTxt.text = "Strenght: ${inventoryAtributesSlot3.strenght}"
            speedTxt.text = "Speed: ${inventoryAtributesSlot3.speed}"
            manaTxt.text = "Mana: ${inventoryAtributesSlot3.mana}"
            var shopedItemPrice = inventoryAtributesSlot3.price/2
            priceTxt.text = "Price: $shopedItemPrice"

            selectedSlotInShopView = 14

            selectedItemInShopPrice = inventoryAtributesSlot3.price


            equipButton.isEnabled = true


        }

        inventorySlot4.setOnClickListener {
            nameTxt.text = "${inventoryAtributesSlot4.armorName}"
            armorTxt.text = "Armor: ${inventoryAtributesSlot4.armor}"
            vitalityTxt.text = "Vitality: ${inventoryAtributesSlot4.vitality}"
            strenghtTxt.text = "Strenght: ${inventoryAtributesSlot4.strenght}"
            speedTxt.text = "Speed: ${inventoryAtributesSlot4.speed}"
            manaTxt.text = "Mana: ${inventoryAtributesSlot4.mana}"
            var shopedItemPrice = inventoryAtributesSlot4.price/2
            priceTxt.text = "Price: $shopedItemPrice"

            selectedSlotInShopView = 15

            selectedItemInShopPrice = inventoryAtributesSlot4.price

            equipButton.isEnabled = true

        }



        inventorySlot5.setOnClickListener {
            nameTxt.text = "${inventoryAtributesSlot5.armorName}"
            armorTxt.text = "Armor: ${inventoryAtributesSlot5.armor}"
            vitalityTxt.text = "Vitality: ${inventoryAtributesSlot5.vitality}"
            strenghtTxt.text = "Strenght: ${inventoryAtributesSlot5.strenght}"
            speedTxt.text = "Speed: ${inventoryAtributesSlot5.speed}"
            manaTxt.text = "Mana: ${inventoryAtributesSlot5.mana}"
            var shopedItemPrice = inventoryAtributesSlot5.price/2
            priceTxt.text = "Price: $shopedItemPrice"

            selectedSlotInShopView = 16

            selectedItemInShopPrice = inventoryAtributesSlot5.price

            equipButton.isEnabled = true

        }












    }




    fun saveM() {

        auth = Firebase.auth
        val user = auth.currentUser



        showMercenaryItems()
        showHeroInventory()



        var totalArmor = (heroArmorSlotAtributesm.armor + heroRobeSlotAtributesm.armor + heroGloveSlotAtributesm.armor +
                heroShoesSlotAtributesm.armor + heroHelmetSlotAtributesm.armor + heroBeltSlotAtributesm.armor +
                heroShieldSlotAtributesm.armor).toDouble()

        var itemsVitality = heroArmorSlotAtributesm.vitality.toDouble() + heroRobeSlotAtributesm.vitality.toDouble() +
                heroGloveSlotAtributesm.vitality.toDouble() + heroShoesSlotAtributesm.vitality.toDouble() +
                heroShieldSlotAtributesm.vitality.toDouble() + heroBeltSlotAtributesm.vitality.toDouble() +
                heroHelmetSlotAtributesm.vitality.toDouble() + heroWeaponSlotAtributesm.vitality.toDouble() +
                heroRingSlot1Attributesm.vitality.toDouble() + heroRingSlot2Attributesm.vitality.toDouble() +
                heroAmuletSlotAttributesm.vitality.toDouble()


        var itemsStrenght = heroArmorSlotAtributesm.strenght.toDouble() + heroRobeSlotAtributesm.strenght.toDouble() +
                heroGloveSlotAtributesm.strenght.toDouble() + heroShoesSlotAtributesm.strenght.toDouble() +
                heroShieldSlotAtributesm.strenght.toDouble() + heroBeltSlotAtributesm.strenght.toDouble() +
                heroHelmetSlotAtributesm.strenght.toDouble() + heroWeaponSlotAtributesm.strenght.toDouble() +
                heroRingSlot1Attributesm.strenght.toDouble() + heroRingSlot2Attributesm.strenght.toDouble() +
                heroAmuletSlotAttributesm.strenght.toDouble()


        var itemsMana = heroArmorSlotAtributesm.mana.toDouble() + heroRobeSlotAtributesm.mana.toDouble() +
                heroGloveSlotAtributesm.mana.toDouble() + heroShoesSlotAtributesm.mana.toDouble() +
                heroShieldSlotAtributesm.mana.toDouble() + heroBeltSlotAtributesm.mana.toDouble() +
                heroHelmetSlotAtributesm.mana.toDouble() + heroWeaponSlotAtributesm.mana.toDouble() +
                heroRingSlot1Attributesm.mana.toDouble() + heroRingSlot2Attributesm.mana.toDouble() +
                heroAmuletSlotAttributesm.mana.toDouble()


        var itemsSpeed = heroArmorSlotAtributesm.speed.toDouble() + heroRobeSlotAtributesm.speed.toDouble() +
                heroGloveSlotAtributesm.speed.toDouble() + heroShoesSlotAtributesm.speed.toDouble() +
                heroShieldSlotAtributesm.speed.toDouble() + heroBeltSlotAtributesm.speed.toDouble() +
                heroHelmetSlotAtributesm.speed.toDouble() + heroWeaponSlotAtributesm.speed.toDouble() +
                heroRingSlot1Attributesm.speed.toDouble() + heroRingSlot2Attributesm.speed.toDouble() +
                heroAmuletSlotAttributesm.speed.toDouble()



        var itemDamage = heroWeaponSlotAtributesm.damage.toDouble()



        var heroData = mercenary(heroArmorId = savedMArmor,
            heroRobeId = savedMRobe, heroGloveId = savedMGloves, heroShoesId = savedMShoes,
            heroShieldId = savedMShield, heroBeltId = savedMBelt,
            heroHelmetId = savedMHelmet, heroWeaponId = savedMWeapon, heroRingId1 = savedMRing1,
            heroRingId2 = savedMRing2, heroAmuletId = savedMAmulet, heroTotalArmor = totalArmor,
        heroMana = savedMMana, heroSpeed = savedMSpeed, heroStrenght = savedMStrenght, heroVitality = savedMVitality,
            heroCurrentHp = savedMHp, heroName = "", itemWeaponDamage = itemDamage, itemsAddedSpeed = itemsSpeed,
            itemsAddedStrenght = itemsStrenght, itemsAddedVitality = itemsVitality, critical = critical)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Mercenaries Data").collection("mercenary$ChS").document("Data").set(heroData)


                .addOnCompleteListener {


                }
        }



    }





    fun save() {


        showHeroItems()
        showHeroInventory()


        var totalArmor = (heroArmorSlotAtributes.armor + heroRobeSlotAtributes.armor + heroGloveSlotAtributes.armor +
                heroShoesSlotAtributes.armor + heroHelmetSlotAtributes.armor + heroBeltSlotAtributes.armor +
                heroShieldSlotAtributes.armor).toDouble()



        auth = Firebase.auth
        val user = auth.currentUser

        var heroData = heroDataClass(heroIconId = savedHeroImage, heroLevel = savedHeroLevel, heroExperience = 1, heroArmorId = savedHeroArmor,
            heroRobeId = savedHeroRobe, heroGloveId = savedHeroGloves, heroShoesId = savedHeroShoes,
            heroShieldId = savedHeroShield, heroBeltId = savedHeroBelt,
            heroHelmetId = savedHeroHelmet, heroWeaponId = savedHeroWeapon,
            heroInventorySlot1 = savedHeroInventorySlot1, heroInventorySlot2 = savedHeroInventorySlot2,
            heroInventorySlot3 = savedHeroInventorySlot3, heroInventorySlot4 = savedHeroInventorySlot4,
            heroInventorySlot5 = savedHeroInventorySlot5, heroGold = savedHeroGold, heroRingId1 = savedHeroRing1,
            heroRingId2 = savedHeroRing2, heroAmuletId = savedHeroAmulet, heroTotalArmor = totalArmor)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Hero").set(heroData)


                .addOnCompleteListener {


                }
        }



    }






    fun showHeroInventory() {

        // snapshot saved items that hero has in inventory




        var savedItemInventorySlot1 = savedHeroInventorySlot1
        var savedItemInventorySlot2 = savedHeroInventorySlot2
        var savedItemInventorySlot3 = savedHeroInventorySlot3
        var savedItemInventorySlot4 = savedHeroInventorySlot4
        var savedItemInventorySlot5 = savedHeroInventorySlot5


        var itemForSlot = 0

        var loopStopper = 0

        while (loopStopper < 5) {

            if (loopStopper == 0) {
                itemForSlot = savedItemInventorySlot1
            } else if (loopStopper == 1) {
                itemForSlot = savedItemInventorySlot2
            } else if (loopStopper == 2) {
                itemForSlot = savedItemInventorySlot3
            } else if (loopStopper == 3) {
                itemForSlot = savedItemInventorySlot4
            } else if (loopStopper == 4) {
                itemForSlot = savedItemInventorySlot5
            }

            for (item in listOfAllArmors) {
                if (item.itemId == itemForSlot && loopStopper == 0) {
                    inventoryAtributesSlot1 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 1) {
                    inventoryAtributesSlot2 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 2) {
                    inventoryAtributesSlot3 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 3) {
                    inventoryAtributesSlot4 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 4) {
                    inventoryAtributesSlot5 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
            }



            for (item in listOfAllRings) {

                if (item.itemId == itemForSlot && loopStopper == 0) {
                    inventoryAtributesSlot1 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 1) {
                    inventoryAtributesSlot2 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 2) {
                    inventoryAtributesSlot3 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 3) {
                    inventoryAtributesSlot4 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 4) {
                    inventoryAtributesSlot5 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }

            }


            for (item in listOfAllAmulets) {

                if (item.itemId == itemForSlot && loopStopper == 0) {
                    inventoryAtributesSlot1 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 1) {
                    inventoryAtributesSlot2 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 2) {
                    inventoryAtributesSlot3 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 3) {
                    inventoryAtributesSlot4 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 4) {
                    inventoryAtributesSlot5 = armorClass(
                        item.itemId, item.armorName, item.armor, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }

            }





            for (item in listOfAllWeapons) {
                if (item.itemId == itemForSlot && loopStopper == 0) {
                    inventoryAtributesSlot1 = armorClass(
                        item.itemId, item.weaponName, item.damage, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 1) {
                    inventoryAtributesSlot2 = armorClass(
                        item.itemId, item.weaponName, item.damage, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 2) {
                    inventoryAtributesSlot3 = armorClass(
                        item.itemId, item.weaponName, item.damage, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 3) {
                    inventoryAtributesSlot4 = armorClass(
                        item.itemId, item.weaponName, item.damage, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
                if (item.itemId == itemForSlot && loopStopper == 4) {
                    inventoryAtributesSlot5 = armorClass(
                        item.itemId, item.weaponName, item.damage, item.vitality,
                        item.speed, item.mana, item.strenght, item.price, item.typeItem
                    )
                }
            }

            loopStopper ++

        }

        if (savedItemInventorySlot1 in 1..4) {
            inventorySlot1.setImageResource(R.drawable.leatherarmor)
        } else if (savedItemInventorySlot1 in 5..6) {
            inventorySlot1.setImageResource(R.drawable.rareleatherarmor)
        } else if (savedItemInventorySlot1 in 7..10) {
            inventorySlot1.setImageResource(R.drawable.leatherrobe)
        } else if (savedItemInventorySlot1 in 11..12) {
            inventorySlot1.setImageResource(R.drawable.rareleatherrobe)
        } else if (savedItemInventorySlot1 in 13..16) {
            inventorySlot1.setImageResource(R.drawable.leathergloves)
        } else if (savedItemInventorySlot1 in 17..18) {
            inventorySlot1.setImageResource(R.drawable.rareleathergloves)
        } else if (savedItemInventorySlot1 in 19..22) {
            inventorySlot1.setImageResource(R.drawable.leathershoes)
        } else if (savedItemInventorySlot1 in 23..24) {
            inventorySlot1.setImageResource(R.drawable.rareleathershoes)
        } else if(savedItemInventorySlot1 in 25..28) {
            inventorySlot1.setImageResource(R.drawable.leathershield)
        } else if (savedItemInventorySlot1 in 29..30) {
            inventorySlot1.setImageResource(R.drawable.rareleathershield)
        } else if (savedItemInventorySlot1 in 31..34) {
            inventorySlot1.setImageResource(R.drawable.leatherbelt)
        } else if (savedItemInventorySlot1 in 35..36) {
            inventorySlot1.setImageResource(R.drawable.rareleatherbelt)
        } else if (savedItemInventorySlot1 in 37..40) {
            inventorySlot1.setImageResource(R.drawable.leatherhat)
        } else if (savedItemInventorySlot1 in 41..42) {
            inventorySlot1.setImageResource(R.drawable.rareleatherhat)
        } else if (savedItemInventorySlot1 in 43..45) {
            inventorySlot1.setImageResource(R.drawable.knife)
        } else if (savedItemInventorySlot1 in 46..47) {
            inventorySlot1.setImageResource(R.drawable.bow)
        } else if (savedItemInventorySlot1 == 48) {
            inventorySlot1.setImageResource(R.drawable.rareknife)
        } else if (savedItemInventorySlot1 == 49) {
            inventorySlot1.setImageResource(R.drawable.strongbow)
        } else if (savedItemInventorySlot1 == 50) {
            inventorySlot1.setImageResource(R.drawable.strongwarknife)
        } else if (savedItemInventorySlot1 == 51) {
            inventorySlot1.setImageResource(R.drawable.sword)
        } else if (savedItemInventorySlot1 in 52..54) {
            inventorySlot1.setImageResource(R.drawable.throwingknives)
        } else if (savedItemInventorySlot1 in 55..56) {
            inventorySlot1.setImageResource(R.drawable.warknife)
        } else if (savedItemInventorySlot1 in 57..59) {
            inventorySlot1.setImageResource(R.drawable.pinkring)
        } else if (savedItemInventorySlot1 in 60..61) {
            inventorySlot1.setImageResource(R.drawable.rarepinkring)
        } else if (savedItemInventorySlot1 in 62..64) {
            inventorySlot1.setImageResource(R.drawable.amulet)
        } else if (savedItemInventorySlot1 in 65..66) {
            inventorySlot1.setImageResource(R.drawable.rareamulet)
        }


        if (savedItemInventorySlot2 in 1..4) {
            inventorySlot2.setImageResource(R.drawable.leatherarmor)
        } else if (savedItemInventorySlot2 in 5..6) {
            inventorySlot2.setImageResource(R.drawable.rareleatherarmor)
        } else if (savedItemInventorySlot2 in 7..10) {
            inventorySlot2.setImageResource(R.drawable.leatherrobe)
        } else if (savedItemInventorySlot2 in 11..12) {
            inventorySlot2.setImageResource(R.drawable.rareleatherrobe)
        } else if (savedItemInventorySlot2 in 13..16) {
            inventorySlot2.setImageResource(R.drawable.leathergloves)
        } else if (savedItemInventorySlot2 in 17..18) {
            inventorySlot2.setImageResource(R.drawable.rareleathergloves)
        } else if (savedItemInventorySlot2 in 19..22) {
            inventorySlot2.setImageResource(R.drawable.leathershoes)
        } else if (savedItemInventorySlot2 in 23..24) {
            inventorySlot2.setImageResource(R.drawable.rareleathershoes)
        } else if(savedItemInventorySlot2 in 25..28) {
            inventorySlot2.setImageResource(R.drawable.leathershield)
        } else if (savedItemInventorySlot2 in 29..30) {
            inventorySlot2.setImageResource(R.drawable.rareleathershield)
        } else if (savedItemInventorySlot2 in 31..34) {
            inventorySlot2.setImageResource(R.drawable.leatherbelt)
        } else if (savedItemInventorySlot2 in 35..36) {
            inventorySlot2.setImageResource(R.drawable.rareleatherbelt)
        } else if (savedItemInventorySlot2 in 37..40) {
            inventorySlot2.setImageResource(R.drawable.leatherhat)
        } else if (savedItemInventorySlot2 in 41..42) {
            inventorySlot2.setImageResource(R.drawable.rareleatherhat)
        } else if (savedItemInventorySlot2 in 43..45) {
            inventorySlot2.setImageResource(R.drawable.knife)
        } else if (savedItemInventorySlot2 in 46..47) {
            inventorySlot2.setImageResource(R.drawable.bow)
        } else if (savedItemInventorySlot2 == 48) {
            inventorySlot2.setImageResource(R.drawable.rareknife)
        } else if (savedItemInventorySlot2 == 49) {
            inventorySlot2.setImageResource(R.drawable.strongbow)
        } else if (savedItemInventorySlot2 == 50) {
            inventorySlot2.setImageResource(R.drawable.strongwarknife)
        } else if (savedItemInventorySlot2 == 51) {
            inventorySlot2.setImageResource(R.drawable.sword)
        } else if (savedItemInventorySlot2 in 52..54) {
            inventorySlot2.setImageResource(R.drawable.throwingknives)
        } else if (savedItemInventorySlot2 in 55..56) {
            inventorySlot2.setImageResource(R.drawable.warknife)
        } else if (savedItemInventorySlot2 in 57..59) {
            inventorySlot2.setImageResource(R.drawable.pinkring)
        } else if (savedItemInventorySlot2 in 60..61) {
            inventorySlot2.setImageResource(R.drawable.rarepinkring)
        } else if (savedItemInventorySlot2 in 62..64) {
            inventorySlot2.setImageResource(R.drawable.amulet)
        } else if (savedItemInventorySlot2 in 65..66) {
            inventorySlot2.setImageResource(R.drawable.rareamulet)
        }

        if (savedItemInventorySlot3 in 1..4) {
            inventorySlot3.setImageResource(R.drawable.leatherarmor)
        } else if (savedItemInventorySlot3 in 5..6) {
            inventorySlot3.setImageResource(R.drawable.rareleatherarmor)
        } else if (savedItemInventorySlot3 in 7..10) {
            inventorySlot3.setImageResource(R.drawable.leatherrobe)
        } else if (savedItemInventorySlot3 in 11..12) {
            inventorySlot3.setImageResource(R.drawable.rareleatherrobe)
        } else if (savedItemInventorySlot3 in 13..16) {
            inventorySlot3.setImageResource(R.drawable.leathergloves)
        } else if (savedItemInventorySlot3 in 17..18) {
            inventorySlot3.setImageResource(R.drawable.rareleathergloves)
        } else if (savedItemInventorySlot3 in 19..22) {
            inventorySlot3.setImageResource(R.drawable.leathershoes)
        } else if (savedItemInventorySlot3 in 23..24) {
            inventorySlot3.setImageResource(R.drawable.rareleathershoes)
        } else if(savedItemInventorySlot3 in 25..28) {
            inventorySlot3.setImageResource(R.drawable.leathershield)
        } else if (savedItemInventorySlot3 in 29..30) {
            inventorySlot3.setImageResource(R.drawable.rareleathershield)
        } else if (savedItemInventorySlot3 in 31..34) {
            inventorySlot3.setImageResource(R.drawable.leatherbelt)
        } else if (savedItemInventorySlot3 in 35..36) {
            inventorySlot3.setImageResource(R.drawable.rareleatherbelt)
        } else if (savedItemInventorySlot3 in 37..40) {
            inventorySlot3.setImageResource(R.drawable.leatherhat)
        } else if (savedItemInventorySlot3 in 41..42) {
            inventorySlot3.setImageResource(R.drawable.rareleatherhat)
        } else if (savedItemInventorySlot3 in 43..45) {
            inventorySlot3.setImageResource(R.drawable.knife)
        } else if (savedItemInventorySlot3 in 46..47) {
            inventorySlot3.setImageResource(R.drawable.bow)
        } else if (savedItemInventorySlot3 == 48) {
            inventorySlot3.setImageResource(R.drawable.rareknife)
        } else if (savedItemInventorySlot3 == 49) {
            inventorySlot3.setImageResource(R.drawable.strongbow)
        } else if (savedItemInventorySlot3 == 50) {
            inventorySlot3.setImageResource(R.drawable.strongwarknife)
        } else if (savedItemInventorySlot3 == 51) {
            inventorySlot3.setImageResource(R.drawable.sword)
        } else if (savedItemInventorySlot3 in 52..54) {
            inventorySlot3.setImageResource(R.drawable.throwingknives)
        } else if (savedItemInventorySlot3 in 55..56) {
            inventorySlot3.setImageResource(R.drawable.warknife)
        } else if (savedItemInventorySlot3 in 57..59) {
            inventorySlot3.setImageResource(R.drawable.pinkring)
        } else if (savedItemInventorySlot3 in 60..61) {
            inventorySlot3.setImageResource(R.drawable.rarepinkring)
        } else if (savedItemInventorySlot3 in 62..64) {
            inventorySlot3.setImageResource(R.drawable.amulet)
        } else if (savedItemInventorySlot3 in 65..66) {
            inventorySlot3.setImageResource(R.drawable.rareamulet)
        }

        if (savedItemInventorySlot4 in 1..4) {
            inventorySlot4.setImageResource(R.drawable.leatherarmor)
        } else if (savedItemInventorySlot4 in 5..6) {
            inventorySlot4.setImageResource(R.drawable.rareleatherarmor)
        } else if (savedItemInventorySlot4 in 7..10) {
            inventorySlot4.setImageResource(R.drawable.leatherrobe)
        } else if (savedItemInventorySlot4 in 11..12) {
            inventorySlot4.setImageResource(R.drawable.rareleatherrobe)
        } else if (savedItemInventorySlot4 in 13..16) {
            inventorySlot4.setImageResource(R.drawable.leathergloves)
        } else if (savedItemInventorySlot4 in 17..18) {
            inventorySlot4.setImageResource(R.drawable.rareleathergloves)
        } else if (savedItemInventorySlot4 in 19..22) {
            inventorySlot4.setImageResource(R.drawable.leathershoes)
        } else if (savedItemInventorySlot4 in 23..24) {
            inventorySlot4.setImageResource(R.drawable.rareleathershoes)
        } else if(savedItemInventorySlot4 in 25..28) {
            inventorySlot4.setImageResource(R.drawable.leathershield)
        } else if (savedItemInventorySlot4 in 29..30) {
            inventorySlot4.setImageResource(R.drawable.rareleathershield)
        } else if (savedItemInventorySlot4 in 31..34) {
            inventorySlot4.setImageResource(R.drawable.leatherbelt)
        } else if (savedItemInventorySlot4 in 35..36) {
            inventorySlot4.setImageResource(R.drawable.rareleatherbelt)
        } else if (savedItemInventorySlot4 in 37..40) {
            inventorySlot4.setImageResource(R.drawable.leatherhat)
        } else if (savedItemInventorySlot4 in 41..42) {
            inventorySlot4.setImageResource(R.drawable.rareleatherhat)
        } else if (savedItemInventorySlot4 in 43..45) {
            inventorySlot4.setImageResource(R.drawable.knife)
        } else if (savedItemInventorySlot4 in 46..47) {
            inventorySlot4.setImageResource(R.drawable.bow)
        } else if (savedItemInventorySlot4 == 48) {
            inventorySlot4.setImageResource(R.drawable.rareknife)
        } else if (savedItemInventorySlot4 == 49) {
            inventorySlot4.setImageResource(R.drawable.strongbow)
        } else if (savedItemInventorySlot4 == 50) {
            inventorySlot4.setImageResource(R.drawable.strongwarknife)
        } else if (savedItemInventorySlot4 == 51) {
            inventorySlot4.setImageResource(R.drawable.sword)
        } else if (savedItemInventorySlot4 in 52..54) {
            inventorySlot4.setImageResource(R.drawable.throwingknives)
        } else if (savedItemInventorySlot4 in 55..56) {
            inventorySlot4.setImageResource(R.drawable.warknife)
        } else if (savedItemInventorySlot4 in 57..59) {
            inventorySlot4.setImageResource(R.drawable.pinkring)
        } else if (savedItemInventorySlot4 in 60..61) {
            inventorySlot4.setImageResource(R.drawable.rarepinkring)
        } else if (savedItemInventorySlot4 in 62..64) {
            inventorySlot4.setImageResource(R.drawable.amulet)
        } else if (savedItemInventorySlot4 in 65..66) {
            inventorySlot4.setImageResource(R.drawable.rareamulet)
        }

        if (savedItemInventorySlot5 in 1..4) {
            inventorySlot5.setImageResource(R.drawable.leatherarmor)
        } else if (savedItemInventorySlot5 in 5..6) {
            inventorySlot5.setImageResource(R.drawable.rareleatherarmor)
        } else if (savedItemInventorySlot5 in 7..10) {
            inventorySlot5.setImageResource(R.drawable.leatherrobe)
        } else if (savedItemInventorySlot5 in 11..12) {
            inventorySlot5.setImageResource(R.drawable.rareleatherrobe)
        } else if (savedItemInventorySlot5 in 13..16) {
            inventorySlot5.setImageResource(R.drawable.leathergloves)
        } else if (savedItemInventorySlot5 in 17..18) {
            inventorySlot5.setImageResource(R.drawable.rareleathergloves)
        } else if (savedItemInventorySlot5 in 19..22) {
            inventorySlot5.setImageResource(R.drawable.leathershoes)
        } else if (savedItemInventorySlot5 in 23..24) {
            inventorySlot5.setImageResource(R.drawable.rareleathershoes)
        } else if(savedItemInventorySlot5 in 25..28) {
            inventorySlot5.setImageResource(R.drawable.leathershield)
        } else if (savedItemInventorySlot5 in 29..30) {
            inventorySlot5.setImageResource(R.drawable.rareleathershield)
        } else if (savedItemInventorySlot5 in 31..34) {
            inventorySlot5.setImageResource(R.drawable.leatherbelt)
        } else if (savedItemInventorySlot5 in 35..36) {
            inventorySlot5.setImageResource(R.drawable.rareleatherbelt)
        } else if (savedItemInventorySlot5 in 37..40) {
            inventorySlot5.setImageResource(R.drawable.leatherhat)
        } else if (savedItemInventorySlot5 in 41..42) {
            inventorySlot5.setImageResource(R.drawable.rareleatherhat)
        } else if (savedItemInventorySlot5 in 43..45) {
            inventorySlot5.setImageResource(R.drawable.knife)
        } else if (savedItemInventorySlot5 in 46..47) {
            inventorySlot5.setImageResource(R.drawable.bow)
        } else if (savedItemInventorySlot5 == 48) {
            inventorySlot5.setImageResource(R.drawable.rareknife)
        } else if (savedItemInventorySlot5 == 49) {
            inventorySlot5.setImageResource(R.drawable.strongbow)
        } else if (savedItemInventorySlot5 == 50) {
            inventorySlot5.setImageResource(R.drawable.strongwarknife)
        } else if (savedItemInventorySlot5 == 51) {
            inventorySlot5.setImageResource(R.drawable.sword)
        } else if (savedItemInventorySlot5 in 52..54) {
            inventorySlot5.setImageResource(R.drawable.throwingknives)
        } else if (savedItemInventorySlot5 in 55..56) {
            inventorySlot5.setImageResource(R.drawable.warknife)
        } else if (savedItemInventorySlot5 in 57..59) {
            inventorySlot5.setImageResource(R.drawable.pinkring)
        } else if (savedItemInventorySlot5 in 60..61) {
            inventorySlot5.setImageResource(R.drawable.rarepinkring)
        } else if (savedItemInventorySlot5 in 62..64) {
            inventorySlot5.setImageResource(R.drawable.amulet)
        } else if (savedItemInventorySlot5 in 65..66) {
            inventorySlot5.setImageResource(R.drawable.rareamulet)
        }

        if (savedItemInventorySlot1 == 0) {
            inventorySlot1.setImageResource(R.drawable.foursquare)
        }

        if (savedItemInventorySlot2 == 0) {
            inventorySlot2.setImageResource(R.drawable.foursquare)
        }

        if (savedItemInventorySlot3 == 0) {
            inventorySlot3.setImageResource(R.drawable.foursquare)
        }

        if (savedItemInventorySlot4 == 0) {
            inventorySlot4.setImageResource(R.drawable.foursquare)
        }

        if (savedItemInventorySlot5 == 0) {
            inventorySlot5.setImageResource(R.drawable.foursquare)
        }






    }










    fun showHeroItems() {

        // snapshot saved items that hero is wearing




        var savedArmor = savedHeroArmor
        var savedRobe = savedHeroRobe
        var savedGloves = savedHeroGloves
        var savedShoes = savedHeroShoes
        var savedShield = savedHeroShield
        var savedBelt = savedHeroBelt
        var savedHelmet = savedHeroHelmet
        var savedRing1 = savedHeroRing1
        var savedRing2 = savedHeroRing2
        var savedAmulet = savedHeroAmulet
        var savedWeapon = savedHeroWeapon




        for (item in listOfAllArmors) {
            if (item.itemId == savedArmor) {
                heroArmorSlotAtributes = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedRobe) {
                heroRobeSlotAtributes = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedGloves) {
                heroGloveSlotAtributes = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedShoes) {
                heroShoesSlotAtributes = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedShield) {
                heroShieldSlotAtributes = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedBelt) {
                heroBeltSlotAtributes = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedHelmet) {
                heroHelmetSlotAtributes = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }

        }


        for (item in listOfAllRings) {

            if (item.itemId == savedRing1) {
                heroRingSlot1Attributes = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedRing2) {
                heroRingSlot2Attributes = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }

        }


        for (item in listOfAllAmulets) {

            if (item.itemId == savedAmulet) {
                heroAmuletSlotAttributes = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }

        }


        for (item in listOfAllWeapons) {
            if (item.itemId == savedWeapon) {
                heroWeaponSlotAtributes = weaponClass(
                    item.itemId, item.weaponName, item.damage, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
        }


        if (ChS < 1) {


            if (savedArmor in 1..4) {
                heroArmorSlot.setImageResource(R.drawable.leatherarmor)
            } else if (savedArmor in 5..6) {
                heroArmorSlot.setImageResource(R.drawable.rareleatherarmor)
            } else if (savedArmor == 0) {
                heroArmorSlot.setImageResource(R.drawable.foursquare)
            }

            if (savedRobe in 7..10) {
                heroRobeSlot.setImageResource(R.drawable.leatherrobe)
            } else if (savedRobe in 11..12) {
                heroRobeSlot.setImageResource(R.drawable.rareleatherrobe)
            } else if (savedRobe == 0) {
                heroRobeSlot.setImageResource(R.drawable.foursquare)
            }

            if (savedGloves in 13..16) {
                heroGloveSlot.setImageResource(R.drawable.leathergloves)
            } else if (savedGloves in 17..18) {
                heroGloveSlot.setImageResource(R.drawable.rareleathergloves)
            } else if (savedGloves == 0) {
                heroGloveSlot.setImageResource(R.drawable.foursquare)
            }

            if (savedShoes in 19..22) {
                heroShoesSlot.setImageResource(R.drawable.leathershoes)
            } else if (savedShoes in 23..24) {
                heroShoesSlot.setImageResource(R.drawable.rareleathershoes)
            } else if (savedShoes == 0) {
                heroShoesSlot.setImageResource(R.drawable.foursquare)
            }

            if (savedShield in 25..28) {
                heroShieldSlot.setImageResource(R.drawable.leathershield)
            } else if (savedShield in 29..30) {
                heroShieldSlot.setImageResource(R.drawable.rareleathershield)
            } else if (savedShield == 0) {
                heroShieldSlot.setImageResource(R.drawable.foursquare)
            }

            if (savedBelt in 31..34) {
                heroBeltSlot.setImageResource(R.drawable.leatherbelt)
            } else if (savedBelt in 35..36) {
                heroBeltSlot.setImageResource(R.drawable.rareleatherbelt)
            } else if (savedBelt == 0) {
                heroBeltSlot.setImageResource(R.drawable.foursquare)
            }

            if (savedHelmet in 37..40) {
                heroHelmetSlot.setImageResource(R.drawable.leatherhat)
            } else if (savedHelmet in 41..42) {
                heroHelmetSlot.setImageResource(R.drawable.rareleatherhat)
            } else if (savedHelmet == 0) {
                heroHelmetSlot.setImageResource(R.drawable.foursquare)
            }

            if (savedRing1 in 57..59) {
                heroRingSlot1.setImageResource(R.drawable.pinkring)
            } else if (savedRing1 in 60..61) {
                heroRingSlot1.setImageResource(R.drawable.rarepinkring)
            } else if (savedRing1 == 0) {
                heroRingSlot1.setImageResource(R.drawable.onesquare)
            }

            if (savedRing2 in 57..59) {
                heroRingSlot2.setImageResource(R.drawable.pinkring)
            } else if (savedRing2 in 60..61) {
                heroRingSlot2.setImageResource(R.drawable.rarepinkring)
            } else if (savedRing2 == 0) {
                heroRingSlot2.setImageResource(R.drawable.onesquare)
            }

            if (savedAmulet in 62..64) {
                heroAmuletSlot.setImageResource(R.drawable.amulet)
            } else if (savedAmulet in 65..66) {
                heroAmuletSlot.setImageResource(R.drawable.rareamulet)
            } else if (savedAmulet == 0) {
                heroAmuletSlot.setImageResource(R.drawable.onesquare)
            }


            if (savedWeapon in 43..45) {
                heroWeaponSlot.setImageResource(R.drawable.knife)
            }

            if (savedWeapon in 46..47) {
                heroWeaponSlot.setImageResource(R.drawable.bow)
            }

            if (savedWeapon == 48) {
                heroWeaponSlot.setImageResource(R.drawable.rareknife)
            }

            if (savedWeapon == 49) {
                heroWeaponSlot.setImageResource(R.drawable.strongbow)
            }

            if (savedWeapon == 50) {
                heroWeaponSlot.setImageResource(R.drawable.strongwarknife)
            }

            if (savedWeapon == 51) {
                heroWeaponSlot.setImageResource(R.drawable.sword)
            }

            if (savedWeapon in 52..54) {
                heroWeaponSlot.setImageResource(R.drawable.throwingknives)
            }

            if (savedWeapon in 55..56) {
                heroWeaponSlot.setImageResource(R.drawable.warknife)
            }

            if (savedWeapon == 0) {
                heroWeaponSlot.setImageResource(R.drawable.foursquare)
            }

        }

    }






    fun showMercenaryItems() {

        // snapshot saved items that hero is wearing




        var savedArmor = savedMArmor
        var savedRobe = savedMRobe
        var savedGloves = savedMGloves
        var savedShoes = savedMShoes
        var savedShield = savedMShield
        var savedBelt = savedMBelt
        var savedHelmet = savedMHelmet
        var savedRing1 = savedMRing1
        var savedRing2 = savedMRing2
        var savedAmulet = savedMAmulet
        var savedWeapon = savedMWeapon




        for (item in listOfAllArmors) {
            if (item.itemId == savedArmor) {
                heroArmorSlotAtributesm = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedRobe) {
                heroRobeSlotAtributesm = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedGloves) {
                heroGloveSlotAtributesm = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedShoes) {
                heroShoesSlotAtributesm = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedShield) {
                heroShieldSlotAtributesm = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedBelt) {
                heroBeltSlotAtributesm = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedHelmet) {
                heroHelmetSlotAtributesm = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }

        }


        for (item in listOfAllRings) {

            if (item.itemId == savedRing1) {
                heroRingSlot1Attributesm = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
            if (item.itemId == savedRing2) {
                heroRingSlot2Attributesm = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }

        }


        for (item in listOfAllAmulets) {

            if (item.itemId == savedAmulet) {
                heroAmuletSlotAttributesm = armorClass(item.itemId, item.armorName, item.armor, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }

        }


        for (item in listOfAllWeapons) {
            if (item.itemId == savedWeapon) {
                heroWeaponSlotAtributesm = weaponClass(
                    item.itemId, item.weaponName, item.damage, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
        }


        if (savedArmor in 1..4) {
            heroArmorSlot.setImageResource(R.drawable.leatherarmor)
        } else if (savedArmor in 5..6) {
            heroArmorSlot.setImageResource(R.drawable.rareleatherarmor)
        } else if (savedArmor == 0) {
            heroArmorSlot.setImageResource(R.drawable.foursquare)
        }

        if (savedRobe in 7..10) {
            heroRobeSlot.setImageResource(R.drawable.leatherrobe)
        } else if (savedRobe in 11..12) {
            heroRobeSlot.setImageResource(R.drawable.rareleatherrobe)
        } else if (savedRobe == 0) {
            heroRobeSlot.setImageResource(R.drawable.foursquare)
        }

        if (savedGloves in 13..16) {
            heroGloveSlot.setImageResource(R.drawable.leathergloves)
        } else if (savedGloves in 17..18) {
            heroGloveSlot.setImageResource(R.drawable.rareleathergloves)
        } else if (savedGloves == 0) {
            heroGloveSlot.setImageResource(R.drawable.foursquare)
        }

        if (savedShoes in 19..22) {
            heroShoesSlot.setImageResource(R.drawable.leathershoes)
        } else if (savedShoes in 23..24) {
            heroShoesSlot.setImageResource(R.drawable.rareleathershoes)
        } else if (savedShoes == 0) {
            heroShoesSlot.setImageResource(R.drawable.foursquare)
        }

        if (savedShield in 25..28) {
            heroShieldSlot.setImageResource(R.drawable.leathershield)
        } else if (savedShield in 29..30) {
            heroShieldSlot.setImageResource(R.drawable.rareleathershield)
        } else if (savedShield == 0) {
            heroShieldSlot.setImageResource(R.drawable.foursquare)
        }

        if (savedBelt in 31..34) {
            heroBeltSlot.setImageResource(R.drawable.leatherbelt)
        } else if (savedBelt in 35..36) {
            heroBeltSlot.setImageResource(R.drawable.rareleatherbelt)
        } else if (savedBelt == 0) {
            heroBeltSlot.setImageResource(R.drawable.foursquare)
        }

        if (savedHelmet in 37..40) {
            heroHelmetSlot.setImageResource(R.drawable.leatherhat)
        } else if (savedHelmet in 41..42) {
            heroHelmetSlot.setImageResource(R.drawable.rareleatherhat)
        } else if (savedHelmet == 0) {
            heroHelmetSlot.setImageResource(R.drawable.foursquare)
        }

        if (savedRing1 in 57..59) {
            heroRingSlot1.setImageResource(R.drawable.pinkring)
        } else if (savedRing1 in 60..61) {
            heroRingSlot1.setImageResource(R.drawable.rarepinkring)
        } else if (savedRing1 == 0) {
            heroRingSlot1.setImageResource(R.drawable.onesquare)
        }

        if (savedRing2 in 57..59) {
            heroRingSlot2.setImageResource(R.drawable.pinkring)
        } else if (savedRing2 in 60..61) {
            heroRingSlot2.setImageResource(R.drawable.rarepinkring)
        } else if (savedRing2 == 0) {
            heroRingSlot2.setImageResource(R.drawable.onesquare)
        }

        if (savedAmulet in 62..64) {
            heroAmuletSlot.setImageResource(R.drawable.amulet)
        } else if (savedAmulet in 65..66) {
            heroAmuletSlot.setImageResource(R.drawable.rareamulet)
        } else if (savedAmulet == 0) {
            heroAmuletSlot.setImageResource(R.drawable.onesquare)
        }


        if (savedWeapon in 43..45) {
            heroWeaponSlot.setImageResource(R.drawable.knife)
        }

        if (savedWeapon in 46..47) {
            heroWeaponSlot.setImageResource(R.drawable.bow)
        }

        if (savedWeapon == 48) {
            heroWeaponSlot.setImageResource(R.drawable.rareknife)
        }

        if (savedWeapon == 49) {
            heroWeaponSlot.setImageResource(R.drawable.strongbow)
        }

        if (savedWeapon == 50) {
            heroWeaponSlot.setImageResource(R.drawable.strongwarknife)
        }

        if (savedWeapon == 51) {
            heroWeaponSlot.setImageResource(R.drawable.sword)
        }

        if (savedWeapon in 52..54) {
            heroWeaponSlot.setImageResource(R.drawable.throwingknives)
        }

        if (savedWeapon in 55..56) {
            heroWeaponSlot.setImageResource(R.drawable.warknife)
        }

        if (savedWeapon == 0) {
            heroWeaponSlot.setImageResource(R.drawable.foursquare)
        }


    }








    fun equip() {

        if (selectedSlotInShopView == 12) {

            if (inventoryAtributesSlot1.typeItem == 1 && savedHeroArmor == 0) {
                savedHeroArmor = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 1 && savedHeroArmor > 0) {
                val rememberer = savedHeroArmor
                savedHeroArmor = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 2 && savedHeroRobe == 0) {
                savedHeroRobe = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 2 && savedHeroRobe > 0) {
                val rememberer = savedHeroRobe
                savedHeroRobe = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 3 && savedHeroGloves == 0) {
                savedHeroGloves = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 3 && savedHeroGloves > 0) {
                val rememberer = savedHeroGloves
                savedHeroGloves = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 4 && savedHeroShoes == 0) {
                savedHeroShoes = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 4 && savedHeroShoes > 0) {
                val rememberer = savedHeroShoes
                savedHeroShoes = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 5 && savedHeroShield == 0) {
                savedHeroShield = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 5 && savedHeroShield > 0) {
                val rememberer = savedHeroShield
                savedHeroShield = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 6 && savedHeroBelt == 0) {
                savedHeroBelt = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 6 && savedHeroBelt > 0) {
                val rememberer = savedHeroBelt
                savedHeroBelt = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 7 && savedHeroHelmet == 0) {
                savedHeroHelmet = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 7 && savedHeroHelmet > 0) {
                val rememberer = savedHeroHelmet
                savedHeroHelmet = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 8 && savedHeroWeapon == 0) {
                savedHeroWeapon = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 8 && savedHeroWeapon > 0) {
                val rememberer = savedHeroWeapon
                savedHeroWeapon = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 9 && savedHeroRing1 == 0) {
                savedHeroRing1 = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 9 && savedHeroRing1 > 0) {
                if (savedHeroRing2 == 0) {
                    savedHeroRing2 = inventoryAtributesSlot1.itemId
                    savedHeroInventorySlot1 = noIdArmor.itemId
                } else if (savedHeroRing2 > 0) {
                    val rememberer = savedHeroRing1
                    savedHeroRing1 = inventoryAtributesSlot1.itemId
                    savedHeroInventorySlot1 = rememberer
                }

            }


            if (inventoryAtributesSlot1.typeItem == 10 && savedHeroAmulet == 0) {
                savedHeroAmulet = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 10 && savedHeroAmulet > 0) {
                val rememberer = savedHeroAmulet
                savedHeroAmulet = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }







        } else if (selectedSlotInShopView == 13) {

            if (inventoryAtributesSlot2.typeItem == 1 && savedHeroArmor == 0) {
                savedHeroArmor = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 1 && savedHeroArmor > 0) {
                val rememberer = savedHeroArmor
                savedHeroArmor = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 2 && savedHeroRobe == 0) {
                savedHeroRobe = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 2 && savedHeroRobe > 0) {
                val rememberer = savedHeroRobe
                savedHeroRobe = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 3 && savedHeroGloves == 0) {
                savedHeroGloves = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 3 && savedHeroGloves > 0) {
                val rememberer = savedHeroGloves
                savedHeroGloves = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 4 && savedHeroShoes == 0) {
                savedHeroShoes = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 4 && savedHeroShoes > 0) {
                val rememberer = savedHeroShoes
                savedHeroShoes = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 5 && savedHeroShield == 0) {
                savedHeroShield = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 5 && savedHeroShield > 0) {
                val rememberer = savedHeroShield
                savedHeroShield = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 6 && savedHeroBelt == 0) {
                savedHeroBelt = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 6 && savedHeroBelt > 0) {
                val rememberer = savedHeroBelt
                savedHeroBelt = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 7 && savedHeroHelmet == 0) {
                savedHeroHelmet = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 7 && savedHeroHelmet > 0) {
                val rememberer = savedHeroHelmet
                savedHeroHelmet = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 8 && savedHeroWeapon == 0) {
                savedHeroWeapon = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 8 && savedHeroWeapon > 0) {
                val rememberer = savedHeroWeapon
                savedHeroWeapon = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }


            if (inventoryAtributesSlot2.typeItem == 9 && savedHeroRing1 == 0) {
                savedHeroRing1 = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 9 && savedHeroRing1 > 0) {
                if (savedHeroRing2 == 0) {
                    savedHeroRing2 = inventoryAtributesSlot2.itemId
                    savedHeroInventorySlot2 = noIdArmor.itemId
                } else if (savedHeroRing2 > 0) {
                    val rememberer = savedHeroRing1
                    savedHeroRing1 = inventoryAtributesSlot2.itemId
                    savedHeroInventorySlot2 = rememberer
                }

            }




            if (inventoryAtributesSlot2.typeItem == 10 && savedHeroAmulet == 0) {
                savedHeroAmulet = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 10 && savedHeroAmulet > 0) {
                val rememberer = savedHeroAmulet
                savedHeroAmulet = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }



        } else if (selectedSlotInShopView == 14) {

            if (inventoryAtributesSlot3.typeItem == 1 && savedHeroArmor == 0) {
                savedHeroArmor = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 1 && savedHeroArmor > 0) {
                val rememberer = savedHeroArmor
                savedHeroArmor = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 2 && savedHeroRobe == 0) {
                savedHeroRobe = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 2 && savedHeroRobe > 0) {
                val rememberer = savedHeroRobe
                savedHeroRobe = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
                Log.d("!!!", "This is the Id of the slots robe: $savedHeroInventorySlot3")
            }

            if (inventoryAtributesSlot3.typeItem == 3 && savedHeroGloves == 0) {
                savedHeroGloves = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 3 && savedHeroGloves > 0) {
                val rememberer = savedHeroGloves
                savedHeroGloves = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 4 && savedHeroShoes == 0) {
                savedHeroShoes = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 4 && savedHeroShoes > 0) {
                val rememberer = savedHeroShoes
                savedHeroShoes = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 5 && savedHeroShield == 0) {
                savedHeroShield = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 5 && savedHeroShield > 0) {
                val rememberer = savedHeroShield
                savedHeroShield = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 6 && savedHeroBelt == 0) {
                savedHeroBelt = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 6 && savedHeroBelt > 0) {
                val rememberer = savedHeroBelt
                savedHeroBelt = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 7 && savedHeroHelmet == 0) {
                savedHeroHelmet = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 7 && savedHeroHelmet > 0) {
                val rememberer = savedHeroHelmet
                savedHeroHelmet = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 8 && savedHeroWeapon == 0) {
                savedHeroWeapon = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 8 && savedHeroWeapon > 0) {
                val rememberer = savedHeroWeapon
                savedHeroWeapon = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }


            if (inventoryAtributesSlot3.typeItem == 9 && savedHeroRing1 == 0) {
                savedHeroRing1 = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 9 && savedHeroRing1 > 0) {
                if (savedHeroRing2 == 0) {
                    savedHeroRing2 = inventoryAtributesSlot3.itemId
                    savedHeroInventorySlot3 = noIdArmor.itemId
                } else if (savedHeroRing2 > 0) {
                    val rememberer = savedHeroRing1
                    savedHeroRing1 = inventoryAtributesSlot3.itemId
                    savedHeroInventorySlot3 = rememberer
                }

            }




            if (inventoryAtributesSlot3.typeItem == 10 && savedHeroAmulet == 0) {
                savedHeroAmulet = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 10 && savedHeroAmulet > 0) {
                val rememberer = savedHeroAmulet
                savedHeroAmulet = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }




        } else if (selectedSlotInShopView == 15) {

            if (inventoryAtributesSlot4.typeItem == 1 && savedHeroArmor == 0) {
                savedHeroArmor = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 1 && savedHeroArmor > 0) {
                val rememberer = savedHeroArmor
                savedHeroArmor = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 2 && savedHeroRobe == 0) {
                savedHeroRobe = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 2 && savedHeroRobe > 0) {
                val rememberer = savedHeroRobe
                savedHeroRobe = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 3 && savedHeroGloves == 0) {
                savedHeroGloves = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 3 && savedHeroGloves > 0) {
                val rememberer = savedHeroGloves
                savedHeroGloves = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 4 && savedHeroShoes == 0) {
                savedHeroShoes = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 4 && savedHeroShoes > 0) {
                val rememberer = savedHeroShoes
                savedHeroShoes = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 5 && savedHeroShield == 0) {
                savedHeroShield = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 5 && savedHeroShield > 0) {
                val rememberer = savedHeroShield
                savedHeroShield = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 6 && savedHeroBelt == 0) {
                savedHeroBelt = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 6 && savedHeroBelt > 0) {
                val rememberer = savedHeroBelt
                savedHeroBelt = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 7 && savedHeroHelmet == 0) {
                savedHeroHelmet = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 7 && savedHeroHelmet > 0) {
                val rememberer = savedHeroHelmet
                savedHeroHelmet = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 8 && savedHeroWeapon == 0) {
                savedHeroWeapon = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 8 && savedHeroWeapon > 0) {
                val rememberer = savedHeroWeapon
                savedHeroWeapon = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }


            if (inventoryAtributesSlot4.typeItem == 9 && savedHeroRing1 == 0) {
                savedHeroRing1 = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 9 && savedHeroRing1 > 0) {
                if (savedHeroRing2 == 0) {
                    savedHeroRing2 = inventoryAtributesSlot4.itemId
                    savedHeroInventorySlot4 = noIdArmor.itemId
                } else if (savedHeroRing2 > 0) {
                    val rememberer = savedHeroRing1
                    savedHeroRing1 = inventoryAtributesSlot4.itemId
                    savedHeroInventorySlot4 = rememberer
                }

            }



            if (inventoryAtributesSlot4.typeItem == 10 && savedHeroAmulet == 0) {
                savedHeroAmulet = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 10 && savedHeroAmulet > 0) {
                val rememberer = savedHeroAmulet
                savedHeroAmulet = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }




        } else if (selectedSlotInShopView == 16) {

            if (inventoryAtributesSlot5.typeItem == 1 && savedHeroArmor == 0) {
                savedHeroArmor = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 1 && savedHeroArmor > 0) {
                val rememberer = savedHeroArmor
                savedHeroArmor = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 2 && savedHeroRobe == 0) {
                savedHeroRobe = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 2 && savedHeroRobe > 0) {
                val rememberer = savedHeroRobe
                savedHeroRobe = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 3 && savedHeroGloves == 0) {
                savedHeroGloves = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 3 && savedHeroGloves > 0) {
                val rememberer = savedHeroGloves
                savedHeroGloves = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 4 && savedHeroShoes == 0) {
                savedHeroShoes = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 4 && savedHeroShoes > 0) {
                val rememberer = savedHeroShoes
                savedHeroShoes = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 5 && savedHeroShield == 0) {
                savedHeroShield = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 5 && savedHeroShield > 0) {
                val rememberer = savedHeroShield
                savedHeroShield = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 6 && savedHeroBelt == 0) {
                savedHeroBelt = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 6 && savedHeroBelt > 0) {
                val rememberer = savedHeroBelt
                savedHeroBelt = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 7 && savedHeroHelmet == 0) {
                savedHeroHelmet = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 7 && savedHeroHelmet > 0) {
                val rememberer = savedHeroHelmet
                savedHeroHelmet = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 8 && savedHeroWeapon == 0) {
                savedHeroWeapon = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 8 && savedHeroWeapon > 0) {
                val rememberer = savedHeroWeapon
                savedHeroWeapon = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }


            if (inventoryAtributesSlot5.typeItem == 9 && savedHeroRing1 == 0) {
                savedHeroRing1 = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 9 && savedHeroRing1 > 0) {
                if (savedHeroRing2 == 0) {
                    savedHeroRing2 = inventoryAtributesSlot5.itemId
                    savedHeroInventorySlot5 = noIdArmor.itemId
                } else if (savedHeroRing2 > 0) {
                    val rememberer = savedHeroRing1
                    savedHeroRing1 = inventoryAtributesSlot5.itemId
                    savedHeroInventorySlot5 = rememberer
                }

            }



            if (inventoryAtributesSlot5.typeItem == 10 && savedHeroAmulet == 0) {
                savedHeroAmulet = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 10 && savedHeroAmulet > 0) {
                val rememberer = savedHeroAmulet
                savedHeroAmulet = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }



        }






    }




    fun moveToIn() {



        if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
            && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
            Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
        }



        if (selectedSlotInShopView == 1) {
            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroArmor
                savedHeroArmor = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroArmor
                savedHeroArmor = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroArmor
                savedHeroArmor = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroArmor
                savedHeroArmor = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroArmor
                savedHeroArmor = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }

        } else if (selectedSlotInShopView == 2) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRobe
                savedHeroRobe = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRobe
                savedHeroRobe = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRobe
                savedHeroRobe = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRobe
                savedHeroRobe = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRobe
                savedHeroRobe = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }

        } else if (selectedSlotInShopView == 3) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroGloves
                savedHeroGloves = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroGloves
                savedHeroGloves = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroGloves
                savedHeroGloves = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroGloves
                savedHeroGloves = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroGloves
                savedHeroGloves = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 4) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroShoes
                savedHeroShoes = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroShoes
                savedHeroShoes = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroShoes
                savedHeroShoes = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroShoes
                savedHeroShoes = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroShoes
                savedHeroShoes = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 5) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroShield
                savedHeroShield = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroShield
                savedHeroShield = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroShield
                savedHeroShield = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroShield
                savedHeroShield = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroShield
                savedHeroShield = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 6) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroBelt
                savedHeroBelt = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroBelt
                savedHeroBelt = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroBelt
                savedHeroBelt = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroBelt
                savedHeroBelt = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroBelt
                savedHeroBelt = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 7) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroHelmet
                savedHeroHelmet = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroHelmet
                savedHeroHelmet = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroHelmet
                savedHeroHelmet = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroHelmet
                savedHeroHelmet = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroHelmet
                savedHeroHelmet = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 8) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroWeapon
                savedHeroWeapon = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroWeapon
                savedHeroWeapon = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroWeapon
                savedHeroWeapon = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroWeapon
                savedHeroWeapon = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroWeapon
                savedHeroWeapon = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 9) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRing1
                savedHeroRing1 = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRing1
                savedHeroRing1 = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRing1
                savedHeroRing1 = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRing1
                savedHeroRing1 = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRing1
                savedHeroRing1 = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 10) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRing2
                savedHeroRing2 = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRing2
                savedHeroRing2 = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRing2
                savedHeroRing2 = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRing2
                savedHeroRing2 = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroRing2
                savedHeroRing2 = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 11) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroAmulet
                savedHeroAmulet = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroAmulet
                savedHeroAmulet = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroAmulet
                savedHeroAmulet = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroAmulet
                savedHeroAmulet = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedHeroAmulet
                savedHeroAmulet = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        }





        isButtonLogicActive = true





    }



    fun equipM() {

        if (selectedSlotInShopView == 12) {

            if (inventoryAtributesSlot1.typeItem == 1 && savedMArmor == 0) {
                savedMArmor = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 1 && savedMArmor > 0) {
                val rememberer = savedMArmor
                savedMArmor = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 2 && savedMRobe == 0) {
                savedMRobe = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 2 && savedMRobe > 0) {
                val rememberer = savedMRobe
                savedMRobe = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 3 && savedMGloves == 0) {
                savedMGloves = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 3 && savedMGloves > 0) {
                val rememberer = savedMGloves
                savedMGloves = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 4 && savedMShoes == 0) {
                savedMShoes = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 4 && savedMShoes > 0) {
                val rememberer = savedMShoes
                savedMShoes = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 5 && savedMShield == 0) {
                savedMShield = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 5 && savedMShield > 0) {
                val rememberer = savedMShield
                savedMShield = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 6 && savedMBelt == 0) {
                savedMBelt = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 6 && savedMBelt > 0) {
                val rememberer = savedMBelt
                savedMBelt = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 7 && savedMHelmet == 0) {
                savedMHelmet = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 7 && savedMHelmet > 0) {
                val rememberer = savedMHelmet
                savedMHelmet = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 8 && savedMWeapon == 0) {
                savedMWeapon = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 8 && savedMWeapon > 0) {
                val rememberer = savedMWeapon
                savedMWeapon = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }

            if (inventoryAtributesSlot1.typeItem == 9 && savedMRing1 == 0) {
                savedMRing1 = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 9 && savedMRing1 > 0) {
                if (savedMRing2 == 0) {
                    savedMRing2 = inventoryAtributesSlot1.itemId
                    savedHeroInventorySlot1 = noIdArmor.itemId
                } else if (savedMRing2 > 0) {
                    val rememberer = savedMRing1
                    savedMRing1 = inventoryAtributesSlot1.itemId
                    savedHeroInventorySlot1 = rememberer
                }

            }


            if (inventoryAtributesSlot1.typeItem == 10 && savedMAmulet == 0) {
                savedMAmulet = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = noIdArmor.itemId
            } else if (inventoryAtributesSlot1.typeItem == 10 && savedMAmulet > 0) {
                val rememberer = savedMAmulet
                savedMAmulet = inventoryAtributesSlot1.itemId
                savedHeroInventorySlot1 = rememberer
            }







        } else if (selectedSlotInShopView == 13) {

            if (inventoryAtributesSlot2.typeItem == 1 && savedMArmor == 0) {
                savedMArmor = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 1 && savedMArmor > 0) {
                val rememberer = savedMArmor
                savedMArmor = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 2 && savedMRobe == 0) {
                savedMRobe = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 2 && savedMRobe > 0) {
                val rememberer = savedMRobe
                savedMRobe = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 3 && savedMGloves == 0) {
                savedMGloves = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 3 && savedMGloves > 0) {
                val rememberer = savedMGloves
                savedMGloves = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 4 && savedMShoes == 0) {
                savedMShoes = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 4 && savedMShoes > 0) {
                val rememberer = savedMShoes
                savedMShoes = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 5 && savedMShield == 0) {
                savedMShield = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 5 && savedMShield > 0) {
                val rememberer = savedMShield
                savedMShield = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 6 && savedMBelt == 0) {
                savedMBelt = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 6 && savedMBelt > 0) {
                val rememberer = savedMBelt
                savedMBelt = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 7 && savedMHelmet == 0) {
                savedMHelmet = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 7 && savedMHelmet > 0) {
                val rememberer = savedMHelmet
                savedMHelmet = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }

            if (inventoryAtributesSlot2.typeItem == 8 && savedMWeapon == 0) {
                savedMWeapon = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 8 && savedMWeapon > 0) {
                val rememberer = savedMWeapon
                savedMWeapon = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }


            if (inventoryAtributesSlot2.typeItem == 9 && savedMRing1 == 0) {
                savedMRing1 = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 9 && savedMRing1 > 0) {
                if (savedMRing2 == 0) {
                    savedMRing2 = inventoryAtributesSlot2.itemId
                    savedHeroInventorySlot2 = noIdArmor.itemId
                } else if (savedMRing2 > 0) {
                    val rememberer = savedMRing1
                    savedMRing1 = inventoryAtributesSlot2.itemId
                    savedHeroInventorySlot2 = rememberer
                }

            }




            if (inventoryAtributesSlot2.typeItem == 10 && savedMAmulet == 0) {
                savedMAmulet = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = noIdArmor.itemId
            } else if (inventoryAtributesSlot2.typeItem == 10 && savedMAmulet > 0) {
                val rememberer = savedMAmulet
                savedMAmulet = inventoryAtributesSlot2.itemId
                savedHeroInventorySlot2 = rememberer
            }



        } else if (selectedSlotInShopView == 14) {

            if (inventoryAtributesSlot3.typeItem == 1 && savedMArmor == 0) {
                savedMArmor = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 1 && savedMArmor > 0) {
                val rememberer = savedMArmor
                savedMArmor = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 2 && savedMRobe == 0) {
                savedMRobe = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 2 && savedMRobe > 0) {
                val rememberer = savedMRobe
                savedMRobe = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
                Log.d("!!!", "This is the Id of the slots robe: $savedHeroInventorySlot3")
            }

            if (inventoryAtributesSlot3.typeItem == 3 && savedMGloves == 0) {
                savedMGloves = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 3 && savedMGloves > 0) {
                val rememberer = savedMGloves
                savedMGloves = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 4 && savedMShoes == 0) {
                savedMShoes = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 4 && savedMShoes > 0) {
                val rememberer = savedMShoes
                savedMShoes = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 5 && savedMShield == 0) {
                savedMShield = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 5 && savedMShield > 0) {
                val rememberer = savedMShield
                savedMShield = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 6 && savedMBelt == 0) {
                savedMBelt = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 6 && savedMBelt > 0) {
                val rememberer = savedMBelt
                savedMBelt = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 7 && savedMHelmet == 0) {
                savedMHelmet = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 7 && savedMHelmet > 0) {
                val rememberer = savedMHelmet
                savedMHelmet = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }

            if (inventoryAtributesSlot3.typeItem == 8 && savedMWeapon == 0) {
                savedMWeapon = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 8 && savedMWeapon > 0) {
                val rememberer = savedMWeapon
                savedMWeapon = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }


            if (inventoryAtributesSlot3.typeItem == 9 && savedMRing1 == 0) {
                savedMRing1 = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 9 && savedMRing1 > 0) {
                if (savedMRing2 == 0) {
                    savedMRing2 = inventoryAtributesSlot3.itemId
                    savedHeroInventorySlot3 = noIdArmor.itemId
                } else if (savedMRing2 > 0) {
                    val rememberer = savedMRing1
                    savedMRing1 = inventoryAtributesSlot3.itemId
                    savedHeroInventorySlot3 = rememberer
                }

            }




            if (inventoryAtributesSlot3.typeItem == 10 && savedMAmulet == 0) {
                savedMAmulet = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = noIdArmor.itemId
            } else if (inventoryAtributesSlot3.typeItem == 10 && savedMAmulet > 0) {
                val rememberer = savedMAmulet
                savedMAmulet = inventoryAtributesSlot3.itemId
                savedHeroInventorySlot3 = rememberer
            }




        } else if (selectedSlotInShopView == 15) {

            if (inventoryAtributesSlot4.typeItem == 1 && savedMArmor == 0) {
                savedMArmor = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 1 && savedMArmor > 0) {
                val rememberer = savedMArmor
                savedMArmor = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 2 && savedMRobe == 0) {
                savedMRobe = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 2 && savedMRobe > 0) {
                val rememberer = savedMRobe
                savedMRobe = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 3 && savedMGloves == 0) {
                savedMGloves = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 3 && savedMGloves > 0) {
                val rememberer = savedMGloves
                savedMGloves = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 4 && savedMShoes == 0) {
                savedMShoes = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 4 && savedMShoes > 0) {
                val rememberer = savedMShoes
                savedMShoes = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 5 && savedMShield == 0) {
                savedMShield = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 5 && savedMShield > 0) {
                val rememberer = savedMShield
                savedMShield = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 6 && savedMBelt == 0) {
                savedMBelt = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 6 && savedMBelt > 0) {
                val rememberer = savedMBelt
                savedMBelt = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 7 && savedMHelmet == 0) {
                savedMHelmet = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 7 && savedMHelmet > 0) {
                val rememberer = savedMHelmet
                savedMHelmet = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }

            if (inventoryAtributesSlot4.typeItem == 8 && savedMWeapon == 0) {
                savedMWeapon = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 8 && savedMWeapon > 0) {
                val rememberer = savedMWeapon
                savedMWeapon = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }


            if (inventoryAtributesSlot4.typeItem == 9 && savedMRing1 == 0) {
                savedMRing1 = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 9 && savedMRing1 > 0) {
                if (savedMRing2 == 0) {
                    savedMRing2 = inventoryAtributesSlot4.itemId
                    savedHeroInventorySlot4 = noIdArmor.itemId
                } else if (savedMRing2 > 0) {
                    val rememberer = savedMRing1
                    savedMRing1 = inventoryAtributesSlot4.itemId
                    savedHeroInventorySlot4 = rememberer
                }

            }



            if (inventoryAtributesSlot4.typeItem == 10 && savedMAmulet == 0) {
                savedMAmulet = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = noIdArmor.itemId
            } else if (inventoryAtributesSlot4.typeItem == 10 && savedMAmulet > 0) {
                val rememberer = savedMAmulet
                savedMAmulet = inventoryAtributesSlot4.itemId
                savedHeroInventorySlot4 = rememberer
            }




        } else if (selectedSlotInShopView == 16) {

            if (inventoryAtributesSlot5.typeItem == 1 && savedMArmor == 0) {
                savedMArmor = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 1 && savedMArmor > 0) {
                val rememberer = savedMArmor
                savedMArmor = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 2 && savedMRobe == 0) {
                savedMRobe = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 2 && savedMRobe > 0) {
                val rememberer = savedMRobe
                savedMRobe = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 3 && savedMGloves == 0) {
                savedMGloves = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 3 && savedMGloves > 0) {
                val rememberer = savedMGloves
                savedMGloves = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 4 && savedMShoes == 0) {
                savedMShoes = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 4 && savedMShoes > 0) {
                val rememberer = savedMShoes
                savedMShoes = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 5 && savedMShield == 0) {
                savedMShield = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 5 && savedMShield > 0) {
                val rememberer = savedMShield
                savedMShield = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 6 && savedMBelt == 0) {
                savedMBelt = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 6 && savedMBelt > 0) {
                val rememberer = savedMBelt
                savedMBelt = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 7 && savedMHelmet == 0) {
                savedMHelmet = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 7 && savedMHelmet > 0) {
                val rememberer = savedMHelmet
                savedMHelmet = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }

            if (inventoryAtributesSlot5.typeItem == 8 && savedMWeapon == 0) {
                savedMWeapon = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 8 && savedMWeapon > 0) {
                val rememberer = savedMWeapon
                savedMWeapon = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }


            if (inventoryAtributesSlot5.typeItem == 9 && savedMRing1 == 0) {
                savedMRing1 = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 9 && savedMRing1 > 0) {
                if (savedMRing2 == 0) {
                    savedMRing2 = inventoryAtributesSlot5.itemId
                    savedHeroInventorySlot5 = noIdArmor.itemId
                } else if (savedMRing2 > 0) {
                    val rememberer = savedMRing1
                    savedMRing1 = inventoryAtributesSlot5.itemId
                    savedHeroInventorySlot5 = rememberer
                }

            }



            if (inventoryAtributesSlot5.typeItem == 10 && savedMAmulet == 0) {
                savedMAmulet = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = noIdArmor.itemId
            } else if (inventoryAtributesSlot5.typeItem == 10 && savedMAmulet > 0) {
                val rememberer = savedMAmulet
                savedMAmulet = inventoryAtributesSlot5.itemId
                savedHeroInventorySlot5 = rememberer
            }



        }






    }





    fun moveMinv() {



        if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
            && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
            Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
        }



        if (selectedSlotInShopView == 1) {
            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMArmor
                savedMArmor = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMArmor
                savedMArmor = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMArmor
                savedMArmor = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMArmor
                savedMArmor = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMArmor
                savedMArmor = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }

        } else if (selectedSlotInShopView == 2) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMRobe
                savedMRobe = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMRobe
                savedMRobe = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMRobe
                savedMRobe = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMRobe
                savedMRobe = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMRobe
                savedMRobe = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }

        } else if (selectedSlotInShopView == 3) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMGloves
                savedMGloves = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMGloves
                savedMGloves = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMGloves
                savedMGloves = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMGloves
                savedMGloves = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMGloves
                savedMGloves = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 4) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMShoes
                savedMShoes = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMShoes
                savedMShoes = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMShoes
                savedMShoes = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMShoes
                savedMShoes = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMShoes
                savedMShoes = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 5) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMShield
                savedMShield = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMShield
                savedMShield = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMShield
                savedMShield = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMShield
                savedMShield = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMShield
                savedMShield = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 6) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMBelt
                savedMBelt = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMBelt
                savedMBelt = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMBelt
                savedMBelt = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMBelt
                savedMBelt = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMBelt
                savedMBelt = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 7) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMHelmet
                savedMHelmet = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMHelmet
                savedMHelmet = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMHelmet
                savedMHelmet = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMHelmet
                savedMHelmet = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMHelmet
                savedMHelmet = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 8) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMWeapon
                savedMWeapon = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMWeapon
                savedMWeapon = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMWeapon
                savedMWeapon = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMWeapon
                savedMWeapon = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMWeapon
                savedMWeapon = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 9) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMRing1
                savedMRing1 = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMRing1
                savedMRing1 = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMRing1
                savedMRing1 = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMRing1
                savedMRing1 = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMRing1
                savedMRing1 = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 10) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMRing2
                savedMRing2 = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMRing2
                savedMRing2 = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMRing2
                savedMRing2 = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMRing2
                savedMRing2 = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMRing2
                savedMRing2 = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        } else if (selectedSlotInShopView == 11) {

            if (savedHeroInventorySlot1 == 0 && isButtonLogicActive) {
                var rememberer = savedMAmulet
                savedMAmulet = 0
                savedHeroInventorySlot1 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot2 == 0 && isButtonLogicActive) {
                var rememberer = savedMAmulet
                savedMAmulet = 0
                savedHeroInventorySlot2 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot3 == 0 && isButtonLogicActive) {
                var rememberer = savedMAmulet
                savedMAmulet = 0
                savedHeroInventorySlot3 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot4 == 0 && isButtonLogicActive) {
                var rememberer = savedMAmulet
                savedMAmulet = 0
                savedHeroInventorySlot4 = rememberer
                isButtonLogicActive = false
            }
            if (savedHeroInventorySlot5 == 0 && isButtonLogicActive) {
                var rememberer = savedMAmulet
                savedMAmulet = 0
                savedHeroInventorySlot5 = rememberer
                isButtonLogicActive = false
            }


        }





        isButtonLogicActive = true





    }








    fun listAllItems() {

        // All games armors are listed

        listOfAllArmors.add(noIdArmor)
        listOfAllArmors.add(leatherArmor1)
        listOfAllArmors.add(leatherArmor2)
        listOfAllArmors.add(leatherArmor3)
        listOfAllArmors.add(leatherArmor4)
        listOfAllArmors.add(rareLeatherArmor1)
        listOfAllArmors.add(rareLeatherArmor2)

        listOfAllArmors.add(leatherRobe1)
        listOfAllArmors.add(leatherRobe2)
        listOfAllArmors.add(leatherRobe3)
        listOfAllArmors.add(leatherRobe4)
        listOfAllArmors.add(rareLeatherRobe1)
        listOfAllArmors.add(rareLeatherRobe2)

        listOfAllArmors.add(leatherGloves1)
        listOfAllArmors.add(leatherGloves2)
        listOfAllArmors.add(leatherGloves3)
        listOfAllArmors.add(leatherGloves4)
        listOfAllArmors.add(rareLeatherGloves1)
        listOfAllArmors.add(rareLeatherGloves2)

        listOfAllArmors.add(leatherShoes1)
        listOfAllArmors.add(leatherShoes2)
        listOfAllArmors.add(leatherShoes3)
        listOfAllArmors.add(leatherShoes4)
        listOfAllArmors.add(rareLeatherShoes1)
        listOfAllArmors.add(rareLeatherShoes2)

        listOfAllArmors.add(leatherShield1)
        listOfAllArmors.add(leatherShield2)
        listOfAllArmors.add(leatherShield3)
        listOfAllArmors.add(leatherShield4)
        listOfAllArmors.add(rareLeatherShield1)
        listOfAllArmors.add(rareLeatherShield2)

        listOfAllArmors.add(leatherBelt1)
        listOfAllArmors.add(leatherBelt2)
        listOfAllArmors.add(leatherBelt3)
        listOfAllArmors.add(leatherBelt4)
        listOfAllArmors.add(rareLeatherBelt1)
        listOfAllArmors.add(rareLeatherBelt2)

        listOfAllArmors.add(leatherHelmet1)
        listOfAllArmors.add(leatherHelmet2)
        listOfAllArmors.add(leatherHelmet3)
        listOfAllArmors.add(leatherHelmet4)
        listOfAllArmors.add(rareLeatherHelmet1)
        listOfAllArmors.add(rareLeatherHelmet2)

        // All games weapons are listed

        listOfAllWeapons.add(noIdWeapon)
        listOfAllWeapons.add(knife1)
        listOfAllWeapons.add(knife2)
        listOfAllWeapons.add(knife3)
        listOfAllWeapons.add(rareKnife)

        listOfAllWeapons.add(bow1)
        listOfAllWeapons.add(bow2)
        listOfAllWeapons.add(strongBow)

        listOfAllWeapons.add(throwingKnifes1)
        listOfAllWeapons.add(throwingKnifes2)
        listOfAllWeapons.add(throwingKnifes3)

        listOfAllWeapons.add(sword)

        listOfAllWeapons.add(warKnife1)
        listOfAllWeapons.add(warKnife2)
        listOfAllWeapons.add(strongWarknife)

        // All game rings

        listOfAllRings.add(pinkRing1)
        listOfAllRings.add(pinkRing2)
        listOfAllRings.add(pinkRing3)
        listOfAllRings.add(rarePinkRing1)
        listOfAllRings.add(rarePinkRing2)


        // All game amulets


        listOfAllAmulets.add(amulet1)
        listOfAllAmulets.add(amulet2)
        listOfAllAmulets.add(amulet3)
        listOfAllAmulets.add(rareAmulet1)
        listOfAllAmulets.add(rareAmulet2)




    }




}