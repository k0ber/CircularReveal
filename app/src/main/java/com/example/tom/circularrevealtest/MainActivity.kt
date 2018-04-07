package com.example.tom.circularrevealtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.containerMain, FragmentMain())
                    .commit()
        }
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.containerMain)
        if (fragment is Dismissible) {
            fragment.dismiss(object : Dismissible.OnDismissedListener {
                override fun onDismissed() {
                    supportFragmentManager.beginTransaction().remove(fragment).commit()
                }
            })
        } else {
            finish()
        }
    }

}
