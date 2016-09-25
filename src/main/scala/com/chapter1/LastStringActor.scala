package com.chapter1

import akka.actor.Actor

/**
  * Created by ruffy on 9/25/16.
  */

case class SetLastStringRequest(message : String) {}

class LastStringActor extends Actor {

  var lastMessage: Option[String] = None

  override def receive = {
    case SetLastStringRequest(message) => lastMessage = Some(message)
  }

}
