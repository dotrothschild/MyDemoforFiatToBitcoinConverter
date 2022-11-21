package com.dotrothschild.mydemoforfiattobitcoinconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dotrothschild.bitcoinlib.ConvertBitcoin
import com.dotrothschild.mydemoforfiattobitcoinconverter.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            // Change the string value passed to test valid and not valid bitcoin names
            val oneBitcoin = ConvertBitcoin.ConvertBitcoin.getBitcoinValue("Simbex")
            if (oneBitcoin!= null) {
                binding.textviewFirst.text = oneBitcoin.toString()
            } else {
                binding.textviewFirst.text = "No bitcoin value found"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}