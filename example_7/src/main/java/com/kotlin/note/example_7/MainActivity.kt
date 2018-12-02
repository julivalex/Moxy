package com.kotlin.note.example_7

import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), DetailsView {

    @InjectPresenter
    lateinit var detailsPresenter: DetailsPresenter

    @ProvidePresenter
    fun provideDetailsPresenter(): DetailsPresenter {
        return DetailsPresenter(intent.getLongExtra("extraDetailsId", 0))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showDetails(details: String) {
        detailsTextView.text = details
        Log.i(MainActivity::class.java.simpleName, details)
    }
}
