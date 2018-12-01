package com.kotlin.note.moxy

import android.annotation.SuppressLint
import android.os.AsyncTask
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.kotlin.note.example_4.R

@InjectViewState
class HelloWorldPresenter : MvpPresenter<HelloWorldView>() {

    init {
        HelloWorldTask().execute()
    }

    fun sleepSecond() {
        Thread.sleep(1000)
    }

    fun onDismissMessage() {
        viewState.hideMessage()
    }

    @SuppressLint("StaticFieldLeak")
    inner class HelloWorldTask : AsyncTask<Void, Int, Void>() {

        override fun onPreExecute() {
            viewState.showTimer()
        }

        override fun doInBackground(vararg params: Void?): Void? {
            for (i: Int in 5 downTo 0) {
                sleepSecond()
                publishProgress(i)
            }
            return null
        }

        override fun onProgressUpdate(vararg values: Int?) {
            values[0]?.let { viewState.setTimer(it) }
        }

        override fun onPostExecute(result: Void?) {
            viewState.hideTimer()
            viewState.showMessage(R.string.hello_world)
        }
    }
}