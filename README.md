# sats-effect
Purely functional library for composing bitcoin apps. 
Like [cats-effect](https://typelevel.org/cats-effect) but for bitcoin.
Built with [fiatjaf/scoin](https://github.com/fiatjaf/scoin) under the hood.

## Motivation

### Programmer Perspective

Purely functional programming is hard to get used to. However, once you are used
to it, it is difficult to go back to a more imperative style. This is because you
begin to take things like referential transparency for granted, and you have become
accustomed to pure functions, capturing side-effects in a context, and
**mathematically law-abiding data structures!**

### Bitcoiner Perspective

The bitcoin protocol provides many benefits for its users such as censorship-resistance.
If you are reading this, you probably already know of these benefits. However, 
interacting with your precious sats, such as receiving them, directing or redirecting them,
and especially if you want to do these things privately while maintaining best practices
is difficult, to say the least.

This library is (rather, will be) here to help!

> **note: right now the "library" only consists of this readme file.**

### The Core Abstraction - Work, and Proof Thereof

Sometimes we need to abstract away the details so that we can see clearly what
is going on. Bitcoin is a network, a currency, and many other things to many 
people. However, we believe the core innovation that bitcoin brings to the world 
is manifest mostly via its self-regulating proof-of-work adjustment algorithm.

Without proof of work (`PoW`), Bitcoin begins to lose two of the core properties bitcoiners
care about most:
1. censorship resistance
2. eventual immutability

We need a `PoW` monad!
