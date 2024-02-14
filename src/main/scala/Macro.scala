
object Macro {
  def magicMatch[T, Res](pf: Function[T, Res]): Seq[T => Boolean] =
    macro MacroImpl.derive[T]
}
