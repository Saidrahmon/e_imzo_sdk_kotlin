package uz.uzinfocom.e_imzo_kotlin_sdk.ui.screens

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import uz.uzinfocom.e_imzo_kotlin_sdk.R
import uz.uzinfocom.e_imzo_kotlin_sdk.contracts.LibraryContract
import uz.uzinfocom.e_imzo_kotlin_sdk.model.HomeRepo
import uz.uzinfocom.e_imzo_kotlin_sdk.ui.presenter.HomePresenter

class HomeActivity : AppCompatActivity() , LibraryContract.View{

    lateinit var btnAddEri: Button
    lateinit var presenter: LibraryContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        window.statusBarColor = resources.getColor(R.color.black)

        title = "E - imzo"

        this.presenter = HomePresenter(this, HomeRepo())

        this.btnAddEri = findViewById(R.id.btn1)

        this.btnAddEri.setOnClickListener {
            presenter.pressAddEri()
        }
    }

    override fun showDialog() {
        val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("ERI qo'shish")
        dialog.setView(view)
        dialog.setPositiveButton("Qo'shish", object: DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Log.d("TTT", p1.toString())
            }

        })
        dialog.setNegativeButton("Yo'q", object: DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Log.d("TTT", "cancel")
            }

        })
        dialog.show()
    }

    override fun showMessage(message: String) {
        Log.d("TTT", message)
    }
}
