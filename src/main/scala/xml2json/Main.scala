package xml2json

/**
  * 9/11/16 12:55 AM
  */
object Main extends App {
    val tokens: Seq[XMLToken] = Tokenizer tokenize Test.exampleXML
    val tokenString = tokens mkString "\n"
    assert(tokenString equals Test.expectedTokenString, "tokenization")
    val parsed: ASTNode = Parser parse tokens
    println(parsed)
    val json: JsonObj = JsonObjectGenerator fromAST parsed
    println(json)
    val compactString: String = JsonPrinter compactPrint json
    val prettyString: String = JsonPrinter prettyPrint json
    println(s"\njson string:\n$compactString\n\nnow pretty:\n$prettyString")
}
