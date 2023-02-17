package fr.isen.idrisse.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.view.MenuItem
import fr.isen.idrisse.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonsListener()
        Log.d("Lifcylce", "HomeActivity onCreate")

    }

    override fun onStart () {
        super.onStart()
        Log.d("Lifcylce", "HomeActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifcylce", "HomeActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifcylce", "HomeActivity onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifcylce", "HomeActivity onDestroy")
    }



/*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

*/

    private fun buttonsListener(){
        binding.bouttonEntrees.setOnClickListener {
            showCategory(Category.ENTREE)
        }

        binding.bouttonPlats.setOnClickListener {
            showCategory(Category.PLAT)

        }

        binding.bouttonDesserts.setOnClickListener {
            showCategory(Category.DESSERT)
                    }
    }
    private fun showCategory(category: Category) {
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra(MenuActivity.CATEGORYKEY, category)
        startActivity(intent)
    }


}