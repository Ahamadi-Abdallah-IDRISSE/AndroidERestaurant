package fr.isen.idrisse.androiderestaurant.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Ingredient (
    @SerializedName("name") val name : String ): Serializable{}

