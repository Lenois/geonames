package io.github.lenois.geonames

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet

abstract class WebService<out T: Response>(
        val userName: String
) {
    init {
        FuelManager.instance.basePath = "api.geonames.org"
    }
    fun search(): T{
        "/search".httpGet(listOf(

        ))
    }
}

