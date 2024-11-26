package com.example.noteapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteapplication.database.NoteDatabase
import com.example.noteapplication.databinding.ActivityMainBinding
import com.example.noteapplication.repository.NoteRepository
import com.example.noteapplication.viewmodel.NoteViewModel
import com.example.noteapplication.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel(){

        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}