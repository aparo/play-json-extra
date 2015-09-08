package play.json.extra

import org.joda.time.DateTime
import utest._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object DateTimeUTests extends TestSuite {
  val tests = TestSuite {
    "testSuccess" - {
      case class TestDataTime(dt:DateTime)
      import boopickle._
      import boopickle.Default._
      import play.json.extra.Picklers._
      val dt = new DateTime(2015, 8, 11, 12, 1, 2, 3)
      val ts=TestDataTime(dt)
      val bb = Pickle.intoBytes(ts)
      assert(bb.array().length == 1400)
    }
  }

  tests.runAsync().map {    results =>
    assert(results.toSeq(0).value.isSuccess) // root
    assert(results.toSeq(1).value.isSuccess) // testSuccess
//    assert(results.toSeq(2).value.isFailure) // testFail
//    assert(results.toSeq(3).value.isSuccess) // normalSuccess
  }
}


