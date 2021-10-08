package uz.uzinfocom.e_imzo_kotlin_sdk.ui.presenter

import uz.uzinfocom.e_imzo_kotlin_sdk.contracts.LibraryContract

class HomePresenter(val view: LibraryContract.View, val model: LibraryContract.Model) : LibraryContract.Presenter {

    override fun pressAddEri() {
        view.showDialog()
    }

    override fun pressByQr() {
    }

    override fun pressByNfc() {

    }
}