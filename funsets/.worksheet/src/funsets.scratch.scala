package funsets

object scratch {
	// define type alias for set characteristic function
	type Set = Int => Boolean;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(144); 
  val s0 = (x: Int) => x == 5;System.out.println("""s0  : Int => Boolean = """ + $show(s0 ));$skip(30); 
  val s1 = (x: Int) => x == 2;System.out.println("""s1  : Int => Boolean = """ + $show(s1 ));$skip(59); 
  
  
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""");$skip(47); 
  def singletonSet(elem: Int): Set = Set(elem);System.out.println("""singletonSet: (elem: Int)Int => Boolean""");$skip(84); 
  
  def union(s: Set, t: Set): Set = {
  	x => contains(s, x) | contains(t, x)
  };System.out.println("""union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(88); 
  
  def intersect(s: Set, t: Set): Set = {
  	x => contains(s, x) & contains(t, x)
  };System.out.println("""intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(84); 
  
  def diff(s: Set, t: Set): Set = {
  	x => contains(s, x) & !contains(t, x)
  };System.out.println("""diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(223); 
  
  // selects only the elements of a set that are accepted by a given predicate p.
  // The filtered elements are returned as a new set.
 	def filter(s: Set, p: Int => Boolean): Set = {
 		x => contains(s, x) & p(x)
 	};System.out.println("""filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean""");$skip(63); 
 
  // union tests
  val unionTest0 = union(s0, s1)(2) == true;System.out.println("""unionTest0  : Boolean = """ + $show(unionTest0 ));$skip(45); 
  val unionTest1 = union(s0, s1)(3) == false;System.out.println("""unionTest1  : Boolean = """ + $show(unionTest1 ));$skip(46); 
  val unionTest2 = union(s0, s1)(-2) == false;System.out.println("""unionTest2  : Boolean = """ + $show(unionTest2 ));$skip(45); 
  val unionTest3 = union(s0, s1)(0) == false;System.out.println("""unionTest3  : Boolean = """ + $show(unionTest3 ));$skip(44); 
  val unionTest4 = union(s0, s1)(5) == true;System.out.println("""unionTest4  : Boolean = """ + $show(unionTest4 ));$skip(198); 
 
 
  def forall(s: Set, p: Int => Boolean): Boolean = {
  	def iter(a: Int): Boolean = {
  		if (a > 1000) true
  		else if (contains(s,a) & !p(a)) false
  		else iter(a+1)
  	}
  	iter(-1000)
  };System.out.println("""forall: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(37); 

	val s3 = (x: Int) => 0 < x & x < 5;System.out.println("""s3  : Int => Boolean = """ + $show(s3 ));$skip(13); 
	val p3 = s3;System.out.println("""p3  : Int => Boolean = """ + $show(p3 ));$skip(16); val res$0 = 
	forall(s3, p3);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(40); 
	val s4 = (x: Int) => -1000 < x & x < 0;System.out.println("""s4  : Int => Boolean = """ + $show(s4 ));$skip(13); 
	val p4 = s4;System.out.println("""p4  : Int => Boolean = """ + $show(p4 ));$skip(16); val res$1 = 
	forall(s4, p4);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(254); 
	
	def map(s: Set, f: Int => Int): Set = {
  	def iter(a: Int, collector: Set): Set = {
  		if (a > 1000) collector
  		else if (contains(s,a)) union(collector, singletonSet(f(a)))
  		else iter(a+1, collector)
  	}
  	iter(-1000, (x: Int) => false)
  };System.out.println("""map: (s: Int => Boolean, f: Int => Int)Int => Boolean""");$skip(37); 
	
	val emptySet = (x: Int) => false;System.out.println("""emptySet  : Int => Boolean = """ + $show(emptySet ));$skip(26); 
	val s6 = singletonSet(6);System.out.println("""s6  : Int => Boolean = """ + $show(s6 ));$skip(30); 
	val s7 = union(emptySet, s6);System.out.println("""s7  : Int => Boolean = """ + $show(s7 ));$skip(17); val res$2 = 
	contains(s7, 6);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(17); val res$3 = 
	contains(s7, 0);System.out.println("""res3: Boolean = """ + $show(res$3))}
}
