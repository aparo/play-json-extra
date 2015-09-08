package org.joda.time.format

import org.joda.time.DateTime

class DateTimeFormatter(val pattern:String) {
  def parseDateTime(text: String): DateTime = DateTime.parse(text, this)
  def print(instant: DateTime): String = instant.toString(this)

}
