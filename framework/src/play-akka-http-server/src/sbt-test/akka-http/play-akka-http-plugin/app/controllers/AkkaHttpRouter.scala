package controllers

import javax.inject.Inject
import akka.http.scaladsl.model.{HttpEntity, HttpRequest, HttpResponse, StatusCodes}
import akka.stream.Materializer
import play.api.routing.Router

class AkkaHttpRouter @Inject() ()(implicit mat: Materializer) extends Router {

  val handler = AkkaHttpHandler { request =>
      Future.successful(HttpResponse(StatusCodes.OK, entity = HttpEntity("Responded using Akka HTTP HttpResponse API")))
  }

  override def routes: Routes = { case _ => handler }

  override def documentation: Seq[(String, String, String)] = Seq.empty

  override def withPrefix(prefix: String): Router = this
}
