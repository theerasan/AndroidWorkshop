package ta.com.workshop1.feature._2_databinding

interface LoginWithBindingInf {
    interface ViewInf {
        fun  performLogin(stringToShow: String)
    }

    interface PresenterInf {
        fun onInit()
    }
}