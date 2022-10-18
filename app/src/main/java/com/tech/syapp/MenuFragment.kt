package com.tech.syapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.tech.syapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegister = view.findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_regFragment)
        }
        val btnInquiryreg = view.findViewById<Button>(R.id.btnInquiryreg)
        btnInquiryreg.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_inquiryregFragment)
        }
        val btnQueryreg = view.findViewById<Button>(R.id.btnQueryreg)
        btnQueryreg.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_queryregFragment)
        }
        val btnAbout = view.findViewById<Button>(R.id.btnAbout)
        btnAbout.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_aboutFragment)
        }
        var addrTitle = getString(R.string.sy_addr_title)
        var addrContent = getString(R.string.sy_addr_content)
        val btnAddr = view.findViewById<Button>(R.id.btnAddr)
        btnAddr.text = addrTitle + addrContent
        btnAddr.setOnClickListener() {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/search/?api=1&query=" + addrContent)
            //"http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"
            )
            startActivity(intent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}