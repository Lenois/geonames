package io.github.lenois.geonames

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet

//todo: implementShortAndLongWebSerivices
abstract class AbstractWebService<out T : Response> protected constructor(
        userName: String,
        responseStyle: ResponseStyle
): WebService {
    init {
        FuelManager.instance.basePath = "http://api.geonames.org"
        FuelManager.instance.baseParams = listOf(
                "username" to userName,
                "style" to responseStyle.style
        )
    }

    override fun search(request: SearchRequest) {
        "/search".httpGet(request.asPairList()).response()
    }

    protected enum class ResponseStyle (val style: String){
        SHORT("SHORT"),
        MEDIUM("MEDIUM"),
        LONG("LONG"),
        FULL("FULL")
    }
}
