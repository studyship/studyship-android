package tsthec.tsstudy.domain.usecase.base

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Scheduler
import tsthec.tsstudy.domain.model.DomainSearchUserHistory

abstract class CompletableUseCase<in Params, T>(
    private val subscribeOnScheduler: Scheduler
) : BaseUseCase<Params>() {
    abstract fun buildMaybeUseCase(params: Params): Maybe<List<T>>

    abstract fun removeUserSearchHistory(item: Params): Completable

    abstract fun deleteAllHistory(): Completable

    abstract fun insertUserAllHistory(history: List<DomainSearchUserHistory>): Completable

    override fun invoke(params: Params): Maybe<List<T>> {
        return buildMaybeUseCase(params)
            .subscribeOn(subscribeOnScheduler)
    }
}