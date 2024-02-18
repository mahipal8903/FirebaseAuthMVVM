package com.example.demoproject

import CoffeeAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoproject.dashboard.ViewModel
import com.example.demoproject.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDashboardBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //rv()

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        setupRecyclerView()
        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.coffees.observe(this, { coffees ->
            val adapter = CoffeeAdapter(coffees)
            binding.rv.adapter = adapter
        })
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rv.layoutManager = layoutManager
    }

//    private fun rv() {
//        binding.rv.layoutManager = LinearLayoutManager(this)
//        val data = ArrayList<Data>()
//
//        for (i in 1..20) {
//            data.add(Data(R.drawable.bgimage, "Item " + i, "Item " + i))
//        }
//        val adapter = DashboardAdapter(data)
//        binding.rv.adapter = adapter
//    }
}