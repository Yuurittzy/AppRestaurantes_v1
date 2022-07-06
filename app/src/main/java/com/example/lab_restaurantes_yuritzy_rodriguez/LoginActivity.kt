package com.example.lab_restaurantes_yuritzy_rodriguez

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private val service by lazy { RetrofitProvider.retrofit.create(RestaurantsApi::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun validateUsers(view: View) {
        val mail = findViewById<EditText>(R.id.editText_mail).text.toString()
        val password = findViewById<EditText>(R.id.editText_password).text.toString()

        service.getUsersForLogin().enqueue(object: Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                if (response.body()?.users?.firstOrNull { it.username == mail && it.password == password } != null) {
                    startActivity(Intent(this@LoginActivity, RestaurantsActivity::class.java))
                    finish()
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Snackbar.make(view, "Usuario no encontrado", Snackbar.LENGTH_SHORT).show()
            }
        })
    }

}