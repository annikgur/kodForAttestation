package com.anatolyg.eysencktest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class QuestionAdapter(private val questionList: List<QuestionData>) : RecyclerView.Adapter<QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val questionListItemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.question_view, parent, false)


        return QuestionViewHolder(questionListItemView)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {

        val questionCurrent = questionList[position]
        holder.bind(questionCurrent)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }
}