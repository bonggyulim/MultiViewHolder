package com.example.multiviewholder.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiviewholder.data.CardInfo
import com.example.multiviewholder.data.DecimalFormat
import com.example.multiviewholder.data.GridSpaceItemDecoration
import com.example.multiviewholder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter: MyAdapter by lazy {
        MyAdapter { cardInfo ->
            adapterOnClick(cardInfo)
        }
    }
    private fun adapterOnClick(cardInfo: CardInfo) {
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle().apply {
            putParcelable(DetailActivity.EXTRA_CARD, cardInfo)
        }
        intent.putExtra("itemCount", adapter.itemCount)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val cardList = DataSource.getDataSource().getCardList()
//        adapter.cardList = cardList

        val cardList = cardViewModel.cardLiveData
        adapter.cardList = cardList

        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            val stringData = DecimalFormat.decimalFormat(285856.2)
            price2.text = "$" + stringData
            recyclerView.run {
                val spanCount = 1
                val space = 20
                addItemDecoration(GridSpaceItemDecoration(spanCount, space))
            }
        }
    }
}