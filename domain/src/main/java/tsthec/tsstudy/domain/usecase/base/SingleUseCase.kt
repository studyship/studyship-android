package tsthec.tsstudy.domain.usecase.base

import io.reactivex.Scheduler
import io.reactivex.Single

abstract class SingleUseCase<T, in Params>(
    private val observerOnScheduler: Scheduler,
    private val subscribeOnScheduler: Scheduler
) : BaseUseCase<Params>() {
    abstract fun buildSingleUseCase(params: Params): Single<T>

    override fun invoke(params: Params): Single<T> {
        return buildSingleUseCase(params)
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observerOnScheduler)
    }
}