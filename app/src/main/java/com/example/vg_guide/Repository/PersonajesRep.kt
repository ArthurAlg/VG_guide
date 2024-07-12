package com.example.vg_guide.Repository

import com.example.vg_guide.DAO.PersonajesDAO
import javax.inject.Inject

class PersonajesRepository @Inject constructor(
    personajesDAO: PersonajesDAO
) {
    val getALl = personajesDAO.getAll()
}