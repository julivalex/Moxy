package com.kotlin.note.example_7

import com.arellomobile.mvp.MvpView

interface DetailsView : MvpView {
    fun showDetails(details: String)
}