package com.example.jettrivia.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettrivia.screens.QuestionVIewModel
import com.example.jettrivia.utils.AppColors

@Composable
fun Question(viewModel: QuestionVIewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
        Log.d("Loading", "Questions: ....Loading...")
    } else {
        questions?.forEach { questionItem ->

            Log.d("Result", "Question : ${questionItem.question}")
        }
    }
}

@Composable
@Preview
fun QuestionDisplay() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp), color = AppColors.mDarkPurple
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            QuestionTracker()
            DrawDottedLine(pathEffect = pathEffect)
            Column {
                Text(
                    text = "What is the meaning of all this?",
                    modifier = Modifier
                        .padding(6.dp)
                        .align(alignment = Alignment.Start)
                        .fillMaxHeight(0.3f),
                    fontSize = 17.sp,
                    color = AppColors.mOffWhite,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp
                )

            }
        }

    }
}

//@Preview
@Composable
fun QuestionTracker(counter: Int = 10, outOff: Int = 100) {
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textIndent = TextIndent.None)) { }
        withStyle(
            style = SpanStyle(
                color = AppColors.mLightGray,
                fontWeight = FontWeight.Bold,
                fontSize = 27.sp
            )
        ) {
            append("Question $counter/")
        }
        withStyle(
            style = SpanStyle(
                color = AppColors.mLightGray,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        ) {
            append("$outOff")
        }
    }, modifier = Modifier.padding(bottom = 20.dp))
}

@Composable
fun DrawDottedLine(pathEffect: PathEffect) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
    ) {

        drawLine(
            color = AppColors.mLightGray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }

}