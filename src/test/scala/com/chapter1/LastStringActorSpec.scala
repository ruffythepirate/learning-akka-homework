package com.chapter1

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import org.scalatest.{FunSpecLike, Matchers}

/**
  * Created by ruffy on 9/25/16.
  */
class LastStringActorSpec extends FunSpecLike with Matchers {

  implicit val system = ActorSystem()

  describe("Chapter 1") {
    describe("given SetLastStringRequest") {

      it("should initialize with none") {
        val actorRef = TestActorRef(new LastStringActor)
        val actor = actorRef.underlyingActor
        actor.lastMessage should equal(None)
      }

      it("should set last string in actor") {
        val actorRef = TestActorRef(new LastStringActor)

        actorRef ! SetLastStringRequest("Message 1")

        val actor = actorRef.underlyingActor
        actor.lastMessage should equal(Some("Message 1"))
      }

      it("should change last string after second message") {
        val actorRef = TestActorRef(new LastStringActor)

        actorRef ! SetLastStringRequest("Message 1")
        actorRef ! SetLastStringRequest("Message 2")

        val actor = actorRef.underlyingActor
        actor.lastMessage should equal(Some("Message 2"))
      }


    }
  }

}
