package com.gan.gan_task.ui

import androidx.lifecycle.*
import com.gan.gan_task.model.BBCharacter
import com.gan.gan_task.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _charData: MutableLiveData<BBCharacter> = MutableLiveData()

    val charData: LiveData<BBCharacter>
        get() = _charData


    fun getData(charId: Int) {
       viewModelScope.launch {
           val character =mainRepository.getCharacterById(charId)
           _charData.postValue(character)
       }
    }

    fun onClickFav() {
        val data = _charData.value
        data!!.isFav = !data.isFav
        viewModelScope.launch {
            mainRepository.updateCharacterData(data)
            _charData.postValue(data!!)

        }

    }

}