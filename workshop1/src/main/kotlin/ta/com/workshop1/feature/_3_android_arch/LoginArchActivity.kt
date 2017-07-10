package ta.com.workshop1.feature._3_android_arch

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import ta.com.workshop1.feature.R
import ta.com.workshop1.feature.common.TextHelper
import ta.com.workshop1.feature.databinding.ActivityLoginArchBinding


class LoginArchActivity : AppCompatActivity(), LoginArchInf.ViewInf {

    var binding: ActivityLoginArchBinding? = null
    var viewModel: LoginArchViewModel? = null
    var presenter: LoginArchInf.PresenterInf? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initViewModel()
        initPresenter()
        initEvent()
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_arch)
    }

    private fun initViewModel() {
        viewModel = LoginArchViewModel()
        binding!!.viewModel = viewModel
    }

    private fun initPresenter() {
        presenter = LoginArchPresenter(viewModel, this)
        presenter!!.onInit()
    }

    private fun initEvent() {
        val textWatcher = object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkIsReadyToSignIn()
            }
        }

        binding?.email?.addTextChangedListener(textWatcher)
        binding?.password?.addTextChangedListener(textWatcher)
    }

    override fun performLogin(stringToShow: String) {
        Toast.makeText(this, stringToShow, Toast.LENGTH_LONG).show()
    }

    private fun checkIsReadyToSignIn() {
        val notEmptyStrings = TextHelper.isNotEmptyStrings(binding?.email?.text.toString(), binding?.password?.text.toString())
        viewModel?.email?.set(binding?.email?.text.toString())
        viewModel?.password?.set(binding?.password?.text.toString())
        presenter?.setReadyToClick(notEmptyStrings)
    }
}

