package io.github.lenois.geonames.request

import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.math.max


class SearchRequestSpec : Spek({
    given("a search request") {
        on("a partial search query") {
            val request = SearchRequest("test", SearchRequest.QueryType.ALL_ATTRIBUTES)
            it("most fields should be null if they don't have a default") {
                request.searchString.should.equal("test")
                request.queryType.should.equal(SearchRequest.QueryType.ALL_ATTRIBUTES)
                request.nameStartsWith.should.equal(null)
                request.maxRows.should.equal(null)
                request.startRow.should.equal(null)
                request.country.should.equal(null)
                request.countryBias.should.equal(null)
                request.continentCode.should.equal(null)
                request.featureClass.should.equal(null)
                request.cities.should.equal(null)
                request.lang.should.equal(null)
                request.isNameRequired.should.equal(null)
                request.tag.should.equal(null)
                request.operator.should.equal(null)
                request.fuzziness.should.equal(null)
                request.boundingBox.should.equal(null)
                request.searchLang.should.equal(null)
                request.orderBy.should.equal(null)
            }
            it("should have a pair list that is mostly null") {
                request.asPairList().forEach {
                    when (it.first) {
                        SearchRequest.QueryType.ALL_ATTRIBUTES.queryType -> it.second.should.equal("test")
                        else -> it.second.should.be.`null`
                    }
                }
            }
        }
        on("a full search query ") {
            val searchString = "test"
            val queryType = SearchRequest.QueryType.NAME_FUZZY
            val nameStart = "te"
            val maxRows = 10
            val startRow = 20
            val country = "UK"
            val countryBias = "no"
            val continentCode = SearchRequest.ContinentCode.EUROPE
            val featureClass = SearchRequest.FeatureClass.BUILDINGS
            val cities = SearchRequest.CitiesSize.CITIES_15000
            val lang = "en"
            val isNameRequired = false
            val tag = "none"
            val operator = SearchRequest.Operator.AND
            val fuzziness = 0.5
            val boundingBox = SearchRequest.BoundingBox(10.0,20.0,30.0,40.0)
            val searchLang = "en"
            val orderBy = SearchRequest.OrderByClause.POPULATION
            val request = SearchRequest(
                    searchString = searchString,
                    queryType = queryType,
                    nameStartsWith = nameStart,
                    maxRows = maxRows,
                    startRow = startRow,
                    country = country,
                    countryBias = countryBias,
                    continentCode = continentCode,
                    featureClass = featureClass,
                    cities = cities,
                    lang = lang,
                    isNameRequired = isNameRequired,
                    tag = tag,
                    operator = operator,
                    fuzziness = fuzziness,
                    boundingBox = boundingBox,
                    searchLang = searchLang,
                    orderBy = orderBy
            )
            it("should not have null fields") {
                request.searchString.should.equal(searchString)
                request.queryType.should.equal(queryType)
                request.nameStartsWith.should.equal(nameStart)
                request.maxRows.should.equal(maxRows)
                request.startRow.should.equal(startRow)
                request.country.should.equal(country)
                request.countryBias.should.equal(countryBias)
                request.continentCode.should.equal(continentCode)
                request.featureClass.should.equal(featureClass)
                request.cities.should.equal(cities)
                request.lang.should.equal(lang)
                request.isNameRequired.should.equal(isNameRequired)
                request.tag.should.equal(tag)
                request.operator.should.equal(operator)
                request.fuzziness.should.equal(fuzziness)
                request.boundingBox.should.equal(boundingBox)
                request.searchLang.should.equal(searchLang)
                request.orderBy.should.equal(orderBy)
            }
            it("should not have a pair list with any nulls") {
                request.asPairList().forEach {
                    when (it.first) {
                        queryType.queryType -> it.second.should.equal(searchString)
                        "name_startsWith" -> it.second.should.equal(nameStart)
                        "maxRows" -> it.second.should.equal(maxRows)
                        "startRow" -> it.second.should.equal(startRow)
                        "country" -> it.second.should.equal(country)
                        "countryBias" -> it.second.should.equal(countryBias)
                        "continentCode" -> it.second.should.equal(continentCode.code)
                        "featureClass" -> it.second.should.equal(featureClass.code)
                        "cities" -> it.second.should.equal(cities.size)
                        "lang" -> it.second.should.equal(lang)
                        "isNameRequired" -> it.second.should.equal(isNameRequired)
                        "tag" -> it.second.should.equal(tag)
                        "operator" -> it.second.should.equal(operator.operator)
                        "fuzzy" -> it.second.should.equal(fuzziness)
                        "east" -> it.second.should.equal(boundingBox.east)
                        "west" -> it.second.should.equal(boundingBox.west)
                        "north" -> it.second.should.equal(boundingBox.north)
                        "south" -> it.second.should.equal(boundingBox.south)
                        "searchlang" -> it.second.should.equal(searchLang)
                        "orderby" -> it.second.should.equal(orderBy.clause)
                    }
                }
            }
        }
    }
})