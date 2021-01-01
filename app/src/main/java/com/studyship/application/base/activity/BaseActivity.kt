package com.studyship.application.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.studyship.application.R
import com.studyship.application.mapper.Mapper
import com.studyship.application.ui.activity.UserInfoActivity
import com.studyship.application.ui.fragment.MyProfileFragmentDirections
import com.tsdev.data.source.Category
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.view.*
import name.Activity
import navigation.NavigationAction
import org.koin.android.ext.android.inject
import tsthec.tsstudy.domain.model.DomainCategory

abstract class BaseActivity<VM : ViewModel, VIEW_BIND : ViewDataBinding>(@LayoutRes private val layout: Int) :
    AppCompatActivity() {

    protected lateinit var binding: VIEW_BIND
        private set
    protected abstract val viewModel: VM

    protected val compositeDisposable by lazy { CompositeDisposable() }

    protected val mapper: Mapper<DomainCategory, Category> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout)
        binding.lifecycleOwner = this
    }

    protected fun bind(bindSet: VIEW_BIND.() -> Unit) {
        binding.run(bindSet)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    internal fun navigate(action: NavigationAction) {
        when (val classname = action as NavigationAction?) {
            is NavigationAction.Move -> {
                when (classname.className) {
                    Activity.USER_INFO -> navigate(
                        MyProfileFragmentDirections.actionProfileToUserInfoActivity(
                            //todo  SharedPreference 이용해서 유저 ID 보내주기.
                            "TaeSeong"
                        )
                    )
                }
            }
        }

    }

    private fun navigate(directions: NavDirections) =
        findNavController(R.id.nav_host_fragment).navigate(directions)
}