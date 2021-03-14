package com.example.android.miwok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlin.reflect.KClass
import kotlin.reflect.KClassifier

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager: ViewPager = findViewById<ViewPager>(R.id.vp_navigation_host).apply {
            adapter = ViewPagerAdapter(supportFragmentManager,
                arrayListOf(NumbersFragment(getText(R.string.category_numbers)),
                            FamilyFragment(getText(R.string.category_family)),
                            ColorsFragment(getText(R.string.category_colors)),
                            PhrasesFragment(getText(R.string.category_phrases))))
        }
        val tabLayout: TabLayout = findViewById<TabLayout>(R.id.tl_navigation_host).apply {
            setupWithViewPager(viewPager)
        }
        Log.w("Resources", resources.getText(R.string.category_numbers).toString())
    }
}