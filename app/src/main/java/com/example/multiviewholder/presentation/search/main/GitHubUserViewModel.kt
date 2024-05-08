package com.example.multiviewholder.presentation.search.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.multiviewholder.data.database.DataSource
import com.example.multiviewholder.data.network.RetrofitClient
import com.example.multiviewholder.data.remote.SearchRepositoryImpl
import com.example.multiviewholder.presentation.search.model.GitHubUserEntity
import com.example.multiviewholder.presentation.search.repository.SearchRepository
import kotlinx.coroutines.launch

// 뷰모델을 사용하여 recyclerview UI 상태 관리를 함
class GitHubUserViewModel(private val searchRepository: SearchRepository): ViewModel() {

    private val _getGitHubUserList: MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
    val getGitHubUserList: LiveData<List<GitHubUserEntity>> get() = _getGitHubUserList

    // repository 패턴의 아이템을 라이브 데이터로 사용
    fun getGitHubUserList() = viewModelScope.launch {
        _getGitHubUserList.value = searchRepository.getGitHubUserList("cindy").items
    }
}


class GitHubUserViewModelFactory : ViewModelProvider.Factory {
    private val repository = SearchRepositoryImpl(DataSource, RetrofitClient.searchGitHubUser)
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {

        return GitHubUserViewModel(
            repository
        ) as T
    }
}