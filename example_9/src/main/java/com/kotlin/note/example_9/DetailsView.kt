package com.kotlin.note.example_9

import com.arellomobile.mvp.MvpView

interface DetailsView : MvpView {
    fun showDetails(details: String)
}