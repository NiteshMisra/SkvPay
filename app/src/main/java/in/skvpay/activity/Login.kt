package `in`.skvpay.activity

import `in`.skvpay.R
import `in`.skvpay.databinding.ActivityLoginBinding
import `in`.skvpay.fragments.Mobile
import `in`.skvpay.fragments.OTP
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager

class Login : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        fragmentManager = supportFragmentManager

        addFragment(0)

    }

    fun addFragment(position : Int){
        when(position){
            0 -> {
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Mobile())
                    .commit()
            }

            1 -> {
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, OTP())
                    .addToBackStack("Fragment")
                    .commit()
            }
        }
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 1){
            fragmentManager.popBackStack()
        }else{
            super.onBackPressed()
        }
    }
}