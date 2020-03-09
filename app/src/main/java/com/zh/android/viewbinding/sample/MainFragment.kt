package com.zh.android.viewbinding.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.zh.android.viewbinding.sample.databinding.FragmentMainBinding

/**
 * <b>Package:</b> com.zh.android.viewbinding.sample <br>
 * <b>Create Date:</b> 2020/3/9  10:19 AM <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
class MainFragment : Fragment() {
    private var mFragmentMainBinding: FragmentMainBinding? = null

    companion object {
        fun newInstance(args: Bundle? = null): Fragment {
            val fragment = MainFragment()
            fragment.arguments = args ?: Bundle()
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Fragment中使用ViewBinding
        mFragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)
        return mFragmentMainBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentMainBinding?.clickMe?.setOnClickListener {
            Toast.makeText(context, "Click Me", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //视图销毁，取消绑定
        mFragmentMainBinding = null
    }
}