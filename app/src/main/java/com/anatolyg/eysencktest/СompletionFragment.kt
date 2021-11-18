package com.anatolyg.eysencktest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CompletionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_completion, container, false)


        val endTestButton: Button = view.findViewById(R.id.end_test_button)
        val resultFragment = ResultFragment()

        var keySave: String
        for (i:Int in 0..9){
            keySave = "key${i}"
            answerArray[i] = savedInstanceState?.getInt(keySave) ?: 0
        }

        endTestButton.setOnClickListener {
            answerResult = 0
            for (i:Int in 0..9){
                answerResult += answerArray[i]
            }
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView, resultFragment)?.commit()
        }

        val questionList: List<QuestionData> = listOf(
            QuestionData(1, "Часто ли вы испытываете тягу к новым впечатлениям, к тому, чтобы отвлечься, испытывать сильные ощущения?", "Norm", "Extravert"),
            QuestionData(2, "Считаете ли вы себя беззаботным человеком?", "Norm", "Extravert"),
            QuestionData(3, "Быстро ли вы обычно действуете и говорите, не тратите ли много времени на обдумывание?", "Norm", "Extravert"),
            QuestionData(4, "Верно ли, что на спор вы способны решиться на всё?", "Norm", "Extravert"),
            QuestionData(5, "Часто ли бывает, что вы действуете необдуманно, под влиянием момента?", "Norm", "Extravert"),
            QuestionData(6, "Любите ли вы часто бывать в компании?", "Norm", "Extravert"),
            QuestionData(7, "Когда на вас кричат, отвечаете ли вы тем же?", "Norm", "Extravert"),
            QuestionData(8, "Способны ли вы иногда дать волю своим чувствам и беззаботно развлечься с весёлой компанией?", "Norm", "Extravert"),
            QuestionData(9, "Слывёте ли вы за человека живого и весёлого?", "Norm", "Extravert"),
            QuestionData(10, "Нравится ли вам работа, требующая быстрого действия?", "Norm", "Extravert")
        )

        val questionRecyclerView: RecyclerView = view.findViewById(R.id.question_recycler_view)

        questionRecyclerView.layoutManager = LinearLayoutManager( activity, LinearLayoutManager.VERTICAL, false)

        questionRecyclerView.adapter = QuestionAdapter(questionList)


        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        var keySave: String
        for (i:Int in 0..9){
            keySave = "key${i}"
            outState.putInt(keySave, answerArray[i])
        }
        super.onSaveInstanceState(outState)
    }


}


