package com.gan.gan_task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.gan.gan_task.R
import com.gan.gan_task.model.BBCharacter
import com.gan.gan_task.util.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.setStateEvent(MainStateEvent.GetBBCharacters)
        viewModel.dataState.observe(this, Observer {
            when(it){
                is DataState.Success<List<BBCharacter>> -> {
                    Log.d("MainActivity", "onCreate: "+it.data)
                }
                is DataState.Error -> {
                    Log.d("MainActivity", "onCreate: "+it.exception.localizedMessage)
                }
                is DataState.Loading -> {
                }
            }
        })

    }
}