package com.example.lab1_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.lab1_kotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonChangeFragment?.setOnClickListener {

            replaceFragment(StringFragment())

        }

        binding.buttonChangeFragment2?.setOnClickListener {

            replaceFragment(NumberFragment())

        }
    }

    private fun replaceFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.results -> {
                startActivity(Intent(this, ResultActivity::class.java))
                true
            }
            R.id.open_browser -> {
                startActivity(Intent(this, OpenBrowserActivity::class.java))
                true
            }
            R.id.open_service -> {
                startActivity(Intent(this, ServiceActivity::class.java))
                true
            }
            R.id.open_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            R.id.open_animation -> {
                startActivity(Intent(this, AnimationActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}


