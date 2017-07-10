package ta.com.workshop1.feature._4_android_arch_2_ways_binding

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.view.View
import ta.com.workshop1.feature.BR
import ta.com.workshop1.feature.common.TextHelper
import ta.com.workshop1.feature.common.TextWatcherAdapter

class LoginArch2WaysBindingViewModel : ViewModel() {
    var email: ObservableField<String>? = ObservableField("")
        set(email) {
            field = email
            readyToLogin?.set(isCanLogin())
        }

    var password: ObservableField<String>? = ObservableField("")
        set(password) {
            field = password
            readyToLogin?.set(isCanLogin())
        }

    var emailOnChange = TextWatcherAdapter(this::email)
    var passwordOnChange = TextWatcherAdapter(this::password)

    var onClickLogin: ObservableField<View.OnClickListener>? = ObservableField()
    var readyToLogin: ObservableField<Boolean>? = ObservableField(false)

    private fun isCanLogin(): Boolean {
        return TextHelper.isNotEmptyStrings(password?.get(), email?.get())
    }
}