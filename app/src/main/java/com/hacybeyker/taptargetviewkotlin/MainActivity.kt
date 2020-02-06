package com.hacybeyker.taptargetviewkotlin

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Documentation
        // https://github.com/KeepSafe/TapTargetView
        //http://yasirameen.com/2016/10/android-creating-app-walkthrough/

        TapTargetView.showFor(
            this, TapTarget.forView(button_click, "This is a button", "Click it if you want!")
                .outerCircleColor(R.color.blue)      // Specify a color for the outer circle
                .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                .targetCircleColor(R.color.white)   // Specify a color for the target circle
                .titleTextSize(30)                  // Specify the size (in sp) of the title text
                .titleTextColor(R.color.white)      // Specify the color of the title text
                .descriptionTextSize(15)            // Specify the size (in sp) of the description text
                .descriptionTextColor(R.color.white)  // Specify the color of the description text
                .textColor(R.color.white)            // Specify a color for both the title and description text
                .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                .dimColor(R.color.black)            // If set, will dim behind the view with 30% opacity of the given color
                .drawShadow(true)                   // Whether to draw a drop shadow or not
                .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
                .tintTarget(false)                   // Whether to tint the target view's color
                .transparentTarget(false)           // Specify whether the target is transparent (displays the content underneath)
                //.icon(Drawable)                     // Specify a custom drawable to draw as the target
                .targetRadius(30), TapTargetView.Listener().apply {
                Toast.makeText(this@MainActivity, "Click Inside", Toast.LENGTH_LONG).show()
            }
        )

        button_click.setOnClickListener {
            Toast.makeText(this, "Click", Toast.LENGTH_LONG).show()
        }
    }
}
