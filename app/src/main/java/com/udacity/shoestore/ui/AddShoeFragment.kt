package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentAddShoeBinding


class AddShoeFragment : Fragment() {
   private lateinit var binding: FragmentAddShoeBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAddShoeBinding.inflate(inflater,container,false)
        binding.viewModel=viewModel
        viewModel.clear()
        binding.cancel.setOnClickListener {
            Navigation.findNavController(it).navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoesListFragment()) }
        binding.save.setOnClickListener {
            if (viewModel.addNewShoes())
                Navigation.findNavController(it)
                    .navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoesListFragment())
            else {
                Toast.makeText(requireContext(), "missing Data!", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }



}