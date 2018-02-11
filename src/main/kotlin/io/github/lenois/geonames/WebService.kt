package io.github.lenois.geonames

interface WebService {
    fun search(request: SearchRequest)
}