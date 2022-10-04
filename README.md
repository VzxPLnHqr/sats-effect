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

An example of what we are thinking might be helpful:

```scala

import sats-effect._

object TipJar extends SatsApp.SelfHosted(bitcoind="localhost:...", wallet="...") {

    /**
     * Our "run" function provides you with an `fs2.Stream` of satoshis where
     * the sats are delivered to you within a Bitcoin context. Now you just need
     * to decide what to do with them!
     * */
    def run(satsIn: Stream[Bitcoin,NonEmptySet[Satoshi]]) = 
        satsIn.evalMap(hodl)

    /**
     * take any sats and put them in a hodl wallet. Can get necessary wallet
     * info to do so from the runtime: `Bitcoin.wallet.deposit(sats)`
     * */
    def hodl(sats: NonEmptySet[Satoshi]): Bitcoin[Unit] = ???
}

```



