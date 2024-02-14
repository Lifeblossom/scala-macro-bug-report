
object Test {
  val functions = Macro.magicMatch[String, String]({
    case "abc"           => "Case 1"
    case t if t == "abc" => "Case 2"
    case "abc"           => "Case 3"
    case t if t == "abc" => "Case 4"
  })
}

//class Test extends AnyFlatSpec with should.Matchers {
//
//  "A Stack" should "pop values in last-in-first-out order" in {
//    val functions = Macro.magicMatch[String, String]({
//      case "123"                    => "Case 1"
//      case t if t.startsWith("abc") => "Case 2"
//    })
//
//    println(functions(0)("123"))
//    println(functions(1)("abc"))
//  }
//}
