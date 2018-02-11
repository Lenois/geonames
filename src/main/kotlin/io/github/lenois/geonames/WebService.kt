package io.github.lenois.geonames

import com.github.kittinunf.fuel.core.ResponseDeserializable

interface WebService<T: Toponym> {
    fun search(request: SearchRequest): T
    fun getDeserializer(): ResponseDeserializable<T>
}