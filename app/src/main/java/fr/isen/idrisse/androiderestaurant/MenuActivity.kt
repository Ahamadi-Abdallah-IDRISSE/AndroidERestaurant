package fr.isen.idrisse.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.isen.idrisse.androiderestaurant.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


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