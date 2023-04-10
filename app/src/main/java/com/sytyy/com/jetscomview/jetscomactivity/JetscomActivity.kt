package com.sytyy.com.jetscomview.jetscomactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.sytyy.com.R
import com.sytyy.com.service.MusicService

class JetscomActivity : AppCompatActivity(R.layout.activity_jetscom) {

    override fun onResume() {
        super.onResume()
        startService(Intent(this, MusicService::class.java))
    }

    override fun onPause() {
        super.onPause()
        stopService(Intent(this, MusicService::class.java))
    }
}