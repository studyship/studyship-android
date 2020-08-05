package tsthec.tsstudy.domain.model.mystudy.response

import tsthec.tsstudy.domain.model.DomainCategory

data class DomainMyStudyResponse(
    val studyTitle: String,
    val studyLocation: String,
    val studyDate: String,
    val studyMakeTime: String,
    val adminName: String,
    val studyDescription: String,
    val members: String,
    val comments: List<DomainComment>,
    val category: List<DomainCategory>
) {
    data class DomainComment(val comment: String)
}