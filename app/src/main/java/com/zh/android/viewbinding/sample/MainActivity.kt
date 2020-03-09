package com.zh.android.viewbinding.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zh.android.viewbinding.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //使用ViewBinding绑定控件
        mActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        //获取根布局
        val rootView = mActivityBinding.root
        //设置根布局
        setContentView(rootView)
        setupToolBar()
        //添加Fragment
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,
                        MainFragment.newInstance(),
                        MainFragment::class.java.simpleName)
                .commit()
    }

    private fun setupToolBar() {
        //绑定ToolBar
        mActivityBinding.toolBar.title = resources.getString(R.string.app_name)
    }
}