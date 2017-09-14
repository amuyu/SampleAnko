package com.amuyu.sampleanko.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.amuyu.logger.Logger
import com.amuyu.sampleanko.R
import com.amuyu.sampleanko.annotation.ListAnnotation
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    val lists: Array<String> by lazy {
        arrayOf(ListAnnotation.DIALOG,
                ListAnnotation.TOSTS,
                ListAnnotation.CUSTOM,
                ListAnnotation.SELECTORS,
                ListAnnotation.PROGRESS_DIALOG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView.let {
            it.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, lists))
            it.setOnItemClickListener(this)
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        Logger.d("pos:"+pos)
        startActivity<SubActivity>(SubActivity.SUB_INTENT to lists[pos])

    }
}
