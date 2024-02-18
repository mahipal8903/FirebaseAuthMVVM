package com.example.demoproject.dashboard
import CoffeeRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel: ViewModel() {
    private val coffeeRepository = CoffeeRepository()
    private val _coffees = MutableLiveData<List<Coffee>>()
    val coffees: LiveData<List<Coffee>> get() = _coffees

    init {
        loadCoffees()
    }

    private fun loadCoffees() {
        coffeeRepository.getCoffees().enqueue(object : Callback<List<Coffee>> {
            override fun onResponse(call: Call<List<Coffee>>, response: Response<List<Coffee>>) {
                if (response.isSuccessful) {
                    _coffees.value = response.body()
                } else {

                }
            }

            override fun onFailure(call: Call<List<Coffee>>, t: Throwable) {
            }
        })
    }
}