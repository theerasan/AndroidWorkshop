package ta.com.workshop1.feature._4_android_arch_2_ways_binding

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import ta.com.workshop1.feature.R
import ta.com.workshop1.feature.databinding.ActivityLoginArch2WaysBindingBinding


class LoginArch2WaysBindingActivity : AppCompatActivity(), LoginArch2WaysBindingInf.ViewInf {

    var binding: ActivityLoginArch2WaysBindingBinding? = null
    var viewModel: LoginArch2WaysBindingViewModel? = null
    var presenter: LoginArch2WaysBindingInf.PresenterInf? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initViewModel()
        initPresenter()
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_arch_2_ways_binding)
    }

    private fun initViewModel() {
        viewModel = LoginArch2WaysBindingViewModel()
        binding!!.viewModel = viewModel
    }

    private fun initPresenter() {
        presenter = LoginArch2WaysBindingPresenter(viewModel, this)
        presenter!!.onInit()
    }

    override fun performLogin(stringToShow: String) {
        Toast.makeText(this, stringToShow, Toast.LENGTH_LONG).show()
    }
}

