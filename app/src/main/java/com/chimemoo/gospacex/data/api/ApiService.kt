package com.chimemoo.gospacex.data.api

import com.chimemoo.gospacex.data.model.Launchpad
import com.chimemoo.gospacex.data.model.Launch
import com.chimemoo.gospacex.data.model.Rocket
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v4/launches/latest")
    fun getUpcomingLaunch(): Observable<Launch>

    @GET("v4/launchpads/{id}")
    fun getLaunchpad(@Path("id") id: String?): Observable<Launchpad>

    @GET("v4/launches/past")
    fun getAllLaunches() : Observable<List<Launch>>

    @GET("v4/rockets")
    fun getAllRockets(): Observable<List<Rocket>>
}