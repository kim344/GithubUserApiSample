package com.example.presentation

import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun initStartView() {
        binding.rvUsers.adapter = MainAdapter {
            showToast(it.userName)
        }
    }

    override fun initDataBinding() {
        with(viewModel) {
            githubRandomUsers.observe(this@MainActivity) {
                Log.e("동주","여기 들어와?? $it")
                (binding.rvUsers.adapter as MainAdapter).setItemList(it)
            }
        }
    }

    override fun initAfterBinding() {
        binding.btnRefresh.setOnClickListener {
            viewModel.getGithubRandomUsers(10)
//            activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//                if (it.resultCode == RESULT_OK) {
//                    val result = it.data
//                }
//            }
//
//            val intent = Intent(this, MainActivity::class.java)
//            activityResultLauncher.launch(intent)
        }

        binding.btnContent.setOnClickListener {
            viewModel.getContent(2)
        }

        binding.btnLike.setOnClickListener {
            viewModel.getLike(5)
        }

        binding.btnReply.setOnClickListener {
            viewModel.getReply(30)
        }
    }

}