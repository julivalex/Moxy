package com.kotlin.note.example_6.mvp

import io.reactivex.subjects.BehaviorSubject

class CounterInteractor {

    private var counterValue: Int = 0
    val counter: BehaviorSubject<Int> = BehaviorSubject.createDefault(counterValue)

    fun increase() {
        counterValue++
        counter.onNext(counterValue)
    }
}