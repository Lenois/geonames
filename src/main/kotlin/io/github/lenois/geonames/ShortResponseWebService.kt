package io.github.lenois.geonames

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.jackson.jacksonDeserializerOf

class ShortResponseWebService(userName: String) : AbstractWebService<ShortToponym>(userName, ResponseStyle.SHORT) {
    override fun getSearchDeserializer(): ResponseDeserializable<SearchResultWrapper<ShortToponym>> {
        return jacksonDeserializerOf()
    }
}

