package ta.com.workshop1.feature._3_android_arch

import android.view.View
import ta.com.workshop1.feature.common.TextHelper

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

    override fun onEmailUpdate(string: String) {
        viewModel?.email?.set(string)
        checkIsReadyToSignIn()
    }

    override fun onPasswordUpdate(string: String) {
        viewModel?.password?.set(string)
        checkIsReadyToSignIn()
    }

    private fun checkIsReadyToSignIn() {
        val notEmptyStrings = TextHelper.isNotEmptyStrings(viewModel?.email?.get(),
                viewModel?.password?.get())
        setReadyToClick(notEmptyStrings)
    }
}