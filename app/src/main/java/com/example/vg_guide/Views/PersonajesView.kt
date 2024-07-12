package com.example.vg_guide.Views

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vg_guide.Model.Personajes
import com.example.vg_guide.VM.PersonajesVM
import com.example.vg_guide.ui.theme.Magenta
import com.example.vg_guide.ui.theme.Magenta2

@Composable
fun PersonajesView(personajesVM: PersonajesVM){
    val showDialog = remember { mutableStateOf(false) }
    val selectedPersonaje = remember { mutableStateOf<Personajes?>(null) }
    val context = LocalContext.current
    val personajes by personajesVM.getPersonajes.collectAsState(initial = emptyList())
    LazyColumn {
        items(personajes){personaje ->
            PersonajeItem(personaje, context,showDialog,selectedPersonaje)
        }
    }
    if (showDialog.value) {
        selectedPersonaje.value?.let { personaje ->
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                buttons = {},
                title = {
                    Text("${personaje.Nombre} - ${personaje.Rol}",
                        style = TextStyle(
                            fontWeight = FontWeight.Black,
                            fontFamily = FontFamily.Serif
                        )
                    )
                },
                text = {
                    Text(
                        "${personaje.argument}",
                        textAlign = TextAlign.Justify,
                        style = TextStyle(
                            fontWeight = FontWeight.W600,
                            fontFamily = FontFamily.Monospace,
                            color = Color.White
                        )
                    )
                }
                ,
                backgroundColor = Magenta2
            )
        }
    }
}

@Composable
fun PersonajeItem(personajes: Personajes, context: Context, showDialog: MutableState<Boolean>, selectedPersonaje: MutableState<Personajes?>){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, bottom = 4.dp, top = 4.dp)
            .clickable {
                selectedPersonaje.value = personajes
                showDialog.value = true
            },
        colors = CardDefaults.cardColors(Magenta),
        border = BorderStroke(4.dp, Magenta2)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            val imageId = getDrawableIdByName(context, personajes.image)
            if (imageId != 0) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = personajes.Nombre,
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterVertically) // Ajusta el tamaño de la imagen según tus necesidades
                )
            } else {
                // Puedes mostrar una imagen de marcador de posición o un componente vacío
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    // Imagen o componente de marcador de posición
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)

            ) {
                Text(
                    text = "Personaje Número ${personajes.id}",
                    style = TextStyle(
                        fontWeight = FontWeight.Thin,
                        fontSize = 10.sp,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Nombre: ${personajes.Nombre}",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Monospace
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Rol: ${personajes.Rol}",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Monospace
                    )
                )
            }
        }
    }
}

fun getDrawableIdByName(context: Context, name: String): Int {
    return context.resources.getIdentifier(name, "drawable", context.packageName)
}