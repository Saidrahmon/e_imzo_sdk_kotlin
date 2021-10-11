package uz.uzinfocom.e_imzo_kotlin_sdk.ui.presenters

import android.Manifest
import androidx.core.app.ActivityCompat
import uz.uzinfocom.e_imzo_kotlin_sdk.contracts.LibraryContract

class HomePresenter(val view: LibraryContract.View, val model: LibraryContract.Model) :
    LibraryContract.Presenter {

    override fun pressAddEri() {

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
    }

    override fun pressByQr() {
    }

    override fun pressByNfc() {

    }
}