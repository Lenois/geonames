package io.github.lenois.geonames.webservice

import com.github.kittinunf.fuel.core.ResponseDeserializable
import io.github.lenois.geonames.request.SearchRequest
import io.github.lenois.geonames.SearchResultWrapper
import io.github.lenois.geonames.Toponym

interface WebService<T: Toponym> {
    fun search(request: SearchRequest): SearchResultWrapper<T>
    fun getSearchDeserializer(): ResponseDeserializable<SearchResultWrapper<T>>
}