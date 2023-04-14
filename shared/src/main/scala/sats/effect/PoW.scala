package sats.effect


/**
  * Architecture heavily inspired by cats-effect and fs2
  *  - https://typelevel.org/cats-effect/
  *  - https://fs2.io/#/
  *  - https://www.youtube.com/watch?v=x5_MmZVLiSM
  * 
  */

sealed trait PoW[+A]

object PoW {
  // the api

  

  // implementations
  final case class Pure[+A](value: A) extends PoW[A]
  final case class Map[E, +A](powe: PoW[E], f: E => A) extends Pow[A]
  final case class FlatMap[E, +A](powe: PoW[E], f: E => PoW[A]) extends PoW[A]
  
}