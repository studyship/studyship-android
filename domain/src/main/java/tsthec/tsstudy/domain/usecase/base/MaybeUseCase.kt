package tsthec.tsstudy.domain.usecase.base

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Scheduler

abstract class CompletableUseCase<in Params>(
    private val subscribeOnScheduler: Scheduler
) : BaseUseCase<Params>() {
    abstract fun buildMaybeUseCase(params: Params): Completable

    abstract fun loadUserSearchHistory(): Maybe<List<String>>

    override fun invoke(params: Params): Completable {
        return buildMaybeUseCase(params)
            .subscribeOn(subscribeOnScheduler)
    }
}