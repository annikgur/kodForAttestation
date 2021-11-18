package com.anatolyg.eysencktest

import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

var answerArray = Array(10, {0})

class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(questionData: QuestionData) {

        val textQuestion: TextView = itemView.findViewById(R.id.text_question)
        val noRadioButton: RadioButton = itemView.findViewById(R.id.no_r_button)
        val yesRadioButton: RadioButton = itemView.findViewById(R.id.yes_r_button)
        val numberQuestion: Int = questionData.numberQuestion-1

        textQuestion.text = questionData.textQuestion


        if (answerArray[numberQuestion]==1){
            yesRadioButton.isChecked = true
        }


        noRadioButton.setOnClickListener{
            answerArray[numberQuestion]=0
        }

        yesRadioButton.setOnClickListener{
            answerArray[numberQuestion]=1
        }

    }

}