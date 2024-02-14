import scala.reflect.macros.whitebox

class MacroImpl(val c: whitebox.Context) {

  import c.universe._

  def derive[T: WeakTypeTag](pf: MacroImpl.this.c.Tree): Tree = {

    val functions = pf
      .collect { case c: CaseDef => c}
      .map {
      case CaseDef(literal: Literal, EmptyTree, _) =>
        q"(t: ${weakTypeTag[T]}) => t == ${literal}"
      case CaseDef(Bind(term, Ident(termNames.WILDCARD)), guard, _) =>
        q"(${term.toTermName}: ${weakTypeTag[T]}) => ${guard}"

      case cf =>
        throw new RuntimeException(
          s"Cannot handle case [${cf}]. Raw tree [${showRaw(cf)}]"
        )
    }

    println(s"RES: [${functions}]")
    println(s"TREE 1: ${showRaw(functions(0))}")
    println(s"TREE 2: ${showRaw(functions(1))}")
    println(functions(0).equalsStructure(functions(1)))

    q"Seq(..${functions})"
  }
}
