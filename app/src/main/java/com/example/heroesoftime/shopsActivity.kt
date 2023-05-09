package com.example.heroesoftime

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList

class shopsActivity : AppCompatActivity() {




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






    var selectedItem = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroArmorSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroRobeSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroGloveSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroShieldSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroShoesSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroHelmetSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroBeltSlotAtributes = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var heroWeaponSlotAtributes = weaponClass(0, "", 0, 0, 0, 0, 0, 0, 0)


    var slot1 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var slot2 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var slot3 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var slot4 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var slot5 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var slot6 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var slot7 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var slot8 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var slot9 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)



    var inventoryAtributesSlot1 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var inventoryAtributesSlot2 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var inventoryAtributesSlot3 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var inventoryAtributesSlot4 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var inventoryAtributesSlot5 = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)


    var selectedItemInShopPrice = 0
    var heroGold = 0
    var selectedSlotInShopView = 0
    var isItWeapon = false


    lateinit var armorSlot1 : ImageView
    lateinit var armorSlot2 : ImageView
    lateinit var armorSlot3 : ImageView
    lateinit var armorSlot4 : ImageView
    lateinit var armorSlot5 : ImageView
    lateinit var armorSlot6 : ImageView
    lateinit var armorSlot7 : ImageView
    lateinit var armorSlot8 : ImageView
    lateinit var armorSlot9 : ImageView

    lateinit var armorTxt : TextView
    lateinit var vitalityTxt : TextView
    lateinit var speedTxt : TextView
    lateinit var strenghtTxt : TextView
    lateinit var manaTxt : TextView
    lateinit var priceTxt : TextView
    lateinit var nameTxt : TextView

    lateinit var inventorySlot1 : ImageView
    lateinit var inventorySlot2 : ImageView
    lateinit var inventorySlot3 : ImageView
    lateinit var inventorySlot4 : ImageView
    lateinit var inventorySlot5 : ImageView

    lateinit var heroArmorSlot : ImageView
    lateinit var heroHelmetSlot : ImageView
    lateinit var heroBeltSlot : ImageView
    lateinit var heroShoesSlot : ImageView
    lateinit var heroRobeSlot : ImageView
    lateinit var heroShieldSlot : ImageView
    lateinit var heroGloveSlot : ImageView
    lateinit var heroWeaponSlot : ImageView


    lateinit var buyButton : Button
    lateinit var equipButton : Button
    lateinit var sellButton : Button



    lateinit var listOfAllArmors : ArrayList<armorClass>
    lateinit var listOfAllWeapons : ArrayList<weaponClass>
    lateinit var listOfArmorItems : ArrayList<armorClass>
    lateinit var listOfWeaponItems : ArrayList<weaponClass>



    lateinit var auth : FirebaseAuth
    lateinit var database : FirebaseFirestore
    lateinit var savedDataOfUser : heroDataClass

    var savedHeroArmor = 0
    var savedHeroRobe = 0
    var savedHeroGloves = 0
    var savedHeroShoes = 0
    var savedHeroShield = 0
    var savedHeroBelt = 0
    var savedHeroHelmet = 0
    var savedHeroWeapon = 0
    var savedHeroInventorySlot1 = 0
    var savedHeroInventorySlot2 = 0
    var savedHeroInventorySlot3 = 0
    var savedHeroInventorySlot4 = 0
    var savedHeroInventorySlot5 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)


        listOfAllArmors = arrayListOf()
        listOfAllWeapons = arrayListOf()
        listOfArmorItems = arrayListOf()
        listOfWeaponItems = arrayListOf()




        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser


        heroArmorSlot = findViewById(R.id.heroArmorSlot)
        heroHelmetSlot = findViewById(R.id.heroHelmetSlot)
        heroBeltSlot = findViewById(R.id.heroBeltSlot)
        heroShoesSlot = findViewById(R.id.heroShoesSlot)
        heroRobeSlot = findViewById(R.id.heroRobeSlot)
        heroShieldSlot = findViewById(R.id.heroShieldSlot)
        heroGloveSlot = findViewById(R.id.heroesGloveSlot)
        heroWeaponSlot = findViewById(R.id.heroWeaponSlot)

        armorSlot1 = findViewById(R.id.armorSlot1)
        armorSlot2 = findViewById(R.id.armorSlot2)
        armorSlot3 = findViewById(R.id.armorSlot3)
        armorSlot4 = findViewById(R.id.armorSlot4)
        armorSlot5 = findViewById(R.id.armorSlot5)
        armorSlot6 = findViewById(R.id.armorSlot6)
        armorSlot7 = findViewById(R.id.armorSlot7)
        armorSlot8 = findViewById(R.id.armorSlot8)
        armorSlot9 = findViewById(R.id.armorSlot9)

        inventorySlot1 = findViewById(R.id.inventorySlot1)
        inventorySlot2 = findViewById(R.id.inventorySlot2)
        inventorySlot3 = findViewById(R.id.inventorySlot3)
        inventorySlot4 = findViewById(R.id.inventorySlot4)
        inventorySlot5 = findViewById(R.id.inventorySlot5)

        armorTxt = findViewById(R.id.armorTxt)
        vitalityTxt = findViewById(R.id.vitalityTxt)
        speedTxt = findViewById(R.id.speedTxt)
        strenghtTxt = findViewById(R.id.strenghtTxt)
        manaTxt = findViewById(R.id.manaTxt)
        priceTxt = findViewById(R.id.priceTxt)
        nameTxt = findViewById(R.id.nameTxt)

        buyButton = findViewById(R.id.buyButton)
        equipButton = findViewById(R.id.equipButton)
        sellButton = findViewById(R.id.sellButton)






        if (user != null) {

            database.collection("users").document(user.uid).collection("userData")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedDataOfUser = document.toObject()!!

                            savedHeroArmor = savedDataOfUser.heroArmorId
                            savedHeroRobe = savedDataOfUser.heroRobeId
                            savedHeroGloves = savedDataOfUser.heroGloveId
                            savedHeroShoes = savedDataOfUser.heroShoesId
                            savedHeroShield = savedDataOfUser.heroShieldId
                            savedHeroBelt = savedDataOfUser.heroBeltId
                            savedHeroHelmet = savedDataOfUser.heroHelmetId
                            savedHeroWeapon = savedDataOfUser.heroWeaponId

                            savedHeroInventorySlot1 = savedDataOfUser.heroInventorySlot1
                            savedHeroInventorySlot2 = savedDataOfUser.heroInventorySlot2
                            savedHeroInventorySlot3 = savedDataOfUser.heroInventorySlot3
                            savedHeroInventorySlot4 = savedDataOfUser.heroInventorySlot4
                            savedHeroInventorySlot5 = savedDataOfUser.heroInventorySlot5


                            showHeroItems()
                            showHeroInventory()


                        }
                    }
                }
        }






        val sharedSelectorShopType = getSharedPreferences("SelectorShopType", AppCompatActivity.MODE_PRIVATE)
        var selectedShopType = sharedSelectorShopType.getInt("SelectorShopType", 0)




        if (selectedShopType == 1) {
            generateRandomArmorItems()
        } else if (selectedShopType == 2) {
            generateRandomWeaponItems()
        }


        buyButton.isEnabled = false
        equipButton.isEnabled = false
        sellButton.isEnabled = false




        buyButton.setOnClickListener {




        }

        equipButton.setOnClickListener {

            if (selectedSlotInShopView == 12) {
                /*
                if (itemTypeOfSelectedSlot == 1 && heroArmorSlot == 0) {
                // heroArmorSlot == IdSelectedItem
                } else if (itemTypeOfSelectedSlot == 1 && heroArmorSlot > 0) {
                // heroArmorSlot == IdSelectedItem
                // inventorySlot == heroArmorSlot
                }
                 */
            } else if (selectedSlotInShopView == 13) {
                // inventorySlot2 = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 14) {
                // inventorySlot3 = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 15) {
                // inventorySlot4 = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 16) {
                // inventorySlot5 = 0     snapshot will set the view of armor on xml
            }


        }


        sellButton.setOnClickListener {

            heroGold += selectedItemInShopPrice

            if (selectedSlotInShopView == 1) {
                // heroArmorId = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 2) {
                // heroRobeId = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 3) {
                // heroGloveId = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 4) {
                // heroShoesId = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 5) {
               // heroShieldId = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 6) {
                // heroBeltId = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 7) {
               // heroHelmetId = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 8) {
              // heroWeaponId = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 12) {
                // inventorySlot1 = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 13) {
              // inventorySlot2 = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 14) {
                // inventorySlot3 = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 15) {
                 // inventorySlot4 = 0     snapshot will set the view of armor on xml
            } else if (selectedSlotInShopView == 16) {
               // inventorySlot5 = 0     snapshot will set the view of armor on xml
            }

            // save in db


        }



        heroArmorSlot.setOnClickListener {
            nameTxt.text = "${heroArmorSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroArmorSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroArmorSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroArmorSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroArmorSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroArmorSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroArmorSlotAtributes.price}"

            selectedSlotInShopView = 1

            selectedItemInShopPrice = heroArmorSlotAtributes.price

            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

        }

        heroRobeSlot.setOnClickListener {
            nameTxt.text = "${heroRobeSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroRobeSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroRobeSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroRobeSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroRobeSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroRobeSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroRobeSlotAtributes.price}"

            selectedSlotInShopView = 2

            selectedItemInShopPrice = heroRobeSlotAtributes.price

            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

        }

        heroGloveSlot.setOnClickListener {
            nameTxt.text = "${heroGloveSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroGloveSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroGloveSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroGloveSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroGloveSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroGloveSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroGloveSlotAtributes.price}"

            selectedSlotInShopView = 3

            selectedItemInShopPrice = heroGloveSlotAtributes.price

            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

        }

        heroShoesSlot.setOnClickListener {
            nameTxt.text = "${heroShoesSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroShoesSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroShoesSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroShoesSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroShoesSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroShoesSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroShoesSlotAtributes.price}"

            selectedSlotInShopView = 4

            selectedItemInShopPrice = heroShoesSlotAtributes.price

            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

        }

        heroShieldSlot.setOnClickListener {
            nameTxt.text = "${heroShieldSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroShieldSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroShieldSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroShieldSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroShieldSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroShieldSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroShieldSlotAtributes.price}"

            selectedSlotInShopView = 5

            selectedItemInShopPrice = heroShieldSlotAtributes.price

            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

        }

        heroBeltSlot.setOnClickListener {
            nameTxt.text = "${heroBeltSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroBeltSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroBeltSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroBeltSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroBeltSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroBeltSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroBeltSlotAtributes.price}"

            selectedSlotInShopView = 6

            selectedItemInShopPrice = heroBeltSlotAtributes.price

            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

        }

        heroHelmetSlot.setOnClickListener {
            nameTxt.text = "${heroHelmetSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroHelmetSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroHelmetSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroHelmetSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroHelmetSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroHelmetSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroHelmetSlotAtributes.price}"

            selectedSlotInShopView = 7

            selectedItemInShopPrice = heroHelmetSlotAtributes.price

            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

        }

        heroWeaponSlot.setOnClickListener {
            nameTxt.text = "${heroWeaponSlotAtributes.weaponName}"
            armorTxt.text = "Damage: ${heroWeaponSlotAtributes.damage}"
            vitalityTxt.text = "Vitality: ${heroWeaponSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroWeaponSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroWeaponSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroWeaponSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroWeaponSlotAtributes.price}"

            selectedSlotInShopView = 8

            selectedItemInShopPrice = heroWeaponSlotAtributes.price

            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

        }




        armorSlot1.setOnClickListener {

                nameTxt.text = "${slot1.armorName}"
                armorTxt.text = "Armor: ${slot1.armor}"
                vitalityTxt.text = "Vitality: ${slot1.vitality}"
                strenghtTxt.text = "Strenght: ${slot1.strenght}"
                speedTxt.text = "Speed: ${slot1.speed}"
                manaTxt.text = "Mana: ${slot1.mana}"
                priceTxt.text = "Price: ${slot1.price}"
             if (selectedShopType == 2) {
                armorTxt.text = "Damage: ${slot1.armor}"
            }

            sellButton.isEnabled = false
            equipButton.isEnabled = false
            buyButton.isEnabled = true
        }

        armorSlot2.setOnClickListener {
            nameTxt.text = "${slot2.armorName}"
            armorTxt.text = "Armor: ${slot2.armor}"
            vitalityTxt.text = "Vitality: ${slot2.vitality}"
            strenghtTxt.text = "Strenght: ${slot2.strenght}"
            speedTxt.text = "Speed: ${slot2.speed}"
            manaTxt.text = "Mana: ${slot2.mana}"
            priceTxt.text = "Price: ${slot2.price}"
            if (selectedShopType == 2) {
                armorTxt.text = "Damage: ${slot2.armor}"
            }

            sellButton.isEnabled = false
            equipButton.isEnabled = false
            buyButton.isEnabled = true
        }

        armorSlot3.setOnClickListener {
            nameTxt.text = "${slot3.armorName}"
            armorTxt.text = "Armor: ${slot3.armor}"
            vitalityTxt.text = "Vitality: ${slot3.vitality}"
            strenghtTxt.text = "Strenght: ${slot3.strenght}"
            speedTxt.text = "Speed: ${slot3.speed}"
            manaTxt.text = "Mana: ${slot3.mana}"
            priceTxt.text = "Price: ${slot3.price}"
            if (selectedShopType == 2) {
                armorTxt.text = "Damage: ${slot3.armor}"
            }

            sellButton.isEnabled = false
            equipButton.isEnabled = false
            buyButton.isEnabled = true
        }

        armorSlot4.setOnClickListener {
            nameTxt.text = "${slot4.armorName}"
            armorTxt.text = "Armor: ${slot4.armor}"
            vitalityTxt.text = "Vitality: ${slot4.vitality}"
            strenghtTxt.text = "Strenght: ${slot4.strenght}"
            speedTxt.text = "Speed: ${slot4.speed}"
            manaTxt.text = "Mana: ${slot4.mana}"
            priceTxt.text = "Price: ${slot4.price}"
            if (selectedShopType == 2) {
                armorTxt.text = "Damage: ${slot4.armor}"
            }

            sellButton.isEnabled = false
            equipButton.isEnabled = false
            buyButton.isEnabled = true
        }

        armorSlot5.setOnClickListener {
            nameTxt.text = "${slot5.armorName}"
            armorTxt.text = "Armor: ${slot5.armor}"
            vitalityTxt.text = "Vitality: ${slot5.vitality}"
            strenghtTxt.text = "Strenght: ${slot5.strenght}"
            speedTxt.text = "Speed: ${slot5.speed}"
            manaTxt.text = "Mana: ${slot5.mana}"
            priceTxt.text = "Price: ${slot5.price}"
            if (selectedShopType == 2) {
                armorTxt.text = "Damage: ${slot5.armor}"
            }

            sellButton.isEnabled = false
            equipButton.isEnabled = false
            buyButton.isEnabled = true
        }

        armorSlot6.setOnClickListener {
            nameTxt.text = "${slot6.armorName}"
            armorTxt.text = "Armor: ${slot6.armor}"
            vitalityTxt.text = "Vitality: ${slot6.vitality}"
            strenghtTxt.text = "Strenght: ${slot6.strenght}"
            speedTxt.text = "Speed: ${slot6.speed}"
            manaTxt.text = "Mana: ${slot6.mana}"
            priceTxt.text = "Price: ${slot6.price}"
            if (selectedShopType == 2) {
                armorTxt.text = "Damage: ${slot6.armor}"
            }

            sellButton.isEnabled = false
            equipButton.isEnabled = false
            buyButton.isEnabled = true
        }

        armorSlot7.setOnClickListener {
            nameTxt.text = "${slot7.armorName}"
            armorTxt.text = "Armor: ${slot7.armor}"
            vitalityTxt.text = "Vitality: ${slot7.vitality}"
            strenghtTxt.text = "Strenght: ${slot7.strenght}"
            speedTxt.text = "Speed: ${slot7.speed}"
            manaTxt.text = "Mana: ${slot7.mana}"
            priceTxt.text = "Price: ${slot7.price}"
            if (selectedShopType == 2) {
                armorTxt.text = "Damage: ${slot7.armor}"
            }

            sellButton.isEnabled = false
            equipButton.isEnabled = false
            buyButton.isEnabled = true
        }

        armorSlot8.setOnClickListener {
            nameTxt.text = "${slot8.armorName}"
            armorTxt.text = "Armor: ${slot8.armor}"
            vitalityTxt.text = "Vitality: ${slot8.vitality}"
            strenghtTxt.text = "Strenght: ${slot8.strenght}"
            speedTxt.text = "Speed: ${slot8.speed}"
            manaTxt.text = "Mana: ${slot8.mana}"
            priceTxt.text = "Price: ${slot8.price}"
            if (selectedShopType == 2) {
                armorTxt.text = "Damage: ${slot8.armor}"
            }

            sellButton.isEnabled = false
            equipButton.isEnabled = false
            buyButton.isEnabled = true
        }

        armorSlot9.setOnClickListener {
            nameTxt.text = "${slot9.armorName}"
            armorTxt.text = "Armor: ${slot9.armor}"
            vitalityTxt.text = "Vitality: ${slot9.vitality}"
            strenghtTxt.text = "Strenght: ${slot9.strenght}"
            speedTxt.text = "Speed: ${slot9.speed}"
            manaTxt.text = "Mana: ${slot9.mana}"
            priceTxt.text = "Price: ${slot9.price}"
            if (selectedShopType == 2) {
                armorTxt.text = "Damage: ${slot9.armor}"
            }

            sellButton.isEnabled = false
            equipButton.isEnabled = false
            buyButton.isEnabled = true
        }


        inventorySlot1.setOnClickListener {
            nameTxt.text = "${inventoryAtributesSlot1.armorName}"
            armorTxt.text = "Armor: ${inventoryAtributesSlot1.armor}"
            vitalityTxt.text = "Vitality: ${inventoryAtributesSlot1.vitality}"
            strenghtTxt.text = "Strenght: ${inventoryAtributesSlot1.strenght}"
            speedTxt.text = "Speed: ${inventoryAtributesSlot1.speed}"
            manaTxt.text = "Mana: ${inventoryAtributesSlot1.mana}"
            priceTxt.text = "Price: ${inventoryAtributesSlot1.price}"

            selectedSlotInShopView = 12

            selectedItemInShopPrice = inventoryAtributesSlot1.price

            sellButton.isEnabled = true
            equipButton.isEnabled = true
            buyButton.isEnabled = false

        }

        inventorySlot2.setOnClickListener {
            nameTxt.text = "${inventoryAtributesSlot2.armorName}"
            armorTxt.text = "Armor: ${inventoryAtributesSlot2.armor}"
            vitalityTxt.text = "Vitality: ${inventoryAtributesSlot2.vitality}"
            strenghtTxt.text = "Strenght: ${inventoryAtributesSlot2.strenght}"
            speedTxt.text = "Speed: ${inventoryAtributesSlot2.speed}"
            manaTxt.text = "Mana: ${inventoryAtributesSlot2.mana}"
            priceTxt.text = "Price: ${inventoryAtributesSlot2.price}"

            selectedSlotInShopView = 13

            selectedItemInShopPrice = inventoryAtributesSlot2.price

            sellButton.isEnabled = true
            equipButton.isEnabled = true
            buyButton.isEnabled = false

        }

        inventorySlot3.setOnClickListener {
            nameTxt.text = "${inventoryAtributesSlot3.armorName}"
            armorTxt.text = "Armor: ${inventoryAtributesSlot3.armor}"
            vitalityTxt.text = "Vitality: ${inventoryAtributesSlot3.vitality}"
            strenghtTxt.text = "Strenght: ${inventoryAtributesSlot3.strenght}"
            speedTxt.text = "Speed: ${inventoryAtributesSlot3.speed}"
            manaTxt.text = "Mana: ${inventoryAtributesSlot3.mana}"
            priceTxt.text = "Price: ${inventoryAtributesSlot3.price}"

            selectedSlotInShopView = 14

            selectedItemInShopPrice = inventoryAtributesSlot3.price

            sellButton.isEnabled = true
            equipButton.isEnabled = true
            buyButton.isEnabled = false

        }

        inventorySlot4.setOnClickListener {
            nameTxt.text = "${inventoryAtributesSlot4.armorName}"
            armorTxt.text = "Armor: ${inventoryAtributesSlot4.armor}"
            vitalityTxt.text = "Vitality: ${inventoryAtributesSlot4.vitality}"
            strenghtTxt.text = "Strenght: ${inventoryAtributesSlot4.strenght}"
            speedTxt.text = "Speed: ${inventoryAtributesSlot4.speed}"
            manaTxt.text = "Mana: ${inventoryAtributesSlot4.mana}"
            priceTxt.text = "Price: ${inventoryAtributesSlot4.price}"

            selectedSlotInShopView = 15

            selectedItemInShopPrice = inventoryAtributesSlot4.price

            sellButton.isEnabled = true
            equipButton.isEnabled = true
            buyButton.isEnabled = false

        }

        inventorySlot5.setOnClickListener {
            nameTxt.text = "${inventoryAtributesSlot5.armorName}"
            armorTxt.text = "Armor: ${inventoryAtributesSlot5.armor}"
            vitalityTxt.text = "Vitality: ${inventoryAtributesSlot5.vitality}"
            strenghtTxt.text = "Strenght: ${inventoryAtributesSlot5.strenght}"
            speedTxt.text = "Speed: ${inventoryAtributesSlot5.speed}"
            manaTxt.text = "Mana: ${inventoryAtributesSlot5.mana}"
            priceTxt.text = "Price: ${inventoryAtributesSlot5.price}"

            selectedSlotInShopView = 16

            selectedItemInShopPrice = inventoryAtributesSlot5.price

            sellButton.isEnabled = true
            equipButton.isEnabled = true
            buyButton.isEnabled = false

        }






        // All games armors are listed

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





    }




    fun send() {



        auth = Firebase.auth
        val user = auth.currentUser

        var heroData = heroDataClass(heroIconId = 0, heroLevel = 1, heroExperience = 1, heroArmorId = 6, heroRobeId = 7,
        heroGloveId = 18, heroShoesId = 19, heroShieldId = 30, heroBeltId = 32, heroHelmetId = 41, heroWeaponId = 49,
        heroInventorySlot1 = 6, heroInventorySlot2 = 7, heroInventorySlot3 = 18, heroInventorySlot4 = 19,
        heroInventorySlot5 = 49)


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

        for (item in listOfAllWeapons) {
            if (item.itemId == savedWeapon) {
                heroWeaponSlotAtributes = weaponClass(
                    item.itemId, item.weaponName, item.damage, item.vitality,
                    item.speed, item.mana, item.strenght, item.price, item.typeItem)
            }
        }


        if (savedArmor in 1..4) {
            heroArmorSlot.setImageResource(R.drawable.leatherarmor)
        } else if (savedArmor in 5..6) {
            heroArmorSlot.setImageResource(R.drawable.rareleatherarmor)
        }

        if (savedRobe in 7..10) {
            heroRobeSlot.setImageResource(R.drawable.leatherrobe)
        } else if (savedRobe in 11..12) {
            heroRobeSlot.setImageResource(R.drawable.rareleatherrobe)
        }

        if (savedGloves in 13..16) {
            heroGloveSlot.setImageResource(R.drawable.leathergloves)
        } else if (savedGloves in 17..18) {
            heroGloveSlot.setImageResource(R.drawable.rareleathergloves)
        }

        if (savedShoes in 19..22) {
            heroShoesSlot.setImageResource(R.drawable.leathershoes)
        } else if (savedShoes in 23..24) {
            heroShoesSlot.setImageResource(R.drawable.rareleathershoes)
        }

        if (savedShield in 25..28) {
            heroShieldSlot.setImageResource(R.drawable.leathershield)
        } else if (savedShield in 29..30) {
            heroShieldSlot.setImageResource(R.drawable.rareleathershield)
        }

        if (savedBelt in 31..34) {
            heroBeltSlot.setImageResource(R.drawable.leatherbelt)
        } else if (savedBelt in 35..36) {
            heroBeltSlot.setImageResource(R.drawable.rareleatherbelt)
        }

        if (savedHelmet in 37..40) {
            heroHelmetSlot.setImageResource(R.drawable.leatherhat)
        } else if (savedHelmet in 41..42) {
            heroHelmetSlot.setImageResource(R.drawable.rareleatherhat)
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


    }







    fun generateRandomWeaponItems() {

        listOfWeaponItems.add(knife1)
        listOfWeaponItems.add(knife2)
        listOfWeaponItems.add(knife3)
        listOfWeaponItems.add(rareKnife)

        listOfWeaponItems.add(bow1)
        listOfWeaponItems.add(bow2)
        listOfWeaponItems.add(strongBow)

        listOfWeaponItems.add(throwingKnifes1)
        listOfWeaponItems.add(throwingKnifes2)
        listOfWeaponItems.add(throwingKnifes3)

        listOfWeaponItems.add(sword)

        listOfWeaponItems.add(warKnife1)
        listOfWeaponItems.add(warKnife2)
        listOfWeaponItems.add(strongWarknife)



        var loopStopper = 0

        while (true) {

            /*

            var random = Random(System.currentTimeMillis())
            var randomN = random.nextInt(42)
            var itemId =  listOfArmorItems[randomN].itemId


             */


            var randomN = (0..13).random()
            var itemId =  listOfWeaponItems[randomN].itemId

            var itemName = listOfWeaponItems[randomN].weaponName
            var damageItem = listOfWeaponItems[randomN].damage
            var vitalityItem = listOfWeaponItems[randomN].vitality
            var speedItem = listOfWeaponItems[randomN].speed
            var manaItem = listOfWeaponItems[randomN].mana
            var strenghtItem = listOfWeaponItems[randomN].strenght
            var priceItem = listOfWeaponItems[randomN].price
            var typeItem = listOfWeaponItems[randomN].typeItem






            if (loopStopper == 0) {

                if (itemId in 43..45) {
                    armorSlot1.setImageResource(R.drawable.knife)
                } else if (itemId in 46..47) {
                    armorSlot1.setImageResource(R.drawable.bow)
                } else if (itemId == 48) {
                    armorSlot1.setImageResource(R.drawable.rareknife)
                } else if (itemId == 49) {
                    armorSlot1.setImageResource(R.drawable.strongbow)
                } else if (itemId == 50) {
                    armorSlot1.setImageResource(R.drawable.strongwarknife)
                } else if (itemId == 51) {
                    armorSlot1.setImageResource(R.drawable.sword)
                } else if (itemId in 52..54) {
                    armorSlot1.setImageResource(R.drawable.throwingknives)
                } else if (itemId in 55..56) {
                    armorSlot1.setImageResource(R.drawable.warknife)
                }

                slot1 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 1) {
                if (itemId in 43..45) {
                    armorSlot2.setImageResource(R.drawable.knife)
                } else if (itemId in 46..47) {
                    armorSlot2.setImageResource(R.drawable.bow)
                } else if (itemId == 48) {
                    armorSlot2.setImageResource(R.drawable.rareknife)
                } else if (itemId == 49) {
                    armorSlot2.setImageResource(R.drawable.strongbow)
                } else if (itemId == 50) {
                    armorSlot2.setImageResource(R.drawable.strongwarknife)
                } else if (itemId == 51) {
                    armorSlot2.setImageResource(R.drawable.sword)
                } else if (itemId in 52..54) {
                    armorSlot2.setImageResource(R.drawable.throwingknives)
                } else if (itemId in 55..56) {
                    armorSlot2.setImageResource(R.drawable.warknife)
                }

                slot2 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 2) {
                if (itemId in 43..45) {
                    armorSlot3.setImageResource(R.drawable.knife)
                } else if (itemId in 46..47) {
                    armorSlot3.setImageResource(R.drawable.bow)
                } else if (itemId == 48) {
                    armorSlot3.setImageResource(R.drawable.rareknife)
                } else if (itemId == 49) {
                    armorSlot3.setImageResource(R.drawable.strongbow)
                } else if (itemId == 50) {
                    armorSlot3.setImageResource(R.drawable.strongwarknife)
                } else if (itemId == 51) {
                    armorSlot3.setImageResource(R.drawable.sword)
                } else if (itemId in 52..54) {
                    armorSlot3.setImageResource(R.drawable.throwingknives)
                } else if (itemId in 55..56) {
                    armorSlot3.setImageResource(R.drawable.warknife)
                }

                slot3 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 3) {
                if (itemId in 43..45) {
                    armorSlot4.setImageResource(R.drawable.knife)
                } else if (itemId in 46..47) {
                    armorSlot4.setImageResource(R.drawable.bow)
                } else if (itemId == 48) {
                    armorSlot4.setImageResource(R.drawable.rareknife)
                } else if (itemId == 49) {
                    armorSlot4.setImageResource(R.drawable.strongbow)
                } else if (itemId == 50) {
                    armorSlot4.setImageResource(R.drawable.strongwarknife)
                } else if (itemId == 51) {
                    armorSlot4.setImageResource(R.drawable.sword)
                } else if (itemId in 52..54) {
                    armorSlot4.setImageResource(R.drawable.throwingknives)
                } else if (itemId in 55..56) {
                    armorSlot4.setImageResource(R.drawable.warknife)
                }

                slot4 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 4) {
                if (itemId in 43..45) {
                    armorSlot5.setImageResource(R.drawable.knife)
                } else if (itemId in 46..47) {
                    armorSlot5.setImageResource(R.drawable.bow)
                } else if (itemId == 48) {
                    armorSlot5.setImageResource(R.drawable.rareknife)
                } else if (itemId == 49) {
                    armorSlot5.setImageResource(R.drawable.strongbow)
                } else if (itemId == 50) {
                    armorSlot5.setImageResource(R.drawable.strongwarknife)
                } else if (itemId == 51) {
                    armorSlot5.setImageResource(R.drawable.sword)
                    slot5 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 52..54) {
                    armorSlot5.setImageResource(R.drawable.throwingknives)
                } else if (itemId in 55..56) {
                    armorSlot5.setImageResource(R.drawable.warknife)
                }

                slot5 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 5) {
                if (itemId in 43..45) {
                    armorSlot6.setImageResource(R.drawable.knife)
                } else if (itemId in 46..47) {
                    armorSlot6.setImageResource(R.drawable.bow)
                } else if (itemId == 48) {
                    armorSlot6.setImageResource(R.drawable.rareknife)
                } else if (itemId == 49) {
                    armorSlot6.setImageResource(R.drawable.strongbow)
                } else if (itemId == 50) {
                    armorSlot6.setImageResource(R.drawable.strongwarknife)
                } else if (itemId == 51) {
                    armorSlot6.setImageResource(R.drawable.sword)
                } else if (itemId in 52..54) {
                    armorSlot6.setImageResource(R.drawable.throwingknives)
                } else if (itemId in 55..56) {
                    armorSlot6.setImageResource(R.drawable.warknife)
                }

                slot6 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 6) {
                if (itemId in 43..45) {
                    armorSlot7.setImageResource(R.drawable.knife)
                } else if (itemId in 46..47) {
                    armorSlot7.setImageResource(R.drawable.bow)
                } else if (itemId == 48) {
                    armorSlot7.setImageResource(R.drawable.rareknife)
                } else if (itemId == 49) {
                    armorSlot7.setImageResource(R.drawable.strongbow)
                } else if (itemId == 50) {
                    armorSlot7.setImageResource(R.drawable.strongwarknife)
                } else if (itemId == 51) {
                    armorSlot7.setImageResource(R.drawable.sword)
                } else if (itemId in 52..54) {
                    armorSlot7.setImageResource(R.drawable.throwingknives)
                } else if (itemId in 55..56) {
                    armorSlot7.setImageResource(R.drawable.warknife)
                }

                slot7 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 7) {
                if (itemId in 43..45) {
                    armorSlot8.setImageResource(R.drawable.knife)
                } else if (itemId in 46..47) {
                    armorSlot8.setImageResource(R.drawable.bow)
                } else if (itemId == 48) {
                    armorSlot8.setImageResource(R.drawable.rareknife)
                } else if (itemId == 49) {
                    armorSlot8.setImageResource(R.drawable.strongbow)
                } else if (itemId == 50) {
                    armorSlot8.setImageResource(R.drawable.strongwarknife)
                } else if (itemId == 51) {
                    armorSlot8.setImageResource(R.drawable.sword)
                } else if (itemId in 52..54) {
                    armorSlot8.setImageResource(R.drawable.throwingknives)
                } else if (itemId in 55..56) {
                    armorSlot8.setImageResource(R.drawable.warknife)
                }

                slot8 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 8) {
                if (itemId in 43..45) {
                    armorSlot9.setImageResource(R.drawable.knife)
                } else if (itemId in 46..47) {
                    armorSlot9.setImageResource(R.drawable.bow)
                } else if (itemId == 48) {
                    armorSlot9.setImageResource(R.drawable.rareknife)
                } else if (itemId == 49) {
                    armorSlot9.setImageResource(R.drawable.strongbow)
                } else if (itemId == 50) {
                    armorSlot9.setImageResource(R.drawable.strongwarknife)
                } else if (itemId == 51) {
                    armorSlot9.setImageResource(R.drawable.sword)
                } else if (itemId in 52..54) {
                    armorSlot9.setImageResource(R.drawable.throwingknives)
                } else if (itemId in 55..56) {
                    armorSlot9.setImageResource(R.drawable.warknife)
                }

                slot9 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            }


            loopStopper++

            if (loopStopper == 9) {
                break
            }

        }


    }





    fun generateRandomArmorItems() {


        listOfArmorItems.add(leatherArmor1)
        listOfArmorItems.add(leatherArmor2)
        listOfArmorItems.add(leatherArmor3)
        listOfArmorItems.add(leatherArmor4)
        listOfArmorItems.add(rareLeatherArmor1)
        listOfArmorItems.add(rareLeatherArmor2)

        listOfArmorItems.add(leatherRobe1)
        listOfArmorItems.add(leatherRobe2)
        listOfArmorItems.add(leatherRobe3)
        listOfArmorItems.add(leatherRobe4)
        listOfArmorItems.add(rareLeatherRobe1)
        listOfArmorItems.add(rareLeatherRobe2)

        listOfArmorItems.add(leatherGloves1)
        listOfArmorItems.add(leatherGloves2)
        listOfArmorItems.add(leatherGloves3)
        listOfArmorItems.add(leatherGloves4)
        listOfArmorItems.add(rareLeatherGloves1)
        listOfArmorItems.add(rareLeatherGloves2)

        listOfArmorItems.add(leatherShoes1)
        listOfArmorItems.add(leatherShoes2)
        listOfArmorItems.add(leatherShoes3)
        listOfArmorItems.add(leatherShoes4)
        listOfArmorItems.add(rareLeatherShoes1)
        listOfArmorItems.add(rareLeatherShoes2)

        listOfArmorItems.add(leatherShield1)
        listOfArmorItems.add(leatherShield2)
        listOfArmorItems.add(leatherShield3)
        listOfArmorItems.add(leatherShield4)
        listOfArmorItems.add(rareLeatherShield1)
        listOfArmorItems.add(rareLeatherShield2)

        listOfArmorItems.add(leatherBelt1)
        listOfArmorItems.add(leatherBelt2)
        listOfArmorItems.add(leatherBelt3)
        listOfArmorItems.add(leatherBelt4)
        listOfArmorItems.add(rareLeatherBelt1)
        listOfArmorItems.add(rareLeatherBelt2)

        listOfArmorItems.add(leatherHelmet1)
        listOfArmorItems.add(leatherHelmet2)
        listOfArmorItems.add(leatherHelmet3)
        listOfArmorItems.add(leatherHelmet4)
        listOfArmorItems.add(rareLeatherHelmet1)
        listOfArmorItems.add(rareLeatherHelmet2)







        var loopStopper = 0

        while (true) {

            /*

            var random = Random(System.currentTimeMillis())
            var randomN = random.nextInt(42)
            var itemId =  listOfArmorItems[randomN].itemId


             */


            var randomN = (0..41).random()
            var itemId =  listOfArmorItems[randomN].itemId

            var itemName = listOfArmorItems[randomN].armorName
            var armorItem = listOfArmorItems[randomN].armor
            var vitalityItem = listOfArmorItems[randomN].vitality
            var speedItem = listOfArmorItems[randomN].speed
            var manaItem = listOfArmorItems[randomN].mana
            var strenghtItem = listOfArmorItems[randomN].strenght
            var priceItem = listOfArmorItems[randomN].price
            var typeItem = listOfArmorItems[randomN].typeItem






            if (loopStopper == 0) {

                if (itemId in 1..4) {
                    armorSlot1.setImageResource(R.drawable.leatherarmor)
                } else if (itemId in 5..6) {
                    armorSlot1.setImageResource(R.drawable.rareleatherarmor)
                } else if (itemId in 7..10) {
                    armorSlot1.setImageResource(R.drawable.leatherrobe)
                } else if (itemId in 11..12) {
                    armorSlot1.setImageResource(R.drawable.rareleatherrobe)
                } else if (itemId in 13..16) {
                    armorSlot1.setImageResource(R.drawable.leathergloves)
                } else if (itemId in 17..18) {
                    armorSlot1.setImageResource(R.drawable.rareleathergloves)
                } else if (itemId in 19..22) {
                    armorSlot1.setImageResource(R.drawable.leathershoes)
                } else if (itemId in 23..24) {
                    armorSlot1.setImageResource(R.drawable.rareleathershoes)
                } else if (itemId in 25..28) {
                    armorSlot1.setImageResource(R.drawable.leathershield)
                } else if (itemId in 29..30) {
                    armorSlot1.setImageResource(R.drawable.rareleathershield)
                } else if (itemId in 31..34) {
                    armorSlot1.setImageResource(R.drawable.leatherbelt)
                }  else if (itemId in 35..36) {
                    armorSlot1.setImageResource(R.drawable.rareleatherbelt)
                } else if (itemId in 37..40) {
                    armorSlot1.setImageResource(R.drawable.leatherhat)
                } else if (itemId in 41..42) {
                    armorSlot1.setImageResource(R.drawable.rareleatherhat)
                }

                slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 1) {
                if (itemId in 1..4) {
                    armorSlot2.setImageResource(R.drawable.leatherarmor)
                } else if (itemId in 5..6) {
                    armorSlot2.setImageResource(R.drawable.rareleatherarmor)
                } else if (itemId in 7..10) {
                    armorSlot2.setImageResource(R.drawable.leatherrobe)
                } else if (itemId in 11..12) {
                    armorSlot2.setImageResource(R.drawable.rareleatherrobe)
                } else if (itemId in 13..16) {
                    armorSlot2.setImageResource(R.drawable.leathergloves)
                } else if (itemId in 17..18) {
                    armorSlot2.setImageResource(R.drawable.rareleathergloves)
                } else if (itemId in 19..22) {
                    armorSlot2.setImageResource(R.drawable.leathershoes)
                } else if (itemId in 23..24) {
                    armorSlot2.setImageResource(R.drawable.rareleathershoes)
                } else if (itemId in 25..28) {
                    armorSlot2.setImageResource(R.drawable.leathershield)
                } else if (itemId in 29..30) {
                    armorSlot2.setImageResource(R.drawable.rareleathershield)
                } else if (itemId in 31..34) {
                    armorSlot2.setImageResource(R.drawable.leatherbelt)
                }  else if (itemId in 35..36) {
                    armorSlot2.setImageResource(R.drawable.rareleatherbelt)
                } else if (itemId in 37..40) {
                    armorSlot2.setImageResource(R.drawable.leatherhat)
                } else if (itemId in 41..42) {
                    armorSlot2.setImageResource(R.drawable.rareleatherhat)
                }

                slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 2) {
                if (itemId in 1..4) {
                    armorSlot3.setImageResource(R.drawable.leatherarmor)
                } else if (itemId in 5..6) {
                    armorSlot3.setImageResource(R.drawable.rareleatherarmor)
                } else if (itemId in 7..10) {
                    armorSlot3.setImageResource(R.drawable.leatherrobe)
                } else if (itemId in 11..12) {
                    armorSlot3.setImageResource(R.drawable.rareleatherrobe)
                } else if (itemId in 13..16) {
                    armorSlot3.setImageResource(R.drawable.leathergloves)
                } else if (itemId in 17..18) {
                    armorSlot3.setImageResource(R.drawable.rareleathergloves)
                } else if (itemId in 19..22) {
                    armorSlot3.setImageResource(R.drawable.leathershoes)
                } else if (itemId in 23..24) {
                    armorSlot3.setImageResource(R.drawable.rareleathershoes)
                } else if (itemId in 25..28) {
                    armorSlot3.setImageResource(R.drawable.leathershield)
                } else if (itemId in 29..30) {
                    armorSlot3.setImageResource(R.drawable.rareleathershield)
                } else if (itemId in 31..34) {
                    armorSlot3.setImageResource(R.drawable.leatherbelt)
                }  else if (itemId in 35..36) {
                    armorSlot3.setImageResource(R.drawable.rareleatherbelt)
                } else if (itemId in 37..40) {
                    armorSlot3.setImageResource(R.drawable.leatherhat)
                } else if (itemId in 41..42) {
                    armorSlot3.setImageResource(R.drawable.rareleatherhat)
                }

                slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 3) {
                if (itemId in 1..4) {
                    armorSlot4.setImageResource(R.drawable.leatherarmor)
                } else if (itemId in 5..6) {
                    armorSlot4.setImageResource(R.drawable.rareleatherarmor)
                } else if (itemId in 7..10) {
                    armorSlot4.setImageResource(R.drawable.leatherrobe)
                } else if (itemId in 11..12) {
                    armorSlot4.setImageResource(R.drawable.rareleatherrobe)
                } else if (itemId in 13..16) {
                    armorSlot4.setImageResource(R.drawable.leathergloves)
                } else if (itemId in 17..18) {
                    armorSlot4.setImageResource(R.drawable.rareleathergloves)
                } else if (itemId in 19..22) {
                    armorSlot4.setImageResource(R.drawable.leathershoes)
                } else if (itemId in 23..24) {
                    armorSlot4.setImageResource(R.drawable.rareleathershoes)
                } else if (itemId in 25..28) {
                    armorSlot4.setImageResource(R.drawable.leathershield)
                } else if (itemId in 29..30) {
                    armorSlot4.setImageResource(R.drawable.rareleathershield)
                } else if (itemId in 31..34) {
                    armorSlot4.setImageResource(R.drawable.leatherbelt)
                }  else if (itemId in 35..36) {
                    armorSlot4.setImageResource(R.drawable.rareleatherbelt)
                } else if (itemId in 37..40) {
                    armorSlot4.setImageResource(R.drawable.leatherhat)
                } else if (itemId in 41..42) {
                    armorSlot4.setImageResource(R.drawable.rareleatherhat)
                }

                slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 4) {
                if (itemId in 1..4) {
                    armorSlot5.setImageResource(R.drawable.leatherarmor)
                } else if (itemId in 5..6) {
                    armorSlot5.setImageResource(R.drawable.rareleatherarmor)
                } else if (itemId in 7..10) {
                    armorSlot5.setImageResource(R.drawable.leatherrobe)
                } else if (itemId in 11..12) {
                    armorSlot5.setImageResource(R.drawable.rareleatherrobe)
                } else if (itemId in 13..16) {
                    armorSlot5.setImageResource(R.drawable.leathergloves)
                } else if (itemId in 17..18) {
                    armorSlot5.setImageResource(R.drawable.rareleathergloves)
                } else if (itemId in 19..22) {
                    armorSlot5.setImageResource(R.drawable.leathershoes)
                } else if (itemId in 23..24) {
                    armorSlot5.setImageResource(R.drawable.rareleathershoes)
                } else if (itemId in 25..28) {
                    armorSlot5.setImageResource(R.drawable.leathershield)
                } else if (itemId in 29..30) {
                    armorSlot5.setImageResource(R.drawable.rareleathershield)
                } else if (itemId in 31..34) {
                    armorSlot5.setImageResource(R.drawable.leatherbelt)
                }  else if (itemId in 35..36) {
                    armorSlot5.setImageResource(R.drawable.rareleatherbelt)
                } else if (itemId in 37..40) {
                    armorSlot5.setImageResource(R.drawable.leatherhat)
                } else if (itemId in 41..42) {
                    armorSlot5.setImageResource(R.drawable.rareleatherhat)
                }

                slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 5) {
                if (itemId in 1..4) {
                    armorSlot6.setImageResource(R.drawable.leatherarmor)
                } else if (itemId in 5..6) {
                    armorSlot6.setImageResource(R.drawable.rareleatherarmor)
                } else if (itemId in 7..10) {
                    armorSlot6.setImageResource(R.drawable.leatherrobe)
                } else if (itemId in 11..12) {
                    armorSlot6.setImageResource(R.drawable.rareleatherrobe)
                } else if (itemId in 13..16) {
                    armorSlot6.setImageResource(R.drawable.leathergloves)
                } else if (itemId in 17..18) {
                    armorSlot6.setImageResource(R.drawable.rareleathergloves)
                } else if (itemId in 19..22) {
                    armorSlot6.setImageResource(R.drawable.leathershoes)
                } else if (itemId in 23..24) {
                    armorSlot6.setImageResource(R.drawable.rareleathershoes)
                } else if (itemId in 25..28) {
                    armorSlot6.setImageResource(R.drawable.leathershield)
                } else if (itemId in 29..30) {
                    armorSlot6.setImageResource(R.drawable.rareleathershield)
                } else if (itemId in 31..34) {
                    armorSlot6.setImageResource(R.drawable.leatherbelt)
                }  else if (itemId in 35..36) {
                    armorSlot6.setImageResource(R.drawable.rareleatherbelt)
                } else if (itemId in 37..40) {
                    armorSlot6.setImageResource(R.drawable.leatherhat)
                } else if (itemId in 41..42) {
                    armorSlot6.setImageResource(R.drawable.rareleatherhat)
                }

                slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 6) {
                if (itemId in 1..4) {
                    armorSlot7.setImageResource(R.drawable.leatherarmor)
                } else if (itemId in 5..6) {
                    armorSlot7.setImageResource(R.drawable.rareleatherarmor)
                } else if (itemId in 7..10) {
                    armorSlot7.setImageResource(R.drawable.leatherrobe)
                } else if (itemId in 11..12) {
                    armorSlot7.setImageResource(R.drawable.rareleatherrobe)
                } else if (itemId in 13..16) {
                    armorSlot7.setImageResource(R.drawable.leathergloves)
                } else if (itemId in 17..18) {
                    armorSlot7.setImageResource(R.drawable.rareleathergloves)
                } else if (itemId in 19..22) {
                    armorSlot7.setImageResource(R.drawable.leathershoes)
                } else if (itemId in 23..24) {
                    armorSlot7.setImageResource(R.drawable.rareleathershoes)
                } else if (itemId in 25..28) {
                    armorSlot7.setImageResource(R.drawable.leathershield)
                } else if (itemId in 29..30) {
                    armorSlot7.setImageResource(R.drawable.rareleathershield)
                } else if (itemId in 31..34) {
                    armorSlot7.setImageResource(R.drawable.leatherbelt)
                }  else if (itemId in 35..36) {
                    armorSlot7.setImageResource(R.drawable.rareleatherbelt)
                } else if (itemId in 37..40) {
                    armorSlot7.setImageResource(R.drawable.leatherhat)
                } else if (itemId in 41..42) {
                    armorSlot7.setImageResource(R.drawable.rareleatherhat)
                }

                slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 7) {
                if (itemId in 1..4) {
                    armorSlot8.setImageResource(R.drawable.leatherarmor)
                } else if (itemId in 5..6) {
                    armorSlot8.setImageResource(R.drawable.rareleatherarmor)
                } else if (itemId in 7..10) {
                    armorSlot8.setImageResource(R.drawable.leatherrobe)
                } else if (itemId in 11..12) {
                    armorSlot8.setImageResource(R.drawable.rareleatherrobe)
                } else if (itemId in 13..16) {
                    armorSlot8.setImageResource(R.drawable.leathergloves)
                } else if (itemId in 17..18) {
                    armorSlot8.setImageResource(R.drawable.rareleathergloves)
                } else if (itemId in 19..22) {
                    armorSlot8.setImageResource(R.drawable.leathershoes)
                } else if (itemId in 23..24) {
                    armorSlot8.setImageResource(R.drawable.rareleathershoes)
                } else if (itemId in 25..28) {
                    armorSlot8.setImageResource(R.drawable.leathershield)
                } else if (itemId in 29..30) {
                    armorSlot8.setImageResource(R.drawable.rareleathershield)
                } else if (itemId in 31..34) {
                    armorSlot8.setImageResource(R.drawable.leatherbelt)
                }  else if (itemId in 35..36) {
                    armorSlot8.setImageResource(R.drawable.rareleatherbelt)
                } else if (itemId in 37..40) {
                    armorSlot8.setImageResource(R.drawable.leatherhat)
                } else if (itemId in 41..42) {
                    armorSlot8.setImageResource(R.drawable.rareleatherhat)
                }

                slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            } else if (loopStopper == 8) {
                if (itemId in 1..4) {
                    armorSlot9.setImageResource(R.drawable.leatherarmor)
                } else if (itemId in 5..6) {
                    armorSlot9.setImageResource(R.drawable.rareleatherarmor)
                } else if (itemId in 7..10) {
                    armorSlot9.setImageResource(R.drawable.leatherrobe)
                } else if (itemId in 11..12) {
                    armorSlot9.setImageResource(R.drawable.rareleatherrobe)
                } else if (itemId in 13..16) {
                    armorSlot9.setImageResource(R.drawable.leathergloves)
                } else if (itemId in 17..18) {
                    armorSlot9.setImageResource(R.drawable.rareleathergloves)
                } else if (itemId in 19..22) {
                    armorSlot9.setImageResource(R.drawable.leathershoes)
                } else if (itemId in 23..24) {
                    armorSlot9.setImageResource(R.drawable.rareleathershoes)
                } else if (itemId in 25..28) {
                    armorSlot9.setImageResource(R.drawable.leathershield)
                } else if (itemId in 29..30) {
                    armorSlot9.setImageResource(R.drawable.rareleathershield)
                } else if (itemId in 31..34) {
                    armorSlot9.setImageResource(R.drawable.leatherbelt)
                }  else if (itemId in 35..36) {
                    armorSlot9.setImageResource(R.drawable.rareleatherbelt)
                } else if (itemId in 37..40) {
                    armorSlot9.setImageResource(R.drawable.leatherhat)
                } else if (itemId in 41..42) {
                    armorSlot9.setImageResource(R.drawable.rareleatherhat)
                }

                slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)

            }





            loopStopper++

            if (loopStopper == 9) {
                break
            }



        }


    }



}