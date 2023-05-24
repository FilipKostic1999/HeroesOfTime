package com.example.heroesoftime

import com.google.firebase.firestore.DocumentId

data class mercenary(@DocumentId var DocumentId: String? = null, var heroName : String = "", var heroCurrentHp : Double = 0.0, var heroVitality : Int = 10,
                     var heroSpeed : Int = 10, var heroStrenght : Int = 10, var heroArmorId : Int = 1,
                     var heroRobeId : Int = 0, var heroGloveId : Int = 0, var heroShoesId : Int = 19, var heroShieldId : Int = 0,
                     var heroBeltId : Int = 0, val heroHelmetId : Int = 0, var heroWeaponId : Int = 43, var heroRingId1 : Int = 0,
                     var heroRingId2 : Int = 0, var heroAmuletId : Int = 0, var heroMana : Int = 10,
                     var heroTotalArmor : Double = 0.0, var itemsAddedVitality : Double = 0.0,
                     var itemsAddedStrenght : Double = 0.0, var itemsAddedSpeed : Double = 0.0,
                     var itemWeaponDamage : Double = 0.0, var critical : Int = 1)
