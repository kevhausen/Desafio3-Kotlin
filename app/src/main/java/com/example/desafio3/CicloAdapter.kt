package com.example.desafio3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//primero se hace la clase viewholder, esta extiende de recyclerview.viewholder

class CicloAdapter(val cycloList:MutableList<Ciclovia>) : RecyclerView.Adapter<CicloAdapter.CicloViewHolder>() {
    class CicloViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //aca se instancian los elementos a multiplicar y se enlazan con su contraparte en el layout
        var cicloText :TextView=itemView.findViewById(R.id.ciclovia_id)
        var comunaText :TextView=itemView.findViewById(R.id.comuna_id)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CicloViewHolder {
        //aca se cargga el layout entero donde estan los textview
        return CicloViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.lista_ciclovia,parent,false))

    }

    override fun getItemCount(): Int {
        return cycloList.size
    }

    override fun onBindViewHolder(holder: CicloViewHolder, position: Int) {
        holder.comunaText.text=cycloList[position].comuna
        holder.cicloText.text=cycloList[position].nombre_ciclovia
        //holder.cicloText.setText(cycloList.get(position).nombre_ciclovia)
        //holder.comunaText.setText(cycloList.get(position).comuna)


    }
}