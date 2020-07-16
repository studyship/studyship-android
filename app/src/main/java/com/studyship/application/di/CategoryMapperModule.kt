package com.studyship.application.di

import com.studyship.application.mapper.CategoryMapper
import com.studyship.application.mapper.Mapper
import com.tsdev.data.source.Category
import com.tsdev.domain.repository.model.DomainCategory
import org.koin.dsl.module

val categoryMapper = module {
    factory<Mapper<DomainCategory, Category>> { CategoryMapper }
}