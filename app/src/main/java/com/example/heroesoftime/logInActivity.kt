package com.example.heroesoftime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.heroesoftime.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth

class logInActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLogInBinding
    private lateinit var firebaseAuth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)



        var auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.createA.setOnClickListener {
            val intent = Intent(this, signUpActivity:: class.java)
            startActivity(intent)
        }





        binding.workerSignInButton.setOnClickListener {


            val email = binding.workerSignUpEmailEditTexst.text.toString()
            val pass = binding.workerSignUpPasEditTexst.text.toString()






            if (email.isNotEmpty() && pass.isNotEmpty()) {


                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, villageOfHopeMapActivity:: class.java)

                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "there are empty fields", Toast.LENGTH_SHORT).show()
            }

        }















    }
}