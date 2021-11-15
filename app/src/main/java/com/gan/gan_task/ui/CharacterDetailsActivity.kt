package com.gan.gan_task.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gan.gan_task.R
import com.gan.gan_task.databinding.ActivityCharacterDetailsBinding
import com.gan.gan_task.util.Util
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsActivity : AppCompatActivity() {

    private val detailViewModel: CharacterDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCharacterDetailsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        intent.getIntExtra(Util.CHARACTER_ID, 0).let { detailViewModel.getData(it) }
        binding.charDetailViewModel= detailViewModel
        detailViewModel.charData.observe(this, Observer {
            binding.charData=it
        })

    }
}