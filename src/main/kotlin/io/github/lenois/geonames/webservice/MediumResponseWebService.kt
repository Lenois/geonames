package io.github.lenois.geonames.webservice

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.jackson.jacksonDeserializerOf
import io.github.lenois.geonames.SearchResultWrapper

class MediumResponseWebService(userName:String) :AbstractWebService<MediumToponym>(userName, ResponseStyle.MEDIUM){
    override fun getSearchDeserializer(): ResponseDeserializable<SearchResultWrapper<MediumToponym>> {
        return jacksonDeserializerOf()
    }
}

