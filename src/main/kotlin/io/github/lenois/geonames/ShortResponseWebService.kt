package io.github.lenois.geonames

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.jackson.jacksonDeserializerOf

class ShortResponseWebService(userName: String) : AbstractWebService<ShortToponym>(userName, ResponseStyle.SHORT) {
    override fun getSearchDeserializer(): ResponseDeserializable<SearchResultWrapper<ShortToponym>> {
        return jacksonDeserializerOf()
    }
}

fun main(args: Array<String>) {
    ShortResponseWebService("lenois").search(SearchRequest("germany", SearchRequest.QueryType.ALL_ATTRIBUTES))
}
