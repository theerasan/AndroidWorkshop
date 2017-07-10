package ta.com.workshop1.feature._1_oldschoolandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import ta.com.workshop1.feature.R
import ta.com.workshop1.feature.common.TextHelper


class LoginActivity : AppCompatActivity() {

    private var emailField: AutoCompleteTextView? = null
    private var passwordField: EditText? = null
    private var signInButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailField = findViewById(R.id.email) as AutoCompleteTextView
        passwordField = findViewById(R.id.password) as EditText


        val textWatcher = object:TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkIsReadyToSignIn()
            }

        }
        emailField!!.addTextChangedListener(textWatcher)
        passwordField!!.addTextChangedListener(textWatcher)

        signInButton = findViewById(R.id.email_sign_in_button) as Button
        signInButton!!.setOnClickListener { performLogin() }
        signInButton!!.isEnabled = false
    }

    private fun performLogin() {
        val stringToShow  = emailField?.text.toString() + " " + passwordField?.text.toString()
        Toast.makeText(this, stringToShow, Toast.LENGTH_LONG).show()
    }

    private fun checkIsReadyToSignIn() {
        val notEmptyStrings = TextHelper.isNotEmptyStrings(emailField!!.text.toString(), passwordField!!.text.toString())
        signInButton!!.isEnabled = notEmptyStrings
    }

}

