package com.example.multiviewholder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiviewholder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var adapter = MyAdapter(cardList())
        var stringData = DecimalFormat.decimalFormat(285856.2)

        binding.price2.text = "$$stringData"

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val dataSource = DataSource.getDataSource()
        adapter.cardList = dataSource.getCardList()

        val detailIntent = Intent(this, DetailActivity::class.java)

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val bundle = Bundle()
                bundle.putParcelable("parcelable", adapter.cardList[position] as Parcelable)
                detailIntent.putExtra("bundle", bundle)
                startActivity(detailIntent)
            }
        }

        binding.recyclerView.run {
            val spanCount = 1
            val space = 20
            addItemDecoration(GridSpaceItemDecoration(spanCount, space))
        }
    }
}