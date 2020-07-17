package tsthec.tsstudy.domain.usecase

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import tsthec.tsstudy.domain.repository.StudyShipRepository
import tsthec.tsstudy.domain.usecase.base.CompletableUseCase

class GetStudyShipSharedPreferenceUseCase(
    private val studyShipRepository: StudyShipRepository,
    subscribeOnScheduler: Scheduler = Schedulers.io()
) : CompletableUseCase<String>(subscribeOnScheduler) {
    override fun buildMaybeUseCase(params: String): Completable {
        return studyShipRepository.setUserSearchHistory(params)
    }

    override fun loadUserSearchHistory(): Maybe<List<String>> {
        return studyShipRepository.getLoadUserSearchHistory()
    }
}