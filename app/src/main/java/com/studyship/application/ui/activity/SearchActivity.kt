package com.studyship.application.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.studyship.application.R
import com.studyship.application.base.activity.BaseActivity
import com.studyship.application.databinding.ActivitySearchBinding
import com.studyship.application.ui.adapter.SuggestRecyclerAdapter
import com.studyship.application.ui.viewmodel.SearchActivityViewModel
import com.studyship.application.util.customOverridePendingTransition
import kotlinx.android.synthetic.main.activity_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchActivity : BaseActivity<SearchActivityViewModel>() {

    private val binding by setDataBinding<ActivitySearchBinding>(R.layout.activity_search)

    override val viewModel: SearchActivityViewModel by viewModel()

    private val suggestAdapter: SuggestRecyclerAdapter by lazy {
        SuggestRecyclerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            lifecycleOwner = this@SearchActivity
            executePendingBindings()
        }


        binding.clearButton.setOnClickListener { binding.inputUserText.text.clear() }

        binding.backButton.setOnClickListener { finish() }

        binding.recyclerSuggest.run {
            adapter = suggestAdapter
            layoutManager = LinearLayoutManager(this.context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        }


        binding.inputUserText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length != 0) {

                } else {

                }
            }

        })
//        input_userText.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                Log.e("TEXT", input_userText.text.toString())
////                test.text = input_userText.text.toString()
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//        })

//        if (input_userText.text.isNotEmpty()) {
//            test.text = input_userText.text
//        }
    }

    override fun finish() {
        super.finish()
        this.customOverridePendingTransition(enterAnim = R.anim.slide_in_left)
    }
}
