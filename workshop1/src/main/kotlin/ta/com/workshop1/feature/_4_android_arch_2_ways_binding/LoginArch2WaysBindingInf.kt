package ta.com.workshop1.feature._4_android_arch_2_ways_binding

interface LoginArch2WaysBindingInf {
    interface ViewInf {
        fun  performLogin(stringToShow: String)
    }

    interface PresenterInf {
        fun onInit()
    }
}