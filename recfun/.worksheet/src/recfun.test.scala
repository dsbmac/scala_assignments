package recfun
//import recfun.Main._

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  val x = pascal(0,2);System.out.println("""x  : <error> = """ + $show(x ));$skip(22); 
  val y = pascal(1,2);System.out.println("""y  : <error> = """ + $show(y ));$skip(22); 
  val z = pascal(1,3);System.out.println("""z  : <error> = """ + $show(z ));$skip(66); 
  
  // Exercise 2
  val s1 = "(if (zero? x) max (/ 1 x))".toList;System.out.println("""s1  : List[Char] = """ + $show(s1 ));$skip(23); 
  val s2 = "()".toList;System.out.println("""s2  : List[Char] = """ + $show(s2 ));$skip(85); 
  val s3 = "I told him (that it's not (yet) done). (But he wasn't listening)".toList;System.out.println("""s3  : List[Char] = """ + $show(s3 ));$skip(24); 
  val s4 = ":-)".toList;System.out.println("""s4  : List[Char] = """ + $show(s4 ));$skip(25); 
  val s5 = "())(".toList;System.out.println("""s5  : List[Char] = """ + $show(s5 ));$skip(26); 
  
  val r1 = balance(s1);System.out.println("""r1  : <error> = """ + $show(r1 ));$skip(23); 
  val r2 = balance(s2);System.out.println("""r2  : <error> = """ + $show(r2 ));$skip(23); 
  val r3 = balance(s3);System.out.println("""r3  : <error> = """ + $show(r3 ));$skip(23); 
  val r4 = balance(s4);System.out.println("""r4  : <error> = """ + $show(r4 ));$skip(23); 
  val r5 = balance(s5);System.out.println("""r5  : <error> = """ + $show(r5 ));$skip(29); 
  
  val c1 = List(1,2).size;System.out.println("""c1  : Int = """ + $show(c1 ))}
}
