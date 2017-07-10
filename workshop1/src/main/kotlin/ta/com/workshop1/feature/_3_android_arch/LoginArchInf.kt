package ta.com.workshop1.feature._3_android_arch

interface LoginArchInf {
    interface ViewInf {
        fun  performLogin(stringToShow: String)
    }

    interface PresenterInf {
        fun onInit()
        fun setReadyToClick(isReady: Boolean)
    }
}