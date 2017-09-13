package com.amuyu.sampleanko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ListView
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alert("Hi,","title") {
            yesButton {
                toast("Oh..")
                viewProgress()
            }
            noButton {
                viewSelector()
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

    fun appCompatAlert(): Unit {
        alert(Appcompat, "text message").show()
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
