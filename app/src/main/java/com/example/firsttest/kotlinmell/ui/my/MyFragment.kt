package com.example.firsttest.kotlinmell.ui.my

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.activity.LoginActivity


class MyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(
            R.layout.fragment_my,
            container,
            false
        )
        initView(inflate)
        return inflate
    }

    private fun initView(inflate: View) {
        var login: TextView = inflate.findViewById(R.id.login)
        login.setOnClickListener {
            var intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}