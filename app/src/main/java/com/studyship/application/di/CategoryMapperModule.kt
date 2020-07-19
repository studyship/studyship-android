package com.studyship.application.di

import com.studyship.application.mapper.CategoryMapper
import com.studyship.application.mapper.Mapper
import com.tsdev.data.source.Category
import org.koin.dsl.module
import tsthec.tsstudy.domain.model.DomainCategory

val categoryMapper = module {
    factory<Mapper<DomainCategory, Category>> { CategoryMapper }
}