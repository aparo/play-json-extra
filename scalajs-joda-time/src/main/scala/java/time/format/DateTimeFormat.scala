package java.time.format

object DateTimeFormat {

  def forPattern(pattern:String)=new DateTimeFormatter(pattern)
}
