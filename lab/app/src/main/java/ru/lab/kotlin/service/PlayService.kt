package ru.lab.kotlin.service

import android.widget.Toast

import android.content.Intent

import android.app.Service
import android.content.Context

import android.media.MediaPlayer
import android.os.Environment

import android.os.IBinder
import ru.lab.lab5.R
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.IOException


class PlayService : Service() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(
            this, getString(R.string.service_is_created),
            Toast.LENGTH_SHORT
        ).show()
        mediaPlayer = MediaPlayer.create(this, R.raw.rampampam)
        mediaPlayer!!.isLooping = false
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(
            this, getString(R.string.service_is_running),
            Toast.LENGTH_SHORT
        ).show()
        mediaPlayer!!.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(
            this, getString(R.string.service_is_stopped),
            Toast.LENGTH_SHORT
        ).show()
        mediaPlayer!!.stop()
    }

}