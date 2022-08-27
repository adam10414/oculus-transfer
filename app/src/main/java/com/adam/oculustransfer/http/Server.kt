package com.adam.oculustransfer.http

// Base documentation: https://ktor.io/docs/welcome.html
// Interactive website documentation: https://ktor.io/docs/creating-interactive-website.html
// Routes documentation: https://ktor.io/docs/routing-in-ktor.html#nested_routes

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun startServer(){
    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) {
            gson {}
        }
        routing {
            get("/") {
                call.respond(mapOf("message" to "Hello world"))
            }

            // Testing variable routes.
            get(path="/{text}"){
                val inputText = call.parameters["text"]!!
                call.respondText { inputText }
            }
            // More routes go here...
        }
    }.start(wait = false)
}