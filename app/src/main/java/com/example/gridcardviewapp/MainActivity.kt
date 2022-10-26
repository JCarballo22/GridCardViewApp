package com.example.gridcardviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    private lateinit var gvTabla:GridView

    var nombre = arrayListOf<String>("Kemberly","Nelson","Cristina","William")
    var departamento = arrayListOf<String>("San Vicente","San Salvador","Chalatenango","Santa Ana")
    var imagenes = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
    )

    var imagesLista = arrayOf(
        ImgItems(imagenes.get(0),nombre.get(0),departamento.get(0)),
        ImgItems(imagenes.get(1),nombre.get(1),departamento.get(1)),
        ImgItems(imagenes.get(2),nombre.get(2),departamento.get(2)),
        ImgItems(imagenes.get(3),nombre.get(3),departamento.get(3)),
    )

    var myImagenLista = ArrayList<ImgItems>()

    var adaptador:AdaptadorModificado? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(imagen in imagesLista){
            myImagenLista.add(imagen)
        }

        gvTabla = findViewById(R.id.gv_Tabla)

        adaptador = AdaptadorModificado(myImagenLista,this)
        gvTabla?.adapter = adaptador
        gvTabla.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var ventana:Intent = Intent(applicationContext,Detalles::class.java)
                ventana.putExtra("imagen",imagenes.get(position))
                ventana.putExtra("nombre",nombre.get(position))
                ventana.putExtra("departamento",departamento.get(position))
                startActivity(ventana)
            }

        }

    }
}