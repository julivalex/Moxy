package com.kotlin.note.example_5

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import com.arellomobile.mvp.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_1, addFragment(ContextCompat.getColor(this, R.color.colorFragmentFirst)))
                .add(R.id.frame_2, addFragment(ContextCompat.getColor(this, R.color.colorFragmentSecond)))
                .commit()
        }
    }

    private fun addFragment(color: Int): Fragment {
        val counterFragment = CounterFragment()
        val args = Bundle()
        args.putInt("argsColor", color)
        counterFragment.arguments = args
        return counterFragment
    }
}
