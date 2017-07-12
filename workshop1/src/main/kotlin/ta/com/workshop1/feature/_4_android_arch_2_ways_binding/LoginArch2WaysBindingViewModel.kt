package ta.com.workshop1.feature._4_android_arch_2_ways_binding

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.view.View
import ta.com.workshop1.feature.common.TextHelper
import ta.com.workshop1.feature.common.TextWatcherAdapter

class LoginArch2WaysBindingViewModel : ViewModel() {
    var email: ObservableField<String>? = ObservableField("")

    var password: ObservableField<String>? = ObservableField("")

    var emailOnChange = TextWatcherAdapter({s ->
        this.email!!.set(s)
        readyToLogin?.set(isCanLogin())
    })
    var passwordOnChange = TextWatcherAdapter({s ->
        this.password!!.set(s)
        readyToLogin?.set(isCanLogin())
    })

    var onClickLogin: ObservableField<View.OnClickListener>? = ObservableField()
    var readyToLogin: ObservableField<Boolean>? = ObservableField(isCanLogin())

    private fun isCanLogin(): Boolean {
        return TextHelper.isNotEmptyStrings(password?.get(), email?.get())
    }
}