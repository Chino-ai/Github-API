package com.example.submission1aplikasigithubuser.ui.detailUserActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.submission1aplikasigithubuser.data.source.remote.response.RepoResponseItem
import com.example.submission1aplikasigithubuser.databinding.ItemRepoUserBinding



class ListRepoAdapter(private val listUser: ArrayList<RepoResponseItem>) :
    RecyclerView.Adapter<ListRepoAdapter.ListViewHolder>() {


    class ListViewHolder(private var binding: ItemRepoUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listUser: RepoResponseItem) {
            with(binding) {
                tvUsername.text = listUser.fullName
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemRowUserBinding =
            ItemRepoUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemRowUserBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        holder.bind(user)

    }

    override fun getItemCount(): Int = listUser.size

    }