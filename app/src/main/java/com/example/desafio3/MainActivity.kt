package com.example.desafio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rView: RecyclerView
    private var cAdapter: CicloAdapter?=null
    private lateinit var layoutMnger: RecyclerView.LayoutManager
    private lateinit var mDataset: MutableList<Ciclovia>

    fun updateLista(lista:MutableList<Ciclovia>){
        rView.adapter=CicloAdapter(lista)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonFiltrar: Button = findViewById(R.id.button)
        val botonSinFiltrar: Button = findViewById(R.id.button2)

        layoutMnger = LinearLayoutManager(this)
        mDataset = SetupCiclovias().init() as MutableList<Ciclovia>
        cAdapter = CicloAdapter(mDataset)
        rView = findViewById(R.id.recyclerView)
        rView.adapter = cAdapter
        rView.layoutManager = layoutMnger

        val mComunas = mDataset.filter { n -> n.comuna.equals("Las Condes") } as MutableList<Ciclovia>
        Log.d("prueba", mComunas.toString())

        val click=View.OnClickListener {
            view-> when(view.id){
            R.id.button-> updateLista(mComunas)
            R.id.button2->updateLista(mDataset)
        }

        }
        botonFiltrar.setOnClickListener(click)
        botonSinFiltrar.setOnClickListener(click)

        //ESTO SIRVE PARA DESAFIO4

        /*botonFiltrar.setOnClickListener {
            val mComunas = mDataset.filter { n -> n.comuna.equals("Las Condes") } as MutableList<Ciclovia>
            mDataset=mComunas
            updateLista()
            Log.d("prueba",mDataset.toString())
        }
        botonSinFiltrar.setOnClickListener {
            mDataset = SetupCiclovias().init() as MutableList<Ciclovia>
            updateLista()
        }
        */

    }
}
