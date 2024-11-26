package com.example.noteapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapplication.model.Note
import com.example.noteapplication.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private val noteRepository: NoteRepository): AndroidViewModel(app) {

    fun addNote(note: Note) =
        viewModelScope.launch { //it ensures that the coroutines is cancelled when the associate viewmodel is cleared or destroyed to prevent potential m/y leaks
            noteRepository.insertNote(note) //this will launch in background using coroutines
        }

    fun deleteNote(note: Note) =
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }

    fun updateNote(note: Note) =
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }

    fun getAllNotes() = noteRepository.getAllNotes()

    fun searchNote(query: String?) = noteRepository.searchNote(query)
}