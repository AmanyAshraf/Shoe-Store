package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =FragmentLoginBinding.inflate(inflater,container,false)
         binding.login.setOnClickListener { Navigation.findNavController(it).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()) }
        binding.signup.setOnClickListener { Navigation.findNavController(it).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()) }
        return binding.root
    }

}