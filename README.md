# sats-effect
Purely functional library for composing bitcoin apps. 
Like [cats-effect](https://typelevel.org/cats-effect) but for bitcoin.
Built with [fiatjaf/scoin](https://github.com/fiatjaf/scoin) under the hood.

## Motivation
### Programmer Perspective
Purely functional programming is hard to get used to. However, once you are used
to it, it is difficult to go back to a more imperative style. This is because you
begin to take things like referential transparency for granted, and you have become
accustomed to pure functions, capturing side-effects in a context, composing, etc.

### Bitcoiner Perspective
The bitcoin protocol provides many benefits for its users such as censorship-resistance.
If you are reading this, you probably already know of these benefits. However, 
interacting with your precious sats, such as receiving them, directing or redirecting them,
and especially if you want to do these things privately while maintaining best practices
is difficult, to say the least.

This library is (rather, will be) here to help! (note: right now the "library" 
only consists of this readme file.

## Get intimate with your sats!

### The core abstraction

```
type Bitcoin[A] = IO[A]  
// the above type can be refined later to build out a bitocin-specific 
// IO-like monad. For now we just use cats-effect.IO under the hood.

// a SatsApp is a function which takes a (possibly infinite) stream of bitcoin 
// outputs and "does something" with this information thereby producing another 
// stream of effects. Effects can be pretty much anything, including signing
// and broadcasting bitcoin transactions.
// 
// This allows wallets to be defined as immutable values (programs).
type SatsApp[F[_], A] = Stream[Bitcoin, Output] => Stream[F, A]

// a trival example of a SatsApp
val hodl: SatsApp[Id,Unit] = satsIn => Stream.empty
```



