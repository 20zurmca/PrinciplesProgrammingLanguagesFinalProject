package IntroducingScala

/**
  * Example Upper converts a list of strings in a sequence
  * to uppercase
  */
class Upper {

  /**
    *  Notice how the return types are formatted like TypeLang
    *  [] is for generics, like <> in java
    *  * means 0 or more separated by comma
    * @param strings list of strings
    * @return sequence of uppercase strings
    */
  def upper(strings: String*): Seq[String] = {
    strings.map((s:String) => s.toUpperCase()) //using function literal (like a lambda function)
  }
}
