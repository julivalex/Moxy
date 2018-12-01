package com.kotlin.note.example_6

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.kotlin.note.example_6.mvp.CounterInteractor
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@InjectViewState
class CounterPresenter : MvpPresenter<CounterView>() {

    private var disposable: Disposable

    @Inject
    lateinit var counterInteractor: CounterInteractor

    init {
        App.appContext?.component?.inject(this)
        disposable = counterInteractor.counter
            .subscribe { integer -> viewState.showCount(integer) }
    }

    fun onPlusClick() {
        counterInteractor.increase()
    }

    override fun onDestroy() {
        disposable.dispose()
    }
}