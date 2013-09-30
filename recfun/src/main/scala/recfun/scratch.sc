package recfun
import recfun.Main._
import scala.collection.mutable.Set

object scratch {
  val x = pascal(0,2)                             //> x  : Int = 1
  val y = pascal(1,2)                             //> y  : Int = 2
  val z = pascal(1,3)                             //> z  : Int = 3
 
  // Exercise 2
  val s1 = "(if (zero? x) max (/ 1 x))".toList    //> s1  : List[Char] = List((, i, f,  , (, z, e, r, o, ?,  , x, ),  , m, a, x,  
                                                  //| , (, /,  , 1,  , x, ), ))
  val s2 = "()".toList                            //> s2  : List[Char] = List((, ))
  val s3 = "I told him (that it's not (yet) done). (But he wasn't listening)".toList
                                                  //> s3  : List[Char] = List(I,  , t, o, l, d,  , h, i, m,  , (, t, h, a, t,  , i
                                                  //| , t, ', s,  , n, o, t,  , (, y, e, t, ),  , d, o, n, e, ), .,  , (, B, u, t,
                                                  //|   , h, e,  , w, a, s, n, ', t,  , l, i, s, t, e, n, i, n, g, ))
  val s4 = ":-)".toList                           //> s4  : List[Char] = List(:, -, ))
  val s5 = "())(".toList                          //> s5  : List[Char] = List((, ), ), ()
  
  val r1 = balance(s1)                            //> r1  : Boolean = true
  val r2 = balance(s2)                            //> r2  : Boolean = true
  val r3 = balance(s3)                            //> r3  : Boolean = true
  val r4 = balance(s4)                            //> r4  : Boolean = false
  val r5 = balance(s5)                            //> r5  : Boolean = false
 
  val c1 = List(1)                                //> c1  : List[Int] = List(1)
  val c2 = List(1,2)                              //> c2  : List[Int] = List(1, 2)
  val c3 = List(1,2, 5)                           //> c3  : List[Int] = List(1, 2, 5)
  val c4 = List()                                 //> c4  : List[Nothing] = List()
  val c5 = List(2,1)                              //> c5  : List[Int] = List(2, 1)
  
  val d1 = countChange(2, c1)                     //> result: Set()
                                                  //|   solution:List(1, 1)
                                                  //| d1  : Int = 2
  val d2 = countChange(2, c2)                     //> result: Set()
                                                  //|   solution:List(1, 1)
                                                  //| d2  : Int = 2
  val d3 = countChange(4, c2)                     //> result: Set()
                                                  //|   solution:List(1, 1, 1, 1)
                                                  //| d3  : Int = 4
  val d4 = countChange(0, c2)                     //> result: Set()
                                                  //|   solution:List()
                                                  //| d4  : Int = 1
  val d5 = countChange(0, List())                 //> result: Set()
                                                  //|   solution:List()
                                                  //| d5  : Int = 1
  val d6 = countChange(10, c4)                    //> result: Set()
                                                  //| d6  : Int = 0
  val d7 = countChange(4, c2) == countChange(4, c5)
                                                  //> result: Set()
                                                  //|   solution:List(1, 1, 1, 1)
                                                  //| result: Set()
                                                  //|   solution:List(2, 2)
                                                  //| d7  : Boolean = false
  val d8 = countChange(300,List(5,10,20,50,100,200,500))
                                                  //> result: Set()
                                                  //|   solution:List(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 
                                                  //| 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5
                                                  //| , 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5)
                                                  //| d8  : Int = 60
}