package `in`.skvpay.activity

import `in`.skvpay.R
import `in`.skvpay.databinding.ActivityMainBinding
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        binding.toolbar.title = ("")
        setSupportActionBar(binding.toolbar)

        setSlider()
        initNavigationMenu()

        binding.navView.setNavigationItemSelectedListener { it ->
            when(it.itemId){
                R.id.nav_logOut -> {
                    startActivity(Intent(this,Login::class.java))
                }
            }
            return@setNavigationItemSelectedListener true
        }

    }

    private fun initNavigationMenu() {

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawer,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()


        //supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24)
    }

    fun setSlider() {

        val newSliderList: ArrayList<Int> = ArrayList()
        for (i in 0..3) {     // adding 10 to the left of slider and 10 to the right of slider and 1 is the original slider
            newSliderList.add(i)
        }
        val adapterImageSlider =
            AdapterImageSlider(
                this,
                newSliderList
            )
        adapterImageSlider.notifyDataSetChanged()
        binding.viewPager.setAdapter(adapterImageSlider)

        addBottomDots(binding.layoutDots, newSliderList.size, 0)
        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                pos: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(pos: Int) {
                addBottomDots(binding.layoutDots, newSliderList.size, pos % newSliderList.size)
                /*if (countDownTimer != null) {
                    countDownTimer.start()
                }*/
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        //startAutoSlider(adapterImageSlider.getCount())
    }

    private fun addBottomDots(
        layout_dots: LinearLayout,
        size: Int,
        current: Int
    ) {
        val dots =
            arrayOfNulls<ImageView>(size)
        layout_dots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = ImageView(this)
            val widthHeight = 17
            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams(
                    widthHeight,
                    widthHeight
                )
            )
            params.setMargins(10, 0, 10, 0)
            dots[i]!!.layoutParams = params
            dots[i]!!.setImageResource(R.drawable.shape_circle_outline)
            dots[i]!!.setColorFilter(
                ContextCompat.getColor(this, R.color.grey_40),
                PorterDuff.Mode.SRC_ATOP
            )
            layout_dots.addView(dots[i])
        }
        if (dots.isNotEmpty()) {
            dots[current]!!.setImageResource(R.drawable.shape_circle)
            dots[current]!!.setColorFilter(
                ContextCompat.getColor(this, R.color.colorPrimary),
                PorterDuff.Mode.SRC_ATOP
            )
        }
    }

    private class AdapterImageSlider(
        private val act: Context,
        private var imageList: List<Int>
    ) :
        PagerAdapter() {

        override fun getCount(): Int {
            return imageList.size
        }

        fun getItem(pos: Int): Int {
            return imageList.size
        }

        fun setItems(items1: List<Int>) {
            imageList = items1
            notifyDataSetChanged()
        }

        override fun isViewFromObject(
            view: View,
            `object`: Any
        ): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val sliderModel: Int = imageList[position]
            val inflater =
                act.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val v: View =
                inflater.inflate(R.layout.item_slider_image, container, false)
            val image =
                v.findViewById<ImageView>(R.id.image)
            val parent: CardView = v.findViewById(R.id.parent)
            parent.setOnClickListener { v1 ->
                // do here
            }
            container.addView(v)
            return v
        }

        override fun destroyItem(
            container: ViewGroup,
            position: Int,
            `object`: Any
        ) {
            container.removeView(`object` as LinearLayout)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.notification_menu, menu)
        return true
    }

}