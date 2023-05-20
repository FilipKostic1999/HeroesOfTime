package com.example.heroesoftime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

class battleView : AppCompatActivity() {


    var character1 = character(100.0, 10.0)
    var character2 = character(100.0, 10.0)
    var character3 = character(100.0, 10.0)
    var character4 = character(100.0, 10.0)
    var character5 = character(100.0, 10.0)

    var character11 = character(110.0, 10.0)
    var character22 = character(110.0, 10.0)
    var character33 = character(100.0, 10.0)
    var character44 = character(100.0, 10.0)




    var hero = character(100.0, 10.0)
    var boar = character(100.0, 10.0)

    var randomCh = 0



    var heroHp : Double = 0.0
    var mercenary1Hp : Double = 0.0
    var mercenary2Hp = 0.0
    var mercenary3Hp = 0.0
    var mercenary4Hp = 0.0


    var enemy1Hp = 0.0
    var enemy2Hp = 0.0
    var enemy3Hp = 0.0
    var enemy4Hp = 0.0
    var enemy5Hp = 0.0


    var isTimerActive = true
    var isTeam1Dead = false
    var isTeam2Dead = false




    lateinit var heroHpTxt : TextView
    lateinit var mercenary1HpTxt : TextView
    lateinit var mercenary2HpTxt : TextView
    lateinit var mercenary3HpTxt : TextView
    lateinit var mercenary4HpTxt : TextView

    lateinit var enemy1HpTxt : TextView
    lateinit var enemy2HpTxt : TextView
    lateinit var enemy3HpTxt : TextView
    lateinit var enemy4HpTxt : TextView
    lateinit var enemy5HpTxt : TextView




    lateinit var auth : FirebaseAuth
    lateinit var database : FirebaseFirestore
    lateinit var data : fightingHp



    lateinit var listOfTeam1: ArrayList<character>
    lateinit var listOfTeam2: ArrayList<character>





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle_view)



        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser



        heroHpTxt = findViewById(R.id.heroHpTxt)
        mercenary1HpTxt = findViewById(R.id.mercenary1Txt)
        mercenary2HpTxt = findViewById(R.id.mercenary2Txt)
        mercenary3HpTxt = findViewById(R.id.mercenary3Txt)
        mercenary4HpTxt = findViewById(R.id.mercenary4Txt)
        enemy1HpTxt = findViewById(R.id.enemy1HpTxt)
        enemy2HpTxt = findViewById(R.id.enemy2HpTxt)
        enemy3HpTxt = findViewById(R.id.enemy3HpTxt)
        enemy4HpTxt = findViewById(R.id.enemy4HpTxt)
        enemy5HpTxt = findViewById(R.id.enemy5HpTxt)





        listOfTeam1 = arrayListOf()
        listOfTeam2 = arrayListOf()


        listOfTeam1.add(hero)
        listOfTeam1.add(character1)
        listOfTeam1.add(character2)
        listOfTeam1.add(character3)
        listOfTeam1.add(character4)

        listOfTeam2.add(boar)
        listOfTeam2.add(character11)
        listOfTeam2.add(character22)
        listOfTeam2.add(character33)
        listOfTeam2.add(character44)








        if (user != null) {

            database.collection("users").document(user.uid).collection("userData")
                .document("battleField").collection("data")
                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            data = document.toObject()!!



                            heroHpTxt.text = "$heroHp HP"
                            mercenary1HpTxt.text = "$mercenary1Hp HP"
                            mercenary2HpTxt.text = "$mercenary2Hp HP"
                            mercenary3HpTxt.text = "$mercenary3Hp HP"
                            mercenary4HpTxt.text = "$mercenary4Hp HP"

                            enemy1HpTxt.text = "$enemy1Hp HP"
                            enemy2HpTxt.text = "$enemy2Hp HP"
                            enemy3HpTxt.text = "$enemy3Hp HP"
                            enemy4HpTxt.text = "$enemy4Hp HP"
                            enemy5HpTxt.text = "$enemy5Hp HP"



                        }
                    }
                }
        }











        Timer().scheduleAtFixedRate( object : TimerTask() {
            override fun run () {


                for (teamOneCharacter in listOfTeam1) {
                    while (true) {
                        randomCh = (0..4).random()
                        if (listOfTeam2[randomCh].hp > 0) {
                            break
                        }
                        if (listOfTeam2[0].hp <= 0 && listOfTeam2[1].hp <= 0 && listOfTeam2[2].hp <= 0 &&
                            listOfTeam2[3].hp <= 0 && listOfTeam2[4].hp <= 0) {
                            isTeam2Dead = true
                            break
                        }
                    }


                    if (teamOneCharacter.hp > 0 && !isTeam2Dead) {
                        listOfTeam2[randomCh].hp -= teamOneCharacter.damage
                        Log.d("!!!", "hero: ${hero.hp}, her2 hp: ${character1.hp}, boar hp: ${boar.hp}, dumy hp: ${character11.hp}")
                    }

                }



                for (teamOneCharacter in listOfTeam2) {
                    while (true) {
                        randomCh = (0..4).random()
                        if (listOfTeam1[randomCh].hp > 0) {
                            break
                        }
                        if (listOfTeam1[0].hp <= 0 && listOfTeam1[1].hp <= 0 && listOfTeam1[2].hp <= 0 &&
                            listOfTeam1[3].hp <= 0 && listOfTeam1[4].hp <= 0) {
                            isTeam1Dead = true
                            break
                        }
                    }


                    if (teamOneCharacter.hp > 0 && !isTeam1Dead) {
                        listOfTeam1[randomCh].hp -= teamOneCharacter.damage
                        Log.d("!!!", "hero: ${hero.hp}, her2 hp: ${character1.hp}, boar hp: ${boar.hp}, dumy hp: ${character11.hp}")
                    }

                }



                heroHp = listOfTeam1[0].hp
                mercenary1Hp = listOfTeam1[1].hp
                mercenary2Hp = listOfTeam1[2].hp
                mercenary3Hp = listOfTeam1[3].hp
                mercenary4Hp = listOfTeam1[4].hp

                enemy1Hp = listOfTeam2[0].hp
                enemy2Hp = listOfTeam2[1].hp
                enemy3Hp = listOfTeam2[2].hp
                enemy4Hp = listOfTeam2[3].hp
                enemy5Hp = listOfTeam2[4].hp


                if (listOfTeam1[0].hp <= 0 && listOfTeam1[1].hp <= 0 && listOfTeam1[2].hp <= 0 &&
                    listOfTeam1[3].hp <= 0 && listOfTeam1[4].hp <= 0) {
                    isTeam1Dead = true
                }

                if (listOfTeam2[0].hp <= 0 && listOfTeam2[1].hp <= 0 && listOfTeam2[2].hp <= 0 &&
                    listOfTeam2[3].hp <= 0 && listOfTeam2[4].hp <= 0) {
                    isTeam2Dead = true
                }



                if (isTimerActive) {
                    updateHp()
                }

                if (isTeam1Dead) {
                    isTimerActive = false
                } else if (isTeam2Dead) {
                    isTimerActive = false
                }


            }
        }, 0, 2000)





    }


    fun updateHp() {



            auth = Firebase.auth
            val user = auth.currentUser


            var refresh = fightingHp(heroHp = heroHp, mercenary1Hp = mercenary1Hp, mercenary2Hp = mercenary2Hp,
            mercenary3Hp = mercenary3Hp, mercenary4Hp = mercenary4Hp, enemy1Hp = enemy1Hp, enemy2Hp = enemy2Hp,
            enemy3Hp = enemy3Hp, enemy4Hp = enemy4Hp, enemy5Hp = enemy5Hp)


            if (user != null) {
                database.collection("users").document(user.uid).collection("userData").
                document("battleField").collection("data").document("list").set(refresh)


                    .addOnCompleteListener {


                    }
            }





        }











}