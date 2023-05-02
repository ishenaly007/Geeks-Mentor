package com.abit8.test_git

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.abit8.test_git.onboard.FirstOnBoardFragment
import com.abit8.test_git.onboard.SecondOnBoardFragment
import com.abit8.test_git.onboard.ThirdOnBoardFragment
import com.abit8.test_git.base.BaseActivity
import com.abit8.test_git.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val fragmentManager = supportFragmentManager
    private val fragmentTransaction = fragmentManager.beginTransaction()

    private val container = R.id.container_main
    private val firstFragment = FirstOnBoardFragment()
    private val secondFragment = SecondOnBoardFragment()
    private val thirdFragment = ThirdOnBoardFragment()

    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        fragmentTransaction.replace(container, thirdFragment)
        fragmentTransaction.replace(container, secondFragment)
        fragmentTransaction.replace(container, firstFragment)

        fragmentTransaction.commit()
    }

//    fun navigateToSecondFragment() {
//        val secondFragment = SecondOnBoardFragment()
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.firstOnBoard, secondFragment)
//            .addToBackStack(null)
//            .commit()
//    }
//
//    fun navigateToThirdFragment() {
//        val thirdFragment = ThirdOnBoardFragment()
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.secondOnBoard, thirdFragment)
//            .addToBackStack(null)
//            .commit()
//    } - Логика в мэйне как второй вариант

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}