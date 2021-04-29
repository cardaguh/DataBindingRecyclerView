package co.cyclopsapps.superheroeslist

import android.content.Context
import android.graphics.ColorSpace.get
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.superheroeslist.databinding.ActivityMainBinding
import co.cyclopsapps.superheroeslist.databinding.ItemSuperheroBinding
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

/**
 * Created by Carlos Daniel Agudelo on 28/04/2021.
 */
class HeroAdapter(val superhero: List<SuperHero>): RecyclerView.Adapter<HeroAdapter.HeroHolder>(){

    lateinit var binding: ItemSuperheroBinding
    lateinit var context: Context
    private val resource = R.layout.item_superhero

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        /*val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate((R.layout.item_superhero), parent, false))*/
        context = parent.context
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, resource, parent, false)
        return HeroHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    override fun getItemCount(): Int = superhero.size


    inner class HeroHolder(binding: ItemSuperheroBinding): RecyclerView.ViewHolder(binding.root) {

        init {
            //this.binding = binding
        }

        fun render(superHero: SuperHero) {
            binding.tvRealName.text = superHero.realName
            binding.tvSuperHeroName.text = superHero.superHeroName
            binding.tvPublisher.text = superHero.publisher

            //Picasso.get().load(superHero.image).into(binding.ivHero)
            Glide.with(binding.ivHero).load(superHero.image).into(binding.ivHero)
            binding.ivHero.setOnClickListener {
                Toast.makeText(binding.ivHero.context, "Has seleccionado a ${superHero.superHeroName}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}