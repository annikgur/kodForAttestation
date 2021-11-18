package com.anatolyg.eysencktest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_instruction, container, false)
        val startTestButton: Button = view.findViewById(R.id.start_test_button)
        val completionFragment = CompletionFragment()
        startTestButton.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentContainerView, completionFragment)
                ?.commit()
        }
        return view
    }

}