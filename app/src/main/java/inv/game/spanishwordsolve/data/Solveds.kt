package inv.game.spanishwordsolve.data

import android.content.Context
import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.io.PrintWriter

class Solveds(activity: Context) {
  val solvedsFile = File(activity.getFilesDir(), "solveds.txt")
  
  var solvedListAsString = ""
    
  private fun updateSolvedListAsString(new: String) {
    solvedListAsString = new
  }
  
  fun writeToSolveds(index: Int) {
    val updatedSolveds = StringBuilder(solvedListAsString)
    val printWriter = PrintWriter(solvedsFile)
    updatedSolveds.setCharAt(index, 'Y')
    val updatedSolvedsAsString = updatedSolveds.toString()
    printWriter.print(updatedSolvedsAsString)
    printWriter.close()
    updateSolvedListAsString(updatedSolvedsAsString)
  }
  
  init {
    if (!(solvedsFile.isFile())) {
      solvedsFile.createNewFile()
      val fileWriter = FileWriter(solvedsFile)
      fileWriter.write("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN")
      fileWriter.close()
    }
    
    if (solvedListAsString == "") {
      updateSolvedListAsString(
        String(
          Files.readAllBytes(
            solvedsFile.toPath()
          )
        )
      )
    }
  }
}