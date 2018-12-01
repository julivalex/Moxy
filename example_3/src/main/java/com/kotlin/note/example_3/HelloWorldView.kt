package com.kotlin.note.moxy

import com.arellomobile.mvp.MvpView

interface HelloWorldView : MvpView {

    fun showTimer()

    fun hideTimer()

    fun setTimer(value: Int)

    fun showMessage(message: Int)

    fun hideMessage()
}