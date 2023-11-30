package com.example.heroesoftime.classes

import com.google.firebase.firestore.DocumentId

data class heroAttributesData(@DocumentId var DocumentId: String? = null, var heroTotalArmor : Double = 0.0, var itemsAddedVitality : Double = 0.0,
                              var itemsAddedStrenght : Double = 0.0, var itemsAddedSpeed : Double = 0.0,
                              var itemsAddedMana : Double = 0.0, var itemWeaponDamage : Double = 0.0) {

}
