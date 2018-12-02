package com.kotlin.note.example_7

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class DetailsPresenter(newsId: Long) : MvpPresenter<DetailsView>() {

    init {
        viewState.showDetails("Details of \"$newsId\"")
    }
}