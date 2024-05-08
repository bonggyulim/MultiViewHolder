package com.example.multiviewholder.presentation.search.main

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.multiviewholder.R
import com.example.multiviewholder.databinding.ActivityGitHubUserBinding
import com.example.multiviewholder.presentation.search.adapter.GitHubAdapter

class GitHubUserActivity : AppCompatActivity() {
    private val binding by lazy { ActivityGitHubUserBinding.inflate(layoutInflater) }
    // 뷰모델 팩토리를 사용해 뷰모델 생성
    private val gitHubUserViewModel by viewModels<GitHubUserViewModel> {
        GitHubUserViewModelFactory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        gitHubUserViewModel.getGitHubUserList()

        // 라이브 데이터 사용하였으므로 옵저버 패턴 사용
        gitHubUserViewModel.getGitHubUserList.observe(this@GitHubUserActivity){ gitHubUserList ->
            Log.d("debug100", gitHubUserList.toString())

            val adapter = GitHubAdapter(gitHubUserList)
            binding.rvGit.adapter = adapter
            binding.rvGit.layoutManager = GridLayoutManager(this, 2)
        }
    }
}