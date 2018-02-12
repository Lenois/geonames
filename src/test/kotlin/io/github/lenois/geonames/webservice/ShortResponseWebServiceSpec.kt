package io.github.lenois.geonames.webservice
import com.github.kittinunf.fuel.core.Client
import com.github.kittinunf.fuel.core.FuelManager
import com.winterbe.expekt.should
import io.github.lenois.geonames.request.SearchRequest
import io.github.lenois.geonames.webservice.ShortResponseWebService
import io.mockk.every
import io.mockk.mockk
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


class ShortResponseWebServiceSpec: Spek({

    given("A short response web service that has a search query invoked"){
        val webService = ShortResponseWebService("test")
        on("a search query with an ok response"){
            //mock the client
            val client = mockk<Client>()
            val jsonResponse = this.javaClass.classLoader
                    .getResourceAsStream("searchResponse.json")
            every { client.executeRequest(any()).data } returns jsonResponse.toString().toByteArray()
            every { client.executeRequest(any()).statusCode} returns 200
            every { client.executeRequest(any()).responseMessage } returns "OK"
            every { client.executeRequest(any()).dataStream} returns jsonResponse

            FuelManager.instance.client = client
            val result = webService.search(SearchRequest("test", SearchRequest.QueryType.ALL_ATTRIBUTES))

            it("should have the correct representation of the json object in a pojo"){
                result.totalResultsCount.should.equal(2)
                val geonames = result.geonames
                geonames.size.should.equal(2)

                val first = geonames.get(0)
                first.lng.should.equal(10.5)
                first.geonameId.should.equal(2921044)
                first.countryCode.should.equal("DE")
                first.name.should.equal("Germany")
                first.toponymName.should.equal("Federal Republic of Germany")
                first.lat.should.equal(51.5)
                first.fcl.should.equal("A")
                first.fcode.should.equal("PCLI")

                val second = geonames.get(1)
                second.lng.should.equal(12.51559)
                second.geonameId.should.equal(8354410)
                second.countryCode.should.equal("DE")
                second.name.should.equal("East Germany")
                second.toponymName.should.equal("German Democratic Republic")
                second.lat.should.equal(52.19498)
                second.fcl.should.equal("A")
                second.fcode.should.equal("PCLH")
            }
        }
    }
})