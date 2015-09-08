play-json-extra
===============

I love working in Scala and ScalaJS. This library is my **opinionated** wrapper of several libraries merged to 
efficiently working in JSON word. 

Main Features are:

* Play JSON for ScalaJS 
* **JsonFormat** macro annotation for lazy people
* Default field values populated in missing JSON field
* Field rewrite for Play JSON ("key") 
* +22 field case class formatter and more [Play Json Extension](http://play-json-extra.megl.io/playjsonext.html)
* **Joda Datetime** for Scala and ScalaJS
* [Strong Typed Enum](http://play-json-extra.megl.io/macrame.html) (String and Int) for Scala and ScalaJS
* [Variant Types](http://play-json-extra.megl.io/variants.html)

Full Documentation [here](http://play-json-extra.megl.io).

## Installing

For the stable version (to be release):

```scala 
resolvers += "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "io.megl" % "play-json-extra" % "2.4.3"
```


For the snapshot version:

```scala 
resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies += "io.megl" % "play-json-extra" % "2.4.3-SNAPSHOT"
```

## Documentation

Full Documentation [here](http://play-json-extra.megl.io).

## Thanks

Thank you very much to:

* Li Haoyi for [upickle](https://github.com/lihaoyi/upickle-pprint) and all his scalaJS stuff
* Jan Christopher Vogt for [Play JSON Extensions](https://github.com/cvogt/play-json-extensions)
* Chris Neveu for [Macramé](https://github.com/ChrisNeveu/macrame)
* Julien Richard-Foy for [Play JSON Variants](https://github.com/julienrf/play-json-variants)
* The ScalaJS team
* The Play Framework team