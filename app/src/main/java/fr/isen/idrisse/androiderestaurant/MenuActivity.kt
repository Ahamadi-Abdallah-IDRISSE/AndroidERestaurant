package fr.isen.idrisse.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import fr.isen.idrisse.androiderestaurant.databinding.ActivityMenuBinding
import fr.isen.idrisse.androiderestaurant.network.MenuResult
//import fr.isen.idrisse.androiderestaurant.network.Category
import fr.isen.idrisse.androiderestaurant.network.NetworkConstants
import org.json.JSONObject
enum class Category {ENTREE, PLAT, DESSERT}
class MenuActivity : AppCompatActivity() {

    companion object {
        val CATEGORYKEY = "CATEGORYKEY"
    }

     lateinit var binding: ActivityMenuBinding
     lateinit var currentCategory: Category


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val category = intent.getSerializableExtra(CATEGORYKEY) as? Category
        currentCategory = category ?: Category.ENTREE
        //supportActionBar?.title = categoryName()
        makeRequest()

    }

    private fun showDatas(category: fr.isen.idrisse.androiderestaurant.network.Category){
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        binding.recyclerView.adapter= CustomAdapter(category.items){
            val intent = Intent(this, MenuDetailsActivity::class.java)
            intent.putExtra(MenuDetailsActivity.PLATE_EXTRA, it)
            startActivity(intent)
        }
    }

    private fun categoryName ():String{
        return when(currentCategory)
        {
            Category.ENTREE -> getString(R.string.starter)
            Category.PLAT -> getString(R.string.main)
            Category.DESSERT -> getString(R.string.finish)

        }
    }

    private fun categoryFilterKey ():String{
        return when (currentCategory)
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
            Request.Method.POST,
            NetworkConstants.url,
            params,
            {
                    result ->
                // success of request
                parseData(Result.toString())
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


    private  fun parseData (data: String)
    {
        val result = GsonBuilder().create().fromJson(data, MenuResult::class.java)
        val category = result.data.first{it.name == categoryFilterKey()}
        showDatas(category)
    }
/*
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
*/
}