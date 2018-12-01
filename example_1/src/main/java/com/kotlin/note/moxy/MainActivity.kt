package com.kotlin.note.example_1

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), HelloWorldView {

    @InjectPresenter
    lateinit var helloWorldPresenter: HelloWorldPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showMessage(message: Int) {
        val messageTextView = TextView(this)
        messageTextView.setText(message)
        val container: LinearLayout = findViewById(R.id.container)
        container.addView(messageTextView)
    }
}
