package sats.effect

import utest.*
import cats.implicits.*
import cats.effect.*
import cats.effect.testing.utest.EffectTestSuite

object PoWTest extends EffectTestSuite[IO] {
  val tests = Tests {
    test("PoW - 10 bits") {
      // construct a message
      PoW("a message")
      // narrow the list of acceptable networks
        .acceptableNetworks(List("bitcoin"))
      // obtain 10 bits of work from the universe (via these network(s))
        .withWork(10.00)
      // then do something (an effect)
        .evalMap { 
          // the code will not be run until the work requirement is achieved
          msg => IO.println(s"message $msg, is now burried in bitcoin blockchain")
        }
        .unsafeRun[IO] // we use the IO runtime under the hood
    }
  }
}