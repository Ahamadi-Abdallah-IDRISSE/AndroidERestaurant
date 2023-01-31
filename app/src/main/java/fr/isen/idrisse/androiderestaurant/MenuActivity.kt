package fr.isen.idrisse.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.idrisse.androiderestaurant.databinding.ActivityMenuBinding


enum class Category {ENTREE, PLAT, DESSERT}
class MenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding

    companion object {
        val extraKey = "extraKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getSerializableExtra(extraKey) as? Category

        supportActionBar?.title = categoryName(category ?: Category.ENTREE)
        showDatas()

/*
        val buttonID = intent.getIntExtra("buttonID", 0)

        if (buttonID == 0)
        {
            binding.textViewMenu.text = getString(R.string.menuEntrees)
        }
        else if (buttonID == 1)
        {
            binding.textViewMenu.text = getString(R.string.menuPlats)
        }
        else if (buttonID == 2)
        {
            binding.textViewMenu.text = getString(R.string.menuDesserts)
        }
*/
    }

    private fun showDatas(){
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        binding.recyclerView.adapter= CustomAdapter(listOf("1", "2", "3"))
    }

    private fun categoryName (category: Category):String{
        return when(category)
        {
            Category.ENTREE -> "ENTREES"
            Category.PLAT -> "PLATS"
            Category.DESSERT -> "DESSERTS"
        }
    }

    override fun onStart () {
        super.onStart()
        Log.d("Lifcylce", "MenuActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifcylce", "MenuActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifcylce", "MenuActivity onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifcylce", "MenuActivity onDestroy")
    }
}