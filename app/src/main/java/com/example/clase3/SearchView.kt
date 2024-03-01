package com.example.clase3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.example.clase3.databinding.ActivityMainBinding
import com.example.clase3.databinding.ActivitySearchViewBinding

class SearchView : AppCompatActivity() {
    lateinit var binding: ActivitySearchViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_search_view)
        searchView()
    }

    private  fun searchView(){
        val listaPaises = arrayOf("Colombia", "España","Ecuador", "Egipto", "Panamá")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPaises)

        binding.lvLista.adapter = adapter //le paso la lista de paises por medio de un adapter a el listView

        //Haciendo la consulta en el cuadro de busqueda:
        binding.svBuscar.setOnQueryTextListener(object:androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                //aqui hago la consulta:
                if(listaPaises.contains(query)) adapter.filter.filter((query))
                return true

            }

            override fun onQueryTextChange(query: String?): Boolean {
                //para detectar los cambios al momento de escribir
                adapter.filter.filter(query)
                return true
            }

        })


    }
}