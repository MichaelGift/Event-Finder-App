package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.presentation.MainActivity
import dagger.Subcomponent

@EventScope
@Subcomponent(modules = [EventModule::class])
interface EventSubComponent {
    fun inject(eventActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): EventSubComponent
    }
}