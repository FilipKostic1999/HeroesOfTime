package com.example.heroesoftime.classes

import com.google.firebase.firestore.DocumentId

data class shopItemsClass(@DocumentId var DocumentId: String? = null, var shopSlot1 : Int = 0,
                          var shopSlot2 : Int = 0, var shopSlot3 : Int = 0, var shopSlot4 : Int = 0, var shopSlot5 : Int = 0,
                          var shopSlot6 : Int = 0, var shopSlot7 : Int = 0, var shopSlot8 : Int = 0, var shopSlot9 : Int = 0,
                          var shopRefresh : Boolean = true)
