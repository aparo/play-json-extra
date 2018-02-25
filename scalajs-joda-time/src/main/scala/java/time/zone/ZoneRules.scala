package java.time.zone

import java.Wraps
import java.time.{Duration, Instant, LocalDateTime, ZoneOffset}

import com.zoepepper.facades.jsjoda.zone.{ZoneRules => ZoneRulesF}

object ZoneRules {
  def of(offset: ZoneOffset): ZoneRules = ZoneRulesF.of(offset)
  def of(baseStandardOffset: ZoneOffset, baseWallOffset: ZoneOffset,
         standardOffsetTransitionList: java.util.List[ZoneOffsetTransition],
         transitionList: java.util.List[ZoneOffsetTransition],
         lastRules: java.util.List[ZoneOffsetTransitionRule]) = ???
}

class ZoneRules protected[time](f: ZoneRulesF) extends Wraps(f) {
  def getDaylightSavings(instant: Instant): Duration = ???
  def getOffset(instant: Instant): ZoneOffset = f.offset(instant)
  def getOffset(localDateTime: LocalDateTime): ZoneOffset = f.offset(localDateTime)
  def getStandardOffset(instant: Instant): ZoneOffset = ???
  def getTransition(localDateTime: LocalDateTime): ZoneOffsetTransition = ???
  def getTransitionRules(): java.util.List[ZoneOffsetTransitionRule] = ???
  def getTransitions(): java.util.List[ZoneOffsetTransition] = ???
  def getValidOffsets(localDateTime: LocalDateTime): java.util.List[ZoneOffset] = ???
  def isDaylightSavings(instant: Instant): Boolean = ???
  def isFixedOffset(): Boolean = f.isFixedOffset
  def isValidOffset(localDateTime: LocalDateTime, offset: ZoneOffset): Boolean = f.isValidOffset(localDateTime, offset)
  def nextTransition(instant: Instant): ZoneOffsetTransition = ???
  def previousTransition(instant: Instant): ZoneOffsetTransition = ???

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
