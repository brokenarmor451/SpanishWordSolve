package inv.game.spanishwordsolve.data

import androidx.appcompat.widget.AppCompatTextView

class Word(
  val correctWord: List<String>,
  val orientation: Int,
  val cantClickableIndices: List<Int>,
) {
  var letterBoxes: List<AppCompatTextView> = listOf()
}
