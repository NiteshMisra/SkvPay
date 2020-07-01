package `in`.skvpay.fragments

import `in`.skvpay.R
import `in`.skvpay.activity.SignUp
import `in`.skvpay.databinding.FragmentPersonalBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity

class Personal : Fragment() {

    private lateinit var binding : FragmentPersonalBinding
    private lateinit var activity1 : FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_personal, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity1 = requireActivity()

        binding.signupButton.setOnClickListener {
            (activity1 as SignUp).addFragment(1)
        }

        binding.second.setOnClickListener {
            (activity1 as SignUp).addFragment(1)
        }
        
        binding.loginText.setOnClickListener { 
            activity1.finish()
        }

    }

    override fun onStart() {
        super.onStart()
        binding.first.isChecked = true
        binding.second.isChecked = false
    }

}