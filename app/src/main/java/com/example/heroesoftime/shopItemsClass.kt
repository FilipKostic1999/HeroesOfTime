package com.example.heroesoftime

import com.google.firebase.firestore.DocumentId

data class shopItemsClass(@DocumentId var DocumentId: String? = null, var shopRefresh : Boolean = true)
