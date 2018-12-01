package com.kotlin.note.example_5

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class CounterPresenter : MvpPresenter<CounterView>() {

    private var count: Int = 0

    init {
        viewState.showCount(count)
    }

    fun onPlusClick() {
        count++
        viewState.showCount(count)
    }
}