package com.example.client

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.client.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.title.text = "OLEG"
            getTest()
        }
    }

    private fun getTest(){
        val url = "http://192.168.0.108:5000/api/users/2"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {resp -> Log.d("MyLog", "Volley response: $resp")},
            {error -> Log.d("MyLog", "Volley error: $error")},
        )
        queue.add(stringRequest)
    }
}