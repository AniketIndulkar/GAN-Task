package com.gan.gan_task.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.gan.gan_task.R
import com.gan.gan_task.databinding.ActivityMainBinding
import com.gan.gan_task.model.BBCharacter
import com.gan.gan_task.util.DataState
import com.gan.gan_task.util.MainStateEvent
import com.gan.gan_task.util.Util
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnCharClickListener {

    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.lifecycleOwner= this
        viewModel.setStateEvent(MainStateEvent.GetBBCharacters)

        viewModel.dataState.observe(this, Observer {
            when(it){
                is DataState.Success<List<BBCharacter>> -> {
                    val charAdapter = BBCharRVAdapter()
                    charAdapter.setClickListener(this@MainActivity)
                    binding.rvBbChar.adapter= charAdapter
                    charAdapter.submitList(it.data)
                    charAdapter.notifyDataSetChanged()
                    shoProgressBar(false)
                }
                is DataState.Error -> {
                    shoProgressBar(false)
                    Log.d("MainActivity", "onCreate: "+it.exception.localizedMessage)
                }
                is DataState.Loading -> {
                    shoProgressBar(true)
                }
            }
        })


        binding.etSearch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.isNotEmpty()){
                    val search = MainStateEvent.Search
                    search.searchString= p0.toString()
                    viewModel.setStateEvent( search)
                }

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.ivFilter.setOnClickListener {
            viewModel.setStateEvent(MainStateEvent.Sort)
        }

    }

    override fun onCharClick(bbCharacter: BBCharacter) {
        val intent = Intent(this@MainActivity, CharacterDetailsActivity::class.java)
        intent.putExtra(Util.CHARACTER_ID, bbCharacter.char_id)
        startActivity(intent)
    }

    fun shoProgressBar(showProgress : Boolean){
        if (showProgress){
            binding.relativeProgress.visibility= View.VISIBLE
        }else{
            binding.relativeProgress.visibility= View.GONE
        }
    }
}