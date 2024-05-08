package com.example.multiviewholder.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiviewholder.databinding.ItemRecyclerviewDefaultBinding
import com.example.multiviewholder.databinding.ItemRecyclerviewOrangeBinding
import com.example.multiviewholder.databinding.ItemRecyclerviewSkyBinding
import com.example.multiviewholder.databinding.UnknownItemBinding
import com.example.multiviewholder.presentation.main.model.CardInfoModel


class MyAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var cardList = listOf<CardInfoModel>()

    interface ItemClick {
        fun onClick(cardInfoModel: CardInfoModel)
    }
    var  itemClick: ItemClick? = null

    class DefaultViewHolder(private val binding: ItemRecyclerviewDefaultBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardInfoModel: CardInfoModel) {
            binding.apply {
                name.text = cardInfoModel.name
                cardNumber.text = cardInfoModel.cardNumber
                expirationDate.text = cardInfoModel.expirationDate
                price.text = cardInfoModel.price
            }
        }
    }

    class OrangeCardViewHolder(private val binding: ItemRecyclerviewOrangeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardInfoModel: CardInfoModel) {
            binding.apply {
                name.text = cardInfoModel.name
                cardNumber.text = cardInfoModel.cardNumber
                expirationDate.text = cardInfoModel.expirationDate
                price.text = cardInfoModel.price
            }
        }
    }

    class LightBlueCardViewHolder(private val binding: ItemRecyclerviewSkyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardInfoModel: CardInfoModel) {
            binding.apply {
                name.text = cardInfoModel.name
                cardNumber.text = cardInfoModel.cardNumber
                expirationDate.text = cardInfoModel.expirationDate
                price.text = cardInfoModel.price
            }
        }
    }

    class UnknownViewHolder(binding: UnknownItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() = Unit
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val multiViewType = MultiViewEnum.entries.find { it.viewType == viewType }
        return when (multiViewType) {
            MultiViewEnum.BLUE -> {
                DefaultViewHolder(ItemRecyclerviewDefaultBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            MultiViewEnum.ORANGE -> {
                OrangeCardViewHolder(ItemRecyclerviewOrangeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            MultiViewEnum.LIGHTBLUE -> {
                LightBlueCardViewHolder(ItemRecyclerviewSkyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> {
                UnknownViewHolder(UnknownItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val cardPosition = cardList[position]
        when (holder.itemViewType) {
            MultiViewEnum.BLUE.viewType -> {
                val blueHolder = holder as DefaultViewHolder
                blueHolder.bind(cardPosition)
                holder.itemView.setOnClickListener {
                    itemClick?.onClick(cardPosition)
                }
            }
            MultiViewEnum.ORANGE.viewType -> {
                val orangeHolder = holder as OrangeCardViewHolder
                orangeHolder.bind(cardPosition)
                holder.itemView.setOnClickListener {
                    itemClick?.onClick(cardPosition)
                }
            }
            MultiViewEnum.LIGHTBLUE.viewType -> {
                val lightBlueHolder = holder as LightBlueCardViewHolder
                lightBlueHolder.bind(cardPosition)
                holder.itemView.setOnClickListener {
                    itemClick?.onClick(cardPosition)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return cardList[position].cardViewType.viewType
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

}