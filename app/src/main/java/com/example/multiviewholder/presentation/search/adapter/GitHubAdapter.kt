package com.example.multiviewholder.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.multiviewholder.databinding.GithubRecyclerviewBinding
import com.example.multiviewholder.presentation.main.util.ImageLoader
import com.example.multiviewholder.presentation.search.model.GitHubUserEntity
import com.example.multiviewholder.presentation.search.model.GitHubUserListEntity

class GitHubAdapter(val items: List<GitHubUserEntity>) : RecyclerView.Adapter<GitHubAdapter.Holder>() {

    class Holder(private val binding: GithubRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.rvGitIv
        val text = binding.rvGitTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = GithubRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val getItem = items[position]

        ImageLoader.load(getItem.avatarUrl, holder.image)
        holder.text.text = getItem.loginName
    }
}