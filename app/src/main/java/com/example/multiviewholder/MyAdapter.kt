package com.example.multiviewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiviewholder.databinding.ItemRecyclerviewDefaultBinding
import com.example.multiviewholder.databinding.ItemRecyclerviewOrangeBinding
import com.example.multiviewholder.databinding.ItemRecyclerviewSkyBinding
import java.lang.RuntimeException


class MyAdapter(private val items: List<CardInfo>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var cardList = listOf<CardInfo>()
    var itemClick : ItemClick? = null

    inner class DefaultViewHolder(private val binding: ItemRecyclerviewDefaultBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
        val cardNumber = binding.cardNumber
        val expirationDate = binding.expirationDate
        val price = binding.price
    }

    inner class OrangeCardViewHolder(private val binding: ItemRecyclerviewOrangeBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
        val cardNumber = binding.cardNumber
        val expirationDate = binding.expirationDate
        val price = binding.price
    }

    inner class SkyCardViewHolder(private val binding: ItemRecyclerviewSkyBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
        val cardNumber = binding.cardNumber
        val expirationDate = binding.expirationDate
        val price = binding.price
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (viewType) {
            CardInfo.BLUE_TYPE -> {
                DefaultViewHolder(ItemRecyclerviewDefaultBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            CardInfo.ORANGE_TYPE -> {
                OrangeCardViewHolder(ItemRecyclerviewOrangeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            CardInfo.SKY_TYPE -> {
                SkyCardViewHolder(ItemRecyclerviewSkyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> throw RuntimeException("에러")

        }
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        val cardPosition = cardList[position]

        when (cardPosition.type) {
            CardInfo.BLUE_TYPE -> {
                (holder as DefaultViewHolder).name.text = cardPosition.name
                holder.cardNumber.text = cardPosition.cardNumber
                holder.expirationDate.text = cardPosition.expirationDate.joinToString("")
                holder.price.text = "$" + DecimalFormat.decimalFormat(items[position].price)
            }
            CardInfo.ORANGE_TYPE -> {
                (holder as OrangeCardViewHolder).name.text = cardPosition.name
                holder.cardNumber.text = cardPosition.cardNumber
                holder.expirationDate.text = cardPosition.expirationDate.joinToString("")
                holder.price.text = "$" + DecimalFormat.decimalFormat(items[position].price)
            }
            CardInfo.SKY_TYPE -> {
                (holder as SkyCardViewHolder).name.text = cardPosition.name
                holder.cardNumber.text = cardPosition.cardNumber
                holder.expirationDate.text = cardPosition.expirationDate.joinToString("")
                holder.price.text = "$" + DecimalFormat.decimalFormat(items[position].price)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return cardList[position].type
    }

    override fun getItemCount(): Int {
        return items.size
    }
}