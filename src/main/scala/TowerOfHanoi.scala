
/**
 * The three pegs of the game. The game starts with all N disks on peg 1 and
 * needs to end with all disks on peg 3.
 */
type Peg = 1 | 2 | 3

/**
 * Denotes the move of a disk. We could have used a triple, but the code would be less clear.
 * An obvious invariant is that the arguments need to be different. If the invariant is violated,
 * the program has a bug and should be stopped right away.
 * Needless to say, this data structure does not check if the move is really legal.
 * @param from The peg where the disk to be moved currently resides
 * @param to   The peg where the disk needs to be moved
 */
case class Move(from: Peg, to: Peg):
  assert(from != to) // Throws and ends the program if violated.

/**
 * Starting with `n` disks of distinct diameters on peg 1, arranged in order of their size,
 * with the smallest disc at the top, and the largest disk at the bottoom, compute the sequence
 * of legal moves which, when executed one disk at a time, move all disks to peg 3.
 * A legal move is one where we take a disk from the top of a pile,
 * and we move it on top of a different (destination) pile,
 * provided that the disk already at the top of the destination pile is larger.
 * @param n The number of disks to be moved from peg 1 to peg 3
 * @return The sequence of moves which, when executed in order, would transfer the entire pile, one disk at a time,
 *         to the destination peg.
 */
def towerOfHanoiRecursive(n: Int): Iterator[Move] = {
  def helper(n: Int, from: Peg, to: Peg, aux: Peg): Iterator[Move] = ???
  helper(n, 1, 3, 2)
}

/**
 * Descriptor for a subproblem that we choose to solve later
 * @param n    number of disks to move
 * @param from source peg
 * @param to   destination peg
 * @param aux  remaining peg
 */
case class Problem(n: Int, from: Peg, to: Peg, aux: Peg)

/**
 * Same as above, but you have to write an iterative solution.
 * The idea here is to set output chunks as part of the state.
 * These chunks, which would be encoded as lists of moves, can be
 * flatMapped at the end.
 */
def towerOfHanoiIterative(n: Int): Iterator[Move] =
  def helper(n: Int, from: Peg, to: Peg, aux: Peg): Iterator[Move] =
    Iterator.iterate((List(Problem(n, from, to, aux)), Iterator.empty[Move])) {
      case (Problem(0, _, _, _) :: _, _) => ???
      case (Problem(1, x, y, _) :: stackTail, _) => ???
      case (Problem(k, f, t, a)::stackTail, _) => ???
      case (Nil, _) => ???
    }.takeWhile { case (p,o) => p.nonEmpty || o.nonEmpty }.flatMap(_._2)
  helper(n, 1, 3, 2)


class TowerOfHanoi // Spurious declaration to get rid of the warning that there must be a class with the same name as the file
