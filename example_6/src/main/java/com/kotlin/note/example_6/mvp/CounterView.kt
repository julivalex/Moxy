package com.kotlin.note.example_6

import com.arellomobile.mvp.MvpView

interface CounterView : MvpView {

    fun showCount(count: Int)
}