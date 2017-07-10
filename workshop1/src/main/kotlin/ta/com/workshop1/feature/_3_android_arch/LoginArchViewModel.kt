package ta.com.workshop1.feature._3_android_arch

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.view.View

class LoginArchViewModel : ViewModel() {
    var email: ObservableField<String>? = ObservableField("")
    var password: ObservableField<String>? = ObservableField("")
    var onClickLogin: ObservableField<View.OnClickListener>? = ObservableField()
    var readyToLogin: ObservableField<Boolean>? = ObservableField(false)
}