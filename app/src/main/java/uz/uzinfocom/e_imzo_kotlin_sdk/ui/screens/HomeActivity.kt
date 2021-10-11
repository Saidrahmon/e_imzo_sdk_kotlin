package uz.uzinfocom.e_imzo_kotlin_sdk.ui.screens

import android.Manifest
import android.R.attr
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.uzinfocom.e_imzo_kotlin_sdk.R
import uz.uzinfocom.e_imzo_kotlin_sdk.contracts.LibraryContract
import uz.uzinfocom.e_imzo_kotlin_sdk.models.EriModel
import uz.uzinfocom.e_imzo_kotlin_sdk.repository.HomeRepo
import uz.uzinfocom.e_imzo_kotlin_sdk.ui.adapters.EriAdapter
import uz.uzinfocom.e_imzo_kotlin_sdk.ui.presenters.HomePresenter
import android.R.attr.data
import android.net.Uri
import android.os.Environment

import android.R.attr.src
import android.R.attr.path
import androidx.core.app.ActivityCompat
import java.io.*
import android.R.attr.data
import android.R.attr.data
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.core.net.toFile
import androidx.core.app.ActivityCompat.startActivityForResult
import android.widget.Toast

import android.os.FileUtils

import android.R.attr.data
import android.provider.DocumentsContract
import android.provider.MediaStore
import java.lang.Exception


class HomeActivity : AppCompatActivity(), LibraryContract.View {

    lateinit var btnAddEri: Button
    lateinit var listViewEri: RecyclerView
    lateinit var presenter: LibraryContract.Presenter
    lateinit var adapter: EriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        window.statusBarColor = resources.getColor(R.color.statusBarColor)

        title = "E - imzo"

        this.presenter = HomePresenter(this, HomeRepo())

        this.btnAddEri = findViewById(R.id.btn1)
        this.listViewEri = findViewById(R.id.listEri)

        this.adapter = EriAdapter(this)

        val listEri: ArrayList<EriModel> = ArrayList()
        listEri.add(EriModel("Shohruh Bekjonov", "******"))
        listEri.add(EriModel("Shohruh Bekjonov", "******"))
        listEri.add(EriModel("Shohruh Bekjonov", "******"))

        adapter.submit(listEri)

        listViewEri.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        listViewEri.adapter = adapter

        this.btnAddEri.setOnClickListener {
            //presenter.pressAddEri()
            this.openFileChooser()
        }
    }

    fun openFileChooser() {

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                23
            )
        }

        else{
            this.filePick()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {

            if (data != null) {
                val fileUri: Uri = data.data!!

                val f = this.getFileFromUri(fileUri)

                val bytes = f?.readBytes()

                Log.d("TTT", bytes.toString());

            }

        }

    }


    fun getFileFromUri(uri: Uri): File? {
        if (uri.path == null) {
            return null
        }
        var realPath = String()
        val databaseUri: Uri
        val selection: String?
        val selectionArgs: Array<String>?
        if (uri.path!!.contains("/document/image:")) {
            databaseUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            selection = "_id=?"
            selectionArgs = arrayOf(DocumentsContract.getDocumentId(uri).split(":")[1])
        } else {
            databaseUri = uri
            selection = null
            selectionArgs = null
        }
        try {
            val column = "_data"
            val projection = arrayOf(column)
            val cursor = this.contentResolver.query(
                databaseUri,
                projection,
                selection,
                selectionArgs,
                null
            )
            cursor?.let {
                if (it.moveToFirst()) {
                    val columnIndex = cursor.getColumnIndexOrThrow(column)
                    realPath = cursor.getString(columnIndex)
                }
                cursor.close()
            }
        } catch (e: Exception) {
            Log.i("GetFileUri Exception:", e.message ?: "")
        }
        val path = if (realPath.isNotEmpty()) realPath else {
            when {
                uri.path!!.contains("/document/raw:") -> uri.path!!.replace(
                    "/document/raw:",
                    ""
                )
                uri.path!!.contains("/document/primary:") -> uri.path!!.replace(
                    "/document/primary:",
                    "/storage/emulated/0/"
                )
                else -> return null
            }
        }
        return File(path)
    }

    fun filePick(){
        var chooseFileIntent = Intent(Intent.ACTION_GET_CONTENT)
        chooseFileIntent.type = "*/*"

        startActivityForResult(Intent.createChooser(chooseFileIntent, "Select a file"), 1)
    }

    override fun showDialog() {
        val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("ERI qo'shish")
        dialog.setView(view)
        dialog.setPositiveButton("Qo'shish", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Log.d("TTT", p1.toString())
            }

        })
        dialog.setNegativeButton("Yo'q", object : DialogInterface.OnClickListener {
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
