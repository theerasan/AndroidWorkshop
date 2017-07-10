package ta.com.workshop1.feature._0_main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ta.com.workshop1.feature.R
import ta.com.workshop1.feature._3_android_arch.LoginArchActivity
import ta.com.workshop1.feature._2_databinding.LoginWithBindingActivity
import ta.com.workshop1.feature._1_oldschoolandroid.LoginActivity
import ta.com.workshop1.feature._4_android_arch_2_ways_binding.LoginArch2WaysBindingActivity
import ta.com.workshop1.feature.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainInf.ViewInf {

    var binding: ActivityMainBinding? = null
    var viewModel: MainViewModel? = null
    var presenter: MainInf.PresenterInf? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViewModel()
        initPresenter()
    }

    private fun initViewModel() {
        viewModel = MainViewModel()
        binding?.viewModel = viewModel
    }

    private fun initPresenter() {
        presenter = MainPresenter(viewModel, this)
        presenter?.onInit()
    }

    override fun goToOldSchoolAndroidActivity() {
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }

    override fun goToDataBindingActivity() {
        val i = Intent(this, LoginWithBindingActivity::class.java)
        startActivity(i)
    }

    override fun goToArchActivity() {
        val i = Intent(this, LoginArchActivity::class.java)
        startActivity(i)
    }

    override fun goToArchWith2WaysBindingActivity() {
        val i = Intent(this, LoginArch2WaysBindingActivity::class.java)
        startActivity(i)
    }
}
