package com.fauzan.quest.di

import com.fauzan.quest.data.Repository

object Injection {
    fun provideRepository(): Repository {
        return Repository.getInstance()
    }
}