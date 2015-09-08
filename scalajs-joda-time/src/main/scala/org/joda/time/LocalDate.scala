package org.joda.time

import org.joda.time.format.DateTimeFormatter
import web.moment.Moment

/**
  * Created by alberto on 27/04/15.
  */
class LocalDate(datetime:Moment) extends DateTime(datetime)


object LocalDate {
 def parse(input:String, formatter:DateTimeFormatter):LocalDate={
  new LocalDate(moment.moment.apply(input, format = formatter.pattern))
 }
}