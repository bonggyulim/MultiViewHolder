package com.example.multiviewholder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.multiviewholder.data.CardInfo
import com.example.multiviewholder.data.DataSource

class CardViewModel(val dataSource: DataSource): ViewModel() {
    var cardLiveData = dataSource.getCardList()

    fun getCardData(position: Int): CardInfo{
        return cardLiveData.get(position)
    }
}
//viewModel 생성
class CardViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardViewModel::class.java)) {
            return CardViewModel(dataSource = DataSource.getDataSource()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}