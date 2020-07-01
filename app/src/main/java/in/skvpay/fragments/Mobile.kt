package `in`.skvpay.fragments

import `in`.skvpay.R
import `in`.skvpay.activity.Login
import `in`.skvpay.activity.MainActivity
import `in`.skvpay.activity.SignUp
import `in`.skvpay.databinding.FragmentMobileBinding
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity

class Mobile : Fragment() {

    private lateinit var binding : FragmentMobileBinding
    private lateinit var activity1 : FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mobile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity1 = requireActivity()

        binding.sendOtpButton.setOnClickListener {
            (activity1 as Login).addFragment(1)
        }

        binding.signUpText.setOnClickListener {
            startActivity(Intent(activity1, SignUp::class.java))
        }

    }
}