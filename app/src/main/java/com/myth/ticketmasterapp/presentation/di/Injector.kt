package com.myth.ticketmasterapp.presentation.di

interface Injector {
    fun createEventSubComponent(): EventSubComponent
}