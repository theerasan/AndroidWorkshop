package ta.com.workshop1.feature._4_android_arch_2_ways_binding

import android.view.View
import ta.com.workshop1.feature.BR

class LoginArch2WaysBindingPresenter(var viewModel: LoginArch2WaysBindingViewModel?, var view: LoginArch2WaysBindingInf.ViewInf) : LoginArch2WaysBindingInf.PresenterInf {

    override fun onInit() {
        viewModel?.readyToLogin?.set(false)
        viewModel?.onClickLogin?.set(View.OnClickListener { _ ->
            view.performLogin(viewModel?.email?.get() + " " + viewModel?.password?.get())
        })

        viewModel?.email?.notifyPropertyChanged(BR.readyToLogin)
    }
}