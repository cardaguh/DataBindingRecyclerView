package co.cyclopsapps.SuperHeroeslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import co.cyclopsapps.superheroeslist.HeroAdapter
import co.cyclopsapps.superheroeslist.R
import co.cyclopsapps.superheroeslist.SuperHero
import co.cyclopsapps.superheroeslist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val superheros = listOf(
        SuperHero(
            "Spiderman",
            "Marvel",
            "Peter Parker",
            "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"
        ),
        SuperHero(
            "Daredevil",
            "Marvel",
            "Matthew Michael Murdock",
            "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"
        ),
        SuperHero(
            "Wolverine",
            "Marvel",
            "James Howlett",
            "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"
        ),
        SuperHero(
            "Batman",
            "DC",
            "Bruce Wayne",
            "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"
        ),
        SuperHero(
            "Thor",
            "Marvel",
            "Thor Odinson",
            "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"
        ),
        SuperHero(
            "Flash",
            "DC",
            "Jay Garrick",
            "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"
        ),
        SuperHero(
            "Green Lantern",
            "DC",
            "Alan Scott",
            "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"
        ),
        SuperHero(
            "Wonder Woman",
            "DC",
            "Princess Diana",
            "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        initRecycler()
    }

    fun initRecycler() {
        binding.rvSuperHelo.layoutManager = LinearLayoutManager(this)
        val adapter = HeroAdapter(superheros)
        binding.rvSuperHelo.adapter = adapter
    }
}
