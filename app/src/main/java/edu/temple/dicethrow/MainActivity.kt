package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.rollDiceButton)


        //add fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, DieFragment.newInstance(10))
            .replace(R.id.fragmentContainerView2, DieFragment.newInstance(6))
            .commit()


        button.setOnClickListener({

            (supportFragmentManager.fragments.forEach(
                {
                    if(it is DieFragment)
                        it.throwDie()
                }
            ))
        })
    }
}