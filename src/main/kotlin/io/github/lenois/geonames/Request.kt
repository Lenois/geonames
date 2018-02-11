package io.github.lenois.geonames

interface Request {
    fun asPairList(): List<Pair<String, Any?>>
}