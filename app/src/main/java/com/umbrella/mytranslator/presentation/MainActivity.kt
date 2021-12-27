package com.umbrella.mytranslator.presentation

import android.animation.ObjectAnimator
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.umbrella.mytranslator.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setOnExitAnimationListener { splashScreenProvider ->
                ObjectAnimator.ofFloat(
                    splashScreenProvider.view,
                    View.TRANSLATION_Y,
                    0f,
                    -splashScreenProvider.view.height.toFloat()
                ).apply {
                    interpolator = AnticipateInterpolator()
                    duration = 1500
                    doOnEnd {
                        splashScreenProvider.remove()
                    }
                }.start()
            }
        }
        setContentView(R.layout.activity_main)
    }
}