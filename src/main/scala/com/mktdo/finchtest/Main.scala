package com.mktdo.finchtest

import com.twitter.finagle.http.filter.Cors
import com.twitter.finagle.http.{ Cookie, Request, Response }
import com.twitter.finagle.Http
import com.twitter.finagle.Service
import com.twitter.util.Await
import io.circe.generic.auto._
import io.finch._
import io.finch.circe._
import io.finch.syntax._
import scala.math.random

object Main extends App {

  val policy: Cors.Policy = Cors.Policy(
    allowsOrigin = _ => Some("*"),
    allowsMethods = _ => Some(Seq("GET", "POST", "PATCH", "DELETE")),
    allowsHeaders = _ => Some(Seq())
  )

  case class Result(method: String, rand: Double)

  def randG: Endpoint[Result] =
    get("randG") {
      Ok(Result("GET", random))
    }

  def randP: Endpoint[Result] =
    post("randP" :: jsonBody[Int]) { i: Int =>
      Ok(Result("POST", random * i))
    }

  val baseService = (randG :+: randP).toService

  val service = new Cors.HttpFilter(policy).andThen(baseService)

  Await.ready(Http.server.serve(":8081", service))
}
