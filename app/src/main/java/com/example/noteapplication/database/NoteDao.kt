package com.example.noteapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapplication.model.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note) // Correct

    @Update
    suspend fun updateNote(note: Note) // Correct

    @Delete
    suspend fun deleteNote(note: Note) // Correct

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE noteTitle LIKE '%' || :query || '%' OR noteDesc LIKE '%' || :query || '%'")
    fun searchNote(query: String?): LiveData<List<Note>>
}