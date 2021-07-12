package com.panda.abakasha_movies.data.api

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL:String = "https://api.nytimes.com"
const val CRITIC:String = ""
const val APIKEY:String = "apikey"
const val REQUEST_PATH:String = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?query=&api-key=apikey"


class MovieApiServiceTest {
    private lateinit var service:MovieApiService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(BASE_URL))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApiService::class.java)
    }

    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        mockWebServer.enqueue(mockResponse)

    }

    @Test
    fun getMovies_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("MovieJsonResponse.json")
            val responseBody = service.getMovies(CRITIC,APIKEY).body()
            val request = mockWebServer.takeRequest()
            Assert.assertNotNull(responseBody)
            Assert.assertEquals(request.path,REQUEST_PATH)
        }
    }

    @Test
    fun getMovies_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("MovieJsonResponse.json")
            val responseBody = service.getMovies("", APIKEY).body()
            val movieList = responseBody!!.results
            val movie = movieList[0]
            Assert.assertEquals(movie.display_title,"Summer '96")
            Assert.assertEquals(movie.summary_short,"Sunny days turn to sweaty nights on the Mediterranean coast in this Turkish coming-of-age film that follows a teenage boy who pines for his older sister’s best friend.")
            Assert.assertEquals(movie.multimedia.src,"https://static01.nyt.com/images/2021/07/10/arts/09last-summer-pix/09last-summer-pix-mediumThreeByTwo440.jpg")
        }
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}