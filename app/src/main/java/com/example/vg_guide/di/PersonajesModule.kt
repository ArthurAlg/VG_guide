package com.example.vg_guide.di

import android.content.Context
import androidx.room.Room
import com.example.vg_guide.DB.PersonajesDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersonajesModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context, PersonajesDB::class.java,"personajes"
    ).createFromAsset("personajes.db").build()

    @Singleton
    @Provides
    fun provideDAO(database: PersonajesDB) =database.PersonajesDAO()
}