package com.example.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs

class SegundoFragment : Fragment(R.layout.fragment_segundo) {
    private var nombre:String?=""
    private var edad: Int?=0
    private val args:SegundoFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            nombre =args.nombre
            edad = args.edad


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text =view.findViewById<TextView>(R.id.text)
        val button = view.findViewById<Button>(R.id.btn_new)
        val result ="resultado"
        button.setOnClickListener {
            setFragmentResult("requestKey", bundleOf("bundlekey" to result))
        }
        text.text ="$nombre $edad"
    }
    companion object {
        private const val miNombre ="nombre"
        private const val miEdad ="edad"
        fun newInstance(nombre:String, edad:Int) =SegundoFragment().apply {
            arguments = bundleOf(miNombre to nombre, miEdad to edad)
        }
    }

}