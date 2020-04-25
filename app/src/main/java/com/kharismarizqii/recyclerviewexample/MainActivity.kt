package com.kharismarizqii.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<SuperHero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_superhero.setHasFixedSize(true)
        list.addAll(getListSuperHero())
        rv_superhero.layoutManager = LinearLayoutManager(this)
        val superHeroAdapter = SuperHeroAdapter(list)
        rv_superhero.adapter = superHeroAdapter

        superHeroAdapter.setOnItemClickCallback(object : SuperHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: SuperHero) {
                Toast.makeText(this@MainActivity, data.name, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getListSuperHero(): ArrayList<SuperHero>{
        val name = resources.getStringArray(R.array.data_name)
        val desc = resources.getStringArray(R.array.data_desc)

        val listSuperHero = ArrayList<SuperHero>()
        for(i in name.indices){
            val superHero = SuperHero(
                name[i],
                desc[i]
            )
            listSuperHero.add(superHero)
        }
        return listSuperHero
    }
}
