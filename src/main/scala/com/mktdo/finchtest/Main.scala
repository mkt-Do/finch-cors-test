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

  case class Result(method: String, rand: Double)

  def randG: Endpoint[Result] =
    get("randG") {
      Ok(Result("GET", random))
    }

  val service = randG.toService

  Await.ready(Http.server.serve(":8081", service))
}
