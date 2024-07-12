package com.example.vg_guide.DAO

import androidx.room.Dao
import androidx.room.Query
import com.example.vg_guide.Model.Personajes
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonajesDAO {
    @Query("SELECT * FROM personajes")
    fun getAll(): Flow<List<Personajes>>
}