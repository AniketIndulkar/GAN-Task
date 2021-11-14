package com.gan.gan_task.ui

import androidx.lifecycle.*
import com.gan.gan_task.model.BBCharacter
import com.gan.gan_task.repository.MainRepository
import com.gan.gan_task.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<BBCharacter>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<BBCharacter>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetBBCharacters -> {
                    mainRepository.getBBCharacters()
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                MainStateEvent.None -> {
                    // who cares
                }
                else ->{

                }
            }
        }
    }

}

sealed class MainStateEvent{

    object GetBBCharacters: MainStateEvent()

    object None: MainStateEvent()
}