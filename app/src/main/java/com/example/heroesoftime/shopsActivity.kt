package com.example.heroesoftime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.heroesoftime.classes.armorClass
import com.example.heroesoftime.classes.heroAttributesData
import com.example.heroesoftime.classes.heroDataClass
import com.example.heroesoftime.classes.shopItemsClass
import com.example.heroesoftime.classes.weaponClass
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlin.collections.ArrayList

class shopsActivity : AppCompatActivity() {



    var noIdArmor = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var noIdWeapon = weaponClass(0, "", 0, 0, 0, 0, 0, 0, 0)


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




    var selectedItem = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
    var selectedItemToBuy = armorClass(0, "", 0, 0, 0, 0, 0, 0, 0)
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
    var selectedItemToShop = 0
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
    lateinit var heroRingSlot1 : ImageView
    lateinit var heroRingSlot2 : ImageView
    lateinit var heroAmuletSlot : ImageView


    lateinit var buyButton : Button
    lateinit var equipButton : Button
    lateinit var sellButton : Button
    lateinit var removeButton : Button
    lateinit var refreshBtn : Button



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






    var armorMarketSlot1 : Int = 0
    var armorMarketSlot2 : Int = 0
    var armorMarketSlot3 : Int = 0
    var armorMarketSlot4 : Int = 0
    var armorMarketSlot5 : Int = 0
    var armorMarketSlot6 : Int = 0
    var armorMarketSlot7 : Int = 0
    var armorMarketSlot8 : Int = 0
    var armorMarketSlot9 : Int = 0
    var weaponMarketSlot1 : Int = 0
    var weaponMarketSlot2 : Int = 0
    var weaponMarketSlot3 : Int = 0
    var weaponMarketSlot4 : Int = 0
    var weaponMarketSlot5 : Int = 0
    var weaponMarketSlot6 : Int = 0
    var weaponMarketSlot7 : Int = 0
    var weaponMarketSlot8 : Int = 0
    var weaponMarketSlot9 : Int = 0
    var ringMarketSlot1 : Int = 0
    var ringMarketSlot2 : Int = 0
    var ringMarketSlot3 : Int = 0
    var ringMarketSlot4 : Int = 0
    var ringMarketSlot5 : Int = 0
    var ringMarketSlot6 : Int = 0
    var ringMarketSlot7 : Int = 0
    var ringMarketSlot8 : Int = 0
    var ringMarketSlot9 : Int = 0





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


    var isShopArmorRefresh = false
    var isShopWeaponsRefresh = false
    var isShopRingsRefresh = false
    var updateAllAttributesData = true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)



        listOfRingItems = arrayListOf()
        listOfAmuletItems = arrayListOf()
        listOfAllAmulets = arrayListOf()
        listOfAllRings = arrayListOf()
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
        heroRingSlot1 = findViewById(R.id.heroRingSlot1)
        heroRingSlot2 = findViewById(R.id.heroRingSlot2)
        heroAmuletSlot = findViewById(R.id.heroAmuletSlot)

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
        removeButton = findViewById(R.id.removeButton)
        refreshBtn = findViewById(R.id.refreshBtn)



        val sharedSelectorShopType = getSharedPreferences("SelectorShopType", AppCompatActivity.MODE_PRIVATE)
        var selectedShopType = sharedSelectorShopType.getInt("SelectorShopType", 0)




        listAllItems()   // update when new items are added in game



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


                            if (updateAllAttributesData) {
                                save()  // no updates
                                updateAllAttributesData = false
                            }



                        }
                    }
                }
        }











        if (user != null) {

            database.collection("users").document(user.uid).collection("userData")
                .document("Shop1").collection("ArmorShop")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedShopData = document.toObject()!!

                            isShopArmorRefresh = savedShopData.shopRefresh


                            if (selectedShopType == 1 && isShopArmorRefresh) {
                                generateRandomArmorItems() // update only in new shops
                                saveNewlyGeneratedArmorItems()  // no updates
                            } else if (selectedShopType == 1 && !isShopArmorRefresh) {
                                isShopArmorRefresh = savedShopData.shopRefresh
                                armorMarketSlot1 = savedShopData.shopSlot1
                                armorMarketSlot2 = savedShopData.shopSlot2
                                armorMarketSlot3 = savedShopData.shopSlot3
                                armorMarketSlot4 = savedShopData.shopSlot4
                                armorMarketSlot5 = savedShopData.shopSlot5
                                armorMarketSlot6 = savedShopData.shopSlot6
                                armorMarketSlot7 = savedShopData.shopSlot7
                                armorMarketSlot8 = savedShopData.shopSlot8
                                armorMarketSlot9 = savedShopData.shopSlot9

                                if(!isShopArmorRefresh && selectedShopType == 1) {
                                    generateRandomArmorItems()
                                }

                            }







                        }
                    }
                }
        }


        if (user != null) {

            database.collection("users").document(user.uid).collection("userData")
                .document("Shop1").collection("WeaponShop")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedShopData = document.toObject()!!

                            isShopWeaponsRefresh = savedShopData.shopRefresh


                            if (selectedShopType == 2 && isShopWeaponsRefresh) {
                                generateRandomWeaponItems() // update only in new shops
                                saveNewlyGeneratedWeaponItems()  // no updates
                            } else if (selectedShopType == 2 && !isShopWeaponsRefresh) {
                                isShopWeaponsRefresh = savedShopData.shopRefresh
                                weaponMarketSlot1 = savedShopData.shopSlot1
                                weaponMarketSlot2 = savedShopData.shopSlot2
                                weaponMarketSlot3 = savedShopData.shopSlot3
                                weaponMarketSlot4 = savedShopData.shopSlot4
                                weaponMarketSlot5 = savedShopData.shopSlot5
                                weaponMarketSlot6 = savedShopData.shopSlot6
                                weaponMarketSlot7 = savedShopData.shopSlot7
                                weaponMarketSlot8 = savedShopData.shopSlot8
                                weaponMarketSlot9 = savedShopData.shopSlot9

                                if(!isShopWeaponsRefresh && selectedShopType == 2) {
                                    generateRandomWeaponItems()
                                }

                            }







                        }
                    }
                }
        }





        if (user != null) {

            database.collection("users").document(user.uid).collection("userData")
                .document("Shop1").collection("RingShop")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedShopData = document.toObject()!!

                            isShopRingsRefresh = savedShopData.shopRefresh


                            if (selectedShopType == 3 && isShopRingsRefresh) {
                                generateRandomAmulets()  // update only in new shops
                                generateRandomRings() // update only in new shops
                                saveNewlyGeneratedRingItems() // no updates
                            } else if (selectedShopType == 3 && !isShopRingsRefresh) {
                                isShopRingsRefresh = savedShopData.shopRefresh
                                ringMarketSlot1 = savedShopData.shopSlot1
                                ringMarketSlot2 = savedShopData.shopSlot2
                                ringMarketSlot3 = savedShopData.shopSlot3
                                ringMarketSlot4 = savedShopData.shopSlot4
                                ringMarketSlot5 = savedShopData.shopSlot5
                                ringMarketSlot6 = savedShopData.shopSlot6
                                ringMarketSlot7 = savedShopData.shopSlot7
                                ringMarketSlot8 = savedShopData.shopSlot8
                                ringMarketSlot9 = savedShopData.shopSlot9

                                if(!isShopRingsRefresh && selectedShopType == 3) {
                                    generateRandomRings()
                                    generateRandomAmulets()
                                }

                            }







                        }
                    }
                }
        }




        removeButton.isEnabled = false
        buyButton.isEnabled = false
        equipButton.isEnabled = false
        sellButton.isEnabled = false







        removeButton.setOnClickListener {

            updateAllAttributesData = true
            moveToIn()    // no updates

            removeButton.isEnabled = false


        }



        buyButton.setOnClickListener {

            performShop()   // update the level required in new shops
            save()
            buyButton.isEnabled = false

        }

        equipButton.setOnClickListener {

            updateAllAttributesData = true
            equip()  // no updates

            save() // no updates


        }


        sellButton.setOnClickListener {

            updateAllAttributesData = true
            sell()   // no updates

            save()

        }




        refreshBtn.setOnClickListener {

            if (savedHeroGold >= 200) {
                savedHeroGold -= 200
                if (selectedShopType == 1) {
                    orderArmorRefresh()
                } else if (selectedShopType == 2) {
                    orderWeaponRefresh()
                } else if (selectedShopType == 3) {
                    orderRingRefresh()
                }
                save()
            }
        }



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
            priceTxt.text = "Price: ${heroRobeSlotAtributes.price/2}"

            selectedSlotInShopView = 2

            selectedItemInShopPrice = heroRobeSlotAtributes.price

            removeButton.isEnabled = true
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
            priceTxt.text = "Price: ${heroGloveSlotAtributes.price/2}"

            selectedSlotInShopView = 3

            selectedItemInShopPrice = heroGloveSlotAtributes.price

            removeButton.isEnabled = true
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
            priceTxt.text = "Price: ${heroShoesSlotAtributes.price/2}"

            selectedSlotInShopView = 4

            selectedItemInShopPrice = heroShoesSlotAtributes.price

            removeButton.isEnabled = true
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
            priceTxt.text = "Price: ${heroShieldSlotAtributes.price/2}"

            selectedSlotInShopView = 5

            selectedItemInShopPrice = heroShieldSlotAtributes.price

            removeButton.isEnabled = true
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
            priceTxt.text = "Price: ${heroBeltSlotAtributes.price/2}"

            selectedSlotInShopView = 6

            selectedItemInShopPrice = heroBeltSlotAtributes.price

            removeButton.isEnabled = true
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
            priceTxt.text = "Price: ${heroHelmetSlotAtributes.price/2}"

            selectedSlotInShopView = 7

            selectedItemInShopPrice = heroHelmetSlotAtributes.price

            removeButton.isEnabled = true
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
            priceTxt.text = "Price: ${heroWeaponSlotAtributes.price/2}"

            selectedSlotInShopView = 8

            selectedItemInShopPrice = heroWeaponSlotAtributes.price

            removeButton.isEnabled = true
            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

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
            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

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
            sellButton.isEnabled = true
            equipButton.isEnabled = false
            buyButton.isEnabled = false

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

            selectedItemToShop = 1
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

            selectedItemToShop = 2
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

            selectedItemToShop = 3
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

            selectedItemToShop = 4
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

            selectedItemToShop = 5
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

            selectedItemToShop = 6
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

            selectedItemToShop = 7
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

            selectedItemToShop = 8
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

            selectedItemToShop = 9
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
            var shopedItemPrice = inventoryAtributesSlot1.price/2
            priceTxt.text = "Price: $shopedItemPrice"

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
            var shopedItemPrice = inventoryAtributesSlot2.price/2
            priceTxt.text = "Price: ${shopedItemPrice}"

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
            var shopedItemPrice = inventoryAtributesSlot3.price/2
            priceTxt.text = "Price: $shopedItemPrice"

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
            var shopedItemPrice = inventoryAtributesSlot4.price/2
            priceTxt.text = "Price: $shopedItemPrice"

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
            var shopedItemPrice = inventoryAtributesSlot5.price/2
            priceTxt.text = "Price: $shopedItemPrice"

            selectedSlotInShopView = 16

            selectedItemInShopPrice = inventoryAtributesSlot5.price

            sellButton.isEnabled = true
            equipButton.isEnabled = true
            buyButton.isEnabled = false

        }












    }




    fun saveNewlyGeneratedArmorItems() {

        auth = Firebase.auth
        val user = auth.currentUser


        var refresh = shopItemsClass(shopSlot1 = slot1.itemId, shopSlot2 = slot2.itemId,
            shopSlot3 = slot3.itemId, shopSlot4 = slot4.itemId, shopSlot5 = slot5.itemId,
            shopSlot6 = slot6.itemId, shopSlot7 = slot7.itemId, shopSlot8 = slot8.itemId,
            shopSlot9 = slot9.itemId, shopRefresh = false)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Shop1").collection("ArmorShop").document("ArmorItems").set(refresh)


                .addOnCompleteListener {


                }
        }





    }


    fun saveNewlyGeneratedWeaponItems() {

        auth = Firebase.auth
        val user = auth.currentUser


        var refresh = shopItemsClass(shopSlot1 = slot1.itemId, shopSlot2 = slot2.itemId,
            shopSlot3 = slot3.itemId, shopSlot4 = slot4.itemId, shopSlot5 = slot5.itemId,
            shopSlot6 = slot6.itemId, shopSlot7 = slot7.itemId, shopSlot8 = slot8.itemId,
            shopSlot9 = slot9.itemId, shopRefresh = false)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Shop1").collection("WeaponShop").document("WeaponItems").set(refresh)


                .addOnCompleteListener {


                }
        }





    }




    fun saveNewlyGeneratedRingItems() {

        auth = Firebase.auth
        val user = auth.currentUser


        var refresh = shopItemsClass(shopSlot1 = slot1.itemId, shopSlot2 = slot2.itemId,
            shopSlot3 = slot3.itemId, shopSlot4 = slot4.itemId, shopSlot5 = slot5.itemId,
            shopSlot6 = slot6.itemId, shopSlot7 = slot7.itemId, shopSlot8 = slot8.itemId,
            shopSlot9 = slot9.itemId, shopRefresh = false)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Shop1").collection("RingShop").document("RingItems").set(refresh)


                .addOnCompleteListener {


                }
        }



    }







    fun orderArmorRefresh() {

        auth = Firebase.auth
        val user = auth.currentUser


        var refresh = shopItemsClass(shopSlot1 = slot1.itemId, shopSlot2 = slot2.itemId,
            shopSlot3 = slot3.itemId, shopSlot4 = slot4.itemId, shopSlot5 = slot5.itemId,
            shopSlot6 = slot6.itemId, shopSlot7 = slot7.itemId, shopSlot8 = slot8.itemId,
            shopSlot9 = slot9.itemId, shopRefresh = true)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Shop1").collection("ArmorShop").document("ArmorItems").set(refresh)


                .addOnCompleteListener {


                }
        }



    }


    fun orderWeaponRefresh() {

        auth = Firebase.auth
        val user = auth.currentUser


        var refresh = shopItemsClass(shopSlot1 = slot1.itemId, shopSlot2 = slot2.itemId,
            shopSlot3 = slot3.itemId, shopSlot4 = slot4.itemId, shopSlot5 = slot5.itemId,
            shopSlot6 = slot6.itemId, shopSlot7 = slot7.itemId, shopSlot8 = slot8.itemId,
            shopSlot9 = slot9.itemId, shopRefresh = true)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Shop1").collection("WeaponShop").document("WeaponItems").set(refresh)


                .addOnCompleteListener {


                }
        }



    }






    fun orderRingRefresh() {

        auth = Firebase.auth
        val user = auth.currentUser


        var refresh = shopItemsClass(shopSlot1 = slot1.itemId, shopSlot2 = slot2.itemId,
            shopSlot3 = slot3.itemId, shopSlot4 = slot4.itemId, shopSlot5 = slot5.itemId,
            shopSlot6 = slot6.itemId, shopSlot7 = slot7.itemId, shopSlot8 = slot8.itemId,
            shopSlot9 = slot9.itemId, shopRefresh = true)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Shop1").collection("RingShop").document("RingItems").set(refresh)


                .addOnCompleteListener {


                }
        }



    }






    fun updateAllAttributes() {




        var heroTotalArmor = heroArmorSlotAtributes.armor.toDouble() + heroRobeSlotAtributes.armor.toDouble() +
                heroGloveSlotAtributes.armor.toDouble() + heroShoesSlotAtributes.armor.toDouble() +
                heroShieldSlotAtributes.armor.toDouble() + heroBeltSlotAtributes.armor.toDouble() +
                heroHelmetSlotAtributes.armor.toDouble()

        var itemsVitality = heroArmorSlotAtributes.vitality.toDouble() + heroRobeSlotAtributes.vitality.toDouble() +
                heroGloveSlotAtributes.vitality.toDouble() + heroShoesSlotAtributes.vitality.toDouble() +
                heroShieldSlotAtributes.vitality.toDouble() + heroBeltSlotAtributes.vitality.toDouble() +
                heroHelmetSlotAtributes.vitality.toDouble() + heroWeaponSlotAtributes.vitality.toDouble() +
                heroRingSlot1Attributes.vitality.toDouble() + heroRingSlot2Attributes.vitality.toDouble() +
                heroAmuletSlotAttributes.vitality.toDouble()


        var itemsStrenght = heroArmorSlotAtributes.strenght.toDouble() + heroRobeSlotAtributes.strenght.toDouble() +
                heroGloveSlotAtributes.strenght.toDouble() + heroShoesSlotAtributes.strenght.toDouble() +
                heroShieldSlotAtributes.strenght.toDouble() + heroBeltSlotAtributes.strenght.toDouble() +
                heroHelmetSlotAtributes.strenght.toDouble() + heroWeaponSlotAtributes.strenght.toDouble() +
                heroRingSlot1Attributes.strenght.toDouble() + heroRingSlot2Attributes.strenght.toDouble() +
                heroAmuletSlotAttributes.strenght.toDouble()


        var itemsMana = heroArmorSlotAtributes.mana.toDouble() + heroRobeSlotAtributes.mana.toDouble() +
                heroGloveSlotAtributes.mana.toDouble() + heroShoesSlotAtributes.mana.toDouble() +
                heroShieldSlotAtributes.mana.toDouble() + heroBeltSlotAtributes.mana.toDouble() +
                heroHelmetSlotAtributes.mana.toDouble() + heroWeaponSlotAtributes.mana.toDouble() +
                heroRingSlot1Attributes.mana.toDouble() + heroRingSlot2Attributes.mana.toDouble() +
                heroAmuletSlotAttributes.mana.toDouble()


        var itemsSpeed = heroArmorSlotAtributes.speed.toDouble() + heroRobeSlotAtributes.speed.toDouble() +
                heroGloveSlotAtributes.speed.toDouble() + heroShoesSlotAtributes.speed.toDouble() +
                heroShieldSlotAtributes.speed.toDouble() + heroBeltSlotAtributes.speed.toDouble() +
                heroHelmetSlotAtributes.speed.toDouble() + heroWeaponSlotAtributes.speed.toDouble() +
                heroRingSlot1Attributes.speed.toDouble() + heroRingSlot2Attributes.speed.toDouble() +
                heroAmuletSlotAttributes.speed.toDouble()



        var itemDamage = heroWeaponSlotAtributes.damage.toDouble()




        auth = Firebase.auth
        val user = auth.currentUser

        var heroData = heroAttributesData(heroTotalArmor = heroTotalArmor,
            itemsAddedVitality = itemsVitality, itemsAddedStrenght = itemsStrenght, itemsAddedMana = itemsMana,
            itemsAddedSpeed = itemsSpeed, itemWeaponDamage = itemDamage)


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData").
            document("Attributes").collection("All hero attributes")
                .document("attributes").set(heroData)


                .addOnCompleteListener {


                }
        }



    }







    fun save() {



        var heroTotalArmor = heroArmorSlotAtributes.armor.toDouble() + heroRobeSlotAtributes.armor.toDouble() +
                heroGloveSlotAtributes.armor.toDouble() + heroShoesSlotAtributes.armor.toDouble() +
                heroShieldSlotAtributes.armor.toDouble() + heroBeltSlotAtributes.armor.toDouble() +
                heroHelmetSlotAtributes.armor.toDouble()

        var itemsVitality = heroArmorSlotAtributes.vitality.toDouble() + heroRobeSlotAtributes.vitality.toDouble() +
                heroGloveSlotAtributes.vitality.toDouble() + heroShoesSlotAtributes.vitality.toDouble() +
                heroShieldSlotAtributes.vitality.toDouble() + heroBeltSlotAtributes.vitality.toDouble() +
                heroHelmetSlotAtributes.vitality.toDouble() + heroWeaponSlotAtributes.vitality.toDouble() +
                heroRingSlot1Attributes.vitality.toDouble() + heroRingSlot2Attributes.vitality.toDouble() +
                heroAmuletSlotAttributes.vitality.toDouble()


        var itemsStrenght = heroArmorSlotAtributes.strenght.toDouble() + heroRobeSlotAtributes.strenght.toDouble() +
                heroGloveSlotAtributes.strenght.toDouble() + heroShoesSlotAtributes.strenght.toDouble() +
                heroShieldSlotAtributes.strenght.toDouble() + heroBeltSlotAtributes.strenght.toDouble() +
                heroHelmetSlotAtributes.strenght.toDouble() + heroWeaponSlotAtributes.strenght.toDouble() +
                heroRingSlot1Attributes.strenght.toDouble() + heroRingSlot2Attributes.strenght.toDouble() +
                heroAmuletSlotAttributes.strenght.toDouble()


        var itemsMana = heroArmorSlotAtributes.mana.toDouble() + heroRobeSlotAtributes.mana.toDouble() +
                heroGloveSlotAtributes.mana.toDouble() + heroShoesSlotAtributes.mana.toDouble() +
                heroShieldSlotAtributes.mana.toDouble() + heroBeltSlotAtributes.mana.toDouble() +
                heroHelmetSlotAtributes.mana.toDouble() + heroWeaponSlotAtributes.mana.toDouble() +
                heroRingSlot1Attributes.mana.toDouble() + heroRingSlot2Attributes.mana.toDouble() +
                heroAmuletSlotAttributes.mana.toDouble()


        var itemsSpeed = heroArmorSlotAtributes.speed.toDouble() + heroRobeSlotAtributes.speed.toDouble() +
                heroGloveSlotAtributes.speed.toDouble() + heroShoesSlotAtributes.speed.toDouble() +
                heroShieldSlotAtributes.speed.toDouble() + heroBeltSlotAtributes.speed.toDouble() +
                heroHelmetSlotAtributes.speed.toDouble() + heroWeaponSlotAtributes.speed.toDouble() +
                heroRingSlot1Attributes.speed.toDouble() + heroRingSlot2Attributes.speed.toDouble() +
                heroAmuletSlotAttributes.speed.toDouble()



        var itemDamage = heroWeaponSlotAtributes.damage.toDouble()




        auth = Firebase.auth
        val user = auth.currentUser

        var heroData = heroDataClass(heroIconId = savedHeroImage, heroLevel = savedHeroLevel, heroExperience = 1, heroArmorId = savedHeroArmor,
            heroRobeId = savedHeroRobe, heroGloveId = savedHeroGloves, heroShoesId = savedHeroShoes,
            heroShieldId = savedHeroShield, heroBeltId = savedHeroBelt,
            heroHelmetId = savedHeroHelmet, heroWeaponId = savedHeroWeapon,
        heroInventorySlot1 = savedHeroInventorySlot1, heroInventorySlot2 = savedHeroInventorySlot2,
            heroInventorySlot3 = savedHeroInventorySlot3, heroInventorySlot4 = savedHeroInventorySlot4,
        heroInventorySlot5 = savedHeroInventorySlot5, heroGold = savedHeroGold, heroRingId1 = savedHeroRing1,
        heroRingId2 = savedHeroRing2, heroAmuletId = savedHeroAmulet, heroTotalArmor = heroTotalArmor,
        itemsAddedVitality = itemsVitality, itemsAddedStrenght = itemsStrenght, itemsAddedSpeed = itemsSpeed,
        itemsAddedMana = itemsMana, itemWeaponDamage = itemDamage)


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



    fun generateRandomAmulets() {

        listOfAmuletItems.add(amulet1)
        listOfAmuletItems.add(amulet2)
        listOfAmuletItems.add(amulet3)
        listOfAmuletItems.add(rareAmulet1)
        listOfAmuletItems.add(rareAmulet2)



        var loopStopper = 0

        while (true) {

            /*

            var random = Random(System.currentTimeMillis())
            var randomN = random.nextInt(42)
            var itemId =  listOfArmorItems[randomN].itemId


             */


            var randomN = (0..4).random()
            var itemId =  listOfAmuletItems[randomN].itemId

            var itemName = listOfAmuletItems[randomN].armorName
            var armorItem = listOfAmuletItems[randomN].armor
            var vitalityItem = listOfAmuletItems[randomN].vitality
            var speedItem = listOfAmuletItems[randomN].speed
            var manaItem = listOfAmuletItems[randomN].mana
            var strenghtItem = listOfAmuletItems[randomN].strenght
            var priceItem = listOfAmuletItems[randomN].price
            var typeItem = listOfAmuletItems[randomN].typeItem



            if (!isShopRingsRefresh && loopStopper == 0) {
                itemId = ringMarketSlot1
            } else if (!isShopRingsRefresh && loopStopper == 1) {
                itemId = ringMarketSlot2
            } else if (!isShopRingsRefresh && loopStopper == 2) {
                itemId = ringMarketSlot3
            }




            if (loopStopper == 0) {

                if (itemId in 62..64) {
                    armorSlot1.setImageResource(R.drawable.amulet)
                } else if (itemId in 65..66) {
                    armorSlot1.setImageResource(R.drawable.rareamulet)
                }

                if (itemId == 0) {
                    armorSlot1.setImageResource(R.drawable.foursquare)
                }

                if (isShopRingsRefresh) {
                    slot1 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopRingsRefresh) {


                    for (items in listOfAllAmulets) {
                        if (items.itemId == itemId) {
                            slot1 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

            } else if (loopStopper == 1) {

                if (itemId in 62..64) {
                    armorSlot2.setImageResource(R.drawable.amulet)
                } else if (itemId in 65..66) {
                    armorSlot2.setImageResource(R.drawable.rareamulet)
                }

                if (itemId == 0) {
                    armorSlot2.setImageResource(R.drawable.foursquare)
                }

                if (isShopRingsRefresh) {
                    slot2 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopRingsRefresh) {


                    for (items in listOfAllAmulets) {
                        if (items.itemId == itemId) {
                            slot2 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

            } else if (loopStopper == 2) {

                if (itemId in 62..64) {
                    armorSlot3.setImageResource(R.drawable.amulet)
                } else if (itemId in 65..66) {
                    armorSlot3.setImageResource(R.drawable.rareamulet)
                }
                if (itemId == 0) {
                    armorSlot3.setImageResource(R.drawable.foursquare)
                }

                if (isShopRingsRefresh) {
                    slot3 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopRingsRefresh) {


                    for (items in listOfAllAmulets) {
                        if (items.itemId == itemId) {
                            slot3 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

            }



            loopStopper++

            if (loopStopper == 3) {
                break
            }



        }


    }






    fun generateRandomRings() {


        listOfRingItems.add(pinkRing1)
        listOfRingItems.add(pinkRing2)
        listOfRingItems.add(pinkRing3)
        listOfRingItems.add(rarePinkRing1)
        listOfRingItems.add(rarePinkRing2)



        var loopStopper = 0

        while (true) {

            /*

            var random = Random(System.currentTimeMillis())
            var randomN = random.nextInt(42)
            var itemId =  listOfArmorItems[randomN].itemId


             */


            var randomN = (0..4).random()
            var itemId =  listOfRingItems[randomN].itemId

            var itemName = listOfRingItems[randomN].armorName
            var armorItem = listOfRingItems[randomN].armor
            var vitalityItem = listOfRingItems[randomN].vitality
            var speedItem = listOfRingItems[randomN].speed
            var manaItem = listOfRingItems[randomN].mana
            var strenghtItem = listOfRingItems[randomN].strenght
            var priceItem = listOfRingItems[randomN].price
            var typeItem = listOfRingItems[randomN].typeItem




            if (!isShopRingsRefresh && loopStopper == 0) {
                itemId = ringMarketSlot4
            } else if (!isShopRingsRefresh && loopStopper == 1) {
                itemId = ringMarketSlot5
            } else if (!isShopRingsRefresh && loopStopper == 2) {
                itemId = ringMarketSlot6
            } else if (!isShopRingsRefresh && loopStopper == 3) {
                itemId = ringMarketSlot7
            } else if (!isShopRingsRefresh && loopStopper == 4) {
                itemId = ringMarketSlot8
            } else if (!isShopRingsRefresh && loopStopper == 5) {
                itemId = ringMarketSlot9
            }



            if (loopStopper == 0) {
                if (itemId in 57..59) {
                    armorSlot4.setImageResource(R.drawable.pinkring)
                } else if (itemId in 60..61) {
                    armorSlot4.setImageResource(R.drawable.rarepinkring)
                }

                if (itemId == 0) {
                    armorSlot4.setImageResource(R.drawable.foursquare)
                }

                if (isShopRingsRefresh) {
                    slot4 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopRingsRefresh) {


                    for (items in listOfAllRings) {
                        if (items.itemId == itemId) {
                            slot4 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

            } else if (loopStopper == 1) {
                if (itemId in 57..59) {
                    armorSlot5.setImageResource(R.drawable.pinkring)
                } else if (itemId in 60..61) {
                    armorSlot5.setImageResource(R.drawable.rarepinkring)
                }
                if (itemId == 0) {
                    armorSlot5.setImageResource(R.drawable.foursquare)
                }

                if (isShopRingsRefresh) {
                    slot5 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopRingsRefresh) {


                    for (items in listOfAllRings) {
                        if (items.itemId == itemId) {
                            slot5 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

            } else if (loopStopper == 2) {

                if (itemId in 57..59) {
                    armorSlot6.setImageResource(R.drawable.pinkring)
                } else if (itemId in 60..61) {
                    armorSlot6.setImageResource(R.drawable.rarepinkring)
                }

                if (itemId == 0) {
                    armorSlot6.setImageResource(R.drawable.foursquare)
                }

                if (isShopRingsRefresh) {
                    slot6 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopRingsRefresh) {


                    for (items in listOfAllRings) {
                        if (items.itemId == itemId) {
                            slot6 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

            } else if (loopStopper == 3) {
                if (itemId in 57..59) {
                    armorSlot7.setImageResource(R.drawable.pinkring)
                } else if (itemId in 60..61) {
                    armorSlot7.setImageResource(R.drawable.rarepinkring)
                }
                if (itemId == 0) {
                    armorSlot7.setImageResource(R.drawable.foursquare)
                }

                if (isShopRingsRefresh) {
                    slot7 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopRingsRefresh) {


                    for (items in listOfAllRings) {
                        if (items.itemId == itemId) {
                            slot7 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

            } else if (loopStopper == 4) {

                if (itemId in 57..59) {
                    armorSlot8.setImageResource(R.drawable.pinkring)
                } else if (itemId in 60..61) {
                    armorSlot8.setImageResource(R.drawable.rarepinkring)
                }

                if (itemId == 0) {
                    armorSlot8.setImageResource(R.drawable.foursquare)
                }

                if (isShopRingsRefresh) {
                    slot8 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopRingsRefresh) {


                    for (items in listOfAllRings) {
                        if (items.itemId == itemId) {
                            slot8 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

            } else if (loopStopper == 5) {

                if (itemId in 57..59) {
                    armorSlot9.setImageResource(R.drawable.pinkring)
                } else if (itemId in 60..61) {
                    armorSlot9.setImageResource(R.drawable.rarepinkring)
                }
                if (itemId == 0) {
                    armorSlot9.setImageResource(R.drawable.foursquare)
                }

                if (isShopRingsRefresh) {
                    slot9 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopRingsRefresh) {


                    for (items in listOfAllRings) {
                        if (items.itemId == itemId) {
                            slot9 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

            }





            loopStopper++

            if (loopStopper == 6) {
                break
            }



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



            if (!isShopWeaponsRefresh && loopStopper == 0) {
                itemId = weaponMarketSlot1
            } else if (!isShopWeaponsRefresh && loopStopper == 1) {
                itemId = weaponMarketSlot2
            } else if (!isShopWeaponsRefresh && loopStopper == 2) {
                itemId = weaponMarketSlot3
            } else if (!isShopWeaponsRefresh && loopStopper == 3) {
                itemId = weaponMarketSlot4
            } else if (!isShopWeaponsRefresh && loopStopper == 4) {
                itemId = weaponMarketSlot5
            } else if (!isShopWeaponsRefresh && loopStopper == 5) {
                itemId = weaponMarketSlot6
            } else if (!isShopWeaponsRefresh && loopStopper == 6) {
                itemId = weaponMarketSlot7
            } else if (!isShopWeaponsRefresh && loopStopper == 7) {
                itemId = weaponMarketSlot8
            } else if (!isShopWeaponsRefresh && loopStopper == 8) {
                itemId = weaponMarketSlot9
            }






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

                if (itemId == 0) {
                    armorSlot1.setImageResource(R.drawable.foursquare)
                }

                if (isShopWeaponsRefresh) {
                    slot1 = armorClass(
                        itemId,
                        itemName,
                        damageItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopWeaponsRefresh) {


                    for (items in listOfAllWeapons) {
                        if (items.itemId == itemId) {
                            slot1 = armorClass(
                                items.itemId,
                                items.weaponName,
                                items.damage,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

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

                if (itemId == 0) {
                    armorSlot2.setImageResource(R.drawable.foursquare)
                }

                if (isShopWeaponsRefresh) {
                    slot2 = armorClass(
                        itemId,
                        itemName,
                        damageItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopWeaponsRefresh) {
                    for (items in listOfAllWeapons) {
                        if (items.itemId == itemId) {
                            slot2 = armorClass(
                                items.itemId,
                                items.weaponName,
                                items.damage,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

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

                if (itemId == 0) {
                    armorSlot3.setImageResource(R.drawable.foursquare)
                }

                if (isShopWeaponsRefresh) {
                    slot3 = armorClass(
                        itemId,
                        itemName,
                        damageItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopWeaponsRefresh) {
                    for (items in listOfAllWeapons) {
                        if (items.itemId == itemId) {
                            slot3 = armorClass(
                                items.itemId,
                                items.weaponName,
                                items.damage,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

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

                if (itemId == 0) {
                    armorSlot4.setImageResource(R.drawable.foursquare)
                }

                if (isShopWeaponsRefresh) {
                    slot4 = armorClass(
                        itemId,
                        itemName,
                        damageItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopWeaponsRefresh) {
                    for (items in listOfAllWeapons) {
                        if (items.itemId == itemId) {
                            slot4 = armorClass(
                                items.itemId,
                                items.weaponName,
                                items.damage,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

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

                if (itemId == 0) {
                    armorSlot5.setImageResource(R.drawable.foursquare)
                }

                if (isShopWeaponsRefresh) {
                    slot5 = armorClass(
                        itemId,
                        itemName,
                        damageItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopWeaponsRefresh) {
                    for (items in listOfAllWeapons) {
                        if (items.itemId == itemId) {
                            slot5 = armorClass(
                                items.itemId,
                                items.weaponName,
                                items.damage,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

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

                if (itemId == 0) {
                    armorSlot6.setImageResource(R.drawable.foursquare)
                }

                if (isShopWeaponsRefresh) {
                    slot6 = armorClass(
                        itemId,
                        itemName,
                        damageItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopWeaponsRefresh) {
                    for (items in listOfAllWeapons) {
                        if (items.itemId == itemId) {
                            slot6 = armorClass(
                                items.itemId,
                                items.weaponName,
                                items.damage,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

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

                if (itemId == 0) {
                    armorSlot7.setImageResource(R.drawable.foursquare)
                }

                if (isShopWeaponsRefresh) {
                    slot7 = armorClass(
                        itemId,
                        itemName,
                        damageItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopWeaponsRefresh) {
                    for (items in listOfAllWeapons) {
                        if (items.itemId == itemId) {
                            slot7 = armorClass(
                                items.itemId,
                                items.weaponName,
                                items.damage,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

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

                if (itemId == 0) {
                    armorSlot8.setImageResource(R.drawable.foursquare)
                }

                if (isShopWeaponsRefresh) {
                    slot8 = armorClass(
                        itemId,
                        itemName,
                        damageItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopWeaponsRefresh) {
                    for (items in listOfAllWeapons) {
                        if (items.itemId == itemId) {
                            slot8 = armorClass(
                                items.itemId,
                                items.weaponName,
                                items.damage,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

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

                if (itemId == 0) {
                    armorSlot9.setImageResource(R.drawable.foursquare)
                }

                if (isShopWeaponsRefresh) {
                    slot9 = armorClass(
                        itemId,
                        itemName,
                        damageItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopWeaponsRefresh) {
                    for (items in listOfAllWeapons) {
                        if (items.itemId == itemId) {
                            slot9 = armorClass(
                                items.itemId,
                                items.weaponName,
                                items.damage,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }

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




            if (!isShopArmorRefresh && loopStopper == 0) {
                itemId = armorMarketSlot1
            } else if (!isShopArmorRefresh && loopStopper == 1) {
                itemId = armorMarketSlot2
            } else if (!isShopArmorRefresh && loopStopper == 2) {
                itemId = armorMarketSlot3
            } else if (!isShopArmorRefresh && loopStopper == 3) {
                itemId = armorMarketSlot4
            } else if (!isShopArmorRefresh && loopStopper == 4) {
                itemId = armorMarketSlot5
            } else if (!isShopArmorRefresh && loopStopper == 5) {
                itemId = armorMarketSlot6
            } else if (!isShopArmorRefresh && loopStopper == 6) {
                itemId = armorMarketSlot7
            } else if (!isShopArmorRefresh && loopStopper == 7) {
                itemId = armorMarketSlot8
            } else if (!isShopArmorRefresh && loopStopper == 8) {
                itemId = armorMarketSlot9
            }


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

                if (itemId == 0) {
                    armorSlot1.setImageResource(R.drawable.foursquare)
                }

                if (isShopArmorRefresh) {
                    slot1 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopArmorRefresh) {

                    for (items in listOfAllArmors) {
                        if (items.itemId == itemId) {
                            slot1 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }

                }
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

                if (itemId == 0) {
                    armorSlot2.setImageResource(R.drawable.foursquare)
                }

                if (isShopArmorRefresh) {
                    slot2 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopArmorRefresh) {
                    for (items in listOfAllArmors) {
                        if (items.itemId == itemId) {
                            slot2 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }
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

                if (itemId == 0) {
                    armorSlot3.setImageResource(R.drawable.foursquare)
                }

                if(isShopArmorRefresh) {
                    slot3 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopArmorRefresh) {
                    for (items in listOfAllArmors) {
                        if (items.itemId == itemId) {
                            slot3 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }
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

                if (itemId == 0) {
                    armorSlot4.setImageResource(R.drawable.foursquare)
                }

                if (isShopArmorRefresh) {
                    slot4 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopArmorRefresh) {
                    for (items in listOfAllArmors) {
                        if (items.itemId == itemId) {
                            slot4 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }
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

                if (itemId == 0) {
                    armorSlot5.setImageResource(R.drawable.foursquare)
                }

                if (isShopArmorRefresh) {
                    slot5 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopArmorRefresh) {
                    for (items in listOfAllArmors) {
                        if (items.itemId == itemId) {
                            slot5 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }
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

                if (itemId == 0) {
                    armorSlot6.setImageResource(R.drawable.foursquare)
                }

                if (isShopArmorRefresh) {
                    slot6 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopArmorRefresh) {
                    for (items in listOfAllArmors) {
                        if (items.itemId == itemId) {
                            slot6 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }
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

                if (itemId == 0) {
                    armorSlot7.setImageResource(R.drawable.foursquare)
                }

                if (isShopArmorRefresh) {
                    slot7 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopArmorRefresh) {
                    for (items in listOfAllArmors) {
                        if (items.itemId == itemId) {
                            slot7 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }
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

                if (itemId == 0) {
                    armorSlot8.setImageResource(R.drawable.foursquare)
                }

                if (isShopArmorRefresh) {
                    slot8 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopArmorRefresh) {
                    for (items in listOfAllArmors) {
                        if (items.itemId == itemId) {
                            slot8 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }
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

                if (itemId == 0) {
                    armorSlot9.setImageResource(R.drawable.foursquare)
                }

                if (isShopArmorRefresh) {
                    slot9 = armorClass(
                        itemId,
                        itemName,
                        armorItem,
                        vitalityItem,
                        speedItem,
                        manaItem,
                        strenghtItem,
                        priceItem,
                        typeItem
                    )
                } else if (!isShopArmorRefresh) {
                    for (items in listOfAllArmors) {
                        if (items.itemId == itemId) {
                            slot9 = armorClass(
                                items.itemId,
                                items.armorName,
                                items.armor,
                                items.vitality,
                                items.speed,
                                items.mana,
                                items.strenght,
                                items.price,
                                items.typeItem
                            )
                        }
                    }
                }
            }





            loopStopper++

            if (loopStopper == 9) {
                break
            }



        }


    }


    fun sell() {

        savedHeroGold += (selectedItemInShopPrice/2)
        selectedItemInShopPrice = 0

        if (selectedSlotInShopView == 1) {
            savedHeroArmor = 0
        } else if (selectedSlotInShopView == 2) {
            savedHeroRobe = 0
        } else if (selectedSlotInShopView == 3) {
            savedHeroGloves = 0
        } else if (selectedSlotInShopView == 4) {
            savedHeroShoes = 0
        } else if (selectedSlotInShopView == 5) {
            savedHeroShield = 0
        } else if (selectedSlotInShopView == 6) {
            savedHeroBelt = 0
        } else if (selectedSlotInShopView == 7) {
            savedHeroHelmet = 0
        } else if (selectedSlotInShopView == 8) {
            savedHeroWeapon = 0
        } else if (selectedSlotInShopView == 9) {
            savedHeroRing1 = 0
        } else if (selectedSlotInShopView == 10) {
            savedHeroRing2 = 0
        } else if (selectedSlotInShopView == 11) {
            savedHeroAmulet = 0
        } else if (selectedSlotInShopView == 12) {
            savedHeroInventorySlot1 = 0
        } else if (selectedSlotInShopView == 13) {
            savedHeroInventorySlot2 = 0
        } else if (selectedSlotInShopView == 14) {
            savedHeroInventorySlot3 = 0
        } else if (selectedSlotInShopView == 15) {
            savedHeroInventorySlot4 = 0
        } else if (selectedSlotInShopView == 16) {
            savedHeroInventorySlot5 = 0
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


    fun performShop() {


        if (selectedItemToShop == 1 && savedHeroGold >= slot1.price && savedHeroLevel >= 1) {
            if (savedHeroInventorySlot1 == 0) {
                    savedHeroGold -= slot1.price
                    savedHeroInventorySlot1 = slot1.itemId
            } else if (savedHeroInventorySlot2 == 0) {
                savedHeroGold -= slot1.price
                savedHeroInventorySlot2 = slot1.itemId
            } else if (savedHeroInventorySlot3 == 0) {
                savedHeroGold -= slot1.price
                savedHeroInventorySlot3 = slot1.itemId
            } else if (savedHeroInventorySlot4 == 0) {
                savedHeroGold -= slot1.price
                savedHeroInventorySlot4 = slot1.itemId
            } else if (savedHeroInventorySlot5 == 0) {
                savedHeroGold -= slot1.price
                savedHeroInventorySlot5 = slot1.itemId
            } else if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
                && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
                Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
            }
        } else if (selectedItemToShop == 2 && savedHeroGold >= slot2.price && savedHeroLevel >= 1) {
            if (savedHeroInventorySlot1 == 0) {
                savedHeroGold -= slot2.price
                savedHeroInventorySlot1 = slot2.itemId
            } else if (savedHeroInventorySlot2 == 0) {
                savedHeroGold -= slot2.price
                savedHeroInventorySlot2 = slot2.itemId
            } else if (savedHeroInventorySlot3 == 0) {
                savedHeroGold -= slot2.price
                savedHeroInventorySlot3 = slot2.itemId
            } else if (savedHeroInventorySlot4 == 0) {
                savedHeroGold -= slot2.price
                savedHeroInventorySlot4 = slot2.itemId
            } else if (savedHeroInventorySlot5 == 0) {
                savedHeroGold -= slot2.price
                savedHeroInventorySlot5 = slot2.itemId
            } else if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
                && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
                Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
            }
        } else if (selectedItemToShop == 3 && savedHeroGold >= slot3.price && savedHeroLevel >= 1) {
            if (savedHeroInventorySlot1 == 0) {
                savedHeroGold -= slot3.price
                savedHeroInventorySlot1 = slot3.itemId
            } else if (savedHeroInventorySlot2 == 0) {
                savedHeroGold -= slot3.price
                savedHeroInventorySlot2 = slot3.itemId
            } else if (savedHeroInventorySlot3 == 0) {
                savedHeroGold -= slot3.price
                savedHeroInventorySlot3 = slot3.itemId
            } else if (savedHeroInventorySlot4 == 0) {
                savedHeroGold -= slot3.price
                savedHeroInventorySlot4 = slot3.itemId
            } else if (savedHeroInventorySlot5 == 0) {
                savedHeroGold -= slot3.price
                savedHeroInventorySlot5 = slot3.itemId
            } else if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
                && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
                Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
            }
        } else if (selectedItemToShop == 4 && savedHeroGold >= slot4.price && savedHeroLevel >= 1) {
            if (savedHeroInventorySlot1 == 0) {
                savedHeroGold -= slot4.price
                savedHeroInventorySlot1 = slot4.itemId
            } else if (savedHeroInventorySlot2 == 0) {
                savedHeroGold -= slot4.price
                savedHeroInventorySlot2 = slot4.itemId
            } else if (savedHeroInventorySlot3 == 0) {
                savedHeroGold -= slot4.price
                savedHeroInventorySlot3 = slot4.itemId
            } else if (savedHeroInventorySlot4 == 0) {
                savedHeroGold -= slot4.price
                savedHeroInventorySlot4 = slot4.itemId
            } else if (savedHeroInventorySlot5 == 0) {
                savedHeroGold -= slot4.price
                savedHeroInventorySlot5 = slot4.itemId
            } else if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
                && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
                Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
            }
        } else if (selectedItemToShop == 5 && savedHeroGold >= slot5.price && savedHeroLevel >= 1) {
            if (savedHeroInventorySlot1 == 0) {
                savedHeroGold -= slot5.price
                savedHeroInventorySlot1 = slot5.itemId
            } else if (savedHeroInventorySlot2 == 0) {
                savedHeroGold -= slot5.price
                savedHeroInventorySlot2 = slot5.itemId
            } else if (savedHeroInventorySlot3 == 0) {
                savedHeroGold -= slot5.price
                savedHeroInventorySlot3 = slot5.itemId
            } else if (savedHeroInventorySlot4 == 0) {
                savedHeroGold -= slot5.price
                savedHeroInventorySlot4 = slot5.itemId
            } else if (savedHeroInventorySlot5 == 0) {
                savedHeroGold -= slot5.price
                savedHeroInventorySlot5 = slot5.itemId
            } else if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
                && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
                Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
            }
        } else if (selectedItemToShop == 6 && savedHeroGold >= slot6.price && savedHeroLevel >= 1) {
            if (savedHeroInventorySlot1 == 0) {
                savedHeroGold -= slot6.price
                savedHeroInventorySlot1 = slot6.itemId
            } else if (savedHeroInventorySlot2 == 0) {
                savedHeroGold -= slot6.price
                savedHeroInventorySlot2 = slot6.itemId
            } else if (savedHeroInventorySlot3 == 0) {
                savedHeroGold -= slot6.price
                savedHeroInventorySlot3 = slot6.itemId
            } else if (savedHeroInventorySlot4 == 0) {
                savedHeroGold -= slot6.price
                savedHeroInventorySlot4 = slot6.itemId
            } else if (savedHeroInventorySlot5 == 0) {
                savedHeroGold -= slot6.price
                savedHeroInventorySlot5 = slot6.itemId
            } else if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
                && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
                Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
            }
        } else if (selectedItemToShop == 7 && savedHeroGold >= slot7.price && savedHeroLevel >= 1) {
            if (savedHeroInventorySlot1 == 0) {
                savedHeroGold -= slot7.price
                savedHeroInventorySlot1 = slot7.itemId
            } else if (savedHeroInventorySlot2 == 0) {
                savedHeroGold -= slot7.price
                savedHeroInventorySlot2 = slot7.itemId
            } else if (savedHeroInventorySlot3 == 0) {
                savedHeroGold -= slot7.price
                savedHeroInventorySlot3 = slot7.itemId
            } else if (savedHeroInventorySlot4 == 0) {
                savedHeroGold -= slot7.price
                savedHeroInventorySlot4 = slot7.itemId
            } else if (savedHeroInventorySlot5 == 0) {
                savedHeroGold -= slot7.price
                savedHeroInventorySlot5 = slot7.itemId
            } else if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
                && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
                Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
            }
        } else if (selectedItemToShop == 8 && savedHeroGold >= slot8.price && savedHeroLevel >= 1) {
            if (savedHeroInventorySlot1 == 0) {
                savedHeroGold -= slot8.price
                savedHeroInventorySlot1 = slot8.itemId
            } else if (savedHeroInventorySlot2 == 0) {
                savedHeroGold -= slot8.price
                savedHeroInventorySlot2 = slot8.itemId
            } else if (savedHeroInventorySlot3 == 0) {
                savedHeroGold -= slot8.price
                savedHeroInventorySlot3 = slot8.itemId
            } else if (savedHeroInventorySlot4 == 0) {
                savedHeroGold -= slot8.price
                savedHeroInventorySlot4 = slot8.itemId
            } else if (savedHeroInventorySlot5 == 0) {
                savedHeroGold -= slot8.price
                savedHeroInventorySlot5 = slot8.itemId
            } else if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
                && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
                Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
            }
        } else if (selectedItemToShop == 9 && savedHeroGold >= slot9.price && savedHeroLevel >= 1) {
            if (savedHeroInventorySlot1 == 0) {
                savedHeroGold -= slot9.price
                savedHeroInventorySlot1 = slot9.itemId
            } else if (savedHeroInventorySlot2 == 0) {
                savedHeroGold -= slot9.price
                savedHeroInventorySlot2 = slot9.itemId
            } else if (savedHeroInventorySlot3 == 0) {
                savedHeroGold -= slot9.price
                savedHeroInventorySlot3 = slot9.itemId
            } else if (savedHeroInventorySlot4 == 0) {
                savedHeroGold -= slot9.price
                savedHeroInventorySlot4 = slot9.itemId
            } else if (savedHeroInventorySlot5 == 0) {
                savedHeroGold -= slot9.price
                savedHeroInventorySlot5 = slot9.itemId
            } else if (savedHeroInventorySlot1 > 0 && savedHeroInventorySlot2 > 0 && savedHeroInventorySlot3 > 0
                && savedHeroInventorySlot4 > 0 && savedHeroInventorySlot5 > 0) {
                Toast.makeText(this, "Your inventory is full!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "You do not have enough gold or your level is too low!", Toast.LENGTH_SHORT).show()
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




        save()

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