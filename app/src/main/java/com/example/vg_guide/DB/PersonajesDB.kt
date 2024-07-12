package com.example.vg_guide.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vg_guide.DAO.PersonajesDAO
import com.example.vg_guide.Model.Personajes

@Database(
    exportSchema = false,
    version = 1,
    entities = [Personajes::class]
)
abstract class PersonajesDB: RoomDatabase() {
    abstract fun PersonajesDAO(): PersonajesDAO
}