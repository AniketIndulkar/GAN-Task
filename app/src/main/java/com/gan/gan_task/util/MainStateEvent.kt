package com.gan.gan_task.util


sealed class MainStateEvent {

    lateinit var searchString: String

    object GetBBCharacters : MainStateEvent()

    object Search : MainStateEvent()

    object Sort : MainStateEvent()
}