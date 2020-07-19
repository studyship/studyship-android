package tsthec.tsstudy.domain.usecase.base

import tsthec.tsstudy.domain.UseCase

abstract class BaseUseCase<in Params> : UseCase {
    abstract operator fun invoke(params: Params): Any
}