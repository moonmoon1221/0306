package com.example.a0306

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.a0306.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        dataBinding.ivCH.visibility = View.INVISIBLE
        dataBinding.ivEN.visibility = View.INVISIBLE
        dataBinding.ivMATH.visibility = View.INVISIBLE

        dataBinding.btCheck.setOnClickListener {
            if (dataBinding.edCHScore.text.toString().toInt() < 60) {
                dataBinding.ivCH.setImageResource(R.drawable.ic_fail)
            } else {
                dataBinding.ivCH.setImageResource(R.drawable.ic_ok)
            }

            dataBinding.ivCH.visibility = View.VISIBLE

            if (dataBinding.edENScore.text.toString().toInt() < 60) {
                dataBinding.ivEN.setImageResource(R.drawable.ic_fail)
            } else {
                dataBinding.ivEN.setImageResource(R.drawable.ic_ok)
            }

            dataBinding.ivEN.visibility = View.VISIBLE

            if (dataBinding.edMATHScore.text.toString().toInt() < 60) {
                dataBinding.ivMATH.setImageResource(R.drawable.ic_fail)
            } else {
                dataBinding.ivMATH.setImageResource(R.drawable.ic_ok)
            }

            dataBinding.ivMATH.visibility = View.VISIBLE

            dataBinding.tvsum.text =
                (dataBinding.edCHScore.text.toString().toInt() +
                        dataBinding.edENScore.text.toString().toInt() +
                        dataBinding.edMATHScore.text.toString().toInt()).toString()

            dataBinding.textView.requestFocus()
        }

        dataBinding.edCHScore.setOnFocusChangeListener { view, b ->
            if (b) {
                dataBinding.ivCH.visibility = View.INVISIBLE
            }
        }
        dataBinding.edENScore.setOnFocusChangeListener { view, b ->
            if (b) {
                dataBinding.ivEN.visibility = View.INVISIBLE
            }
        }
        dataBinding.edMATHScore.setOnFocusChangeListener { view, b ->
            if (b) {
                dataBinding.ivMATH.visibility = View.INVISIBLE
            }
        }
    }
}
