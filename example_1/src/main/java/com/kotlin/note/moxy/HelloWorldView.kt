package com.kotlin.note.example_1

import com.arellomobile.mvp.MvpView

interface HelloWorldView : MvpView {
    fun showMessage(message: Int)
}