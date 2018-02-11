package io.github.lenois.geonames.webservice

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.response
import com.github.kittinunf.fuel.httpGet
import io.github.lenois.geonames.request.SearchRequest
import io.github.lenois.geonames.SearchResultWrapper
import io.github.lenois.geonames.Toponym

//todo: implementShortAndLongWebSerivices
abstract class AbstractWebService<T : Toponym> protected constructor(
        userName: String,
        responseStyle: ResponseStyle
): WebService<T> {
    init {
        FuelManager.instance.basePath = "http://api.geonames.org"
        FuelManager.instance.baseParams = listOf(
                "username" to userName,
                "style" to responseStyle.style
        )
    }

    override fun search(request: SearchRequest): SearchResultWrapper<T> {
         return "/searchJSON".httpGet(request.asPairList())
                 .response(getSearchDeserializer())
                 .third.get()
    }

    protected enum class ResponseStyle (val style: String){
        SHORT("SHORT"),
        MEDIUM("MEDIUM"),
        LONG("LONG"),
        FULL("FULL")
    }
}
