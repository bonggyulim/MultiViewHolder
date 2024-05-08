package com.example.multiviewholder.presentation.main.main

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiviewholder.databinding.ActivityMainBinding
import com.example.multiviewholder.presentation.main.adapter.MyAdapter
import com.example.multiviewholder.presentation.main.detail.DetailActivity
import com.example.multiviewholder.presentation.main.model.CardInfoModel
import com.example.multiviewholder.presentation.main.util.DecimalFormat
import com.example.multiviewholder.presentation.main.util.GridSpaceItemDecoration
import com.example.multiviewholder.presentation.search.main.GitHubUserActivity

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

        binding.button.setOnClickListener {
            val intent = Intent(this, GitHubUserActivity::class.java)
            startActivity(intent)
        }

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
                    putParcelable(DetailActivity.EXTRA_CARD, cardInfoModel as Parcelable)
                }
                intent.putExtra(DetailActivity.EXTRA_CARD, bundle)
                startActivity(intent)
            }
        }

    }

}