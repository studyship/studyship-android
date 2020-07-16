package com.studyship.application.ui.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.studyship.application.R
import com.studyship.application.base.activity.BaseActivity
import com.studyship.application.databinding.ActivitySearchBinding
import com.studyship.application.ui.adapter.BottomSheetRecyclerAdapter
import com.studyship.application.ui.adapter.SearchHistoryRecyclerAdapter
import com.studyship.application.ui.adapter.SuggestRecyclerAdapter
import com.studyship.application.ui.widget.CustomBottomSheetDialog
import com.studyship.application.util.customOverridePendingTransition
import com.tsdev.domain.repository.DomainSuggestResponse
import com.tsdev.presentation.SearchKeywordViewModel
import com.tsdev.presentation.ext.CustomFinishProviderImpl
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class SearchActivity : BaseActivity<SearchKeywordViewModel>() {

    private val binding by setDataBinding<ActivitySearchBinding>(R.layout.activity_search)

    override val viewModel: SearchKeywordViewModel by viewModel {
        parametersOf(customFinishImpl)
    }

    private val bottomSheet by inject<CustomBottomSheetDialog> {
        parametersOf(viewModel, supportFragmentManager, bottomSheetRecyclerAdapter)
    }

    private val bottomSheetRecyclerAdapter by lazy {
        BottomSheetRecyclerAdapter(mapper)
    }

    private val suggestAdapter: SuggestRecyclerAdapter by lazy {
        SuggestRecyclerAdapter()
    }

    private val searchHistoryAdapter: SearchHistoryRecyclerAdapter by lazy {
        SearchHistoryRecyclerAdapter(preference)
    }
    protected val customFinishImpl: View.OnClickListener by inject {
        parametersOf(finish())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.saveSearchKeyword = {
            searchHistoryAdapter.saveUserHistory(it ?: "")
        }

        binding.run {
            lifecycleOwner = this@SearchActivity
            executePendingBindings()
        }

        suggestAdapter.onClickListener = {
            binding.inputUserText.setText((suggestAdapter.getItems(it) as DomainSuggestResponse).suggestValue)
        }

        searchHistoryAdapter.setOnClickRemoveListener = {
            searchHistoryAdapter.destroyedPositionItem(it)
        }

        viewModel.showBottomSheetDialog.observe(this) {
            if (it.getContentValue()) {
                bottomSheet.showDialogWithData(
//                    listOf(
//                        "카테고리",
//                        "지역",
//                        "검색 필터"
//                    )
                )
            }
        }

        viewModel.selectedCategory.observe(this) {
            when (it) {
//                CATEGO
//                LOCATION -> bottomSheet.setReplaceFragmentLayout()
//                FILTER -> bottomSheet.setReplaceFragmentLayout()
            }
        }

//        binding.backButton.setOnClickListener { finish() }

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

        bottomSheetRecyclerAdapter.hideKeyBoard = {
            (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                binding.inputUserText.windowToken,
                0
            )
        }
    }

    override fun finish() {
        super.finish()
        this.customOverridePendingTransition(enterAnim = R.anim.slide_in_left)
    }

    companion object {
        private const val CATEGORY = "카테고리"
        private const val LOCATION = "지역"
        private const val FILTER = "검색필터"
    }
}
