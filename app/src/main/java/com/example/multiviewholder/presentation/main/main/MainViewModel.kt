package com.example.multiviewholder.presentation.main.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.multiviewholder.data.database.CardRepositoryImpl
import com.example.multiviewholder.data.database.DataSource
import com.example.multiviewholder.presentation.main.model.CardInfoModel
import com.example.multiviewholder.presentation.search.repository.SearchRepository

class MainViewModel(private val searchRepository: SearchRepository): ViewModel() {
    private val _getCardModel: MutableLiveData<List<CardInfoModel>> = MutableLiveData()
    val getCardModel : LiveData<List<CardInfoModel>> get() = _getCardModel

    fun getCardInfoModel() {
        // Mapper 인터페이스를 통해 DB의 entity값을 직렬화된 데이터로 받아올 수 있음
        _getCardModel.value = searchRepository.getCardList()
    }
}

class MainViewModlleFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(CardRepositoryImpl(DataSource)) as T
    }
}