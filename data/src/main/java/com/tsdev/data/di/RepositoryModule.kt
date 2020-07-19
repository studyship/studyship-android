package com.tsdev.data.di

import com.tsdev.data.source.repository.StudyShipRepositoryImpl
import org.koin.dsl.module
import tsthec.tsstudy.domain.repository.StudyShipRepository

val repositoryModule = module {
    single<StudyShipRepository> { StudyShipRepositoryImpl(get()) }
}