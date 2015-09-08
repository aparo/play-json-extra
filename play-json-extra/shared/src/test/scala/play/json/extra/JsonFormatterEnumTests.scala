package play.json.extra

import macrame.enum
import org.scalatest.FunSuite
import play.api.libs.json._
import play.json.extra.Picklers._

class JsonFormatterEnumTests extends FunSuite {

  test("basic color wrapping test") {

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
    assert(Color.asString(Color.Red) == "Red")
    assert(Color.asString(Color.Blue) == "BLUE")
    assert(Color.asString(Color.Yellow) == "YELLOW")
    assert(Color.fromString("Red") == Some(Color.Red))
    assert(Color.fromString("BLUE") == Some(Color.Blue))
    assert(Color.fromString("YELLOW") == Some(Color.Yellow))

    val ts = ColorData(Color.Red)
    val json = Json.toJson(ts)
    val expectedResult="""{"color":"Red"}"""
    assert(Json.stringify(json) === expectedResult)
    val ts2 = Json.parse(expectedResult).as[ColorData]
    assert(ts === ts2)

  }

  test("basic color wrapping test with int") {

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
    assert(Color.asInt(Color.Red) == 0)
    assert(Color.asInt(Color.Blue) == 1)
    assert(Color.asInt(Color.Yellow) == 2)
    assert(Color.fromInt(0) == Some(Color.Red))
    assert(Color.fromInt(1) == Some(Color.Blue))
    assert(Color.fromInt(2) == Some(Color.Yellow))
    val ts = ColorData(Color.Red)
    val json = Json.toJson(ts)
    val expectedResult="""{"color":0}"""
    assert(Json.stringify(json) === expectedResult)
    val ts2 = Json.parse(expectedResult).as[ColorData]
    assert(ts === ts2)

  }


}


