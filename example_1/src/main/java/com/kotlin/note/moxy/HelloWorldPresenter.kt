package com.kotlin.note.moxy

import android.annotation.SuppressLint
import android.os.AsyncTask
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class HelloWorldPresenter : MvpPresenter<HelloWorldView>() {

    init {
        HelloWorldTask().execute()
    }

    fun sleep() {
        Thread.sleep(1000)
    }

    @SuppressLint("StaticFieldLeak")
    inner class HelloWorldTask : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            sleep()
            return null
        }

        override fun onPostExecute(result: Void?) {
            viewState.showMessage(R.string.hello_world)
        }
    }
}