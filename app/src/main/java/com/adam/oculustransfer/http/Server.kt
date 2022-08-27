package com.adam.oculustransfer.http


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
        }
    }.start(wait = false)
}