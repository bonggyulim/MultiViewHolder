package com.example.multiviewholder.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.multiviewholder.R
import com.example.multiviewholder.data.CardInfo
import com.example.multiviewholder.data.DecimalFormat
import com.example.multiviewholder.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_detail) }
    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }
    companion object {
        const val EXTRA_CARD: String = "extra_card"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var cardItem = intent.getParcelableExtra<CardInfo>(EXTRA_CARD)
        val itemCount = intent.getIntExtra("itemCount", 0)

        var currentPosition = cardItem?.position

        if (currentPosition != null) {
            binding.cardinfo = cardItem
        }

        binding.nextCard.setOnClickListener {
            if (currentPosition != null && itemCount - 1 > currentPosition) {
                binding.cardinfo = cardViewModel.getCardData(currentPosition + 1)
                currentPosition++
            } else {
                Toast.makeText(this, "다음 카드가 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.beforeCard.setOnClickListener {
            if (currentPosition != null && currentPosition > 0) {
                binding.cardinfo = cardViewModel.getCardData(currentPosition - 1)
                currentPosition--
            } else {
                Toast.makeText(this, "이전 카드가 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
