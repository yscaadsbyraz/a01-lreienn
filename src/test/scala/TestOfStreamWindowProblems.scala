import org.scalacheck._
import Prop._
import Test._

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

// This is a very inefficient solution, do not replicate
def testMovingAverage(l: List[Double], k: Int): List[Double] = l.sliding(k).filter(_.length == k).map(_.sum/k).to(List)

// Very inefficient, do not replicate
def testMaximumGains(l: List[Double]): List[Double] = l.zipWithIndex.map {
  case (elem, idx) => l.take(idx).map(elem - _).maxOption.filter(_ >= 0.0).getOrElse(0.0)
}.scanLeft(0.0)(Math.max)

class TestOfStreamWindowProblems extends AnyFunSuite:
  test("The moving average solution is correct") {
    check {
      forAll(Gen.listOf(Gen.choose(0.1, 1000000.0)), Gen.choose(1, 10)) { (l: List[Double], k: Int) =>
        val actual = movingAverage(l, k)
        val expected = testMovingAverage(l, k)
        actual.zip(expected).forall{ case (x, y) => x == y || Math.abs((x - y)/(x+y)) < 1e-6 }
      }
    }(_.withMinSuccessfulTests(20)).status shouldBe Passed
  }

  test("The gains solution is correct") {
    check {
      forAll(Gen.listOfN(20, Gen.choose(-3.0, 3.0)), Gen.choose(10.0, 100.0)) {
        (l: List[Double], start: Double) =>
          val samples = l.scanLeft(start)(_ + _)
          val actual = maximumGains(samples)
          val expected = testMaximumGains(samples)
          actual == expected
      }
    }(_.withMinSuccessfulTests(200)).status shouldBe Passed
  }

