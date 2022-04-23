
import GutenbergUtil.{getAuthor, getTitle}

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Books2(title:String= "", author:String= "", url:String = "", rows:Array[String] = Array[String]()) {

  val rowCount: Int = rows.length
  val wordCount: Int = Util.getWordCountPerLine(rows).sum

  println(s"Document $title has $rowCount lines.")
  println(s"Document $title has $wordCount words.")

  val fileLines = Util.getLinesFromFile(url)

  def saveRawFiles(files: Array[String]): Array[Document] = {
    val Folder = "src/resources/texts/"
    val url = "src/resources/webPages2.txt"
    val fileLines = Util.getLinesFromFile(url)
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
object Day19Excercise  extends App{
  val tempFolder = "src/resources/texts/temp/"
  val folder = "src/resources/texts/"
  def saveTitle(files:String, dstpath1:String = "", folder:String = "src/resources/texts/"):Unit= {
    val filePath =  "src/resources/websites2.txt"
    val fileLines = Util.getLinesFromFile(filePath)
    //val rawFiles:Array[String] = saveRawFiles(fileLines:Array[String]):Unit
    val files = Util.getListOfFiles(tempFolder)
    for (file <- files) yield {
      val rows = Util.getLinesFromFile("src/resources/temp")
      val lines = Util.getLinesFromFile(file)
      val author = GutenbergUtil.getAuthor(lines)
      val title=GutenbergUtil.getTitle(lines)
      val newDocument:String = files.head +
        "\n" +
        title +
        "\n" +
        author +
        "\n" +
        rows +
        "\n" + "\n" + "\n"

      val fileName = author.slice(0,10)
      val fileTitle=getTitle(lines).slice(0,15)
      val timenow = DateTimeFormatter.ofPattern(("yyyy_MM_dd_HH:mm")).format(LocalDateTime.now).replaceAll("-", "_").replace(":", "_")
      val fileNo = fileName + " " + fileTitle + timenow + ".txt"
      println(fileNo)
      val dstpath1 = folder + fileNo
      Util.saveText(dstpath1, newDocument)
      Thread.sleep(200)
    }
  }
  saveTitle()
}