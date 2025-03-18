package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //make sure when the fragment is destroyed and recreated like switching to landscape mode, save the instance state
        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment())
                .commit()
        }


        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                    as DieFragment).run {
                        throwDie()
                    supportFragmentManager.saveFragmentInstanceState(this)
            }

        }
    }
}