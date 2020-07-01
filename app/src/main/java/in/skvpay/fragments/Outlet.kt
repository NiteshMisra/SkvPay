package `in`.skvpay.fragments

import `in`.skvpay.R
import `in`.skvpay.activity.MainActivity
import `in`.skvpay.databinding.FragmentOutletBinding
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class Outlet : Fragment() {

    private lateinit var binding : FragmentOutletBinding
    private lateinit var activity1 : FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_outlet, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity1 = requireActivity()

        binding.first.setOnClickListener {
            activity1.onBackPressed()
        }

        binding.signupButton.setOnClickListener {
            val intent = Intent(activity1,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            activity1.startActivity(intent)
        }

        binding.loginText.setOnClickListener {
            activity1.finish()
        }

    }

    override fun onStart() {
        super.onStart()
        binding.first.isChecked = false
        binding.second.isChecked = true
    }

}