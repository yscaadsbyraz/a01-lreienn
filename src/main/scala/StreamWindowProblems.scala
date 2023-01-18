import collection.immutable.Queue

/**
 * Template for the Moving Average problem. Replace the `???` symbol with valid expressions. Your solution must run in
 * O(n).
 * @param l The list of samples to be averaged
 * @param k The averaging size
 * @return  The averaged list
 */
def movingAverage(l: List[Double], k: Int): List[Double] = {
  if (k <= 0 || l.length <= 0 || k > l.length) List.empty[Double]
  else {
    val ans = l.scanLeft(MovingAverageState()) {
      {
        case (MovingAverageState(sum, queue, size), element)
          if size < k =>
          MovingAverageState(sum + element, queue.enqueue(element), size + 1)
        case (MovingAverageState(sum, queue, size), element) =>
          val (front, newQueue) = queue.dequeue
          MovingAverageState(sum - front + element, newQueue.enqueue(element), size)
      }
    }.filter(_.samplesSize == k).map(_.sumOfSamples / k)
    ans
  }
}


/**
 * Case class to represent the state of the Moving Average computation. Remember, we want an efficient solution, i.e one
 * that runs in O(n), so we need to maintain certain fields that may appear
 * @param sumOfSamples      The sum of all the samples in the queue
 * @param samplesToAverage  A queue holding all the samples to be averaged
 * @param samplesSize       The number of elements currently in the queue (good to keep track of, since computing the length of the queue takes O(n)
 */
case class MovingAverageState(
  sumOfSamples: Double = 0.0,
  samplesToAverage: Queue[Double] = Queue.empty,
  samplesSize: Int = 0, // Queue.length is not constant time
)

/**
 * Template for the Maximum Gains problem. Replace the ??? by your own code. Feel free to add more `case` clauses
 * if you so feel inclined.
 * @param l the time series for the transacted asset
 * @return for each day, the maximum gain that could have been obtained up to that point by buying low and selling high.
 */
def maximumGains(l: List[Double]): List[Double] = l.scanLeft(MaximumGainsState()) {
  {
    case (MaximumGainsState(gains, min, _), sample) if min > sample => MaximumGainsState(gains, sample)
    case (MaximumGainsState(gains, min, max), sample) if max < sample & (sample-min) > gains =>
      MaximumGainsState(sample - min, min, sample)
    case (MaximumGainsState(gains, min, max), sample) if max < sample =>
      MaximumGainsState(gains, min, sample)
    case (MaximumGainsState(gains, min, max), _) => MaximumGainsState(gains, min, max)
  }
}.map(_.maxGainsSoFar)

/**
 * Case class to represent the state of the computation for Maximum Gains.
 * @param maxGainsSoFar the maximum gains obtainable up to the current day.
 * @param currentMin  the current minimum value observed so far.
 * @param currentMax  the current maximum value *that occurs after the day of the minimum value* so far.
 */
case class MaximumGainsState(
  maxGainsSoFar: Double = 0.0,
  currentMin: Double = Double.MaxValue,
  currentMax: Double = 0.0,
)

class StreamWindowProblems // Spurious class to keep Intellij happy.
