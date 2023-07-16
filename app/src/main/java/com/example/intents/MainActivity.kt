package com.example.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.example.intents.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenWebsite.setOnClickListener{ openWebsite() }
        binding.btnLocation.setOnClickListener{ openLocation() }
        binding.btnShareText.setOnClickListener{ shareText() }
    }

    fun openWebsite(){
        val url = binding.editWebsite.text.toString()
        val webpage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        //if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        //} else {
        //    Log.d("ImplicitIntents", "Can't handle this intent!");
        //}
    }

    fun openLocation(){
        val loc = binding.editLocation.text
        val addressUri = Uri.parse("geo:0,0?q="+loc)
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        startActivity(intent)
    }

    fun shareText(){
        val text = binding.editShareText.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder(this)
            .setType(mimeType)
            .setChooserTitle(binding.editShareText.text)
            .setText(text)
            .startChooser()
    }
}