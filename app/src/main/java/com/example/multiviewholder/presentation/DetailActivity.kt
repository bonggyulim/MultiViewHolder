package com.example.multiviewholder.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.multiviewholder.data.CardInfo
import com.example.multiviewholder.data.DecimalFormat
import com.example.multiviewholder.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding : ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }
    companion object {
        const val EXTRA_CARD: String = "extra_card"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 메인에서 CardInfo 인스턴스 받아오기
        val cardItem = intent.getParcelableExtra<CardInfo>(EXTRA_CARD)

        // 메인에서 position을 받아와서 뷰모델에서 position으로 CardInfo 인스턴스 반환
        val position = intent.getIntExtra("position", 0)
        val cardData = cardViewModel.getCardPosition(position)

        binding.name.text = "이름 : ${cardItem?.name}"
        binding.cardnumber.text = "카드번호 : ${cardItem?.cardNumber}"
        binding.expirationDate.text = "유효기간 : ${cardData?.expirationDate?.get(0).toString()}"
        binding.expirationDate.append(" / ${cardData?.expirationDate?.get(1).toString()}")
        binding.price.text = "가격 : ${cardData?.price?.let { DecimalFormat.decimalFormat(it) }}"
    }
}