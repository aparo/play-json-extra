package play.json.extra

import scala.annotation.StaticAnnotation

//Name to be used to serialize this field
final case class key(name: String) extends StaticAnnotation
