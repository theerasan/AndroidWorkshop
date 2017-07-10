package ta.com.workshop1.feature._2_databinding

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ta.com.workshop1.feature.R
import ta.com.workshop1.feature.databinding.ActivityLoginWithBindingBinding


class LoginWithBindingActivity : AppCompatActivity(), LoginWithBindingInf.ViewInf {

    var binding: ActivityLoginWithBindingBinding? = null
    var viewModel: LoginDataBindingViewModel? = null
    var presenter: LoginWithBindingInf.PresenterInf? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initViewModel()
        initPresenter()
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_with_binding)
    }

    private fun initViewModel() {
        viewModel = LoginDataBindingViewModel()
        binding!!.viewModel = viewModel
    }

    private fun initPresenter() {
        presenter = LoginWithBindingPresenter(viewModel, this)
        presenter!!.onInit()
    }

    override fun performLogin(stringToShow: String) {
        Toast.makeText(this, stringToShow, Toast.LENGTH_LONG).show()
    }
}

