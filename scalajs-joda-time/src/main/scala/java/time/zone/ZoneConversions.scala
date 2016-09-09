package java.time.zone

import com.zoepepper.facades.jsjoda.zone.{ZoneRules => ZoneRulesF}

import scala.language.implicitConversions

trait ZoneConversions {
  implicit def f2ZoneRules(f: ZoneRulesF): ZoneRules = new ZoneRules(f)
}
