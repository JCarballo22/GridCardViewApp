package com.example.gridcardviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorModificado(
    var imagenLista:ArrayList<ImgItems>,
    var context: Context
):BaseAdapter() {
    override fun getCount(): Int {
        return imagenLista.size
    }

    override fun getItem(position: Int): Any {
        return imagenLista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        if(vista==null){
            vista = LayoutInflater.from(context).inflate(R.layout.fila_items,parent,false)
        }
        var imagenVista:ImageView = vista!!.findViewById(R.id.iv_Imagen)
        var tvNombre:TextView = vista!!.findViewById(R.id.tv_Nombre)
        var tvDepartamento:TextView = vista!!.findViewById(R.id.tv_Departamento)

        val imgIdentificador = imagenLista[position]

        imagenVista.setImageResource(imgIdentificador.imagen)
        tvNombre.text = imgIdentificador.nombre
        tvDepartamento.text = imgIdentificador.departamento

        return vista!!
    }
}