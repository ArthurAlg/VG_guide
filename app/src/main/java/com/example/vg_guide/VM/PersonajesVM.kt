package com.example.vg_guide.VM

import androidx.lifecycle.ViewModel
import com.example.vg_guide.Model.Personajes
import com.example.vg_guide.Repository.PersonajesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PersonajesVM @Inject constructor(
    private val personajesRepository: PersonajesRepository
): ViewModel() {
    val getPersonajes: Flow<List<Personajes>> = personajesRepository.getALl
}