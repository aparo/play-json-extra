package play.json.extra

import org.joda.time.DateTime
import play.api.libs.json._

object Picklers {


   implicit val customJodaDateReads = Reads.jodaDateReads(DateConstants.millis)
   implicit val customJodaDateWrites =  Writes.jodaDateWrites(DateConstants.millis)
   implicit val format:Format[DateTime]=Format(customJodaDateReads, customJodaDateWrites)

   import boopickle.Default._


   implicit val datePickler = transformPickler[org.joda.time.DateTime, String](_.toString(DateConstants.millis), t => DateTime.parse(t))

 }
