package com.example.heroesoftime

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
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
    var leatherRobe2 = armorClass(8, "Leather robe", 6, 0,2,0,1, 35, 2)
    var leatherRobe3 = armorClass(9, "Leather robe", 4, 2, 0, 2, 2, 30, 2)
    var leatherRobe4 = armorClass(10, "Leather robe", 8, 2,2,2,0, 50, 2)
    var rareLeatherRobe1 = armorClass(11, "Rare leather robe", 15, 4, 2, 2, 2, 120, 2)
    var rareLeatherRobe2 = armorClass(12, "Rare leather robe", 12, 0,4,0,2, 80, 2)


    var leatherGloves1 = armorClass(13, "Leather gloves", 3, 0, 0, 0, 0, 15, 3)
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
    var leatherBelt2 = armorClass(32, "Leather belt", 7, 0,0,0,2, 25, 6)
    var leatherBelt3 = armorClass(33, "Leather belt", 8, 2, 0, 0, 2, 40, 6)
    var leatherBelt4 = armorClass(34, "Leather belt", 10, 0,0,0,0, 35, 6)
    var rareLeatherBelt1 = armorClass(35, "Rare leather belt", 12, 3, 1, 0, 3, 65, 6)
    var rareLeatherBelt2 = armorClass(36, "Rare leather belt", 18, 2,6,0,0, 95, 6)



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


    lateinit var listOfAllArmors : ArrayList<armorClass>
    lateinit var listOfAllWeapons : ArrayList<weaponClass>
    lateinit var listOfArmorItems : ArrayList<armorClass>
    lateinit var listOfWeaponItems : ArrayList<weaponClass>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)


        listOfAllArmors = arrayListOf()
        listOfAllWeapons = arrayListOf()
        listOfArmorItems = arrayListOf()
        listOfWeaponItems = arrayListOf()



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





        val sharedSelectorShopType = getSharedPreferences("SelectorShopType", AppCompatActivity.MODE_PRIVATE)
        var selectedShopType = sharedSelectorShopType.getInt("SelectorShopType", 0)




        if (selectedShopType == 1) {
            generateRandomArmorItems()
        } else if (selectedShopType == 2) {
            generateRandomWeaponItems()
        }



        heroArmorSlot.setOnClickListener {
            nameTxt.text = "${heroArmorSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroArmorSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroArmorSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroArmorSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroArmorSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroArmorSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroArmorSlotAtributes.price}"

        }

        heroRobeSlot.setOnClickListener {
            nameTxt.text = "${heroRobeSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroRobeSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroRobeSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroRobeSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroRobeSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroRobeSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroRobeSlotAtributes.price}"

        }

        heroGloveSlot.setOnClickListener {
            nameTxt.text = "${heroGloveSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroGloveSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroGloveSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroGloveSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroGloveSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroGloveSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroGloveSlotAtributes.price}"

        }

        heroShoesSlot.setOnClickListener {
            nameTxt.text = "${heroShoesSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroShoesSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroShoesSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroShoesSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroShoesSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroShoesSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroShoesSlotAtributes.price}"

        }

        heroShieldSlot.setOnClickListener {
            nameTxt.text = "${heroShieldSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroShieldSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroShieldSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroShieldSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroShieldSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroShieldSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroShieldSlotAtributes.price}"

        }

        heroBeltSlot.setOnClickListener {
            nameTxt.text = "${heroBeltSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroBeltSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroBeltSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroBeltSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroBeltSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroBeltSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroBeltSlotAtributes.price}"

        }

        heroHelmetSlot.setOnClickListener {
            nameTxt.text = "${heroHelmetSlotAtributes.armorName}"
            armorTxt.text = "Armor: ${heroHelmetSlotAtributes.armor}"
            vitalityTxt.text = "Vitality: ${heroHelmetSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroHelmetSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroHelmetSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroHelmetSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroHelmetSlotAtributes.price}"

        }

        heroWeaponSlot.setOnClickListener {
            nameTxt.text = "${heroWeaponSlotAtributes.weaponName}"
            armorTxt.text = "Damage: ${heroWeaponSlotAtributes.damage}"
            vitalityTxt.text = "Vitality: ${heroWeaponSlotAtributes.vitality}"
            strenghtTxt.text = "Strenght: ${heroWeaponSlotAtributes.strenght}"
            speedTxt.text = "Speed: ${heroWeaponSlotAtributes.speed}"
            manaTxt.text = "Mana: ${heroWeaponSlotAtributes.mana}"
            priceTxt.text = "Price: ${heroWeaponSlotAtributes.price}"

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




        showHeroItems()




    }




    fun showHeroInventory() {

        // snapshot saved items that hero has in inventory
        var savedItemInventorySlot1 = 6
        var savedItemInventorySlot2 = 7
        var savedItemInventorySlot3 = 18
        var savedItemInventorySlot4 = 19
        var savedItemInventorySlot5 = 30







    }





    fun showHeroItems() {

        // snapshot saved items that hero is wearing
        var savedArmor = 6
        var savedRobe = 7
        var savedGloves = 18
        var savedShoes = 19
        var savedShield = 30
        var savedBelt = 32
        var savedHelmet = 41
        var savedWeapon = 49




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
                    slot1 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 46..47) {
                    armorSlot1.setImageResource(R.drawable.bow)
                    slot1 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 48) {
                    armorSlot1.setImageResource(R.drawable.rareknife)
                    slot1 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 49) {
                    armorSlot1.setImageResource(R.drawable.strongbow)
                    slot1 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 50) {
                    armorSlot1.setImageResource(R.drawable.strongwarknife)
                    slot1 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 51) {
                    armorSlot1.setImageResource(R.drawable.sword)
                    slot1 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 52..54) {
                    armorSlot1.setImageResource(R.drawable.throwingknives)
                    slot1 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 55..56) {
                    armorSlot1.setImageResource(R.drawable.warknife)
                    slot1 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 1) {
                if (itemId in 43..45) {
                    armorSlot2.setImageResource(R.drawable.knife)
                    slot2 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 46..47) {
                    armorSlot2.setImageResource(R.drawable.bow)
                    slot2 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 48) {
                    armorSlot2.setImageResource(R.drawable.rareknife)
                    slot2 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 49) {
                    armorSlot2.setImageResource(R.drawable.strongbow)
                    slot2 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 50) {
                    armorSlot2.setImageResource(R.drawable.strongwarknife)
                    slot2 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 51) {
                    armorSlot2.setImageResource(R.drawable.sword)
                    slot2 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 52..54) {
                    armorSlot2.setImageResource(R.drawable.throwingknives)
                    slot2 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 55..56) {
                    armorSlot2.setImageResource(R.drawable.warknife)
                    slot2 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 2) {
                if (itemId in 43..45) {
                    armorSlot3.setImageResource(R.drawable.knife)
                    slot3 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 46..47) {
                    armorSlot3.setImageResource(R.drawable.bow)
                    slot3 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 48) {
                    armorSlot3.setImageResource(R.drawable.rareknife)
                    slot3 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 49) {
                    armorSlot3.setImageResource(R.drawable.strongbow)
                    slot3 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 50) {
                    armorSlot3.setImageResource(R.drawable.strongwarknife)
                    slot3 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 51) {
                    armorSlot3.setImageResource(R.drawable.sword)
                    slot3 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 52..54) {
                    armorSlot3.setImageResource(R.drawable.throwingknives)
                    slot3 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 55..56) {
                    armorSlot3.setImageResource(R.drawable.warknife)
                    slot3 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 3) {
                if (itemId in 43..45) {
                    armorSlot4.setImageResource(R.drawable.knife)
                    slot4 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 46..47) {
                    armorSlot4.setImageResource(R.drawable.bow)
                    slot4 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 48) {
                    armorSlot4.setImageResource(R.drawable.rareknife)
                    slot4 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 49) {
                    armorSlot4.setImageResource(R.drawable.strongbow)
                    slot4 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 50) {
                    armorSlot4.setImageResource(R.drawable.strongwarknife)
                    slot4 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 51) {
                    armorSlot4.setImageResource(R.drawable.sword)
                    slot4 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 52..54) {
                    armorSlot4.setImageResource(R.drawable.throwingknives)
                    slot4 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 55..56) {
                    armorSlot4.setImageResource(R.drawable.warknife)
                    slot4 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 4) {
                if (itemId in 43..45) {
                    armorSlot5.setImageResource(R.drawable.knife)
                    slot5 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 46..47) {
                    armorSlot5.setImageResource(R.drawable.bow)
                    slot5 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 48) {
                    armorSlot5.setImageResource(R.drawable.rareknife)
                    slot5 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 49) {
                    armorSlot5.setImageResource(R.drawable.strongbow)
                    slot5 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 50) {
                    armorSlot5.setImageResource(R.drawable.strongwarknife)
                    slot5 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 51) {
                    armorSlot5.setImageResource(R.drawable.sword)
                    slot5 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 52..54) {
                    armorSlot5.setImageResource(R.drawable.throwingknives)
                    slot5 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 55..56) {
                    armorSlot5.setImageResource(R.drawable.warknife)
                    slot5 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 5) {
                if (itemId in 43..45) {
                    armorSlot6.setImageResource(R.drawable.knife)
                    slot6 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 46..47) {
                    armorSlot6.setImageResource(R.drawable.bow)
                    slot6 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 48) {
                    armorSlot6.setImageResource(R.drawable.rareknife)
                    slot6 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 49) {
                    armorSlot6.setImageResource(R.drawable.strongbow)
                    slot6 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 50) {
                    armorSlot6.setImageResource(R.drawable.strongwarknife)
                    slot6 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId == 51) {
                    armorSlot6.setImageResource(R.drawable.sword)
                    slot6 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 52..54) {
                    armorSlot6.setImageResource(R.drawable.throwingknives)
                    slot6 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 55..56) {
                    armorSlot6.setImageResource(R.drawable.warknife)
                    slot6 = armorClass(itemId, itemName, damageItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
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
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 5..6) {
                    armorSlot1.setImageResource(R.drawable.rareleatherarmor)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 7..10) {
                    armorSlot1.setImageResource(R.drawable.leatherrobe)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 11..12) {
                    armorSlot1.setImageResource(R.drawable.rareleatherrobe)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 13..16) {
                    armorSlot1.setImageResource(R.drawable.leathergloves)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 17..18) {
                    armorSlot1.setImageResource(R.drawable.rareleathergloves)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 19..22) {
                    armorSlot1.setImageResource(R.drawable.leathershoes)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 23..24) {
                    armorSlot1.setImageResource(R.drawable.rareleathershoes)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 25..28) {
                    armorSlot1.setImageResource(R.drawable.leathershield)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 29..30) {
                    armorSlot1.setImageResource(R.drawable.rareleathershield)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 31..34) {
                    armorSlot1.setImageResource(R.drawable.leatherbelt)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }  else if (itemId in 35..36) {
                    armorSlot1.setImageResource(R.drawable.rareleatherbelt)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 37..40) {
                    armorSlot1.setImageResource(R.drawable.leatherhat)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 41..42) {
                    armorSlot1.setImageResource(R.drawable.rareleatherhat)
                    slot1 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 1) {
                if (itemId in 1..4) {
                    armorSlot2.setImageResource(R.drawable.leatherarmor)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 5..6) {
                    armorSlot2.setImageResource(R.drawable.rareleatherarmor)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 7..10) {
                    armorSlot2.setImageResource(R.drawable.leatherrobe)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 11..12) {
                    armorSlot2.setImageResource(R.drawable.rareleatherrobe)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 13..16) {
                    armorSlot2.setImageResource(R.drawable.leathergloves)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 17..18) {
                    armorSlot2.setImageResource(R.drawable.rareleathergloves)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 19..22) {
                    armorSlot2.setImageResource(R.drawable.leathershoes)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 23..24) {
                    armorSlot2.setImageResource(R.drawable.rareleathershoes)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 25..28) {
                    armorSlot2.setImageResource(R.drawable.leathershield)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 29..30) {
                    armorSlot2.setImageResource(R.drawable.rareleathershield)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 31..34) {
                    armorSlot2.setImageResource(R.drawable.leatherbelt)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }  else if (itemId in 35..36) {
                    armorSlot2.setImageResource(R.drawable.rareleatherbelt)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 37..40) {
                    armorSlot2.setImageResource(R.drawable.leatherhat)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 41..42) {
                    armorSlot2.setImageResource(R.drawable.rareleatherhat)
                    slot2 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 2) {
                if (itemId in 1..4) {
                    armorSlot3.setImageResource(R.drawable.leatherarmor)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 5..6) {
                    armorSlot3.setImageResource(R.drawable.rareleatherarmor)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 7..10) {
                    armorSlot3.setImageResource(R.drawable.leatherrobe)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 11..12) {
                    armorSlot3.setImageResource(R.drawable.rareleatherrobe)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 13..16) {
                    armorSlot3.setImageResource(R.drawable.leathergloves)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 17..18) {
                    armorSlot3.setImageResource(R.drawable.rareleathergloves)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 19..22) {
                    armorSlot3.setImageResource(R.drawable.leathershoes)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 23..24) {
                    armorSlot3.setImageResource(R.drawable.rareleathershoes)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 25..28) {
                    armorSlot3.setImageResource(R.drawable.leathershield)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 29..30) {
                    armorSlot3.setImageResource(R.drawable.rareleathershield)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 31..34) {
                    armorSlot3.setImageResource(R.drawable.leatherbelt)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }  else if (itemId in 35..36) {
                    armorSlot3.setImageResource(R.drawable.rareleatherbelt)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 37..40) {
                    armorSlot3.setImageResource(R.drawable.leatherhat)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 41..42) {
                    armorSlot3.setImageResource(R.drawable.rareleatherhat)
                    slot3 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 3) {
                if (itemId in 1..4) {
                    armorSlot4.setImageResource(R.drawable.leatherarmor)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 5..6) {
                    armorSlot4.setImageResource(R.drawable.rareleatherarmor)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 7..10) {
                    armorSlot4.setImageResource(R.drawable.leatherrobe)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 11..12) {
                    armorSlot4.setImageResource(R.drawable.rareleatherrobe)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 13..16) {
                    armorSlot4.setImageResource(R.drawable.leathergloves)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 17..18) {
                    armorSlot4.setImageResource(R.drawable.rareleathergloves)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 19..22) {
                    armorSlot4.setImageResource(R.drawable.leathershoes)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 23..24) {
                    armorSlot4.setImageResource(R.drawable.rareleathershoes)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 25..28) {
                    armorSlot4.setImageResource(R.drawable.leathershield)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 29..30) {
                    armorSlot4.setImageResource(R.drawable.rareleathershield)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 31..34) {
                    armorSlot4.setImageResource(R.drawable.leatherbelt)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }  else if (itemId in 35..36) {
                    armorSlot4.setImageResource(R.drawable.rareleatherbelt)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 37..40) {
                    armorSlot4.setImageResource(R.drawable.leatherhat)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 41..42) {
                    armorSlot4.setImageResource(R.drawable.rareleatherhat)
                    slot4 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 4) {
                if (itemId in 1..4) {
                    armorSlot5.setImageResource(R.drawable.leatherarmor)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 5..6) {
                    armorSlot5.setImageResource(R.drawable.rareleatherarmor)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 7..10) {
                    armorSlot5.setImageResource(R.drawable.leatherrobe)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 11..12) {
                    armorSlot5.setImageResource(R.drawable.rareleatherrobe)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 13..16) {
                    armorSlot5.setImageResource(R.drawable.leathergloves)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 17..18) {
                    armorSlot5.setImageResource(R.drawable.rareleathergloves)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 19..22) {
                    armorSlot5.setImageResource(R.drawable.leathershoes)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 23..24) {
                    armorSlot5.setImageResource(R.drawable.rareleathershoes)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 25..28) {
                    armorSlot5.setImageResource(R.drawable.leathershield)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 29..30) {
                    armorSlot5.setImageResource(R.drawable.rareleathershield)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 31..34) {
                    armorSlot5.setImageResource(R.drawable.leatherbelt)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }  else if (itemId in 35..36) {
                    armorSlot5.setImageResource(R.drawable.rareleatherbelt)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 37..40) {
                    armorSlot5.setImageResource(R.drawable.leatherhat)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 41..42) {
                    armorSlot5.setImageResource(R.drawable.rareleatherhat)
                    slot5 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 5) {
                if (itemId in 1..4) {
                    armorSlot6.setImageResource(R.drawable.leatherarmor)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 5..6) {
                    armorSlot6.setImageResource(R.drawable.rareleatherarmor)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 7..10) {
                    armorSlot6.setImageResource(R.drawable.leatherrobe)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 11..12) {
                    armorSlot6.setImageResource(R.drawable.rareleatherrobe)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 13..16) {
                    armorSlot6.setImageResource(R.drawable.leathergloves)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 17..18) {
                    armorSlot6.setImageResource(R.drawable.rareleathergloves)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 19..22) {
                    armorSlot6.setImageResource(R.drawable.leathershoes)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 23..24) {
                    armorSlot6.setImageResource(R.drawable.rareleathershoes)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 25..28) {
                    armorSlot6.setImageResource(R.drawable.leathershield)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 29..30) {
                    armorSlot6.setImageResource(R.drawable.rareleathershield)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 31..34) {
                    armorSlot6.setImageResource(R.drawable.leatherbelt)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }  else if (itemId in 35..36) {
                    armorSlot6.setImageResource(R.drawable.rareleatherbelt)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 37..40) {
                    armorSlot6.setImageResource(R.drawable.leatherhat)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 41..42) {
                    armorSlot6.setImageResource(R.drawable.rareleatherhat)
                    slot6 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 6) {
                if (itemId in 1..4) {
                    armorSlot7.setImageResource(R.drawable.leatherarmor)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 5..6) {
                    armorSlot7.setImageResource(R.drawable.rareleatherarmor)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 7..10) {
                    armorSlot7.setImageResource(R.drawable.leatherrobe)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 11..12) {
                    armorSlot7.setImageResource(R.drawable.rareleatherrobe)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 13..16) {
                    armorSlot7.setImageResource(R.drawable.leathergloves)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 17..18) {
                    armorSlot7.setImageResource(R.drawable.rareleathergloves)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 19..22) {
                    armorSlot7.setImageResource(R.drawable.leathershoes)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 23..24) {
                    armorSlot7.setImageResource(R.drawable.rareleathershoes)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 25..28) {
                    armorSlot7.setImageResource(R.drawable.leathershield)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 29..30) {
                    armorSlot7.setImageResource(R.drawable.rareleathershield)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 31..34) {
                    armorSlot7.setImageResource(R.drawable.leatherbelt)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }  else if (itemId in 35..36) {
                    armorSlot7.setImageResource(R.drawable.rareleatherbelt)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 37..40) {
                    armorSlot7.setImageResource(R.drawable.leatherhat)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 41..42) {
                    armorSlot7.setImageResource(R.drawable.rareleatherhat)
                    slot7 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 7) {
                if (itemId in 1..4) {
                    armorSlot8.setImageResource(R.drawable.leatherarmor)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 5..6) {
                    armorSlot8.setImageResource(R.drawable.rareleatherarmor)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 7..10) {
                    armorSlot8.setImageResource(R.drawable.leatherrobe)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 11..12) {
                    armorSlot8.setImageResource(R.drawable.rareleatherrobe)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 13..16) {
                    armorSlot8.setImageResource(R.drawable.leathergloves)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 17..18) {
                    armorSlot8.setImageResource(R.drawable.rareleathergloves)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 19..22) {
                    armorSlot8.setImageResource(R.drawable.leathershoes)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 23..24) {
                    armorSlot8.setImageResource(R.drawable.rareleathershoes)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 25..28) {
                    armorSlot8.setImageResource(R.drawable.leathershield)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 29..30) {
                    armorSlot8.setImageResource(R.drawable.rareleathershield)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 31..34) {
                    armorSlot8.setImageResource(R.drawable.leatherbelt)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }  else if (itemId in 35..36) {
                    armorSlot8.setImageResource(R.drawable.rareleatherbelt)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 37..40) {
                    armorSlot8.setImageResource(R.drawable.leatherhat)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 41..42) {
                    armorSlot8.setImageResource(R.drawable.rareleatherhat)
                    slot8 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            } else if (loopStopper == 8) {
                if (itemId in 1..4) {
                    armorSlot9.setImageResource(R.drawable.leatherarmor)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 5..6) {
                    armorSlot9.setImageResource(R.drawable.rareleatherarmor)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 7..10) {
                    armorSlot9.setImageResource(R.drawable.leatherrobe)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 11..12) {
                    armorSlot9.setImageResource(R.drawable.rareleatherrobe)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 13..16) {
                    armorSlot9.setImageResource(R.drawable.leathergloves)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 17..18) {
                    armorSlot9.setImageResource(R.drawable.rareleathergloves)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 19..22) {
                    armorSlot9.setImageResource(R.drawable.leathershoes)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 23..24) {
                    armorSlot9.setImageResource(R.drawable.rareleathershoes)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 25..28) {
                    armorSlot9.setImageResource(R.drawable.leathershield)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 29..30) {
                    armorSlot9.setImageResource(R.drawable.rareleathershield)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 31..34) {
                    armorSlot9.setImageResource(R.drawable.leatherbelt)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }  else if (itemId in 35..36) {
                    armorSlot9.setImageResource(R.drawable.rareleatherbelt)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 37..40) {
                    armorSlot9.setImageResource(R.drawable.leatherhat)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                } else if (itemId in 41..42) {
                    armorSlot9.setImageResource(R.drawable.rareleatherhat)
                    slot9 = armorClass(itemId, itemName, armorItem, vitalityItem, speedItem, manaItem, strenghtItem, priceItem, typeItem)
                }
            }





            loopStopper++

            if (loopStopper == 9) {
                break
            }



        }


    }



}