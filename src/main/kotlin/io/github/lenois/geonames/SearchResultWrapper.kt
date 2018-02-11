package io.github.lenois.geonames

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchResultWrapper<T:Toponym> (
        val totalResultsCount: Int,
        val geonames: List<T>
)