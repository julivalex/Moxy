package com.kotlin.note.moxy

import com.arellomobile.mvp.MvpView

interface HelloWorldView : MvpView {

    fun showMessage(message: Int)

    fun hideMessage()
}