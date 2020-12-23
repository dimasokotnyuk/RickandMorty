package com.example.rickandmorty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.rickandmorty.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(CharactersFragment.newInstance(), false)
    }

    private fun replaceFragment(fragment: Fragment, isAddToBackStack: Boolean) {
        supportFragmentManager.apply {
            beginTransaction().apply {
                replace(
                    nav_host_fragment.id,
                    fragment
                )
                if (isAddToBackStack) addToBackStack(fragment::class.simpleName)
            }.commit()
        }
    }
}