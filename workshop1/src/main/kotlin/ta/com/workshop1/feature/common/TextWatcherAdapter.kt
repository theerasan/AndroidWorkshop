package ta.com.workshop1.feature.common

import android.text.Editable
import android.databinding.ObservableField
import android.text.TextWatcher


class TextWatcherAdapter(private var field: (String) -> Unit) : TextWatcher {

    private var isInEditMode = false
    var tmp = ""

    init {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
    }

    override fun afterTextChanged(s: Editable) {
        setText(s.toString())
    }

    private fun setText(s: String) {
        if (tmp != s) {
            isInEditMode = true
            field.invoke(s)
            tmp = s
            isInEditMode = false
        }
    }
}
