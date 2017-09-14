package com.amuyu.sampleanko.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.amuyu.logger.Logger
import com.amuyu.sampleanko.R
import com.amuyu.sampleanko.annotation.ListAnnotation
import com.amuyu.sampleanko.annotation.ListName
import kotlinx.android.synthetic.main.activity_sub.*
import org.jetbrains.anko.*

class SubActivity : AppCompatActivity() {

    companion object {
        val SUB_INTENT = "ITEM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        Logger.d("itemt:"+intent.getStringExtra(SUB_INTENT))

        intent.getStringExtra(SUB_INTENT)?.let {title ->
            textView.setText(getTitle(title))
            button.setOnClickListener { click(title) }
        }
    }

    fun getTitle(@ListName name: String): Int {
        Logger.d(""+name)
        when (name) {
            ListAnnotation.DIALOG -> return R.string.alert_activity_name
            ListAnnotation.TOSTS -> return R.string.toast_activity_name
            ListAnnotation.CUSTOM -> return R.string.custom_activity_name
            ListAnnotation.SELECTORS -> return R.string.selector_activity_name
            ListAnnotation.PROGRESS_DIALOG -> return R.string.progress_activity_name
        }
        return R.string.alert_activity_name
    }

    fun click(@ListName name: String) {
        Logger.d(""+name)
        when (name) {
            ListAnnotation.DIALOG -> showAlert()
            ListAnnotation.TOSTS -> showToast()
            ListAnnotation.CUSTOM -> customAlert()
            ListAnnotation.SELECTORS -> viewSelector()
            ListAnnotation.PROGRESS_DIALOG -> viewProgress()
        }
    }

    fun showToast() {
        toast("Toast message!!!")
    }

    fun showAlert() {
        alert("Hi,","title") {
            yesButton {
                toast("확인")
            }
            noButton {
                toast("취소")
            }
        }.show()
    }


    fun customAlert(): Unit {
        alert {
            customView {
                editText()
            }
        }.show()
    }

    fun viewSelector(): Unit {
        val countries = listOf("Russia", "USA", "Japan", "Australia")
        selector("Where are you from?", countries, { dialogInterface, i ->
            toast("So you're living in ${countries[i]}, right?")
        })
    }

    fun viewProgress(): Unit {
        val dialog = progressDialog(message = "Please wait a bit…", title = "Fetching data")
        dialog.show()
    }
}