package ta.com.workshop1.feature._0_main

import android.view.View

class MainPresenter(var viewModel: MainViewModel?, var view: MainInf.ViewInf) : MainInf.PresenterInf {
    override fun onInit() {
        viewModel?.oldSchoolAndroidOnClick?.set(View.OnClickListener { _ ->
            view.goToOldSchoolAndroidActivity()
        })

        viewModel?.dataBindingAndroidOnClick?.set(View.OnClickListener { _ ->
            view.goToDataBindingActivity()
        })

        viewModel?.archOnClick?.set(View.OnClickListener { _ ->
            view.goToArchActivity()
        })

        viewModel?.arch2WaysBindingOnClick?.set(View.OnClickListener { _ ->
            view.goToArchWith2WaysBindingActivity()
        })
    }
}