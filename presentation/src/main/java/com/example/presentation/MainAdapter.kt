package com.example.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.GithubRandom
import com.example.presentation.base.BaseViewHolder
import com.example.presentation.databinding.ItemMainBinding

class MainAdapter(
    val itemClick: ((GithubRandom) -> Unit)
): RecyclerView.Adapter<BaseViewHolder>() {

    private val itemList = mutableListOf<GithubRandom>()

    fun setItemList(itemList: List<GithubRandom>) {
        this.itemList.clear()
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class MainViewHolder(private val binding: ItemMainBinding): BaseViewHolder(binding.root) {
        override fun bind(position: Int) {
            val itemData = itemList[position]
            Log.e("동주","Adapter = $itemData")

            Glide.with(binding.root.context).load(itemData.userProfile).into(binding.ivProfile)
            binding.tvUserName.text = itemData.userName
            binding.tvUserEmail.text = itemData.userEmail
            binding.tvUserCountry.text = itemData.userCountry

            binding.clBody.setOnClickListener {
                itemClick.invoke(itemData)
            }
        }
    }
}