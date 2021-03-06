package com.example.plugins

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {

    routing {
        get("/") {
            println("URI: ${call.request.uri}") // '/'
            println("Headers: ${call.request.headers.names()}")
            println("User-Agent: ${call.request.headers["User-Agent"]}")
            println("Accept: ${call.request.headers["Accept"]}")
            println("Query Params: ${call.request.queryParameters.names()}")
            println("Name: ${call.request.queryParameters["name"]}")
            println("Email: ${call.request.queryParameters["email"]}")

            call.respondText("Hello World!")
        }

        get("/iphones/{page}") {
            val pageNumber = call.parameters["page"]

            call.respondText("Your are on Page number: $pageNumber")
        }

        post("/login") {

            val userInfo = call.receive<UserInfo>()
            print(userInfo)
            call.respondText("Everything working.")
        }
    }
}

@Serializable
data class UserInfo(
    val email: String,
    val password: String
)