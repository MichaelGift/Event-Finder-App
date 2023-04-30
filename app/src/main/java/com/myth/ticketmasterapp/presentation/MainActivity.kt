package com.myth.ticketmasterapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.myth.ticketmasterapp.R
import com.myth.ticketmasterapp.databinding.ActivityMainBinding
import com.myth.ticketmasterapp.presentation.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var eventViewModel: EventViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as Injector).createEventSubComponent().inject(this)
        eventViewModel = ViewModelProvider(this, factory)[EventViewModel::class.java]
    }

}