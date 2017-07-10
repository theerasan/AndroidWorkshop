package ta.com.workshop1.feature._2_databinding

import android.view.View

class LoginWithBindingPresenter(var viewModel: LoginDataBindingViewModel?, var view: LoginWithBindingInf.ViewInf) : LoginWithBindingInf.PresenterInf {
    override fun onInit() {
        viewModel?.onClickLogin = View.OnClickListener { _ ->
            view.performLogin(viewModel?.email + " " + viewModel?.password)
        }
    }
}