package com.example.heroesoftime


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesoftime.adapters.itemInventoryViewAdapter
import com.example.heroesoftime.adapters.itemShopViewAdapter
import com.example.heroesoftime.classes.armorClass
import com.example.heroesoftime.classes.heroDataClass
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class shopsActivity2 : AppCompatActivity(), itemShopViewAdapter.OnBuyClickListener, itemInventoryViewAdapter.OnEquipClickListener, itemInventoryViewAdapter.OnSellClickListener {



    // All items in game (update with any new game items)


        var leatherArmor1 = armorClass(1, "Leather armor", 18, 0, 0, 0, 0, 60, 1)
        var leatherArmor2 = armorClass(2, "Leather armor", 22, 0, 0, 2, 2, 100, 1)
        var leatherArmor3 = armorClass(3, "Leather armor", 15, 2, 0, 0, 0, 80, 1)
        var leatherArmor4 = armorClass(4, "Leather armor", 25, 1, 1, 2, 2, 90, 1)
        var rareLeatherArmor1 = armorClass(5, "Rare leather armor", 38, 5, 2, 1, 3, 220, 1)
        var rareLeatherArmor2 = armorClass(6, "Rare leather armor", 34, 6, 4, 0, 2, 210, 1)


        var leatherRobe1 = armorClass(7, "Leather robe", 5, 1, 0, 0, 0, 20, 2)
        var leatherRobe2 = armorClass(8, "Leather robe", 6, 0, 2, 0, 1, 34, 2)
        var leatherRobe3 = armorClass(9, "Leather robe", 4, 2, 0, 2, 2, 30, 2)
        var leatherRobe4 = armorClass(10, "Leather robe", 8, 2, 2, 2, 0, 50, 2)
        var rareLeatherRobe1 = armorClass(11, "Rare leather robe", 15, 4, 2, 2, 2, 120, 2)
        var rareLeatherRobe2 = armorClass(12, "Rare leather robe", 12, 0, 4, 0, 2, 80, 2)


        var leatherGloves1 = armorClass(13, "Leather gloves", 3, 0, 0, 0, 0, 16, 3)
        var leatherGloves2 = armorClass(14, "Leather gloves", 6, 0, 0, 2, 2, 32, 3)
        var leatherGloves3 = armorClass(15, "Leather gloves", 4, 1, 1, 0, 0, 26, 3)
        var leatherGloves4 = armorClass(16, "Leather gloves", 7, 2, 0, 2, 0, 40, 3)
        var rareLeatherGloves1 = armorClass(17, "Rare leather gloves", 14, 4, 2, 2, 2, 80, 3)
        var rareLeatherGloves2 = armorClass(18, "Rare leather gloves", 13, 3, 6, 0, 0, 70, 3)


        var leatherShoes1 = armorClass(19, "Leather shoes", 8, 1, 0, 0, 0, 40, 4)
        var leatherShoes2 = armorClass(20, "Leather shoes", 12, 0, 3, 0, 2, 70, 4)
        var leatherShoes3 = armorClass(21, "Leather shoes", 15, 2, 2, 0, 0, 80, 4)
        var leatherShoes4 = armorClass(22, "Leather shoes", 19, 2, 0, 2, 2, 90, 4)
        var rareLeatherShoes1 = armorClass(23, "Rare leather shoes", 24, 3, 0, 0, 5, 110, 4)
        var rareLeatherShoes2 = armorClass(24, "Rare leather shoes", 21, 6, 4, 0, 0, 150, 4)


        var leatherShield1 = armorClass(25, "Leather shield", 24, 0, 0, 0, 0, 140, 5)
        var leatherShield2 = armorClass(26, "Leather shield", 29, 1, 0, 0, 0, 170, 5)
        var leatherShield3 = armorClass(27, "Leather shield", 18, 4, 0, 0, 0, 200, 5)
        var leatherShield4 = armorClass(28, "Leather shield", 32, 0, 4, 0, 2, 200, 5)
        var rareLeatherShield1 = armorClass(29, "Rare leather shield", 44, 4, 0, 0, 4, 220, 5)
        var rareLeatherShield2 = armorClass(30, "Rare leather shield", 40, 5, 4, 0, 4, 280, 5)


        var leatherBelt1 = armorClass(31, "Leather belt", 4, 1, 0, 0, 0, 20, 6)
        var leatherBelt2 = armorClass(32, "Leather belt", 7, 0, 0, 0, 2, 24, 6)
        var leatherBelt3 = armorClass(33, "Leather belt", 8, 2, 0, 0, 2, 40, 6)
        var leatherBelt4 = armorClass(34, "Leather belt", 10, 0, 0, 0, 0, 34, 6)
        var rareLeatherBelt1 = armorClass(35, "Rare leather belt", 12, 3, 1, 0, 3, 64, 6)
        var rareLeatherBelt2 = armorClass(36, "Rare leather belt", 18, 2, 6, 0, 0, 94, 6)


        var leatherHelmet1 = armorClass(37, "Leather helmet", 7, 0, 0, 0, 0, 24, 7)
        var leatherHelmet2 = armorClass(38, "Leather helmet", 10, 0, 0, 0, 0, 28, 7)
        var leatherHelmet3 = armorClass(39, "Leather helmet", 11, 2, 0, 2, 0, 42, 7)
        var leatherHelmet4 = armorClass(40, "Leather helmet", 16, 1, 1, 2, 0, 58, 7)
        var rareLeatherHelmet1 = armorClass(41, "Rare leather helmet", 18, 4, 0, 1, 1, 72, 7)
        var rareLeatherHelmet2 = armorClass(42, "Rare leather helmet", 21, 2, 2, 2, 0, 90, 7)


        var knife1 = armorClass(43, "Knife", 3, 0, 0, 0, 0, 28, 8)
        var knife2 = armorClass(44, "Knife", 2, 0, 1, 0, 1, 26, 8)
        var knife3 = armorClass(45, "Knife", 3, 2, 0, 0, 0, 48, 8)
        var bow1 = armorClass(46, "Bow", 6, 0, 2, 0, 2, 122, 8)
        var bow2 = armorClass(47, "Bow", 6, 0, 0, 0, 2, 90, 8)
        var rareKnife = armorClass(48, "Rare knife", 6, 0, 0, 2, 0, 92, 8)
        var strongBow = armorClass(49, "Strong bow", 18, 2, 1, 2, 0, 280, 8)
        var strongWarknife = armorClass(50, "Strong warknife", 14, 4, 0, 0, 0, 240, 8)
        var sword = armorClass(51, "Sword", 16, 0, 0, 0, 0, 190, 8)
        var throwingKnifes1 = armorClass(52, "Throwing knifes", 4, 0, 0, 0, 0, 32, 8)
        var throwingKnifes2 = armorClass(53, "Throwing knifes", 5, 0, 0, 0, 0, 48, 8)
        var throwingKnifes3 = armorClass(54, "Throwing knifes", 4, 0, 4, 0, 0, 68, 8)
        var warKnife1 = armorClass(55, "War knife", 8, 0, 0, 0, 0, 64, 8)
        var warKnife2 = armorClass(56, "War knife", 8, 1, 0, 0, 0, 92, 8)


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





    private lateinit var recyclerViewArmorShop: RecyclerView
    private lateinit var listOfArmorShopRecyclerView: ArrayList<armorClass>
    private lateinit var armorShopRecyclerViewAdapter: itemShopViewAdapter
    private lateinit var recyclerViewInventoryItem: RecyclerView
    private lateinit var listOfInventoryItemRecyclerView: ArrayList<armorClass>
    private lateinit var itemInventoryRecyclerViewAdapter: itemInventoryViewAdapter

    lateinit var auth: FirebaseAuth
    lateinit var database: FirebaseFirestore

    lateinit var savedArmorShopItems : armorClass
    lateinit var savedItemInventory : armorClass
    lateinit var savedDataOfUser : heroDataClass
    lateinit var allGameArmors : ArrayList<armorClass>


    lateinit var refreshBtn: Button

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



    var heroData = heroDataClass("", 0, 0, 0, "", 0,
        0.0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0,
        0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0)



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops2)


        refreshBtn = findViewById(R.id.refreshBtn)
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



        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser



        // Adding all game items in list
        allGameArmors = arrayListOf()
        addAllGameArmorsInList()


        // RecyclerView of shop
        recyclerViewArmorShop = findViewById(R.id.recyclerViewArmorShop)
        recyclerViewArmorShop.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerViewArmorShop.setHasFixedSize(true)
        listOfArmorShopRecyclerView = arrayListOf()
        armorShopRecyclerViewAdapter = itemShopViewAdapter(listOfArmorShopRecyclerView)
        armorShopRecyclerViewAdapter.setOnBuyClickListener(this)
        recyclerViewArmorShop.adapter = armorShopRecyclerViewAdapter

        // RecyclerView of inventory
        recyclerViewInventoryItem = findViewById(R.id.recyclerViewInventoryItem)
        recyclerViewInventoryItem.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerViewInventoryItem.setHasFixedSize(true)
        listOfInventoryItemRecyclerView = arrayListOf()
        itemInventoryRecyclerViewAdapter = itemInventoryViewAdapter(listOfInventoryItemRecyclerView)
        itemInventoryRecyclerViewAdapter.setOnEquipClickListener(this)
        itemInventoryRecyclerViewAdapter.setOnSellClickListener(this)
        recyclerViewInventoryItem.adapter = itemInventoryRecyclerViewAdapter




        // Create random items for the first visit
        val sharedFirstVisitShop1 = getSharedPreferences("sharedFirstVisitShop1", AppCompatActivity.MODE_PRIVATE)
        var firstTimeShop1 = sharedFirstVisitShop1.getBoolean("sharedFirstVisitShop1", true)
        if (firstTimeShop1) {
            sharedFirstVisitShop1.edit().putBoolean("sharedFirstVisitShop1", false).apply()
            generateRandomArmorItems()
        }



        // Fetch all armors in shop and display
        if (user != null) {
            database.collection("users").document(user.uid).collection("userData")
                .document("Shop1").collection("ArmorShop")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        listOfArmorShopRecyclerView.clear()
                        armorShopRecyclerViewAdapter.notifyDataSetChanged()
                        for (document in snapshot.documents) {
                            savedArmorShopItems = document.toObject()!!
                            listOfArmorShopRecyclerView.add(savedArmorShopItems)
                        }
                        armorShopRecyclerViewAdapter.notifyDataSetChanged()
                    }
                }
        }



        // fetch items in inventory and display
        if (user != null) {
            database.collection("users").document(user.uid)
                .collection("userData").document("inventory")
                .collection("itemsInventory").addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        listOfInventoryItemRecyclerView.clear()
                        itemInventoryRecyclerViewAdapter.notifyDataSetChanged()
                        for (document in snapshot.documents) {
                            savedItemInventory = document.toObject()!!
                            listOfInventoryItemRecyclerView.add(savedItemInventory)
                        }
                        itemInventoryRecyclerViewAdapter.notifyDataSetChanged()

                    }
                }
        }






        // Fetch hero data and display equipped items (update with all existing items in game)
        if (user != null) {
            database.collection("users").document(user.uid).collection("userData")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {
                            savedDataOfUser = document.toObject()!!
                            heroData = savedDataOfUser
                       //     if (heroData.heroArmorId)
                                when (heroData.heroArmorId) {
                                    in 1..4 -> heroArmorSlot.setImageResource(R.drawable.leatherarmor)
                                    in 5..6 -> heroArmorSlot.setImageResource(R.drawable.rareleatherarmor)
                                    else -> {
                                        heroArmorSlot.setImageResource(R.drawable.foursquare)
                                    }
                                }
                            when (heroData.heroRobeId) {
                                in 7..10 -> heroRobeSlot.setImageResource(R.drawable.leatherrobe)
                                in 11..12 -> heroRobeSlot.setImageResource(R.drawable.rareleatherrobe)
                                else -> {
                                    heroRobeSlot.setImageResource(R.drawable.foursquare)
                                }
                            }
                            when (heroData.heroGloveId) {
                                in 13..16 -> heroGloveSlot.setImageResource(R.drawable.leathergloves)
                                in 17..18 -> heroGloveSlot.setImageResource(R.drawable.rareleathergloves)
                                else -> {
                                    heroGloveSlot.setImageResource(R.drawable.foursquare)
                                }
                            }
                            when (heroData.heroShoesId) {
                                in 19..22 -> heroShoesSlot.setImageResource(R.drawable.leathershoes)
                                in 23..24 -> heroShoesSlot.setImageResource(R.drawable.rareleathershoes)
                                else -> {
                                    heroShoesSlot.setImageResource(R.drawable.foursquare)
                                }
                            }
                            when (heroData.heroShieldId) {
                                in 25..28 -> heroShieldSlot.setImageResource(R.drawable.leathershield)
                                in 29..30 -> heroShieldSlot.setImageResource(R.drawable.rareleathershield)
                                else -> {
                                    heroShieldSlot.setImageResource(R.drawable.foursquare)
                                }
                            }
                            when (heroData.heroBeltId) {
                                in 31..34 -> heroBeltSlot.setImageResource(R.drawable.leatherbelt)
                                in 35..36 -> heroBeltSlot.setImageResource(R.drawable.rareleatherbelt)
                                else -> {
                                    heroBeltSlot.setImageResource(R.drawable.foursquare)
                                }
                            }
                            when (heroData.heroHelmetId) {
                                in 37..40 -> heroHelmetSlot.setImageResource(R.drawable.leatherhat)
                                in 41..42 -> heroHelmetSlot.setImageResource(R.drawable.rareleatherhat)
                                else -> {
                                    heroHelmetSlot.setImageResource(R.drawable.foursquare)
                                }
                            }
                            when (heroData.heroRingId1) {
                                in 57..59 -> heroRingSlot1.setImageResource(R.drawable.pinkring)
                                in 60..61 -> heroRingSlot1.setImageResource(R.drawable.rarepinkring)
                                else -> {
                                    heroRingSlot1.setImageResource(R.drawable.foursquare)
                                }
                            }
                            when (heroData.heroRingId2) {
                                in 57..59 -> heroRingSlot2.setImageResource(R.drawable.pinkring)
                                in 60..61 -> heroRingSlot2.setImageResource(R.drawable.rarepinkring)
                                else -> {
                                    heroRingSlot2.setImageResource(R.drawable.foursquare)
                                }
                            }
                            when (heroData.heroAmuletId) {
                                in 62..64 -> heroAmuletSlot.setImageResource(R.drawable.amulet)
                                in 65..66 -> heroAmuletSlot.setImageResource(R.drawable.rareamulet)
                                else -> {
                                    heroAmuletSlot.setImageResource(R.drawable.foursquare)
                                }
                            }
                            when (heroData.heroWeaponId) {
                                in 43..45 -> heroWeaponSlot.setImageResource(R.drawable.knife)
                                in 46..47 -> heroWeaponSlot.setImageResource(R.drawable.bow)
                                48 -> heroWeaponSlot.setImageResource(R.drawable.rareknife)
                                49 -> heroWeaponSlot.setImageResource(R.drawable.strongbow)
                                50 -> heroWeaponSlot.setImageResource(R.drawable.strongwarknife)
                                51 -> heroWeaponSlot.setImageResource(R.drawable.sword)
                                in 52..54 -> heroWeaponSlot.setImageResource(R.drawable.throwingknives)
                                in 55..56 -> heroWeaponSlot.setImageResource(R.drawable.warknife)
                                else -> {
                                    heroWeaponSlot.setImageResource(R.drawable.foursquare)
                                }
                            }
                        }
                    }
                }
        }






        refreshBtn.setOnClickListener {
            generateRandomArmorItems()
        }






    }


    fun saveHeroData() {

        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser


        if (user != null) {
            database.collection("users").document(user.uid).collection("userData")
                .document("Hero").set(heroData)
                .addOnSuccessListener {

                }
        }
    }






    override fun onBuyClick(armor: armorClass) {
        if (heroData.heroGold >= armor.price) {
            heroData.heroGold -= armor.price

            database = Firebase.firestore
            auth = Firebase.auth
            val user = auth.currentUser
            var isOneItemDeleted = false


            if (user != null) {
                val userId = user.uid
                val armorShopCollection = database.collection("users").document(userId)
                    .collection("userData").document("Shop1").collection("ArmorShop")
                armorShopCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedArmorShopItems = document.toObject()!!
                            if (savedArmorShopItems.itemId == armor.itemId && savedArmorShopItems.armorName
                                == armor.armorName && savedArmorShopItems.armor == armor.armor
                                && savedArmorShopItems.vitality == armor.vitality
                                && savedArmorShopItems.strenght == armor.strenght
                                && savedArmorShopItems.mana == armor.mana
                                && savedArmorShopItems.speed == armor.speed
                                && savedArmorShopItems.price == armor.price
                                && savedArmorShopItems.typeItem == armor.typeItem && !isOneItemDeleted) {
                                armorShopCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // add the shopped item to inventory
                        database.collection("users").document(userId)
                            .collection("userData").document("inventory")
                            .collection("itemsInventory").add(armor)

                    }
            }
            saveHeroData()
        } else {
            Toast.makeText(this, "Not enough money", Toast.LENGTH_SHORT).show()
        }
    }





    // Copy to the other shops, no updates required
    override fun onEquipClick(item: armorClass) {

        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser
        var isSecondRingInsertable = true







        if (item.typeItem == 1 && heroData.heroArmorId == 0) {

            var isOneItemDeleted = false


            if (user != null) {
                val userId = user.uid
                val itemsInventoryCollection = database.collection("users").document(userId)
                    .collection("userData").document("inventory")
                    .collection("itemsInventory")
                itemsInventoryCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedItemInventory = document.toObject()!!
                            if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                == item.armorName && savedItemInventory.armor == item.armor
                                && savedItemInventory.vitality == item.vitality
                                && savedItemInventory.strenght == item.strenght
                                && savedItemInventory.mana == item.mana
                                && savedItemInventory.speed == item.speed
                                && savedItemInventory.price == item.price
                                && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted) {
                                itemsInventoryCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // equip item on hero and save hero data
                        heroData.heroArmorId = item.itemId
                        saveHeroData()

                    }
            }

        } else if (item.typeItem == 2 && heroData.heroRobeId == 0) {
            var isOneItemDeleted = false
            if (user != null) {
                val userId = user.uid
                val itemsInventoryCollection = database.collection("users").document(userId)
                    .collection("userData").document("inventory")
                    .collection("itemsInventory")
                itemsInventoryCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedItemInventory = document.toObject()!!
                            if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                == item.armorName && savedItemInventory.armor == item.armor
                                && savedItemInventory.vitality == item.vitality
                                && savedItemInventory.strenght == item.strenght
                                && savedItemInventory.mana == item.mana
                                && savedItemInventory.speed == item.speed
                                && savedItemInventory.price == item.price
                                && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted) {
                                itemsInventoryCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // equip item on hero and save hero data
                        heroData.heroRobeId = item.itemId
                        saveHeroData()

                    }
            }
        } else if (item.typeItem == 3 && heroData.heroGloveId == 0) {
            var isOneItemDeleted = false
            if (user != null) {
                val userId = user.uid
                val itemsInventoryCollection = database.collection("users").document(userId)
                    .collection("userData").document("inventory")
                    .collection("itemsInventory")
                itemsInventoryCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedItemInventory = document.toObject()!!
                            if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                == item.armorName && savedItemInventory.armor == item.armor
                                && savedItemInventory.vitality == item.vitality
                                && savedItemInventory.strenght == item.strenght
                                && savedItemInventory.mana == item.mana
                                && savedItemInventory.speed == item.speed
                                && savedItemInventory.price == item.price
                                && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted) {
                                itemsInventoryCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // equip item on hero and save hero data
                        heroData.heroGloveId = item.itemId
                        saveHeroData()

                    }
            }
        } else if (item.typeItem == 4 && heroData.heroShoesId == 0) {
            var isOneItemDeleted = false
            if (user != null) {
                val userId = user.uid
                val itemsInventoryCollection = database.collection("users").document(userId)
                    .collection("userData").document("inventory")
                    .collection("itemsInventory")
                itemsInventoryCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedItemInventory = document.toObject()!!
                            if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                == item.armorName && savedItemInventory.armor == item.armor
                                && savedItemInventory.vitality == item.vitality
                                && savedItemInventory.strenght == item.strenght
                                && savedItemInventory.mana == item.mana
                                && savedItemInventory.speed == item.speed
                                && savedItemInventory.price == item.price
                                && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted) {
                                itemsInventoryCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // equip item on hero and save hero data
                        heroData.heroShoesId = item.itemId
                        saveHeroData()

                    }
            }
        } else if (item.typeItem == 5 && heroData.heroShieldId == 0) {
            var isOneItemDeleted = false
            if (user != null) {
                val userId = user.uid
                val itemsInventoryCollection = database.collection("users").document(userId)
                    .collection("userData").document("inventory")
                    .collection("itemsInventory")
                itemsInventoryCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedItemInventory = document.toObject()!!
                            if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                == item.armorName && savedItemInventory.armor == item.armor
                                && savedItemInventory.vitality == item.vitality
                                && savedItemInventory.strenght == item.strenght
                                && savedItemInventory.mana == item.mana
                                && savedItemInventory.speed == item.speed
                                && savedItemInventory.price == item.price
                                && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted) {
                                itemsInventoryCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // equip item on hero and save hero data
                        heroData.heroShieldId = item.itemId
                        saveHeroData()

                    }
            }
        } else if (item.typeItem == 6 && heroData.heroBeltId == 0) {
            var isOneItemDeleted = false
            if (user != null) {
                val userId = user.uid
                val itemsInventoryCollection = database.collection("users").document(userId)
                    .collection("userData").document("inventory")
                    .collection("itemsInventory")
                itemsInventoryCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedItemInventory = document.toObject()!!
                            if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                == item.armorName && savedItemInventory.armor == item.armor
                                && savedItemInventory.vitality == item.vitality
                                && savedItemInventory.strenght == item.strenght
                                && savedItemInventory.mana == item.mana
                                && savedItemInventory.speed == item.speed
                                && savedItemInventory.price == item.price
                                && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted) {
                                itemsInventoryCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // equip item on hero and save hero data
                        heroData.heroBeltId = item.itemId
                        saveHeroData()

                    }
            }
        } else if (item.typeItem == 7 && heroData.heroHelmetId == 0) {
            var isOneItemDeleted = false
            if (user != null) {
                val userId = user.uid
                val itemsInventoryCollection = database.collection("users").document(userId)
                    .collection("userData").document("inventory")
                    .collection("itemsInventory")
                itemsInventoryCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedItemInventory = document.toObject()!!
                            if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                == item.armorName && savedItemInventory.armor == item.armor
                                && savedItemInventory.vitality == item.vitality
                                && savedItemInventory.strenght == item.strenght
                                && savedItemInventory.mana == item.mana
                                && savedItemInventory.speed == item.speed
                                && savedItemInventory.price == item.price
                                && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted) {
                                itemsInventoryCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // equip item on hero and save hero data
                        heroData.heroHelmetId = item.itemId
                        saveHeroData()

                    }
            }
        }  else if (item.typeItem == 8 && heroData.heroWeaponId == 0) {
            var isOneItemDeleted = false
            if (user != null) {
                val userId = user.uid
                val itemsInventoryCollection = database.collection("users").document(userId)
                    .collection("userData").document("inventory")
                    .collection("itemsInventory")
                itemsInventoryCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedItemInventory = document.toObject()!!
                            if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                == item.armorName && savedItemInventory.armor == item.armor
                                && savedItemInventory.vitality == item.vitality
                                && savedItemInventory.strenght == item.strenght
                                && savedItemInventory.mana == item.mana
                                && savedItemInventory.speed == item.speed
                                && savedItemInventory.price == item.price
                                && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted) {
                                itemsInventoryCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // equip item on hero and save hero data
                        heroData.heroWeaponId = item.itemId
                        saveHeroData()

                    }
            }
        } else if (item.typeItem == 9 && heroData.heroRingId1 == 0) {
            var isOneItemDeleted = false
            if (user != null) {
                val userId = user.uid
                val itemsInventoryCollection = database.collection("users").document(userId)
                    .collection("userData").document("inventory")
                    .collection("itemsInventory")
                itemsInventoryCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedItemInventory = document.toObject()!!
                            if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                == item.armorName && savedItemInventory.armor == item.armor
                                && savedItemInventory.vitality == item.vitality
                                && savedItemInventory.strenght == item.strenght
                                && savedItemInventory.mana == item.mana
                                && savedItemInventory.speed == item.speed
                                && savedItemInventory.price == item.price
                                && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted) {
                                itemsInventoryCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // equip item on hero and save hero data
                        heroData.heroRingId1 = item.itemId
                        isSecondRingInsertable = false
                        saveHeroData()

                    }
            }
        } else if (item.typeItem == 9 && heroData.heroRingId1 > 0) {
            if (heroData.heroRingId2 == 0 && isSecondRingInsertable) {
                var isOneItemDeleted = false
                if (user != null) {
                    val userId = user.uid
                    val itemsInventoryCollection = database.collection("users").document(userId)
                        .collection("userData").document("inventory")
                        .collection("itemsInventory")
                    itemsInventoryCollection.get()
                        .addOnSuccessListener { documents ->
                            for (document in documents) {
                                savedItemInventory = document.toObject()!!
                                if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                    == item.armorName && savedItemInventory.armor == item.armor
                                    && savedItemInventory.vitality == item.vitality
                                    && savedItemInventory.strenght == item.strenght
                                    && savedItemInventory.mana == item.mana
                                    && savedItemInventory.speed == item.speed
                                    && savedItemInventory.price == item.price
                                    && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted
                                ) {
                                    itemsInventoryCollection.document(document.id).delete()
                                    isOneItemDeleted = true
                                }
                            }

                            // equip item on hero and save hero data
                            heroData.heroRingId2 = item.itemId
                            saveHeroData()

                        }
                }
            } else {
                Toast.makeText(this, "Unequip the corresponding item first", Toast.LENGTH_SHORT).show()
            }
        } else if (item.typeItem == 10 && heroData.heroAmuletId == 0) {
            var isOneItemDeleted = false
            if (user != null) {
                val userId = user.uid
                val itemsInventoryCollection = database.collection("users").document(userId)
                    .collection("userData").document("inventory")
                    .collection("itemsInventory")
                itemsInventoryCollection.get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            savedItemInventory = document.toObject()!!
                            if (savedItemInventory.itemId == item.itemId && savedItemInventory.armorName
                                == item.armorName && savedItemInventory.armor == item.armor
                                && savedItemInventory.vitality == item.vitality
                                && savedItemInventory.strenght == item.strenght
                                && savedItemInventory.mana == item.mana
                                && savedItemInventory.speed == item.speed
                                && savedItemInventory.price == item.price
                                && savedItemInventory.typeItem == item.typeItem && !isOneItemDeleted) {
                                itemsInventoryCollection.document(document.id).delete()
                                isOneItemDeleted = true
                            }
                        }

                        // equip item on hero and save hero data
                        heroData.heroAmuletId = item.itemId
                        saveHeroData()

                    }
            }
        } else {
            Toast.makeText(this, "Unequip the corresponding item first", Toast.LENGTH_SHORT).show()
        }







    }




    override fun onSellClick(item: armorClass) {

    }



    // update when adding new order shops

    fun generateRandomArmorItems() {

        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser


        if (user != null) {
            val userId = user.uid
            val armorShopCollection = database.collection("users").document(userId)
                .collection("userData").document("Shop1").collection("ArmorShop")
            armorShopCollection.get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        armorShopCollection.document(document.id).delete()
                    }
                }
        }




        var loopStop = 0

        while (true) {
            val randomN = (0..41).random()
            val armor = armorClass(allGameArmors[randomN].itemId, allGameArmors[randomN].armorName,
                allGameArmors[randomN].armor, allGameArmors[randomN].vitality, allGameArmors[randomN].speed,
                allGameArmors[randomN].mana, allGameArmors[randomN].strenght,
                allGameArmors[randomN].price, allGameArmors[randomN].typeItem)

            if (user != null) {
                database.collection("users").document(user.uid).collection("userData")
                    .document("Shop1").collection("ArmorShop").add(armor)
                    .addOnSuccessListener {

                    }
            }

            loopStop++

            if (loopStop == 9) {
                break
            }
        }

        loopStop = 0

        while (true) {
            val randomN = (42..55).random()
            val armor = armorClass(allGameArmors[randomN].itemId, allGameArmors[randomN].armorName,
                allGameArmors[randomN].armor, allGameArmors[randomN].vitality, allGameArmors[randomN].speed,
                allGameArmors[randomN].mana, allGameArmors[randomN].strenght,
                allGameArmors[randomN].price, allGameArmors[randomN].typeItem)

            if (user != null) {
                database.collection("users").document(user.uid).collection("userData")
                    .document("Shop1").collection("ArmorShop").add(armor)
                    .addOnSuccessListener {

                    }
            }

            loopStop++

            if (loopStop == 9) {
                break
            }
        }

        loopStop = 0

        while (true) {
            val randomN = (56..65).random()
            val armor = armorClass(allGameArmors[randomN].itemId, allGameArmors[randomN].armorName,
                allGameArmors[randomN].armor, allGameArmors[randomN].vitality, allGameArmors[randomN].speed,
                allGameArmors[randomN].mana, allGameArmors[randomN].strenght,
                allGameArmors[randomN].price, allGameArmors[randomN].typeItem)

            if (user != null) {
                database.collection("users").document(user.uid).collection("userData")
                    .document("Shop1").collection("ArmorShop").add(armor)
                    .addOnSuccessListener {

                    }
            }

            loopStop++

            if (loopStop == 9) {
                break
            }
        }


    }



    // add all game items in global list (update with all new game items)
    fun addAllGameArmorsInList() {

        allGameArmors.add(leatherArmor1)
        allGameArmors.add(leatherArmor2)
        allGameArmors.add(leatherArmor3)
        allGameArmors.add(leatherArmor4)
        allGameArmors.add(rareLeatherArmor1)
        allGameArmors.add(rareLeatherArmor2)

        allGameArmors.add(leatherBelt1)
        allGameArmors.add(leatherBelt2)
        allGameArmors.add(leatherBelt3)
        allGameArmors.add(leatherBelt4)
        allGameArmors.add(rareLeatherBelt1)
        allGameArmors.add(rareLeatherBelt2)

        allGameArmors.add(leatherHelmet1)
        allGameArmors.add(leatherHelmet2)
        allGameArmors.add(leatherHelmet3)
        allGameArmors.add(leatherHelmet4)
        allGameArmors.add(rareLeatherHelmet1)
        allGameArmors.add(rareLeatherHelmet2)

        allGameArmors.add(leatherGloves1)
        allGameArmors.add(leatherGloves2)
        allGameArmors.add(leatherGloves3)
        allGameArmors.add(leatherGloves4)
        allGameArmors.add(rareLeatherGloves1)
        allGameArmors.add(rareLeatherGloves2)

        allGameArmors.add(leatherRobe1)
        allGameArmors.add(leatherRobe2)
        allGameArmors.add(leatherRobe3)
        allGameArmors.add(leatherRobe4)
        allGameArmors.add(rareLeatherRobe1)
        allGameArmors.add(rareLeatherRobe2)

        allGameArmors.add(leatherShoes1)
        allGameArmors.add(leatherShoes2)
        allGameArmors.add(leatherShoes3)
        allGameArmors.add(leatherShoes4)
        allGameArmors.add(rareLeatherShoes1)
        allGameArmors.add(rareLeatherShoes2)

        allGameArmors.add(leatherShield1)
        allGameArmors.add(leatherShield2)
        allGameArmors.add(leatherShield3)
        allGameArmors.add(leatherShield4)
        allGameArmors.add(rareLeatherShield1)
        allGameArmors.add(rareLeatherShield2)  // 42 0bjects (0..41)

        allGameArmors.add(knife1)
        allGameArmors.add(knife2)
        allGameArmors.add(knife3)
        allGameArmors.add(warKnife1)
        allGameArmors.add(warKnife2)
        allGameArmors.add(bow1)
        allGameArmors.add(bow2)
        allGameArmors.add(throwingKnifes1)
        allGameArmors.add(throwingKnifes2)
        allGameArmors.add(throwingKnifes3)
        allGameArmors.add(strongBow)
        allGameArmors.add(rareKnife)
        allGameArmors.add(strongWarknife)
        allGameArmors.add(sword) // 55 (42..55)



        allGameArmors.add(pinkRing1)
        allGameArmors.add(pinkRing2)
        allGameArmors.add(pinkRing3)
        allGameArmors.add(rarePinkRing1)
        allGameArmors.add(rarePinkRing2)

        allGameArmors.add(amulet1)
        allGameArmors.add(amulet2)
        allGameArmors.add(amulet3)
        allGameArmors.add(rareAmulet1)
        allGameArmors.add(rareAmulet2) // 65 (56..65)






    }







}