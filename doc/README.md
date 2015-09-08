# Introduction

I love working in Scala and ScalaJS. This library is my **opinionated** wrapper of several libraries merged to 
efficiently working in JSON word. 

Main Features are:

* Play JSON for ScalaJS 
* **JsonFormat** macro annotation for lazy people
* Default field values populated in missing JSON 
* Field rewrite for Play JSON ("key") 
* +22 field case class formatter and more [Play Json Extension](playjsonext.md)
* **Joda Datetime** for Scala and ScalaJS
* Strong Typed Enum (String and Int) for Scala and ScalaJS
* [Variant Types](variants.md)

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


## Play JSON for ScalaJS

You can share the same code for backend and frontend.

> The implementation is targeting play-json 2.4.3 on scala 2.11

In ScalaJS world the [upickle](https://github.com/lihaoyi/upickle-pprint) library is used under the hood.

## JsonFormat annotation macro

**JsonFormat** annotation macro reduce the requirement to manually write Play Json.Format code. It automatically uses **all** 
the features of **Play Json Extra**.

```scala 
import play.json.extra.JsonFormat 
import play.json.extra.Picklers._

@JsonFormat
case class TestDataTime(dt: DateTime, children: List[TestDataTime] = Nil)

test("basic datetime test") {
  val dt = new DateTime(2015, 8, 11, 12, 1, 2, 3)
  val ts = TestDataTime(dt)
  val json = Json.toJson(ts)
  assert(Json.stringify(json) === """{"dt":"2015-08-11T12:01:02.003","children":[]}""")
}
```

## Default field values populated in missing JSON 

Default values are added automatically if they are missing in the JSON.
 
This allows a much faster refactory of your models adding new fields with default values. 

```scala 
case class DefaultValueTestClass(@key("ok-field") field:String="p", lp:List[String],
                                 l1:Option[Option[Int]])

test("json default serialize/deserialize") {
  import play.json.extra.implicits.optionWithNull

  implicit def fmt1 = Jsonx.formatCaseClass[DefaultValueTestClass]
  val t1=DefaultValueTestClass(lp=Nil, l1=None)

  assert(Json.stringify(Json.toJson(t1)) === """{"ok-field":"p","lp":[]}""")
  assert(t1 === Json.parse("{}").as[DefaultValueTestClass])
}
```



## Field rewrite for Play JSON

Field translation during the Serialization/Deserialization


```scala

import play.json.extra.{JsonFormat, key}

@JsonFormat
case class DefaultTest(@key("ok1") a1: Int = 1, @key("ok2") a2: Int = 2, @key("ok3") a3: Int = 3, @key("ok4") a4: Int = 4,
                       @key("ok5") a5: Int = 5, @key("ok6") a6: Int = 6, @key("ok7") a7: Int = 7, @key("ok8") a8: Int = 8,
                       @key("ok9") a9: Int = 9, @key("ok10") a10: Int = 10,
                       @key("ok11") a11: Int = 11, @key("ok12") a12: Int = 12, @key("ok13") a13: Int = 13, @key("ok14") a14: Int = 14,
                       @key("ok15") a15: Int = 15, @key("ok16") a16: Int = 16, @key("ok17") a17: Int = 17, @key("ok18") a18: Int = 18,
                       @key("ok19") a19: Int = 19, @key("ok20") a20: Int = 20,
                       @key("ok21") a21: Int = 21, @key("ok22") a22: Int = 22, @key("ok23") a23: Int = 23, @key("ok24") a24: Int = 24,
                       @key("ok25") a25: Int = 25, @key("ok26") a26: Int = 26, @key("ok27") a27: Int = 27, @key("ok28") a28: Int = 28,
                       @key("ok29") a29: Int = 29
                        )


test("default test key + >21 fields + des/ser") {
  val ts = DefaultTest()
  val json = Json.toJson(ts).as[JsObject]
  assert(json.fields.length === 29)
  val fieldNames=List(
    "ok1", "ok2", "ok3", "ok4", "ok5", "ok6", "ok7", "ok8",  "ok9", "ok10",
    "ok10", "ok11", "ok12", "ok13", "ok14", "ok15", "ok16", "ok17", "ok18",  "ok19",
    "ok20", "ok21", "ok22", "ok23", "ok24", "ok25", "ok26", "ok27", "ok28",  "ok29"
  )

  fieldNames.foreach(value => assert(json.fields.map(_._1).contains(value) === true))
  val json2=Json.parse("""{"ok27":27,"ok16":16,"ok4":4,"ok25":25,"ok14":14,"ok10":10,"ok17":17,"ok21":21,"ok24":24,"ok28":28,"ok3":3,"ok20":20,"ok15":15,"ok7":7,"ok11":11,"ok1":1,"ok23":23,"ok12":12,"ok8":8,"ok29":29,"ok19":19,"ok2":2,"ok5":5,"ok26":26,"ok13":13,"ok18":18,"ok9":9,"ok6":6,"ok22":22}""")
  val ts2 = json2.as[DefaultTest]
  assert(ts2.a29 === 29)
}

```

## Joda Datetime for Scala and ScalaJS

Finally a working implementation of Joda for Scala and ScalaJS. 

Play JSON serialization/deserialization in both Scala and ScalaJS

In scalaJS is a facade around [moment.js](http://momentjs.com/)

```scala
test("basic datetime test") {
  val dt = new DateTime(2015, 8, 11, 12, 1, 2, 3)
  assert(dt.year.get === 2015)
  assert(dt.monthOfYear.get === 8)
  assert(dt.dayOfMonth.get === 1)
  assert(dt.hourOfDay.get === 12)
  assert(dt.minuteOfHour.get === 1)
  assert(dt.secondOfMinute.get === 2)
  assert(dt.millisOfSecond.get === 3)
}

test("play json serialization/deserialization") {
  val dt = new DateTime(2015, 8, 11, 12, 1, 2, 3)
  val ts=TestDataTime(dt)
  val json = Json.stringify(Json.toJson(ts))
  println(json)
  val ts2=Json.parse(json).as[TestDataTime]
  println(s"${ts.toString} ${ts2.toString}")
  println(s"${ts.dt.toString()} ${ts2.dt.toString()}")

  assert(ts2.dt.year.get === 2015)
  assert(ts2.dt.monthOfYear.get === 8)
  assert(ts2.dt.dayOfMonth.get === 1)
  assert(ts2.dt.hourOfDay.get === 12)
  assert(ts2.dt.minuteOfHour.get === 1)
  assert(ts2.dt.secondOfMinute.get === 2)
}
```

## Strong Typed Enum (String and Int) for Scala and ScalaJS

Everyone loves strong type enums interoperability in play JSON.

Just import:

```scala
import macrame.enum
import play.json.extra.Picklers._
```

For a String Enum:

```scala
val yellowStr = "YELLOW"
@enum class Color {
  Red
  Blue("BLUE")
  Yellow(yellowStr)
}
object Color extends EnumStringJSON[Color] {
  def asString(c:Color) = asStringImpl(c)
  def fromString(s:String) = fromStringImpl(s)

}

@JsonFormat
case class ColorData(color:Color)

val ts = ColorData(Color.Red)
val json = Json.toJson(ts)
val expectedResult="""{"color":"Red"}"""
assert(Json.stringify(json) === expectedResult)
val ts2 = Json.parse(expectedResult).as[ColorData]
assert(ts === ts2)
```

For an Int Enum:

```scala
@enum class Color {
  Red
  Blue
  Yellow
}
object Color  extends EnumIntJSON[Color] {
  def asInt(c:Color) = asIntImpl (c)
  def fromInt(i:Int) = fromIntImpl(i)
}

@JsonFormat
case class ColorData(color:Color)
val ts = ColorData(Color.Red)
val json = Json.toJson(ts)
val expectedResult="""{"color":0}"""
assert(Json.stringify(json) === expectedResult)
val ts2 = Json.parse(expectedResult).as[ColorData]
assert(ts === ts2)
```

## Thanks

Thank you very much to:

* Li Haoyi for [upickle](https://github.com/lihaoyi/upickle-pprint) and all his scalaJS stuff
* Jan Christopher Vogt for [Play JSON Extensions](https://github.com/cvogt/play-json-extensions)
* Chris Neveu for [Macramé](https://github.com/ChrisNeveu/macrame)
* Julien Richard-Foy for [Play JSON Variants](https://github.com/julienrf/play-json-variants)
* The ScalaJS team
* The Play Framework team