package play.json.extra

import play.api.libs.json._

object Picklers {


  trait EnumStringJSON[T] {
    def asString(t: T): String

    def fromString(s: String): Option[T]

    implicit val jsonFmt = new Format[T] {
      override def writes(o: T): JsValue = JsString(asString(o))

      override def reads(json: JsValue): JsResult[T] = json match {
        case JsString(v) =>
          fromString(v) match {
            case Some(result) => JsSuccess(result.asInstanceOf[T])
            case _ => JsError("Invalid value $v")
          }
        case _ => JsError("Invalid json element $json")

      }
    }

  }


  trait EnumIntJSON[T] {
    def asInt(t: T): Int

    def fromInt(s: Int): Option[T]

    implicit val jsonFmt = new Format[T] {
      override def writes(o: T): JsValue = JsNumber(asInt(o))

      override def reads(json: JsValue): JsResult[T] = json match {
        case JsNumber(v) =>
          fromInt(v.toInt) match {
            case Some(result) => JsSuccess(result.asInstanceOf[T])
            case _ => JsError("Invalid value $v")
          }
        case _ => JsError("Invalid json element $json")

      }
    }

  }

}
