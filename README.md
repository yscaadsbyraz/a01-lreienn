# AADS 2022 - Assignment 1

## Part 1

### Problem 1: The Moving Average Problem

Terminology:
  * **Time series:** a data set containing the values of a certain metric taken over a period of time with a certain
    frequency. For instance, the daily prices of a stock at market close
    represent a time series. Similary, the hourly exchange rate of a currency, taken
    during market hours for a few months or years can also represent a time series.
  * **Moving average:** The time series obtained by averaging every *k*
    consecutive samples from an original time series. For instance, given
    the series [1, 2, 3, 4, 5], and an averaging size of 3, then
    we create the segments [[1,2,3], [2,3,4], [3,4,5]], and then we
    average every segment as [2, 3, 4]. Obviously, the resultant time
    series will have *n-k+1* samples, where *n* is the length of the original
    time series, and *k* is the averaging size.

Problem Statement:
    Write an efficient program for computing the moving average of a streams
of *double* numbers with an averaging size of *k*. The template for your solution
is given in the function `movingAverage`. Simply replace the `???` symbols
with valid expressions. Test your solution with the test entitled
`The moving average solution is correct`.
Read the comments in the code carefully. They contain hints that will
guide you towards the right solution.

### Problem 2

The input to this problem is a time series that represents the daily price of
an asset over a certain period of time. You can make money by trading this
asset and applying the well know principle of *"buy low, sell high"*.
The output that you need to compute is the maximum gain that you could
have obtained from trading the asset on all days up to day *k*.

For instance, let's take the time series
```
[5, 4, 6, 7, 5, 6, 9, 2, 8, 1]
```
The expected output is:
```
[0, 0, 2, 3, 3, 3, 5, 5, 6, 6]
```
Remember, this is a simulation. For each sample, we have to
pretend we can only see the samples that appear before that
sample, as if they were in the past.
The explanation is as follows:
* Day 0: We only have 1 sample so far, and there's no point in buying and selling on the same day.
  Thus the output for Day 0 is $0.
* Day 1: We can see 2 days, but the price has lowered, so the best outcome is to not lose money.
  Thus the output for Day 1 is $0.
* Day 2: The price rises to $6. If we buy on Day 1 and sell on Day 2, we can make $2.
  Thus the output for Day 2 is $2.
* Day 3: The price rises some more. If we buy on Day 1 and sell on Day 3, we could make $3.
  Thus the output for Day 3 is $3.
* Day 4: The price drops a bit. The best outcome is still to buy on Day 1 and sell on Day 3, and make $3.
  Thus the output for Day 4 is $3.
* Day 5: The price is now $6, still smaller than the all-time max, which was $7. The best outcome
  is still to buy on Day 1 and sell on Day 3, and make $3. Thus the output for Day 5 is still $3.
* Day 6: The price increases to $9. If we buy on Day 1, and sell on Day 6, we can make $5, the
  highest outcome so far. Thus the output for Day 6 is $5.
* Day 7: The price falls to $2. The best outcome so far is still to buy on Day 1 and
  sell on Day 6, and make $5. Thus the output for Day 7 is $5.
* Day 8: The price increases from $2 to $8. If we buy on Day 7 and
  sell on Day 8, we can make $6, the highest so far. Thus the output for Day 8
  is $6.
* Day 9: The price falls to $1. The best outcome we can obtain so far
  is still to buy on Day 7 and sell on Day 8, and make $6. Thus the output
  for Day 9 is $6.

The essential aspect to understand is that the output for Day *k* does not
require you to sell on Day *k*. You need to compute the best gains that can
be obtained *up to Day k*. You can sell on any day before *Day k*, as long as
the gains are maximized for the period spanning from the start
of the time series, and up to *Day k*.

Again, we expect a O(n) solution here, which is the fastest
way to solve the problem.

The solution template is given in method `maximumGains`.
You need to replace the `???` symbol with your own code.
The correctness of this method is tested in the test with
the name `"The gains solution is correct`. Use it to make
sure that your solution is correct before submitting.

## Part 2
Solve the Tower of Hanoi problem using the templates provided. Provide the following types of solutions:
  * Recursive (sequence - based)
  * Iterative

Please follow the template given by replacing the ??? symbols, denoting unimplemented expressions, with real code.

The test section has ready-made unit tests that should pass for a correct solution. 
Please note that passing the tests is a necessary but not sufficient condition for your solution to be correct. 
You are highly encouraged to write additional tests to ensure the correctness of your solution.

## Hints
* The test files contain inefficient, but correct solutions to the problems given.
* Do not try to replicate those solutions, since you are required to produce efficient solutions.
* However, you can study the inefficient solutions to obtain insights and ressure yourselves that you have understood the problem correctly.
* Follow the templates as given; it is very unlikely that you will obtain better
  solutions by modifying the code outside the ??? symbols.