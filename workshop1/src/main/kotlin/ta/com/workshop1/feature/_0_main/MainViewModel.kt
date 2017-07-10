package ta.com.workshop1.feature._0_main

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.view.View

class MainViewModel : ViewModel() {
    var oldSchoolAndroidOnClick : ObservableField<View.OnClickListener> = ObservableField()
    var dataBindingAndroidOnClick: ObservableField<View.OnClickListener> = ObservableField()
    var archOnClick: ObservableField<View.OnClickListener> = ObservableField()
    var arch2WaysBindingOnClick: ObservableField<View.OnClickListener> = ObservableField()
}