package com.example.vg_guide.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personajes")
data class Personajes(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val Nombre: String,
    val Rol: String,
    val image: String,
    val argument: String
)