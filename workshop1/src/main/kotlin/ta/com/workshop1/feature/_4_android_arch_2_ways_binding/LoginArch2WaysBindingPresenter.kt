package ta.com.workshop1.feature._4_android_arch_2_ways_binding

import android.databinding.ObservableField
import android.view.View

class LoginArch2WaysBindingPresenter(var viewModel: LoginArch2WaysBindingViewModel?, var view: LoginArch2WaysBindingInf.ViewInf) : LoginArch2WaysBindingInf.PresenterInf {

    override fun onInit() {
        viewModel?.readyToLogin?.set(false)
        viewModel?.onClickLogin?.set(View.OnClickListener { _ ->
            view.performLogin(viewModel?.email?.get() + " " + viewModel?.password?.get())
            viewModel!!.email!!.set("")
            viewModel!!.password!!.set("")
        })
    }
}