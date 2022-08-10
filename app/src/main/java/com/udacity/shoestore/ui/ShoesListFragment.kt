package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import kotlinx.android.synthetic.main.list_item.view.*


class ShoesListFragment : Fragment() {
    private lateinit var binding: FragmentShoesListBinding

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentShoesListBinding.inflate(inflater,container,false)
        binding.addShoeButton.setOnClickListener { Navigation.findNavController(it).navigate(R.id.action_shoesListFragment_to_addShoeFragment) }
        setHasOptionsMenu(true)
        viewModel.shoeList.observe(viewLifecycleOwner) {
            for (shoe in it) {
                addItem(shoe.name)
                addItem(shoe.size.toString())
                addItem(shoe.company)
                addItem(shoe.description)

            }
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> view?.let { Navigation.findNavController(it).navigate(R.id.action_shoesListFragment_to_loginFragment) }
        }
        return super.onOptionsItemSelected(item)
    }
     private fun addItem(shoeName : String ){
        val view =layoutInflater.inflate(R.layout.list_item,null)
         view.shoeItemList.text=shoeName
         binding.shoesList.addView(view.shoeItemList)
    }


}