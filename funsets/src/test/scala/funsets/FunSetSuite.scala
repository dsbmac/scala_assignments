package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */
  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("intersect contains correct elements") {
    new TestSets {
      val set1 = union(s1, s2)
      val set2 = union(s2, s3)
      val r = intersect(set1, set2) 
      assert(contains(r, 2), "Intersect contains 2")
      assert(!contains(r, 1), "Intersect !contains 1")
      assert(!contains(r, 3), "Intersect !contains 3")
    }
  }
  
  test("diff test") {
    new TestSets {
      val s = diff(s1, s2)
      assert(contains(s, 1), "diff contains 1")
      assert(!contains(s, 2), "diff !contains 2")
    }
  }
  
  test("forall test") {
    new TestSets {
      val p = ((x: Int) => 0 < x & x < 3)
      val u = union(s1, s2)
      val u2 = union(s1, s3)
      assert(forall(u, p), "forall 1")
      assert(!forall(u2, p), "forall 2")
    }
  }
  
  test("exists") {
    new TestSets {
	    val p = ((x: Int) => x > 2)
	    val u1 = union(s1, s2)
	    val u2 = union(s1, s3)
	    assert(!exists(u1, p), "exists 1")
	    assert(exists(u2, p), "exists 2")
    }
  }
}
