package com.abit8.test_git.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected abstract fun inflateViewBinding(): VB
    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)

        isConnection()
        initViews()
        initViewModels()
        initListener()
    }

    open fun isConnection() {} // проверка на подключение к интернету
    open fun initViews() {}  // инициализация вьюшек
    open fun initViewModels() {} // все обзерверы нашего ViewModel\'a
    open fun initListener() {} // инициализация кнопок

}