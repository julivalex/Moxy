package com.kotlin.note.example_5

import com.arellomobile.mvp.MvpView

interface CounterView : MvpView {

    fun showCount(count: Int)
}