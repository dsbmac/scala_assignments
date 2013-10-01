package funsets

object scratch {
	// define type alias for set characteristic function
	type Set = Int => Boolean
  val s0 = (x: Int) => x == 5                     //> s0  : Int => Boolean = <function1>
  val s1 = (x: Int) => x == 2                     //> s1  : Int => Boolean = <function1>
  
  
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean
  def singletonSet(elem: Int): Set = Set(elem)    //> singletonSet: (elem: Int)Int => Boolean
  
  def union(s: Set, t: Set): Set = {
  	x => contains(s, x) | contains(t, x)
  }                                               //> union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
  
  def intersect(s: Set, t: Set): Set = {
  	x => contains(s, x) & contains(t, x)
  }                                               //> intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
  
  def diff(s: Set, t: Set): Set = {
  	x => contains(s, x) & !contains(t, x)
  }                                               //> diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
  
  // selects only the elements of a set that are accepted by a given predicate p.
  // The filtered elements are returned as a new set.
 	def filter(s: Set, p: Int => Boolean): Set = {
 		x => contains(s, x) & p(x)
 	}                                         //> filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean
 
  // union tests
  val unionTest0 = union(s0, s1)(2) == true       //> unionTest0  : Boolean = true
  val unionTest1 = union(s0, s1)(3) == false      //> unionTest1  : Boolean = true
  val unionTest2 = union(s0, s1)(-2) == false     //> unionTest2  : Boolean = true
  val unionTest3 = union(s0, s1)(0) == false      //> unionTest3  : Boolean = true
  val unionTest4 = union(s0, s1)(5) == true       //> unionTest4  : Boolean = true
 
 
  def forall(s: Set, p: Int => Boolean): Boolean = {
  	def iter(a: Int): Boolean = {
  		if (a > 1000) true
  		else if (contains(s,a) & !p(a)) false
  		else iter(a+1)
  	}
  	iter(-1000)
  }                                               //> forall: (s: Int => Boolean, p: Int => Boolean)Boolean

	val s3 = (x: Int) => 0 < x & x < 5        //> s3  : Int => Boolean = <function1>
	val p3 = s3                               //> p3  : Int => Boolean = <function1>
	forall(s3, p3)                            //> res0: Boolean = true
	val s4 = (x: Int) => -1000 < x & x < 0    //> s4  : Int => Boolean = <function1>
	val p4 = s4                               //> p4  : Int => Boolean = <function1>
	forall(s4, p4)                            //> res1: Boolean = true
	
	def map(s: Set, f: Int => Int): Set = {
  	def iter(a: Int, collector: Set): Set = {
  		if (a > 1000) collector
  		else if (contains(s,a)) union(collector, singletonSet(f(a)))
  		else iter(a+1, collector)
  	}
  	iter(-1000, (x: Int) => false)
  }                                               //> map: (s: Int => Boolean, f: Int => Int)Int => Boolean
	
	val emptySet = (x: Int) => false          //> emptySet  : Int => Boolean = <function1>
	val s6 = singletonSet(6)                  //> s6  : Int => Boolean = Set(6)
	val s7 = union(emptySet, s6)              //> s7  : Int => Boolean = <function1>
	contains(s7, 6)                           //> res2: Boolean = true
	contains(s7, 0)                           //> res3: Boolean = false
}