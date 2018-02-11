package io.github.lenois.geonames.webservice

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.jackson.jacksonDeserializerOf
import io.github.lenois.geonames.SearchResultWrapper
import io.github.lenois.geonames.ShortToponym

class ShortResponseWebService(userName: String) : AbstractWebService<ShortToponym>(userName, ResponseStyle.SHORT) {
    override fun getSearchDeserializer(): ResponseDeserializable<SearchResultWrapper<ShortToponym>> {
        return jacksonDeserializerOf()
    }
}

