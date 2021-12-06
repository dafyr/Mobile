package ru.lab.kotlin.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import ru.lab.lab5.R
import ru.lab.kotlin.ui.number.NumberFragment
import ru.lab.kotlin.ui.result.ResultActivity
import ru.lab.kotlin.ui.string.StringFragment
import ru.lab.kotlin.ui.service.ServiceActivity
import ru.lab.kotlin.ui.animation.AnimationActivity
import ru.lab.kotlin.ui.settings.SettingsActivity
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var fragmentContainer: FragmentContainerView? = null
    private var switchButton: Button? = null
    private var state by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        if (fragmentContainer != null) {
            setNumberFragment()
            switchButton?.setOnClickListener {
                switchFragment()
            }
        }
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

    private fun initViews() {
        fragmentContainer = findViewById(R.id.fragment_container_view)
        switchButton = findViewById(R.id.btn_change_fragment)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view, fragment)
        fragmentTransaction.commit()
    }

    private fun setNumberFragment() {
        setFragment(NumberFragment.newInstance())
        state = NUMBER_STATE
    }

    private fun setStringFragment() {
        setFragment(StringFragment.newInstance())
        state = STRING_STATE
    }

    private fun switchFragment() {
        if (state == NUMBER_STATE) {
            setStringFragment()
        } else if (state == STRING_STATE) {
            setNumberFragment()
        }
    }

    companion object {
        private const val NUMBER_STATE = 1
        private const val STRING_STATE = 2
    }

}