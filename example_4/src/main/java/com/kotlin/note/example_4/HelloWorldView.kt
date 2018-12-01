package com.kotlin.note.moxy

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface HelloWorldView : MvpView {

    fun showTimer()

    fun hideTimer()

    fun setTimer(value: Int)

    fun showMessage(message: Int)

    fun hideMessage()
}