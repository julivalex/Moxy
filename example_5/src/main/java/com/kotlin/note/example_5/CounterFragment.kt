package com.kotlin.note.example_5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.item_layout.view.*

class CounterFragment : MvpAppCompatFragment(), CounterView {

    @InjectPresenter
    lateinit var counterPresenter: CounterPresenter

    lateinit var counterTextView: TextView

    var color: Int = android.R.color.white

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            color = it.getInt("argsColor")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.item_layout, container, false)
        view.setBackgroundColor(color)
        view.plusButton.setOnClickListener { counterPresenter.onPlusClick() }
        counterTextView = view.counterTextView
        return view
    }

    override fun showCount(count: Int) {
        counterTextView.text = "$count"
    }
}