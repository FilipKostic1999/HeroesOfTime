package com.example.heroesoftime

import com.google.firebase.firestore.DocumentId

data class missions(@DocumentId var DocumentId: String? = null, var mission1 : Int = 0, var mission2 : Int = 0,
                    var mission3 : Int = 0, var mission4 : Int = 0, var mission5 : Int = 0, var mission6 : Int = 0,
                    var mission7 : Int = 0, var mission8 : Int = 0, var mission9 : Int = 0, var mission10 : Int = 0)
