package com.example.consultabasedatostc100321

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos(context: Context):SQLiteOpenHelper(context, NOMBRE_DB,null, BD_VERSION) {

    companion object{
        private const val NOMBRE_DB = "mensaje.db"
        private const val BD_VERSION = 1
        private const val NOMBRE_TABLA = "mensaje"
        private const val ID = "id"
        private const val MENSAJE = "mensaje"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val queryCreacionTabla = "CREATE TABLE $NOMBRE_TABLA($ID INTEGER PRIMARY KEY AUTOINCREMENT, $MENSAJE TEXT)"
        db?.execSQL(queryCreacionTabla)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val queryBorrarTabla = "DROP TABLE IF EXISTS $NOMBRE_TABLA"
        db?.execSQL(queryBorrarTabla)
        onCreate(db)
    }

    fun insertarMensaje(registro:Registro) {
        val base_datos = writableDatabase
        val valores = ContentValues().apply {
            put(MENSAJE, registro.mensaje)
        }
        base_datos.insert(NOMBRE_DB,null,valores)
        base_datos.close()
    }

}