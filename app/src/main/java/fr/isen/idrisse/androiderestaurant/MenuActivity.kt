package fr.isen.idrisse.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.idrisse.androiderestaurant.databinding.ActivityMenuBinding
import fr.isen.idrisse.androiderestaurant.network.NetworkConstants
import org.json.JSONObject
import java.lang.reflect.Method


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
        binding.recyclerView.adapter= CustomAdapter(listOf("1", "2", "3")){ position ->
            val menuDetailsIntent = Intent(this, MenuDetailsActivity::class.java)
            startActivity(menuDetailsIntent)
        }
    }

    private fun categoryName (category: Category):String{
        return when(category)
        {
            Category.ENTREE -> "ENTREES"
            Category.PLAT -> "PLATS"
            Category.DESSERT -> "DESSERTS"
        }
    }

    private fun makeRequest () {
        val queue = Volley.newRequestQueue(this)
        val params = JSONObject()
        params.put(NetworkConstants.idShopKey, 1)
        val request = JsonObjectRequest(
            Method.POST,
            NetworkConstants.url,
            params,
            {
                    result ->
                // success of request
                Log.d("request", result.toString(2))
            },
            {
                    error ->
                //Error when request
                Log.e("request", error.toString())
            }
        )
        queue.add(request)
        //showDatas()
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