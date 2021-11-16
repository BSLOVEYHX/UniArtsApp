package com.zysc.uniartsapp.ui

import android.os.Bundle
import android.view.View
import com.orhanobut.logger.Logger.t
import com.zysc.uniartsapp.R
import com.zysc.uniartsapp.base.BaseActivity
import com.zysc.uniartsapp.databinding.ActivityLoginLayoutBinding
import com.zysc.uniartsapp.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginLayoutBinding>(),
    View.OnClickListener {

    override val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_layout)
        mBinding.btnTest.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_test) {
            viewModel.getHomePageBannerList()
        }
    }

    override fun initObserve() {
        super.initObserve()
        viewModel.run {
            bannerData.observe(this@LoginActivity, { list ->
                t("LoginActivity").e("BannerSize${list.size}")
            })
        }
    }
}
