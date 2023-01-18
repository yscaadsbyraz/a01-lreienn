import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class TowerOfHanoiTest extends AnyFunSuite {
  private def toh(n: Int, a: Peg, b: Peg, c: Peg) =
    Iterator.iterate(List(Problem(n, a, b, c)).filter(_ => n > 0)) { _.flatMap {
      case p @ Problem(k, _, _ , _) if k == 1 => List(p)
      case Problem(k, x, y, z) => List(Problem(k-1, x, z, y), Problem(1, x, y, z), Problem(k-1, z, y, x))
    }}.dropWhile(_.length < (1 << n) -1).next.map{case Problem(_, x, y, _) => Move(x, y)}

  test("towerOfHanoiRecursive is correct for n = 0") {
    towerOfHanoiRecursive(0).to(List) shouldBe toh(0, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 1") {
    towerOfHanoiRecursive(1).to(List) shouldBe toh(1, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 2") {
    towerOfHanoiRecursive(2).to(List) shouldBe toh(2, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 3") {
    towerOfHanoiRecursive(3).to(List) shouldBe toh(3, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 4") {
    towerOfHanoiRecursive(4).to(List) shouldBe toh(4, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 5") {
    towerOfHanoiRecursive(4).to(List) shouldBe toh(5, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 6") {
    towerOfHanoiRecursive(4).to(List) shouldBe toh(6, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 7") {
    towerOfHanoiRecursive(4).to(List) shouldBe toh(7, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 8") {
    towerOfHanoiRecursive(4).to(List) shouldBe toh(8, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 9") {
    towerOfHanoiRecursive(4).to(List) shouldBe toh(9, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 10") {
    towerOfHanoiRecursive(4).to(List) shouldBe toh(10, 1, 3, 2)
  }

  test("towerOfHanoiRecursive is correct for n = 100") {
    towerOfHanoiRecursive(4).to(List) shouldBe toh(100, 1, 3, 2)
  }

  test("towerOfHanoiIterative is correct for n = 0") {
    towerOfHanoiIterative(0).to(List) shouldBe toh(0, 1, 3, 2)
  }

  test("towerOfHanoiIterative is correct for n = 1") {
    towerOfHanoiIterative(1).to(List) shouldBe toh(1, 1, 3, 2)
  }

  test("towerOfHanoiIterative is correct for n = 2") {
    towerOfHanoiIterative(2).to(List) shouldBe toh(2, 1, 3, 2)
  }

  test("towerOfHanoiIterative is correct for n = 3") {
    towerOfHanoiIterative(3).to(List) shouldBe toh(3, 1, 3, 2)
  }

  test("towerOfHanoiIterative is correct for n = 4") {
    towerOfHanoiIterative(4).to(List) shouldBe toh(4, 1, 3, 2)
  }

  test("towerOfHanoiIterative is correct for n = 100") {
    towerOfHanoiIterative(4).to(List) shouldBe toh(100, 1, 3, 2)
  }
}
