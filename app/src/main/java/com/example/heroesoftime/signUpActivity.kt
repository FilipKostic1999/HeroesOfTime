package com.example.heroesoftime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.heroesoftime.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class signUpActivity : AppCompatActivity() {



    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)



        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        binding.signInTxt.setOnClickListener {


            val intent = Intent(this, logInActivity::class.java)

            startActivity(intent)
        }










        binding.signUpWorkerBut.setOnClickListener {
            val email = binding.workerSignUpEmailEditTexst.text.toString()
            val pass = binding.workerSignUpPasEditTexst.text.toString()
            val confirmPass = binding.workerSignUpPas2EditTexst.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {

                if (pass == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {



                            waitAsec()


                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Pasword does not mach", Toast.LENGTH_SHORT).show()
                }


            } else {
                Toast.makeText(this, "there are empty fields", Toast.LENGTH_SHORT).show()
            }












        }













    }


    fun waitAsec() {


        Toast.makeText(this, "Wait 5 seconds, your account is being created...", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({



            val intent = Intent(this, heroAvatarActivity::class.java)

            startActivity(intent)

        }, 5000)







    }





}