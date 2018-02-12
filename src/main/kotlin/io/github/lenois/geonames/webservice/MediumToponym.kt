package io.github.lenois.geonames.webservice

import io.github.lenois.geonames.ShortToponym

class MediumToponym(
        toponymName: String,
        name: String,
        lat: Double,
        lng: Double,
        geonameId: Int,
        countryCode: String,
        fcl: String,
        fcode: String
) : ShortToponym(toponymName, name, lat, lng, geonameId, countryCode, fcl, fcode){

}