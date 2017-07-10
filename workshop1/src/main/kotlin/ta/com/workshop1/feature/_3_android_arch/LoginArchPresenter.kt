package ta.com.workshop1.feature._3_android_arch

import android.view.View

class LoginArchPresenter(var viewModel: LoginArchViewModel?, var view: LoginArchInf.ViewInf) : LoginArchInf.PresenterInf {

    override fun onInit() {
        viewModel?.readyToLogin?.set(false)
        viewModel?.onClickLogin?.set(View.OnClickListener { _ ->
            view.performLogin(viewModel?.email?.get() + " " + viewModel?.password?.get())
            viewModel?.email?.set("")
            viewModel?.password?.set("")
        })
    }

    override fun setReadyToClick(isReady: Boolean) {
        viewModel?.readyToLogin?.set(isReady)
    }
}