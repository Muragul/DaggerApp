package com.app.daggerapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.app.daggerapp.App
import com.app.daggerapp.R
import com.app.daggerapp.ui.list.ListActivity
import com.app.daggerapp.ui.nestedrv.NestedRVActivity
import javax.inject.Inject

class LoginFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val loginViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_login, container, false)
        rootView.findViewById<Button>(R.id.view_list).setOnClickListener {
            val intent = Intent(activity, ListActivity::class.java)
            startActivity(intent)
        }
        rootView.findViewById<Button>(R.id.to_nested_rv).setOnClickListener {
            val intent = Intent(activity, NestedRVActivity::class.java)
            startActivity(intent)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel.login("abc", "def")
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}