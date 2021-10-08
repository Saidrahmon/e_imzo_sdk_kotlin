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







//lateinit var addERIView: LinearLayout
//val REQUEST_CODE = 1
//
//        addERIView = findViewById(R.id.addERIView)
//
////        addERIView.setOnClickListener {
////            ActivityCompat.requestPermissions(
////                this,
////                arrayOf(
////                    Manifest.permission.READ_EXTERNAL_STORAGE,
////                    Manifest.permission.WRITE_EXTERNAL_STORAGE
////                ),
////                23
////            )
////            val folder: File =
////                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
////            Log.d("TTT", folder.path)
////
////            val file = File("${folder.path}/DS5805631160001.pfx")
////
////            val bytes: ByteArray = Pfx2qr.pfX2QR(file.readBytes(), "58796849")
////
////            Log.d("TTT", bytes.toString())
////
////            //privateKey = QRKey.decrypt(data, pinCode);
////            //bytesToHex(bytes)
////
////            //openFileChooser()
////        }
//    }
//
//    fun hexStringToByteArray(s: String): ByteArray {
//        val len = s.length
//        val data = ByteArray(len / 2)
//        var i = 0
//        while (i < len) {
//            data[i / 2] = ((Character.digit(s[i], 16) shl 4)
//                    + Character.digit(s[i + 1], 16)).toByte()
//            i += 2
//        }
//        return data
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
//
//
//            val downloadFolder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
//            Log.d("TTT", downloadFolder?.path.toString())
//            Toast.makeText(this, downloadFolder?.path, Toast.LENGTH_SHORT).show()
//
////            FileInputStream("${downloadFolder?.path}/DS58056311600001.pfx").use { stream ->
////                val store =
////                    KeyStore.getInstance("pkcs12", "SunJSSE")
////                store.load(stream, "password".toCharArray())
////                val aliases: Enumeration<String> = store.aliases()
////                while (aliases.hasMoreElements()) {
////                    System.err.println(aliases.nextElement())
////                }
////                val certificate: X509Certificate = store.getCertificate("alias") as X509Certificate
////                System.err.println(certificate.getNotAfter())
////                System.err.println(certificate.getNotBefore())
////                System.err.println(certificate.toString())
////            }
//        }
//
//    }
//
//    fun openFileChooser() {
//        val intent = Intent(Intent.ACTION_GET_CONTENT)
//        intent.setType("*/*")
//        startActivityForResult(intent, REQUEST_CODE)
//    }
//}