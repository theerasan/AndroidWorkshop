package ta.com.workshop1.feature.common

import android.text.Editable
import android.databinding.ObservableField
import android.text.TextWatcher
import kotlin.reflect.KMutableProperty0


class TextWatcherAdapter(private var field: KMutableProperty0<ObservableField<String>?>) : TextWatcher {

    val value = ObservableField<String>()

    private var isInEditMode = false

    init {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
    }

    override fun afterTextChanged(s: Editable) {
        if (field.get()?.get()  != s.toString()) {
            isInEditMode = true
            value.set(s.toString())
            field.set(value)
            isInEditMode = false
        }
    }
}