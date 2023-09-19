
### Array Reduction

 Find the minimum cost of reducing the array to one element

 There is an array of 'n' integers called 'num'. The array can be reduced by 1 element
 by performing a 'move'. Each move consists of the following three steps:

- Pick two different elements num[i] and num[j], i ≠ j.
- Remove the two selected elements from the array.
- Add the sum of the two selected elements to the end of the array.

 Each move has a 'cost' associated with it: the sum of the two elements removed from the array during the move.
 Calculate the minimum total cost of reducing the array to one element.

---
 Example:
 `num = [4,6,8]`

- Remove '4' and '6' in the first move at a cost of 4 + 6 = 10, and the resultant array is 'num' = [8,10].
- Remove '8' and '10' in the second move at a cost of 8 + 10 = 18, and the resultant array is 'num' = [18].

 The total cost of reducing this array to one element using this sequence of moves is 10 + 18 = 28.
 This is just one set of possible moves. For instance, one could have started with '4' and '8'.
 Then 4 + 8 = 12, 'num' = [6, 12], 6 + 12 = 18, num'' = [18], cost = 12 + 18 = 30.

---
 #### Function Description:

 Complete the function 'reductionCost' in the editor below.
 reductionCost has the following parameter(s):
 int num[n]: an array of integers
 Return
 int: the minimum total cost of reducing the input array to one element

---
 ####  Constraints:
-  2 ≤ n ≤ 10^4
- 0 ≤ num[i] ≤ 10^5

 Make the following moves to reduce the array num = [1, 2, 3]

- Remove 1 and 2 at cost = 1 + 2 = 3, resulting in 'num' = [3, 3].
- Remove 3 and 3 at cost = 3 + 3 = 6, resulting in 'num' = [6]

 Sum up the cost of each reduction to get 3 + 6 = 9

 Sample Case 1

 Sample Input 1
 [1, 2, 3, 4]

 Sample Output 1
 19

 Explanation 1

 Make the following moves to reduce the array num = [1, 2, 3, 4] :
- Remove 1 and 2 at cost= 1 + 2 = 3, resulting in num= [3, 4, 3].
- Remove 3 and 3 at cost = 3 + 3 = 6, resulting in num= [4, 6].
- Remove 4 and 6 at cost = 4 + 6 = 10, resulting in num= [10].

 Sum up the cost of each reduction to get 3 + 6 + 10 = 19

---

 Using Greedy algo and taking always 2 min elements at each step.
 Min Heap will help with that.

---
#### Complexity:

 Time Complexity: `O(n log n)` ; adding to priority queue once
 and then removing 2 minimal elements is O(1) but inserting 1 element is log N,
 and it is done N times, so it is still `O(n log n)`

 Space complexity: `O(N)` to  store N elements in the queue and O(1) to store temp sum and cost function