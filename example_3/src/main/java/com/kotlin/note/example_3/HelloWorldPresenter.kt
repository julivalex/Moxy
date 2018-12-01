package com.kotlin.note.moxy

import android.annotation.SuppressLint
import android.os.AsyncTask
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.kotlin.note.example_3.R

@InjectViewState
class HelloWorldPresenter : MvpPresenter<HelloWorldView>() {

    init {
        HelloWorldTask().execute()
    }

    fun sleepTwoSecond() {
        Thread.sleep(2000)
    }

    fun onDismissMessage() {
        viewState.hideMessage()
    }

    @SuppressLint("StaticFieldLeak")
    inner class HelloWorldTask : AsyncTask<Void, Int, Void>() {

        override fun doInBackground(vararg params: Void?): Void? {
            sleepTwoSecond()
            return null
        }

        override fun onPostExecute(result: Void?) {
            viewState.showMessage(R.string.hello_world)
        }
    }
}