package com.ar.newjetpack2021.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ar.newjetpack2021.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        /*supportFragmentManager.beginTransaction()
            .replace(R.id.containerView, RecipeListFragment())
            .commit()*/
    }

}