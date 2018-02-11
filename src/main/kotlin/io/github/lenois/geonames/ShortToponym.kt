package io.github.lenois.geonames

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JsonIgnoreProperties(ignoreUnknown = true)
data class ShortToponym(
        val toponymName: String?,
        val name: String?,
        val lat: Double?,
        val lng: Double?,
        val geonameId: Int?,
        val countryCode: String?,
        val fcl: String?,
        val fcode: String?
) :Toponym