package ru.lab.kotlin.service

import android.widget.Toast

import android.content.Intent

import android.app.Service

import android.media.MediaPlayer

import android.os.IBinder
import ru.lab.lab5.R


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
        mediaPlayer = MediaPlayer.create(this, R.raw.rammstein_auslander)
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