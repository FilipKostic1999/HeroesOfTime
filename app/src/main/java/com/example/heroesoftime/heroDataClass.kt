package com.example.heroesoftime

import com.google.firebase.firestore.DocumentId

data class heroDataClass(@DocumentId var DocumentId: String? = null, var heroIconId: Int = 0, var heroLevel : Int = 1, var heroExperience : Int = 0,
var heroName : String = "", var heroGold : Int = 0, var heroCurrentHp : Double = 0.0, var heroVitality : Int = 10,
var heroSpeed : Int = 10, var heroCurrentMana : Int = 100, var heroStrenght : Int = 10, var heroArmorId : Int = 1,
var heroRobeId : Int = 0, var heroGloveId : Int = 0, var heroShoesId : Int = 19, var heroShieldId : Int = 0,
var heroBeltId : Int = 0, val heroHelmetId : Int = 0, var heroWeaponId : Int = 43, var heroRingId1 : Int = 0,
var heroRingId2 : Int = 0, var heroAmuletId : Int = 0, var warCry : Int = 0, var critical : Int = 1,
var fury : Int = 0, var poisonBlade : Int = 0, val warriorSpirit : Int = 0, var temerary : Int = 0,
var destructiveSpirit : Int = 0, var hardSkin : Int = 0, var heroInventorySlot1 : Int = 0,
var heroInventorySlot2 : Int = 0, var heroInventorySlot3 : Int = 0, var heroInventorySlot4 : Int = 0,
var heroInventorySlot5 : Int = 0, var heroMana : Int = 10, var heroDiamonds : Int = 0, var heroCurrentLocation : Int = 1,
                         var heroTotalArmor : Double = 0.0, var itemsAddedVitality : Double = 0.0,
                         var itemsAddedStrenght : Double = 0.0, var itemsAddedSpeed : Double = 0.0,
                         var itemsAddedMana : Double = 0.0, var itemWeaponDamage : Double = 0.0) {

}
