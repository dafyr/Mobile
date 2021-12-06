package ru.lab.kotlin.ui.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.animation.AccelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import ru.lab.lab5.R
import kotlin.properties.Delegates

class AnimationActivity : AppCompatActivity() {

    private lateinit var rotateButton: Button
    private lateinit var scaleButton: Button
    private lateinit var translateButton: Button
    private lateinit var alphaButton: Button
    private lateinit var rocket: ImageView
    private var screenHeight by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        initView()
        initListeners()
    }

    private fun initView() {
        rotateButton = findViewById(R.id.btn_rotate)
        scaleButton = findViewById(R.id.btn_scale)
        translateButton = findViewById(R.id.btn_translate)
        alphaButton = findViewById(R.id.btn_alpha)
        rocket = findViewById(R.id.iv_rocket)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels
    }

    private fun initListeners() {
        rotateButton.setOnClickListener {
            ObjectAnimator.ofFloat(
                rocket,
                "rotation",
                360f
            ).apply {
                duration = 1000L
                repeatCount = 1
                repeatMode = ValueAnimator.REVERSE
                start()
            }
        }

        scaleButton.setOnClickListener {
            val scaleX = ObjectAnimator.ofFloat(
                rocket,
                "scaleX",
                2f
            )

            val scaleY = ObjectAnimator.ofFloat(
                rocket,
                "scaleY",
                2f
            )

            scaleX.apply {
                repeatCount = 1
                repeatMode = ValueAnimator.REVERSE
                duration = 1000L
            }

            scaleY.apply {
                repeatCount = 1
                repeatMode = ValueAnimator.REVERSE
                duration = 1000L
            }

            val set = AnimatorSet()
            set.playTogether(scaleX, scaleY)
            set.start()
        }

        translateButton.setOnClickListener {
            ObjectAnimator.ofFloat(
                rocket,
                "translationY",
                -screenHeight.toFloat()
            ).apply {
                repeatCount = 1
                repeatMode = ValueAnimator.REVERSE
                interpolator = AccelerateInterpolator(1.5f)
                duration = 1000L
                start()
            }
        }

        alphaButton.setOnClickListener {
            ObjectAnimator.ofFloat(
                rocket,
                "alpha",
                0.1f
            ).apply {
                repeatCount = 1
                repeatMode = ValueAnimator.REVERSE
                duration = 1000L
                start()
            }
        }
    }
}