package com.studyship.application.ui.activity

import android.os.Bundle
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.studyship.application.R
import com.studyship.application.base.activity.BaseActivity
import com.studyship.application.databinding.ActivitySearchBinding
import com.studyship.application.ui.adapter.SearchHistoryRecyclerAdapter
import com.studyship.application.ui.adapter.SuggestRecyclerAdapter
import com.studyship.application.ui.viewmodel.SearchActivityViewModel
import com.studyship.application.ui.widget.CustomBottomSheetDialog
import com.studyship.application.util.customOverridePendingTransition
import com.tsdev.data.source.SuggestResponse
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class SearchActivity : BaseActivity<SearchActivityViewModel>() {

    private val binding by setDataBinding<ActivitySearchBinding>(R.layout.activity_search)

    override val viewModel: SearchActivityViewModel by viewModel()

    private val bottomSheet by inject<CustomBottomSheetDialog> {
        parametersOf(viewModel, supportFragmentManager)
    }

    private val suggestAdapter: SuggestRecyclerAdapter by lazy {
        SuggestRecyclerAdapter()
    }

    private val searchHistoryAdapter: SearchHistoryRecyclerAdapter by lazy {
        SearchHistoryRecyclerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            lifecycleOwner = this@SearchActivity
            executePendingBindings()
        }

        suggestAdapter.onClickListener = {
            binding.inputUserText.setText((suggestAdapter.getItems(it) as SuggestResponse).suggestValue)
        }

        searchHistoryAdapter.setOnClickRemoveListener = {
            searchHistoryAdapter.destroyedPositionItem(it)
        }

        viewModel.showBottomSheetDialog.observe(this) {
            if (it.getContentValue()) {
                bottomSheet.showDialogWithData(
                    listOf(
                        "카테고리",
                        "지역",
                        "검색 필터"
                    )
                )
            }
        }

        binding.clearButton.setOnClickListener { binding.inputUserText.text.clear() }

        binding.backButton.setOnClickListener { finish() }

        binding.recyclerSuggest.run {
            adapter = suggestAdapter
            layoutManager = LinearLayoutManager(this.context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        }

        binding.recyclerLatestHistory.run {
            adapter = searchHistoryAdapter
            layoutManager = GridLayoutManager(this.context, 1)
        }
    }

    override fun finish() {
        super.finish()
        this.customOverridePendingTransition(enterAnim = R.anim.slide_in_left)
    }
}
