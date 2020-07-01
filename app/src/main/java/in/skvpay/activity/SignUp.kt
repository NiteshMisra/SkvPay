package `in`.skvpay.activity

import `in`.skvpay.R
import `in`.skvpay.databinding.ActivitySignUpBinding
import `in`.skvpay.fragments.Outlet
import `in`.skvpay.fragments.Personal
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager

class SignUp : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
        fragmentManager = supportFragmentManager

        addFragment(0)
    }

    fun addFragment(position : Int){
        when(position){
            0 -> {
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,Personal())
                    .commit()
            }

            1 -> {
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,Outlet())
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