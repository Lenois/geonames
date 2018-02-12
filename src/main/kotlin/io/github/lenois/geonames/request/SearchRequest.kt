package io.github.lenois.geonames.request

class SearchRequest(
        val searchString: String,
        val queryType: QueryType,
        val nameStartsWith: String? = null,
        val maxRows: Int? = null,
        val startRow: Int? = null,
        val country: String? = null,
        val countryBias: String? = null,
        val continentCode: ContinentCode? = null,
        val featureClass: FeatureClass? = null,
        val cities: CitiesSize? = null,
        //TODO Validate this from java locale before submitting the request
        val lang: String? = null,
        val isNameRequired: Boolean? = null,
        val tag: String? = null,
        val operator: Operator? = null,
        val fuzziness: Double? = null,
        val boundingBox: BoundingBox? = null,
        //TODO Validate this from java locale before submitting the request
        val searchLang: String? = null,
        val orderBy: OrderByClause? = null

) : Request {
    override fun asPairList(): List<Pair<String, Any?>> {
        return listOf(
                queryType.queryType to searchString,
                "name_startsWith" to nameStartsWith,
                "maxRows" to maxRows,
                "startRow" to startRow,
                "country" to country,
                "countryBias" to countryBias,
                "continentCode" to continentCode?.code,
                "featureClass" to featureClass?.code,
                "cities" to cities?.size,
                "lang" to lang,
                "isNameRequired" to isNameRequired,
                "tag" to tag,
                "operator" to operator?.operator,
                "fuzzy" to fuzziness,
                "east" to boundingBox?.east,
                "west" to boundingBox?.west,
                "north" to boundingBox?.north,
                "south" to boundingBox?.south,
                "searchlang" to searchLang,
                "orderby" to orderBy?.clause
        )
    }
    enum class QueryType(val queryType: String){
        ALL_ATTRIBUTES("q"),
        NAME_FUZZY("name"),
        PLACE_NAME_EXACT("name_equals")
    }
    enum class OrderByClause(val clause: String){
        POPULATION("population"),
        ELEVATION("elevation"),
        RELEVANCE("relevance")
    }

    enum class Operator(val operator: String){
        AND("AND"),
        OR("OR")
    }

    enum class ContinentCode(val code: String) {
        AFRICA("AF"),
        ASIA("AS"),
        EUROPE("EU"),
        NORTH_AMERICA("NA"),
        OCEANIA("OC"),
        SOUTH_AMERICA("SA"),
        ANTARCTICA("AN")
    }

    enum class FeatureClass(val code: String) {
        ADMINISTRATIVE_BODY("A"),
        WATER_BODIES("H"),
        LAND_DEVELOPMENT("L"),
        POPULATED_PLACE("P"),
        TRANSPORTATION_ROUTE("R"),
        BUILDINGS("S"),
        TERRAIN_FEATURE("T"),
        UNDERSEA("U"),
        FOREST_HEATH("V")
    }

    enum class CitiesSize(val size: String) {
        CITIES_1000("cities1000"),
        CITIES_5000("cities5000"),
        CITIES_15000("cities15000")
    }

    data class BoundingBox(
            val east: Double?,
            val west: Double?,
            val north: Double?,
            val south: Double?
    )
}

