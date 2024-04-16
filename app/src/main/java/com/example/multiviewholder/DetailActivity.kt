package com.example.multiviewholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.multiviewholder.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding : ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("bundle")
        val cardInfo = bundle?.getParcelable<CardInfo>("parcelable")
        Log.d("bundle", "${cardInfo?.name}")

        binding.name.text = "이름 : ${cardInfo?.name}"
        binding.cardnumber.text = "카드번호 : ${cardInfo?.cardNumber}"
        binding.expirationDate.text = "유효기간 : ${cardInfo?.expirationDate?.get(0).toString()}"
        binding.expirationDate.append(" / ${cardInfo?.expirationDate?.get(1).toString()}")
        binding.price.text = "가격 : ${cardInfo?.price?.let { DecimalFormat.decimalFormat(it) }}"
    }
}