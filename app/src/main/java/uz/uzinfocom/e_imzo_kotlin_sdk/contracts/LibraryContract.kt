package uz.uzinfocom.e_imzo_kotlin_sdk.contracts

interface LibraryContract {

    interface Model
    interface View{
        fun showDialog()
        fun showMessage(message: String)
    }
    interface Presenter{
        fun pressAddEri()
        fun pressByQr()
        fun pressByNfc()
    }

}