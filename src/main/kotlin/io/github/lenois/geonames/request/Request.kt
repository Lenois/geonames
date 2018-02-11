package io.github.lenois.geonames.request

interface Request {
    fun asPairList(): List<Pair<String, Any?>>
}