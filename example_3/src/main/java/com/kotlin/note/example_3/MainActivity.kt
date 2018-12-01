package com.kotlin.note.example_3

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kotlin.note.moxy.HelloWorldPresenter
import com.kotlin.note.moxy.HelloWorldView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), HelloWorldView {

    private var messageDialog: AlertDialog? = null

    @InjectPresenter
    lateinit var helloWorldPresenter: HelloWorldPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showMessage(message: Int) {
        messageDialog = AlertDialog.Builder(this)
            .setTitle(R.string.app_name)
            .setMessage(message)
            .setOnDismissListener {
                helloWorldPresenter.onDismissMessage()
            }
            .show()

    }

    override fun hideMessage() {
        messageDialog?.dismiss()
    }

    override fun showTimer() {
        timer.visibility = View.VISIBLE
    }

    override fun hideTimer() {
        timer.visibility = View.GONE
    }

    override fun setTimer(value: Int) {
        timer.text = "$value"
    }

    override fun onDestroy() {
        super.onDestroy()
        messageDialog?.let {
            it.setOnDismissListener(null)
            it.dismiss()
        }
    }
}
