package com.example.desafio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lista_ciclovia.*

class MainActivity : AppCompatActivity() {

    //declarar nuestra dataset,recyclerview,layout,adapter

    private lateinit var rView:RecyclerView
    private lateinit var cAdapter:CicloAdapter
    private lateinit var layoutMnger:RecyclerView.LayoutManager
    private lateinit var mDataset:MutableList<Ciclovia>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //instanciar y enlazar botones con layout
        //hacer logica de botones(puede ser con streams, no se si tiene kotlin)
        //

        val filtrarCondes :Button=findViewById(R.id.button)
        val noFiltrar :Button=findViewById(R.id.button2)





        layoutMnger= LinearLayoutManager(this)
        mDataset=SetupCiclovias().init() as MutableList<Ciclovia>
        cAdapter=CicloAdapter(mDataset)
        rView=findViewById(R.id.recyclerView)
        rView.adapter=cAdapter
        rView.layoutManager=layoutMnger


        filtrarCondes.setOnClickListener(View.OnClickListener {
            when (mDataset){
                //reccorer lista para comparar comunas con "las condes"
                //val filtroCondes =mDataset.filter { comuna -> comuna.equals("Las Condes") }
            }

        })



       // Log.d("desafio",SetupCiclovias().initDani().toString())



    }
}