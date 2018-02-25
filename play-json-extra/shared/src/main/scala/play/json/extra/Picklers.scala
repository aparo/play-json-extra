package play.json.extra

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatter
import play.api.data.validation.ValidationError
import play.api.libs.json._

object Picklers {


//  implicit val customJodaDateReads = //Reads.jodaDateReads(DateConstants.millis)
  implicit val customJodaDateReads: Reads[org.joda.time.DateTime] = new Reads[org.joda.time.DateTime] {

      import org.joda.time.DateTime

      val formats=List("yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ss.SSSZZ", "yyyy-MM-dd'T'HH:mm:ss.SSS", DateConstants.millis)
        .map(v => org.joda.time.format.DateTimeFormat.forPattern(v))

      def reads(json: JsValue): JsResult[DateTime] = json match {
        case JsNumber(d) => JsSuccess(new DateTime(d.toLong))
        case JsString(s) => parseDate(s) match {
          case Some(d) => JsSuccess(d)
          case None => JsError(Seq(JsPath() -> Seq(ValidationError("error.expected.jodadate.format", ""))))
        }
        case _ => JsError(Seq(JsPath() -> Seq(ValidationError("error.expected.date"))))
      }

      private def parseDate(input: String): Option[DateTime] ={
        var result:Option[DateTime]=scala.util.control.Exception.allCatch[DateTime] opt (DateTime.parse(input))
        if(result.nonEmpty) return result
        formats.foreach{
          df =>
            result=scala.util.control.Exception.allCatch[DateTime] opt (DateTime.parse(input, df))
            if(result.nonEmpty) return result
        }
        result
      }

    }

  implicit val customJodaDateWrites = Writes.jodaDateWrites(DateConstants.millis)
  implicit val format: Format[DateTime] = Format(customJodaDateReads, customJodaDateWrites)

  import boopickle.Default._


  implicit val datePickler = transformPickler[org.joda.time.DateTime, String](t => DateTime.parse(t))(_.toString(DateConstants.millis))

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
