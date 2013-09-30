package recfun
import recfun.Main._
import scala.collection.mutable.Set

object scratch {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(111); 
  val x = pascal(0,2);System.out.println("""x  : Int = """ + $show(x ));$skip(22); 
  val y = pascal(1,2);System.out.println("""y  : Int = """ + $show(y ));$skip(22); 
  val z = pascal(1,3);System.out.println("""z  : Int = """ + $show(z ));$skip(65); 
 
  // Exercise 2
  val s1 = "(if (zero? x) max (/ 1 x))".toList;System.out.println("""s1  : List[Char] = """ + $show(s1 ));$skip(23); 
  val s2 = "()".toList;System.out.println("""s2  : List[Char] = """ + $show(s2 ));$skip(85); 
  val s3 = "I told him (that it's not (yet) done). (But he wasn't listening)".toList;System.out.println("""s3  : List[Char] = """ + $show(s3 ));$skip(24); 
  val s4 = ":-)".toList;System.out.println("""s4  : List[Char] = """ + $show(s4 ));$skip(25); 
  val s5 = "())(".toList;System.out.println("""s5  : List[Char] = """ + $show(s5 ));$skip(26); 
  
  val r1 = balance(s1);System.out.println("""r1  : Boolean = """ + $show(r1 ));$skip(23); 
  val r2 = balance(s2);System.out.println("""r2  : Boolean = """ + $show(r2 ));$skip(23); 
  val r3 = balance(s3);System.out.println("""r3  : Boolean = """ + $show(r3 ));$skip(23); 
  val r4 = balance(s4);System.out.println("""r4  : Boolean = """ + $show(r4 ));$skip(23); 
  val r5 = balance(s5);System.out.println("""r5  : Boolean = """ + $show(r5 ));$skip(21); 
 
  val c1 = List(1);System.out.println("""c1  : List[Int] = """ + $show(c1 ));$skip(21); 
  val c2 = List(1,2);System.out.println("""c2  : List[Int] = """ + $show(c2 ));$skip(24); 
  val c3 = List(1,2, 5);System.out.println("""c3  : List[Int] = """ + $show(c3 ));$skip(18); 
  val c4 = List();System.out.println("""c4  : List[Nothing] = """ + $show(c4 ));$skip(21); 
  val c5 = List(2,1);System.out.println("""c5  : List[Int] = """ + $show(c5 ));$skip(34); 
  
  val d1 = countChange(2, c1);System.out.println("""d1  : Int = """ + $show(d1 ));$skip(30); 
  val d2 = countChange(2, c2);System.out.println("""d2  : Int = """ + $show(d2 ));$skip(30); 
  val d3 = countChange(4, c2);System.out.println("""d3  : Int = """ + $show(d3 ));$skip(30); 
  val d4 = countChange(0, c2);System.out.println("""d4  : Int = """ + $show(d4 ));$skip(34); 
  val d5 = countChange(0, List());System.out.println("""d5  : Int = """ + $show(d5 ));$skip(31); 
  val d6 = countChange(10, c4);System.out.println("""d6  : Int = """ + $show(d6 ));$skip(52); 
  val d7 = countChange(4, c2) == countChange(4, c5);System.out.println("""d7  : Boolean = """ + $show(d7 ));$skip(57); 
  val d8 = countChange(300,List(5,10,20,50,100,200,500));System.out.println("""d8  : Int = """ + $show(d8 ))}
}
