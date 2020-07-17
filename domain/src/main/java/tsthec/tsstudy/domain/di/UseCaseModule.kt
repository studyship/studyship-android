package tsthec.tsstudy.domain.di

import org.koin.dsl.module
import tsthec.tsstudy.domain.usecase.GetStudyShipSharedPreferenceUseCase
import tsthec.tsstudy.domain.usecase.base.CompletableUseCase

val useCaseModule = module {
    factory<CompletableUseCase<String>> { GetStudyShipSharedPreferenceUseCase(get()) }
}