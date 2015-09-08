package play.json.extra

import org.joda.time.DateTime
import play.api.libs.json._

object Picklers {


   implicit val customJodaDateReads = Reads.jodaDateReads(DateConstants.millis)
   implicit val customJodaDateWrites =  Writes.jodaDateWrites(DateConstants.millis)
   implicit val format:Format[DateTime]=Format(customJodaDateReads, customJodaDateWrites)

   import boopickle.Default._


   implicit val datePickler = transformPickler[org.joda.time.DateTime, String](_.toString(DateConstants.millis), t => DateTime.parse(t))

   trait EnumStringJSON[T] {
      def asString(t:T):String
      def fromString(s:String):Option[T]

      implicit val jsonFmt=new Format[T]{
         override def writes(o: T): JsValue = JsString(asString(o))

         override def reads(json: JsValue): JsResult[T] = json match {
            case JsString(v) =>
               fromString(v) match {
                  case Some(result) =>JsSuccess(result.asInstanceOf[T])
                  case _ => JsError("Invalid value $v")
               }
            case _ => JsError("Invalid json element $json")

         }
      }

   }


   trait EnumIntJSON[T] {
      def asInt(t:T):Int
      def fromInt(s:Int):Option[T]

      implicit val jsonFmt=new Format[T]{
         override def writes(o: T): JsValue = JsNumber(asInt(o))

         override def reads(json: JsValue): JsResult[T] = json match {
            case JsNumber(v) =>
               fromInt(v.toInt) match {
                  case Some(result) =>JsSuccess(result.asInstanceOf[T])
                  case _ => JsError("Invalid value $v")
               }
            case _ => JsError("Invalid json element $json")

         }
      }

   }
 }
