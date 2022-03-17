package com.example.application_test.feature.liste.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.application_test.R
import com.example.application_test.databinding.UserFragmentBinding
//import androidx.fragment.app.viewModels
import com.example.application_test.feature.liste.viewModel.UserViewModel
import com.example.application_test.network.UIState
import com.kinandcarta.casestudies.feature.list.view.adapter.UsersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : Fragment() {

    private val viewModel : UserViewModel by viewModels()

    private lateinit var binding: UserFragmentBinding
    private val adapter = UsersAdapter()



    override fun onCreateView(
        inflater: LayoutInflater,

        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        viewModel.getUsers()
        viewModel.users.observe(viewLifecycleOwner, ::handleCards)
    }
    private fun handleCards(uiState: UIState) {
        when(uiState) {
            is UIState.LOADING -> {
                binding.apply {
                    progress.isVisible = true
                    error.isGone = true
                }
            }
            is UIState.SUCCESS -> {
                binding.apply {
                    progress.isGone = true
                    error.isGone = true
                }

                adapter.submitList(uiState.response)
            }
            is UIState.ERROR -> {
                binding.apply {
                    progress.isGone = true
                    error.isVisible = true
                }
                Toast.makeText(requireContext(), "Please retry again!", Toast.LENGTH_LONG).show()
            }
        }
    }

}