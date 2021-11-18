package com.anatolyg.eysencktest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val view: View = inflater.inflate(R.layout.fragment_result, container, false)
        val endAppButton: Button = view.findViewById(R.id.end_app_button)
        val backToTestButton: Button = view.findViewById(R.id.back_to_test_button)
        val completionFragment = CompletionFragment()
        val resultView: TextView = view.findViewById(R.id.result_view)
        val summaResult: String = answerResult.toString()

        resultView.text = "Вы набрали ${summaResult} балла из 10 возможных по шкале Экстраверсии. " +
                "Показатель от 0 до 2 - это низкий покзатель, Вы скорее интроверт. " +
                "Показатель от 8 до 10 - это выскоий поаказатель, Вы скорее экстраверт. " +
                "Но помните, что это только ознакомительная часть теста, не принимайте результаты слишком близко к сердцу."

        endAppButton.setOnClickListener {
            activity?.finish()
        }

        backToTestButton.setOnClickListener {


            for (i:Int in 0..9){
                answerArray[i]=0
            }


            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentContainerView, completionFragment)
                ?.commit()
        }

        return view
    }

}