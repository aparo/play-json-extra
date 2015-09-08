package java.time.format

import java.time.temporal.Temporal

case class DateTimeFormatter(pattern:String) {
  def format(t:Temporal):String={
    //TODO
    "2015-01-01T00:00:00Z"
  }

  override  def toString():String=pattern

}

object DateTimeFormatter{
  def ofPattern(pattern:String):DateTimeFormatter=new DateTimeFormatter(pattern)
  val ISO_LOCAL_DATE_TIME=DateTimeFormatter("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
  val ISO_LOCAL_DATE=DateTimeFormatter("yyyy-MM-dd")
  val ISO_DATE=DateTimeFormatter("yyyy-MM-dd")
  val ISO_DATE_TIME=DateTimeFormatter("yyyy-MM-dd'T'HH:mm:ss.SSSZ")

}
