package start.scala

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    println("Hello, world2!")
    test01()
  }

  def test01() {
    var a = 10;
    var b = 20;
    var c = 25;
    var d = 25
    val constant = 100;
    println("a + b = " + (a + b) );
    println("a - b = " + (a - b) );
    println("a * b = " + (a * b - constant));
    println("b / a = " + (b / a) );
    println("b % a = " + (b % a) );
    println("c % a = " + (c % a) );

  }

}
