package com.example.multiviewholder.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiviewholder.databinding.ActivityMainBinding
import com.example.multiviewholder.presentation.util.DecimalFormat
import com.example.multiviewholder.presentation.detail.DetailActivity
import com.example.multiviewholder.presentation.detail.DetailActivity.Companion.EXTRA_CARD
import com.example.multiviewholder.presentation.util.GridSpaceItemDecoration
import com.example.multiviewholder.presentation.adapter.MyAdapter
import com.example.multiviewholder.presentation.model.CardInfoModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter = MyAdapter()
    private lateinit var cardList: List<CardInfoModel>
    private val mainViewModel by viewModels<MainViewModel> {
        MainViewModlleFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()
        initViewModel()
    }

    // 실제 값을 받는 ViewModel의 함수
    private fun initData() {
        mainViewModel.getCardInfoModel()
    }

    // 옵저버 패턴 생성
    // 받아온 값을 observe로 감시하기에 값받는 부분과 옵저버는 따로 있어야 함
    private fun initViewModel() {
        mainViewModel.getCardModel.observe(this@MainActivity) {
            cardList = it
            adapter.cardList = cardList
            initView()
        }
    }

    // view에 데이터 넣는 부분
    private fun initView() {
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

        val intent = Intent(this, DetailActivity::class.java)
        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(cardInfoModel: CardInfoModel) {
                val bundle = Bundle().apply {
                    putParcelable(EXTRA_CARD, cardInfoModel as Parcelable)
                }
                intent.putExtra(EXTRA_CARD, bundle)
                startActivity(intent)
            }
        }

    }

}