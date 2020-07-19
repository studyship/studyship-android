package com.studyship.application.mapper

import com.tsdev.data.source.Category
import tsthec.tsstudy.domain.model.DomainCategory

object CategoryMapper : Mapper<DomainCategory, Category> {
    override fun toMap(item: DomainCategory): Category {
        return Category(
            categoryName = item.categoryName
        )
    }

    override fun fromMap(item: Category): DomainCategory {
        return DomainCategory(categoryName = item.categoryName)
    }
}