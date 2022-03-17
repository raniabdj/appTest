package com.kinandcarta.casestudies.feature.list.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.application_test.databinding.UserItemBinding
import com.example.application_test.network.model.UserResponse
import com.kinandcarta.casestudies.feature.list.view.adapter.UsersAdapter.ItemsViewHolder

class UsersAdapter : ListAdapter<UserResponse, ItemsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(

            UserItemBinding.inflate(
                LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val caseStudy = getItem(position)
        holder.bind(caseStudy)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<UserResponse>() {
        override fun areItemsTheSame(oldItem: UserResponse, newItem: UserResponse): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: UserResponse, newItem: UserResponse): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class ItemsViewHolder(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(users: UserResponse) {
            binding.firstname.text = users.first_name
            binding.lastname.text = users.last_name
            binding.email.text = users.email
            Glide.with(itemView.context)
                .load(users.avatar)
                .into(binding.image)
        }
    }
}
