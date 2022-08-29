package com.example.submission1aplikasigithubuser.ui.detailUserActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.example.submission1aplikasigithubuser.data.source.remote.response.ItemsItem
import com.example.submission1aplikasigithubuser.data.source.remote.response.RepoResponse
import com.example.submission1aplikasigithubuser.data.source.remote.response.RepoResponseItem
import com.example.submission1aplikasigithubuser.databinding.ActivityDetailUserBinding
import com.example.submission1aplikasigithubuser.ui.main.ListUserAdapter


class DetailUserActivity : AppCompatActivity() {


    private lateinit var detailUserBinding: ActivityDetailUserBinding
    private val detailUserViewModel by viewModels<DetailUserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailUserBinding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(detailUserBinding.root)

        val user = intent.getParcelableExtra<ItemsItem>(EXTRA_USER) as ItemsItem


        detailUserViewModel.isLoading.observe(this, {
            showLoading(it)
        })

        detailUserViewModel.toast.observe(this, {
            it.getContentIfNotHandled()?.let {
                showToast(it)
            }

        })

        detailUserViewModel.name.observe(this){
            detailUserBinding.username.text = it
        }

        detailUserViewModel.username.observe(this){
            detailUserBinding.name.text = it
        }

        detailUserViewModel.descript.observe(this){
            detailUserBinding.descrip.text = it
        }

        detailUserViewModel.avatar.observe(this, {
            Glide.with(detailUserBinding.avatar)
                .load(it)
                .apply(RequestOptions().override(55, 55))
                .into(detailUserBinding.avatar)
        })

        detailUserViewModel.getRepo(user.login)
        detailUserViewModel.getUserDetail(user.login)
        name = user.login

        detailUserViewModel.repo.observe(this){
            setUserData(it)
        }


    }

    companion object {
        const val EXTRA_USER = "extra_user"
        lateinit var name: String


    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            detailUserBinding.progressBar.visibility = View.VISIBLE
        } else {
            detailUserBinding.progressBar.visibility = View.GONE
        }
    }

    private fun showToast(isToast: Boolean) {
        val caution = "No Internet Connection"
        if (isToast) {

            Toast.makeText(this@DetailUserActivity, caution, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUserData(userData: List<RepoResponseItem>) {
        val listReview = ArrayList<RepoResponseItem>()
        for (review in userData) {
            listReview.add(review)
        }
        val adapter = ListRepoAdapter(listReview)
        detailUserBinding.rv.adapter = adapter


    }


}