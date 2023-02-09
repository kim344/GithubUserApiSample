package com.example.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B: ViewDataBinding, V: BaseViewModel>(
    @LayoutRes val layout: Int
): AppCompatActivity() {

    lateinit var binding: B

    protected abstract val viewModel: V

    /**
     * 레이아웃 띄운 직후 호출
     * view or Activity 속성 등 초기화
     * ex)_ 리싸이클러뷰, 툴바, 드로어뷰
     */
    abstract fun initStartView()

    /**
     * 데이터 바인딩 및 RxJava 설정
     * ex)_ RxJava Observe, DataBinding Observe
     */
    abstract fun initDataBinding()

    /**
     * 바인딩 이후에 할 일을 여기에 구현
     * 그 외에 설정할 것이 있으면 여기서 설정
     * 클릭 리스너도 설정
     */
    abstract fun initAfterBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout)
        binding.lifecycleOwner = this

        initStartView()
        initDataBinding()
        initAfterBinding()
    }

    protected fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(resource: Int){
        Toast.makeText(this, resource, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}