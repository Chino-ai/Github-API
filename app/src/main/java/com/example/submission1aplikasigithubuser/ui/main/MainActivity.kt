package com.example.submission1aplikasigithubuser.ui.main

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import android.widget.SearchView.OnQueryTextListener;
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.SearchView
import com.example.submission1aplikasigithubuser.R
import com.example.submission1aplikasigithubuser.data.source.remote.response.ItemsItem
import com.example.submission1aplikasigithubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        searchView = findViewById(R.id.searchView)

        mainViewModel.noData.observe(this, {
            activityMainBinding.noData.text = it
        })
        activityMainBinding.rv.setHasFixedSize(true)

        mainViewModel.userGithub.observe(this, {
            setUserData(it)

        })
        mainViewModel.isLoading.observe(this, {
            showLoading(it)

        })

        mainViewModel.toast.observe(this, {
            it.getContentIfNotHandled()?.let {
                showToast(it)
            }
        })



        searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                mainViewModel.getUserGithub(query)
                searchView.clearFocus()
                return true

            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })


        showRecycleView()

    }

    private fun setUserData(userData: List<ItemsItem>) {
        val listReview = ArrayList<ItemsItem>()
        for (review in userData) {
            listReview.add(review)
        }
        val adapter = ListUserAdapter(listReview)
        activityMainBinding.rv.adapter = adapter


    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            activityMainBinding.progressBar.visibility = View.VISIBLE
        } else {
            activityMainBinding.progressBar.visibility = View.GONE
        }
    }

    private fun showToast(isToast: Boolean) {
        val caution = "No Internet Connection"
        if (isToast) {

            Toast.makeText(this@MainActivity, caution, Toast.LENGTH_SHORT).show()
        }
    }

    private fun showRecycleView() {
        activityMainBinding.rv.layoutManager = LinearLayoutManager(this)
    }






}