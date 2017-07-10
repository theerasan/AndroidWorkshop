package ta.com.workshop1.feature._2_databinding

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import ta.com.workshop1.feature.BR
import ta.com.workshop1.feature.common.TextHelper

class LoginDataBindingViewModel : BaseObservable() {
    @get:Bindable
    var email: String? = ""
        set(email) {
            field = email
            notifyPropertyChanged(BR.email)
            notifyPropertyChanged(BR.readyToLogin)
        }

    @get:Bindable
    var password: String? = ""
        set(password) {
            field = password
            notifyPropertyChanged(BR.password)
            notifyPropertyChanged(BR.readyToLogin)
        }

    @get:Bindable
    var onClickLogin: View.OnClickListener? = null
        set(onClickLogin) {
            field = onClickLogin
            notifyPropertyChanged(BR.onClickLogin)
        }

    @get:Bindable
    var readyToLogin: Boolean? = false
        get() {
            val notEmptyStrings = TextHelper.isNotEmptyStrings(email, password)
            return notEmptyStrings
        }
}