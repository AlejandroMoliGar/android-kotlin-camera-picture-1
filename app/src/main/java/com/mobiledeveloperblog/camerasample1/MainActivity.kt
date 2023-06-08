package com.mobiledeveloperblog.cameravip

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.mobiledeveloperblog.cameravip.R
import com.mobiledeveloperblog.cameravip.R.*



class MainActivity : AppCompatActivity() {

    private val STORAGE_PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        setSupportActionBar(findViewById(id.toolbar))

        // Verificar si se ha concedido el permiso WRITE_EXTERNAL_STORAGE
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            // Si el permiso no ha sido concedido, solicitarlo al usuario
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                STORAGE_PERMISSION_REQUEST_CODE)
        } else {
            // El permiso ya ha sido concedido, realizar las acciones necesarias
            // relacionadas con el almacenamiento externo aquí
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // El permiso WRITE_EXTERNAL_STORAGE ha sido concedido,
                // realizar las acciones necesarias relacionadas con el almacenamiento externo aquí
            } else {
                // El permiso WRITE_EXTERNAL_STORAGE ha sido denegado,
                // tomar medidas correspondientes (por ejemplo, mostrar un mensaje de error)
            }
        }
    }
}
