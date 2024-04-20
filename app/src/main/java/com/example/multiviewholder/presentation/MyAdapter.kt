package com.example.multiviewholder.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiviewholder.data.CardInfo
import com.example.multiviewholder.data.DecimalFormat
import com.example.multiviewholder.data.MultiViewEnum
import com.example.multiviewholder.databinding.ItemRecyclerviewDefaultBinding
import com.example.multiviewholder.databinding.ItemRecyclerviewOrangeBinding
import com.example.multiviewholder.databinding.ItemRecyclerviewSkyBinding
import java.lang.RuntimeException


class MyAdapter(private val onClick: (CardInfo) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var cardList = listOf<CardInfo>()
    class DefaultViewHolder(private val binding: ItemRecyclerviewDefaultBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardInfo: CardInfo) {
            binding.apply {
                name.text = cardInfo.name
                cardNumber.text = cardInfo.cardNumber
                expirationDate.text = cardInfo.expirationDate.joinToString()
                price.text = cardInfo.price.toString()
            }
        }
    }

    class OrangeCardViewHolder(private val binding: ItemRecyclerviewOrangeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardInfo: CardInfo) {
            binding.apply {
                name.text = cardInfo.name
                cardNumber.text = cardInfo.cardNumber
                expirationDate.text = cardInfo.expirationDate.joinToString()
                price.text = cardInfo.price.toString()
            }
        }
    }

    class LightBlueCardViewHolder(private val binding: ItemRecyclerviewSkyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardInfo: CardInfo) {
            binding.apply {
                name.text = cardInfo.name
                cardNumber.text = cardInfo.cardNumber
                expirationDate.text = cardInfo.expirationDate.joinToString()
                price.text = cardInfo.price.toString()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (viewType) {
            MultiViewEnum.BLUE.viewType -> {
                DefaultViewHolder(ItemRecyclerviewDefaultBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            MultiViewEnum.ORANGE.viewType -> {
                OrangeCardViewHolder(ItemRecyclerviewOrangeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            MultiViewEnum.LIGHTBLUE.viewType -> {
                LightBlueCardViewHolder(ItemRecyclerviewSkyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> throw RuntimeException("에러")

        }
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val cardPosition = cardList[position]

        when (holder.itemViewType) {
            MultiViewEnum.BLUE.viewType -> {
                val blueHolder = holder as DefaultViewHolder
                blueHolder.bind(cardPosition)
                holder.itemView.setOnClickListener {
                    onClick(cardPosition)
                }
            }
            MultiViewEnum.ORANGE.viewType -> {
                val orangeHolder = holder as OrangeCardViewHolder
                orangeHolder.bind(cardPosition)
                holder.itemView.setOnClickListener {
                    onClick(cardPosition)
                }
            }
            MultiViewEnum.LIGHTBLUE.viewType -> {
                val lightBlueHolder = holder as LightBlueCardViewHolder
                lightBlueHolder.bind(cardPosition)
                holder.itemView.setOnClickListener {
                    onClick(cardPosition)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> MultiViewEnum.BLUE.viewType
            1 -> MultiViewEnum.ORANGE.viewType
            2 -> MultiViewEnum.LIGHTBLUE.viewType
            else -> throw IllegalAccessException("에러")
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

}