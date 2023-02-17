package fr.isen.idrisse.androiderestaurant

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import fr.isen.idrisse.androiderestaurant.databinding.ActivityMenuDetailsBinding
import fr.isen.idrisse.androiderestaurant.network.Plate

class MenuDetailsActivity : AppCompatActivity() {

    companion object {
        val PLATE_EXTRA = "PLATE_EXTRA"
    }

    lateinit var binding: ActivityMenuDetailsBinding
    var plate: Plate? = null


    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        plate = intent.getSerializableExtra(PLATE_EXTRA) as? Plate

        val ingredients = plate?.ingredients?.map{it.name}?.joinToString(", ") ?: ""
        binding.textView.text = ingredients

    //    plate?.let {
  //          binding.viewPager.adapter = PhotoAdapter(it.images, this)
//        }
    }
}