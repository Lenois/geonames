package io.github.lenois.geonames

import com.github.kittinunf.fuel.core.ResponseDeserializable

interface WebService<T: Toponym> {
    fun search(request: SearchRequest): SearchResultWrapper<T>
    fun getSearchDeserializer(): ResponseDeserializable<SearchResultWrapper<T>>
}