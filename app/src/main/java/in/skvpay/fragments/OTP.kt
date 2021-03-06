package `in`.skvpay.fragments

import `in`.skvpay.R
import `in`.skvpay.activity.MainActivity
import `in`.skvpay.activity.SignUp
import `in`.skvpay.databinding.FragmentOTPBinding
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity

class OTP : Fragment() {

    private lateinit var binding : FragmentOTPBinding
    private lateinit var activity1 : FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_o_t_p, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity1 = requireActivity()
        binding.loginButton.setOnClickListener {
            startActivity(Intent(activity1,MainActivity::class.java))
        }

        binding.signUpText.setOnClickListener {
            startActivity(Intent(activity1,SignUp::class.java))
        }
    }
}