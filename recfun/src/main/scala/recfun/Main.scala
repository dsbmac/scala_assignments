package recfun
import common._
import scala.collection.mutable.Set


object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   * Int Int -> Int
   * takes a column c and a row r, counting from 0 and returns 
   * the number at that spot in the triangle. 
   * For example, pascal(0,2)=1, pascal(1,2)=2 and pascal(1,3)=3.
   */
  def pascal(c: Int, r: Int): Int = {
    def rec_pascal(c: Int, r: Int): Int = {
	    if (c < 0 | c > r) {
	      0
	    } else {
	      if (c == 0 | r == c) 1 else pascal(c-1, r-1) + pascal(c, r-1)
		  }
	  }
    rec_pascal(c,r)
  }

  /**
   * Exercise 2
   * List[Char] -> Boolean
   * verifies the balancing of parentheses in a string 
   */
  
  def balance(chars: List[Char]): Boolean = {
    def rec_balance(chars: List[Char], score: Int): Boolean = {
	    if (chars.isEmpty) {
	      score == 0
	    }
	    else if (chars.head == ')' | chars.head == '(') {
		      if (chars.head == ')') {
		        if (score <= 0) false else rec_balance(chars.tail, score-1)
		      }
		      else {
			      rec_balance(chars.tail, score+1)
		      }		      
		    } 
	    else {
	      rec_balance(chars.tail, score)
	    } 
    }
    
    rec_balance(chars, 0)
  }

  /**
   * Exercise 3  
   * counts how many different ways you can make change for an amount, given a list of coin denominations.
   * countChange(4, List[1,2]) -> 3
   * countChange(4, List[]) -> 0
   * countChange(0, List[1,2]) -> 1
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    val result = Set.empty[List[Int]]
    
    def rec_count(combo: List[Int], coinsAvailable: List[Int]): Int = {
      //println(combo)
      if(combo.sum == money) {
        println("  solution:" + combo.sortWith(_<_) )
        result += combo.sortWith(_ < _)
        1
      } else if (coinsAvailable.isEmpty) {
        0
      } else {
        val newCombo = combo:+coinsAvailable.head
        newCombo.sortWith(_<_)
        if (!(result contains newCombo) & newCombo.sum <= money) {
          result.add(newCombo)
        	rec_count(newCombo, coins)
        } else {
          rec_count(combo, coinsAvailable.tail)
        }
      }
      0
    }
    println("result: " + result)
    rec_count(List(), coins)
    result.size
  }
}
