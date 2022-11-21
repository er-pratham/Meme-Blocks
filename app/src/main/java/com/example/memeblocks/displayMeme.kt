package com.example.memeblocks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_display_meme.*
import org.json.JSONObject

class displayMeme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_meme)
        loadmeme()
    }
    private fun loadmeme()
    {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener{ response ->
                val url=response.getString("url")
                println("URL = $url")
                Glide.with(this).load(url).into(memeview)
//                println("URL = $url")
            },
            Response.ErrorListener{
                Toast.makeText(this,"Something Went Wrong",Toast.LENGTH_LONG).show()
            }
        )

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }



    fun shareFunc(view: View) {}
    fun nextFunc(view: View) {
        loadmeme()
    }
}