package com.abit8.test_git.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.abit8.test_git.R
import com.abit8.test_git.databinding.OnBoarding1FragmentBinding

class FirstOnBoardFragment : Fragment(){
    private lateinit var binding: OnBoarding1FragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OnBoarding1FragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBoarding1.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out)
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN) 
            fragmentTransaction.replace(R.id.container_main, SecondOnBoardFragment())
            fragmentTransaction.addToBackStack(null) // позволяет вернуться назад
            fragmentTransaction.commit()
        }
    }
}
