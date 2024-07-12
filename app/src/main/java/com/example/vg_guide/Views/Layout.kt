package com.example.vg_guide.Views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vg_guide.VM.PersonajesVM
import com.example.vg_guide.ui.theme.Celeste
import com.example.vg_guide.ui.theme.Morado

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Layout(personajesVM: PersonajesVM){
    val showDialog = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Personajes",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 20.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                backgroundColor = Morado
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Celeste
        ) {
            PersonajesView(personajesVM)
        }
    }
}