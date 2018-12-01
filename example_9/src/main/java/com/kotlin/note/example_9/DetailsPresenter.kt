package com.kotlin.note.example_9

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class DetailsPresenter(newsId: Long) : MvpPresenter<DetailsView>() {

    init {
        viewState.showDetails("Details of \"$newsId\"")
    }
}