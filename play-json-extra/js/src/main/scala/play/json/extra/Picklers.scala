package play.json.extra

import boopickle.Default._
import org.joda.time.DateTime
import play.api.libs.json._

object Picklers {
  implicit val customJodaDateReads = Reads.jodaDateReads("YYYY-MM-DDTHH:mm:ss.SSSZ")
  implicit val customJodaDateWrites =  Writes.jodaDateWrites("YYYY-MM-DDTHH:mm:ss.SSSZ")
  implicit val format:Format[DateTime]=Format(customJodaDateReads, customJodaDateWrites)
  implicit val datePickler = transformPickler[org.joda.time.DateTime, String](_.toStringISO, t => DateTime.parse(t))

}
