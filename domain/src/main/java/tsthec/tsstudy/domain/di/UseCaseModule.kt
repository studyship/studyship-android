package tsthec.tsstudy.domain.di

import org.koin.dsl.module
import tsthec.tsstudy.domain.model.DomainSearchUserHistory
import tsthec.tsstudy.domain.usecase.GetStudyShipSharedPreferenceUseCase
import tsthec.tsstudy.domain.usecase.base.CompletableUseCase

val useCaseModule = module {
    factory<CompletableUseCase<DomainSearchUserHistory, DomainSearchUserHistory>> {
        GetStudyShipSharedPreferenceUseCase(
            get()
        )
    }
}