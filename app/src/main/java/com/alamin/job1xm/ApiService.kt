package com.alamin.job1xm

import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts():List<Product>

}