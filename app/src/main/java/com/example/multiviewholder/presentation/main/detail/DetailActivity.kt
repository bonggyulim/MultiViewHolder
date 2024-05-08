package com.example.multiviewholder.presentation.main.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multiviewholder.databinding.ActivityDetailBinding
import com.example.multiviewholder.presentation.main.model.CardInfoModel


class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    companion object {
        const val EXTRA_CARD: String = "extra_card"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val bundle = intent.getBundleExtra(EXTRA_CARD)
        val cardInfoEntityParcelable = bundle?.getParcelable<CardInfoModel>(EXTRA_CARD)

        binding.apply {
            name.text = cardInfoEntityParcelable?.name
            cardnumber.text = cardInfoEntityParcelable?.cardNumber
            expirationDate.text = cardInfoEntityParcelable?.expirationDate
            price.text = cardInfoEntityParcelable?.price
        }
    }
}

