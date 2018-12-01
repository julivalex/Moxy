package com.kotlin.note.example_4

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kotlin.note.moxy.HelloWorldPresenter
import com.kotlin.note.moxy.HelloWorldView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_message.view.*

class MainActivity : MvpAppCompatActivity(), HelloWorldView {

    @InjectPresenter
    lateinit var helloWorldPresenter: HelloWorldPresenter

    lateinit var messageView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showMessage(message: Int) {
        val rootView: ViewGroup = container
        messageView = layoutInflater.inflate(R.layout.item_message, rootView, false)
        rootView.addView(messageView)
        messageView.messageTextView.setText(message)
        messageView.closeButton.setOnClickListener { helloWorldPresenter.onDismissMessage() }
    }

    override fun hideMessage() {
        val rootView: ViewGroup = container
        rootView.removeView(messageView)
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
}
