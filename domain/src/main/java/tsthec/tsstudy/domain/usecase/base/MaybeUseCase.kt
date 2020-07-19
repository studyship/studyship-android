package tsthec.tsstudy.domain.usecase.base

import io.reactivex.Maybe
import io.reactivex.Scheduler

abstract class CompletableUseCase<in Params, T>(
    private val subscribeOnScheduler: Scheduler
) : BaseUseCase<Params>() {
    abstract fun buildMaybeUseCase(params: Params): Maybe<List<T>>

    abstract fun removeUserSearchHistory(item: Params)

    override fun invoke(params: Params): Maybe<List<T>> {
        return buildMaybeUseCase(params)
            .subscribeOn(subscribeOnScheduler)
    }
}