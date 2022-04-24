
import Day19DocumentReading.saveRawFiles
import GutenbergUtil.{getAuthor, getTitle}

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Books2(title:String= "", author:String= "", url:String = "", rows:Array[String] = Array[String]()) {

  val rowCount: Int = rows.length
  val wordCount: Int = Util.getWordCountPerLine(rows).sum

  println(s"Document $title has $rowCount lines.")
  println(s"Document $title has $wordCount words.")

  def saveRawFiles(files: Array[String]): Array[Document] = {
    val url = "src/resources/webPages2.txt"
    val documentArray = for ((url, i) <- files.zipWithIndex) yield {
      val dst1 = "src/resources/texts/temp/" + "txt" + i + ".txt"
      val text = Util.getTextFromWebAndSave(url, dst1)
      val rows = Util.getLinesFromFile("src/resources/temp")
      val title = GutenbergUtil.getTitle(rows)
      val author = GutenbergUtil.getAuthor(rows)
      Document(title, author, url, rows)
    }
    documentArray
  }
}
object Day19Excercise2  extends App{
  val urls = "src/resources/webPages2.txt"
  val fileLines = Util.getLinesFromFile(urls)
  val files = saveRawFiles(fileLines)
  val tempFolder = "src/resources/texts/temp/"
  val folder = "src/resources/texts/"
  def saveTitle(files:String, dstpath1:String = "", folder:String = "src/resources/texts/"):Unit= {
    for (file <- files) yield {
      val lines = Util.getLinesFromFile("src/resources/temp")
      val author = GutenbergUtil.getAuthor(lines)
      val title=GutenbergUtil.getTitle(lines)
      val newDocument:String = files.head +
        "\n" +
        title +
        "\n" +
        author +
        "\n" +
        lines +
        "\n" + "\n" + "\n"

      val fileName = author.slice(0,10)
      val fileTitle=getTitle(lines).slice(0,15)
      val timenow = DateTimeFormatter.ofPattern(("yyyy_MM_dd_HH:mm")).format(LocalDateTime.now).replaceAll("-", "_").replace(":", "_")
      val fileNo = fileName + " " + fileTitle + timenow + ".txt"
      val dstpath1 = folder + fileNo
      Util.saveText(dstpath1, newDocument)
      Thread.sleep(200)
    }
  }
  saveTitle()
}
