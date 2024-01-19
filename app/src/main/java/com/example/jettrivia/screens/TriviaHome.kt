package com.example.jettrivia.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jettrivia.components.Question


@Composable
fun TriviaHome(viewModel: QuestionVIewModel = hiltViewModel()) {
    Question(viewModel)
}


