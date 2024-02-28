package inv.game.spanishwordsolve.data

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.gridlayout.widget.GridLayout.HORIZONTAL
import androidx.gridlayout.widget.GridLayout.VERTICAL

var selectedLevel = 0

fun level1(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("R", "", "D"),
        arrayOf("", "", "K"),
        arrayOf("","Y"),
        arrayOf("","","","","W"),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("R", "E", "D"),
      HORIZONTAL,
      listOf(0, 2),
    )
    
    val word2 = Word (
      listOf("A", "R", "K"),
      VERTICAL,
      listOf(2),
    )
    
    val word3 = Word(
      listOf("E","Y"),
      HORIZONTAL,
      listOf(1)
    )
    
    val word4 = Word(
      listOf("E","L","L","O","W"),
      VERTICAL,
      listOf(4)
    )
    
    val word5 = Word(
      listOf("S", "N", "O"),
      HORIZONTAL,
      listOf()
    )
    
    // paddings of 5 words left top right bottom
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (2 * level.boxWidth) + (4 * level.boxPadding),
        level.boxHeight + 2 * level.boxPadding,
        0,
        0,
      ),
      listOf(
        (3 * level.boxWidth) + (6*level.boxPadding),
        (3 * level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4 * level.boxWidth) + (8*level.boxPadding),
        (4 * level.boxHeight) + (8*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (8 * level.boxHeight) + (16*level.boxPadding),
        0,
        0,
      ),
    )
    
    level.wordsToBeFind = "ROJO\nOSCURA\nLLAVE\nAMARILLO\nNIEVE"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(3,3,2,5,3))
    
    return level
}

fun level2(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("K","","","B","","","",""),
        arrayOf("","","E"),
        arrayOf("","","","T"),
        arrayOf("","","","R",),
        arrayOf("C","","",""),
      )
    }
    
    val word1 = Word(
      listOf("K","E","Y","B","O","A","R","D"),
      HORIZONTAL,
      listOf(0, 3),
    )
    
    val word2 = Word (
      listOf("L", "U", "E"),
      VERTICAL,
      listOf(2),
    )
    
    val word3 = Word(
      listOf("I","G","H","T"),
      HORIZONTAL,
      listOf(3)
    )
    
    val word4 = Word(
      listOf("I","G","E","R"),
      VERTICAL,
      listOf(3)
    )
    
    val word5 = Word(
      listOf("C","H","A","I"),
      HORIZONTAL,
      listOf(0)
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (3 * level.boxWidth) + (6*level.boxPadding),
        (level.boxWidth) + (2*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4 * level.boxWidth) + (8*level.boxPadding),
        (3 * level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (7 * level.boxWidth) + (14*level.boxPadding),
        (4 * level.boxHeight) + (8*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3 * level.boxWidth) + (6*level.boxPadding),
        (7 * level.boxHeight) + (14*level.boxPadding),
        0,
        0,
      ),
    )
    
    level.wordsToBeFind = "TECLADO\nAZUL\nOCHO\nTIGRE\nSILLA"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(8,3,4,4,4))
    
    return level
}

fun level3(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("S","H","","", ""),
        arrayOf("","","D"),
        arrayOf("","Y"),
        arrayOf("", "","R"),
        arrayOf("","","",""),
      )
    }
    
    val word1 = Word(
      listOf("S","H", "O", "E", "S"),
      HORIZONTAL,
      listOf(0, 1),
    )
    
    val word2 = Word (
      listOf("A", "N", "D"),
      VERTICAL,
      listOf(2),
    )
    
    val word3 = Word(
      listOf("A","Y"),
      HORIZONTAL,
      listOf(1)
    )
    
    val word4 = Word(
      listOf("E","A","R"),
      VERTICAL,
      listOf(2)
    )
    
    val word5 = Word(
      listOf("I","V","E","R"),
      HORIZONTAL,
      listOf()
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2 * level.boxWidth) + (4*level.boxPadding),
        (3 * level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3 * level.boxWidth) + (6*level.boxPadding),
        (4 * level.boxHeight) + (8*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4* level.boxWidth) + (8*level.boxPadding),
        (6 * level.boxHeight) + (12*level.boxPadding),
        0,
        0,
      ),
    )
    
    level.wordsToBeFind = "ZAPATOS\nMANO\nDÍA\nAÑO\nRÍO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(5,3,2,3,4))
    
    return level
}

fun level4(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("L", "","", "N"),
        arrayOf("","","", "H"),
        arrayOf("","","S",""),
        arrayOf("","","T",""),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("L","I", "O", "N"),
      HORIZONTAL,
      listOf(0, 3),
    )
    
    val word2 = Word (
      listOf("O","R","T","H"),
      VERTICAL,
      listOf(3),
    )
    
    val word3 = Word(
      listOf("O", "U", "S", "E"),
      HORIZONTAL,
      listOf(2)
    )
    
    val word4 = Word(
      listOf("O","U", "T", "H"),
      VERTICAL,
      listOf(2)
    )
    
    val word5 = Word(
      listOf("C","A"),
      HORIZONTAL,
      listOf()
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (3 * level.boxWidth) + (6 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4 * level.boxWidth) + (8 * level.boxPadding),
        (4 * level.boxHeight) + (8 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (6 * level.boxWidth) + (12 * level.boxPadding),
        (5 * level.boxHeight) + (10 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4* level.boxWidth) + (8 * level.boxPadding),
        (7 * level.boxHeight) + (14 * level.boxPadding),
        0,
        0,
      ),
    )
    
    level.wordsToBeFind = "LEÓN\nNORTE\nCASA\nSUR\nGATA"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,4,4,4,2))
    
    return level
}

fun level5(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("", "O", "", "R"),
        arrayOf("", "", "", "","E"),
        arrayOf("","","H",""),
        arrayOf("","","E"),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("D","O","O","R"),
      VERTICAL,
      listOf(1, 3),
    )
    
    val word2 = Word (
      listOf("R","A","N","G","E"),
      HORIZONTAL,
      listOf(4),
    )
    
    val word3 = Word(
      listOf("I","G", "H", "T"),
      HORIZONTAL,
      listOf(2)
    )
    
    val word4 = Word(
      listOf("O","L","E"),
      VERTICAL,
      listOf(2)
    )
    
    val word5 = Word(
      listOf("G","G"),
      HORIZONTAL,
      listOf()
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        (3 * level.boxHeight) + (6 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3 * level.boxWidth) + (6 * level.boxPadding),
        (4 * level.boxHeight) + (8 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4 * level.boxWidth) + (8 * level.boxPadding),
        (6 * level.boxHeight) + (12 * level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "PUERTA\nNARANJA\nDERECHA\nAGUJERO\nHUEVO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,5,4,3,2))
    
    return level
}

fun level6(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("T", "", "U", "","","D","",""),
        arrayOf("", "", "",""),
        arrayOf("","","","E"),
        arrayOf("",""),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("T","H","U","R","S","D","A","Y"),
      HORIZONTAL,
      listOf(0,2,5),
    )
    
    val word2 = Word (
      listOf("O","D","A","Y"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("N","C", "L", "E"),
      VERTICAL,
      listOf(3)
    )
    
    val word4 = Word(
      listOf("A","D"),
      VERTICAL,
      listOf()
    )
    
    val word5 = Word(
      listOf("X","I","T"),
      HORIZONTAL,
      listOf()
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4 * level.boxPadding),
        (1 * level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (5* level.boxWidth) + (10 * level.boxPadding),
        (1 * level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3 * level.boxWidth) + (6 * level.boxPadding),
        (4 * level.boxHeight) + (8 * level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "JUEVES\nHOY\nTÍO\nPAPÁ\nSALIDA"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(8,4,4,2,3))
    
    return level
}

fun level7(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("H", "", "", ""),
        arrayOf("","G",""),
        arrayOf("","E",""),
        arrayOf("","","","W"),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("H","O","U","R"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("U","G","E"),
      VERTICAL,
      listOf(1),
    )
    
    val word3 = Word(
      listOf("R","E","Y"),
      HORIZONTAL,
      listOf(1)
    )
    
    val word4 = Word(
      listOf("L","B","O","W"),
      VERTICAL,
      listOf(3)
    )
    
    val word5 = Word(
      listOf("O","L","F"),
      HORIZONTAL,
      listOf()
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
         0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        (2 * level.boxHeight) + (4 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (2 * level.boxWidth) + (4 * level.boxPadding),
        (3 * level.boxHeight) + (6 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3 * level.boxWidth) + (6 * level.boxPadding),
        (6 * level.boxHeight) + (12 * level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "HORA\nENORME\nGRIS\nCODO\nLOBO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,3,3,4,3))
    
    return level
}

fun level8(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("M", "", "", "T",""),
        arrayOf("", "", "", ""),
        arrayOf("","","","B"),
        arrayOf("","A",""),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("M","O","U","T","H"),
      HORIZONTAL,
      listOf(0, 3),
    )
    
    val word2 = Word (
      listOf("O","U","S","E"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("H","U", "M", "B"),
      VERTICAL,
      listOf(3)
    )
    
    val word4 = Word(
      listOf("E","A","R"),
      HORIZONTAL,
      listOf(1)
    )
    
    val word5 = Word(
      listOf("R","M"),
      VERTICAL,
      listOf()
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4 * level.boxWidth) + (8 * level.boxPadding),
        (4 * level.boxHeight) + (8 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (5 * level.boxWidth) + (10 * level.boxPadding),
        (5 * level.boxHeight) + (10 * level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "BOCA\nRATÓN\nPULGAR\nOSO\nBRAZO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(5,4,4,3,2))
    
    return level
}

fun level9(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("C","","W"),
        arrayOf("", "", "","",""),
        arrayOf("","L","","","S"),
        arrayOf("","","",""),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("C","O","W"),
      HORIZONTAL,
      listOf(0, 2),
    )
    
    val word2 = Word (
      listOf("A","R","R","O","T"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("A","L","R","U","S"),
      VERTICAL,
      listOf(1,4),
    )
    
    val word4 = Word(
      listOf("E","M","O","N"),
      HORIZONTAL,
      listOf(),
    )
    
    val word5 = Word(
      listOf("E","A","L"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3 * level.boxWidth) + (6 * level.boxPadding),
        (2 * level.boxHeight) + (4 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3 * level.boxWidth) + (6 * level.boxPadding),
        (5 * level.boxHeight) + (10 * level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "VACA\nZANAHORIA\nMORSA\nLIMÓN\nFOCA"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(3,5,5,4,3))
    
    return level
}

fun level10(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("S","","","","","D"),
        arrayOf("", "", "","A",""),
        arrayOf("","",""),
        arrayOf("","","F"),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("S","E","C","O","N","D"),
      HORIZONTAL,
      listOf(0, 5),
    )
    
    val word2 = Word (
      listOf("U","N","D","A","Y"),
      VERTICAL,
      listOf(3),
    )
    
    val word3 = Word(
      listOf("U","N","T"),
      HORIZONTAL,
      listOf(),
    )
    
    val word4 = Word(
      listOf("E","A","F"),
      VERTICAL,
      listOf(2),
    )
    
    val word5 = Word(
      listOf("O","X"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        (4*level.boxHeight) + (8 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (5 * level.boxWidth) + (10 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (6 * level.boxWidth) + (12 * level.boxPadding),
        (3 * level.boxHeight) + (6 * level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "DOMINGO\nSEGUNDO\nTÍA\nSORDO\nZORRO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(6,5,3,3,2))
    
    return level
}

fun level11(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("O","","L"),
        arrayOf("","","","",""),
        arrayOf("","","C",""),
        arrayOf("","P"),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("O","W","L"),
      HORIZONTAL,
      listOf(0, 2),
    )
    
    val word2 = Word (
      listOf("F","F","I","C","E"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("U","N","C","H"),
      VERTICAL,
      listOf(2),
    )
    
    val word4 = Word(
      listOf("U","P"),
      HORIZONTAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("S","O","A"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3 * level.boxWidth) + (6 * level.boxPadding),
        (3 * level.boxHeight) + (6 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4 * level.boxWidth) + (8 * level.boxPadding),
        0,
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "BÚHO\nOFICINA\nALMUERZO\nCOPA\nJABÓN"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(3,5,4,2,3))
    
    return level
}

fun level12(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("K","","T","","H","","N"),
        arrayOf("","","",""),
        arrayOf("","",""),
        arrayOf("","","",""),
        arrayOf("","","","","",""),
      )
    }
    
    val word1 = Word(
      listOf("K","I","T","C","H","E","N"),
      HORIZONTAL,
      listOf(0,2,4,6),
    )
    
    val word2 = Word (
      listOf("N","I","F","E"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("H","I","S"),
      VERTICAL,
      listOf(),
    )
    
    val word4 = Word(
      listOf("A","P","P","Y"),
      VERTICAL,
      listOf(),
    )
    
    val word5 = Word(
      listOf("E","R","V","O","U","S"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4 * level.boxWidth) + (8 * level.boxPadding),
        (level.boxHeight) + ( 2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (6*level.boxWidth) + (12 * level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "COCINA\nCUCHILLO\nESTO\nFELIZ\nNERVIOSA"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(7,4,3,4,6))
    
    return level
}

fun level13(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("G","","A","",""),
        arrayOf("","",""),
        arrayOf("","P","",""),
        arrayOf("","A",""),
        arrayOf("","","",""),
      )
    }
    
    val word1 = Word(
      listOf("G","L","A","S","S"),
      VERTICAL,
      listOf(0,2),
    )
    
    val word2 = Word (
      listOf("O","A","T"),
      HORIZONTAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("P","P","L","E"),
      HORIZONTAL,
      listOf(1),
    )
    
    val word4 = Word(
      listOf("E","A","R"),
      VERTICAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("P","R","I","L"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        0,
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        (2*level.boxHeight) + (4 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (2 * level.boxWidth) + (4 * level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6 * level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "VASO\nCABRA\nMANZANA\nPERA\nABRIL"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(5,3,4,3,4))
    
    return level
}

fun level14(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("S","","E","","P"),
        arrayOf("","","",""),
        arrayOf("","","","","E","",""),
        arrayOf("","",""),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("S","H","E","E","P"),
      VERTICAL,
      listOf(0,2,4),
    )
    
    val word2 = Word (
      listOf("M","A","L","L"),
      HORIZONTAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("N","G","I","N","E","E","R"),
      HORIZONTAL,
      listOf(4),
    )
    
    val word4 = Word(
      listOf("I","N","K"),
      HORIZONTAL,
      listOf(),
    )
    
    val word5 = Word(
      listOf("A","R"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        0,
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        (2*level.boxHeight) + (4 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (5*level.boxWidth) + (10 * level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "PEQUEÑA\nOVEJA\nINGENIERO\nROSADO\nOÍDO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(5,4,7,3,2))
    
    return level
}

fun level15(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("","O","","","",""),
        arrayOf("","","O","N"),
        arrayOf("","I","",""),
        arrayOf("","K"),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("D","O","N","K","E","Y"),
      VERTICAL,
      listOf(1),
    )
    
    val word2 = Word (
      listOf("N","I","O","N"),
      HORIZONTAL,
      listOf(2,3),
    )
    
    val word3 = Word(
      listOf("L","I","V","E"),
      VERTICAL,
      listOf(1),
    )
    
    val word4 = Word(
      listOf("N","K"),
      HORIZONTAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("I","D"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6 * level.boxPadding),
        (2*level.boxHeight) + (4 * level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (5*level.boxWidth) + (10*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "BURRO\nCEBOLLA\nACEITUNA\nTINTA\nNIÑO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(6,4,4,2,2))
    
    return level
}

fun level16(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("W","","","T"),
        arrayOf("","",""),
        arrayOf("","","E"),
        arrayOf("","D"),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("W","H","A","T"),
      HORIZONTAL,
      listOf(0,3),
    )
    
    val word2 = Word (
      listOf("O","R","D"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("I","M","E"),
      VERTICAL,
      listOf(2),
    )
    
    val word4 = Word(
      listOf("N","D"),
      HORIZONTAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("L","A","N"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (5*level.boxWidth) + (10*level.boxPadding),
        0,
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "QUÉ\nPALABRA\nTIEMPO\nFIN\nTIERRA"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,3,3,2,3))
    
    return level
}

fun level17(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("H","","",""),
        arrayOf("","T"),
        arrayOf("","","C",""),
        arrayOf("","","","R"),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("H","I","G","H"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("O","T"),
      VERTICAL,
      listOf(1),
    )
    
    val word3 = Word(
      listOf("H","I","C","K"),
      HORIZONTAL,
      listOf(2),
    )
    
    val word4 = Word(
      listOf("O","V","E","R"),
      VERTICAL,
      listOf(3),
    )
    
    val word5 = Word(
      listOf("I","N","G"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (6*level.boxHeight) + (12*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "ALTO\nCALIENTE\nGRUESAS\nCUBIERTA\nANILLO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,2,4,4,3))
    
    return level
}

fun level18(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("P","","A","","T"),
        arrayOf("","","","",""),
        arrayOf("",""),
        arrayOf("U","","","","",""),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("P","L","A","N","T"),
      HORIZONTAL,
      listOf(0,2,4),
    )
    
    val word2 = Word (
      listOf("A","C","K","E","T"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("N","T"),
      VERTICAL,
      listOf(),
    )
    
    val word4 = Word(
      listOf("U","E","S","D","A","Y"),
      VERTICAL,
      listOf(0),
    )
    
    val word5 = Word(
      listOf("N","I","T"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (5*level.boxWidth) + (10*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "PLANTA\nPAQUETE\nHORMIGA\nMARTES\nUNIDAD"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(5,5,2,6,3))
    
    return level
}

fun level19(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("H","","",""),
        arrayOf("","S","","O","","Y"),
        arrayOf("","",""),
        arrayOf("","",""),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("H","I","L","L"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("I","S","T","O","R","Y"),
      VERTICAL,
      listOf(1,3,5),
    )
    
    val word3 = Word(
      listOf("A","M","E"),
      HORIZONTAL,
      listOf(),
    )
    
    val word4 = Word(
      listOf("N","C","E"),
      HORIZONTAL,
      listOf(),
    )
    
    val word5 = Word(
      listOf("E","S"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (6*level.boxHeight) + (12*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "COLINA\nHISTORIA\nMISMA\nUNA VEZ\nSÍ"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,6,3,3,2))
    
    return level
}

fun level20(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("H","","T"),
        arrayOf("","","",""),
        arrayOf("R","","",""),
        arrayOf("","","","L",""),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("H","A","T"),
      HORIZONTAL,
      listOf(0,2),
    )
    
    val word2 = Word (
      listOf("E","A","R","T"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("R","U","C","K"),
      VERTICAL,
      listOf(0),
    )
    
    val word4 = Word(
      listOf("E","S","U","L","T"),
      HORIZONTAL,
      listOf(3),
    )
    
    val word5 = Word(
      listOf("O","W"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (6*level.boxWidth) + (12*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "SOMBRERO\nCORAZÓN\nCAMÍON\nRESULTADO\nBAJO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(3,4,4,5,2))
    
    return level
}

fun level21(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("A","","","D"),
        arrayOf("","","",""),
        arrayOf("","N","","E",""),
        arrayOf("","",""),
        arrayOf("","","",""),
      )
    }
    
    val word1 = Word(
      listOf("A","C","I","D"),
      HORIZONTAL,
      listOf(0,3),
    )
    
    val word2 = Word (
      listOf("G","A","I","N"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("A","N","G","E","R"),
      VERTICAL,
      listOf(1,3),
    )
    
    val word4 = Word(
      listOf("E","A","R"),
      HORIZONTAL,
      listOf(),
    )
    
    val word5 = Word(
      listOf("Q","U","A","L"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "ÁCIDO\nDE NUEVO\nPELIGRO\nCERCA\nIGUAL"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,4,5,3,4))
    
    return level
}

fun level22(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("S","",""),
        arrayOf("","L","","I","","R"),
        arrayOf("","",""),
        arrayOf("","",""),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("S","I","X"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("O","L","D","I","E","R"),
      VERTICAL,
      listOf(1,3,5),
    )
    
    val word3 = Word(
      listOf("A","S","T"),
      HORIZONTAL,
      listOf(),
    )
    
    val word4 = Word(
      listOf("R","O","N"),
      HORIZONTAL,
      listOf(),
    )
    
    val word5 = Word(
      listOf("A","W"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (level.boxPadding),
        (6*level.boxHeight) + (12*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "SEIS\nSOLDADO\nÚLTIMA\nHIERRO\nCRUDO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(3,6,3,3,2))
    
    return level
}

fun level23(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("T","","C","","",""),
        arrayOf("","",""),
        arrayOf("","L",""),
        arrayOf("","V","",""),
        arrayOf("","","",""),
      )
    }
    
    val word1 = Word(
      listOf("T","I","C","K","E","T"),
      HORIZONTAL,
      listOf(0,2),
    )
    
    val word2 = Word (
      listOf("H","E","Y"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("O","L","D"),
      VERTICAL,
      listOf(1),
    )
    
    val word4 = Word(
      listOf("E","V","E","L"),
      HORIZONTAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("O","I","C","E"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "BOLETO\nELLOS\nFRÍA\nNIVEL\nVOZ"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(6,3,3,4,4))
    
    return level
}

fun level24(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("E","","A","","","",""),
        arrayOf("","",""),
        arrayOf("","O","",""),
        arrayOf("","","","N"),
        arrayOf("","","",""),
      )
    }
    
    val word1 = Word(
      listOf("E","X","A","M","P","L","E"),
      HORIZONTAL,
      listOf(0,2),
    )
    
    val word2 = Word (
      listOf("A","S","T"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("B","O","U","T"),
      VERTICAL,
      listOf(1),
    )
    
    val word4 = Word(
      listOf("C","E","A","N"),
      HORIZONTAL,
      listOf(3),
    )
    
    val word5 = Word(
      listOf("I","G","H","T"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (6*level.boxWidth) + (12*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "EJEMPLO\nESTE\nACERCA DE\nOCÉANO\nNOCHE"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(7,3,4,4,4))
    
    return level
}

fun level25(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("S","",""),
        arrayOf("","","P",""),
        arrayOf("","","","E"),
        arrayOf("S",""),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("S","K","Y"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("H","A","P","E"),
      VERTICAL,
      listOf(2),
    )
    
    val word3 = Word(
      listOf("R","I","C","E"),
      HORIZONTAL,
      listOf(3),
    )
    
    val word4 = Word(
      listOf("S","H"),
      VERTICAL,
      listOf(0),
    )
    
    val word5 = Word(
      listOf("A","N","D"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (5*level.boxWidth) + (10*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "CIELO\nFORMA\nPRECIO\nELLA\nARENA"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(3,4,4,2,3))
    
    return level
}

fun level26(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("E","","S",""),
        arrayOf("","","","G",""),
        arrayOf("","",""),
        arrayOf("","A"),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("E","A","S","Y"),
      HORIZONTAL,
      listOf(0,2),
    )
    
    val word2 = Word (
      listOf("N","O","U","G","H"),
      VERTICAL,
      listOf(3),
    )
    
    val word3 = Word(
      listOf("O","L","D"),
      HORIZONTAL,
      listOf(),
    )
    
    val word4 = Word(
      listOf("E","A"),
      VERTICAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("I","R"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "FÁCIL\nSUFICIENTE\nORO\nMAR\nAIRE"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,5,3,2,2))
    
    return level
}

fun level27(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("D","","",""),
        arrayOf("","G"),
        arrayOf("","","","N"),
        arrayOf("","N",""),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("D","E","S","K"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("O","G"),
      VERTICAL,
      listOf(1),
    )
    
    val word3 = Word(
      listOf("R","E","E","N"),
      HORIZONTAL,
      listOf(3),
    )
    
    val word4 = Word(
      listOf("I","N","E"),
      VERTICAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("S","K","I"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "ESCRITORIO\nPERRO\nVERDE\nNUEVE\nPIEL"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,2,4,3,3))
    
    return level
}

fun level28(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("S","","","",""),
        arrayOf("","","P"),
        arrayOf("","G",""),
        arrayOf("","M",""),
        arrayOf("","","","",""),
      )
    }
    
    val word1 = Word(
      listOf("S","H","I","R","T"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("H","I","P"),
      VERTICAL,
      listOf(2),
    )
    
    val word3 = Word(
      listOf("A","G","E"),
      HORIZONTAL,
      listOf(1),
    )
    
    val word4 = Word(
      listOf("A","M","E"),
      VERTICAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("O","N","K","E","Y"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (5*level.boxHeight) + (10*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "CAMISA\nBARCO\nPÁGINA\nJUEGO\nMONO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(5,3,3,3,5))
    
    return level
}

fun level29(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("M","","","","","","",""),
        arrayOf("","S","","","",""),
        arrayOf("","","D"),
        arrayOf("","","","R",""),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("M","O","U","N","T","A","I","N"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("E","S","S","A","G","E"),
      VERTICAL,
      listOf(1),
    )
    
    val word3 = Word(
      listOf("E","E","D"),
      HORIZONTAL,
      listOf(2),
    )
    
    val word4 = Word(
      listOf("E","S","E","R","T"),
      VERTICAL,
      listOf(3),
    )
    
    val word5 = Word(
      listOf("O","A","D"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (6*level.boxHeight) + (12*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "MONTAÑA\nMENSAJE\nSEMILLA\nDESIERTO\nCAMINO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(8,6,3,5,3))
    
    return level
}

fun level30(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("","R","","",""),
        arrayOf("","C",""),
        arrayOf("","L","","R"),
        arrayOf("","",""),
        arrayOf("","","","",""),
      )
    }
    
    val word1 = Word(
      listOf("T","R","A","I","N"),
      VERTICAL,
      listOf(1),
    )
    
    val word2 = Word (
      listOf("A","C","E"),
      HORIZONTAL,
      listOf(1),
    )
    
    val word3 = Word(
      listOf("O","L","O","R"),
      VERTICAL,
      listOf(1,3),
    )
    
    val word4 = Word(
      listOf("I","S","T"),
      HORIZONTAL,
      listOf(),
    )
    
    val word5 = Word(
      listOf("E","F","U","N","D"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (5*level.boxHeight) + (10*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "TREN\nCARRERA\nCOLOR\nLISTA\nREEMBOLSO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(5,3,4,3,5))
    
    return level
}

fun level31(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("O","",""),
        arrayOf("","Y","","","N"),
        arrayOf("","","","G"),
        arrayOf("","",""),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("O","I","L"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("X","Y","G","E","N"),
      VERTICAL,
      listOf(1,4),
    )
    
    val word3 = Word(
      listOf("O","U","N","G"),
      HORIZONTAL,
      listOf(3),
    )
    
    val word4 = Word(
      listOf("A","M","E"),
      HORIZONTAL,
      listOf(),
    )
    
    val word5 = Word(
      listOf("T","A"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (5*level.boxHeight) + (10*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        0,
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "ACEITE\nOXÍGENO\nJOVEN\nNOMBRE\nETIQUETA"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(3,5,4,3,2))
    
    return level
}

fun level32(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("D","","","A",""),
        arrayOf("","","","","","",""),
        arrayOf("","","","","T"),
        arrayOf("","","E"),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("D","R","E","A","M"),
      HORIZONTAL,
      listOf(0,3),
    )
    
    val word2 = Word (
      listOf("I","S","C","O","U","N","T"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("M","O","U","N","T"),
      VERTICAL,
      listOf(4),
    )
    
    val word4 = Word(
      listOf("R","E","E"),
      HORIZONTAL,
      listOf(2),
    )
    
    val word5 = Word(
      listOf("V","O","T"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (5*level.boxHeight) + (10*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (6*level.boxWidth) + (12*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "SUEÑO\nDESCUENTO\nCANTIDAD\nÁRBOL\nVOTO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(5,7,5,3,3))
    
    return level
}

fun level33(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("L","","",""),
        arrayOf("","G","",""),
        arrayOf("","","S",""),
        arrayOf("","N"),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("L","E","F","T"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("I","G","H","T"),
      VERTICAL,
      listOf(1),
    )
    
    val word3 = Word(
      listOf("O","O","S","E"),
      HORIZONTAL,
      listOf(2),
    )
    
    val word4 = Word(
      listOf("U","N"),
      VERTICAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("E","W"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "IZQUIERDA\nLUZ\nGANSO\nSOL\nNUEVO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,4,4,2,2))
    
    return level
}

fun level34(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("M","","",""),
        arrayOf("","P"),
        arrayOf("","C","","","",""),
        arrayOf("","B","",""),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("M","O","O","N"),
      HORIZONTAL,
      listOf(0),
    )
    
    val word2 = Word (
      listOf("A","P"),
      VERTICAL,
      listOf(1),
    )
    
    val word3 = Word(
      listOf("I","C","T","U","R","E"),
      HORIZONTAL,
      listOf(1),
    )
    
    val word4 = Word(
      listOf("A","B","L","E"),
      VERTICAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("U","S"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "LUNA\nMAPA\nIMAGEN\nCABLE\nAUTOBÚS"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,2,6,4,2))
    
    return level
}

fun level35(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("P","","","","","O"),
        arrayOf("","R","","L",""),
        arrayOf("","",""),
        arrayOf("","",""),
        arrayOf("","","","",""),
      )
    }
    
    val word1 = Word(
      listOf("P","O","T","A","T","O"),
      HORIZONTAL,
      listOf(0,5),
    )
    
    val word2 = Word (
      listOf("U","R","P","L","E"),
      VERTICAL,
      listOf(1,3),
    )
    
    val word3 = Word(
      listOf("A","I","L"),
      HORIZONTAL,
      listOf(),
    )
    
    val word4 = Word(
      listOf("A","K","E"),
      HORIZONTAL,
      listOf(),
    )
    
    val word5 = Word(
      listOf("B","J","E","C","T"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (5*level.boxWidth) + (10*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "PATATA\nMORADO\nCARRIL\nLAGO\nOBJETO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(6,5,3,3,5))
    
    return level
}

fun level36(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("H","","R","",""),
        arrayOf("","","","","T","",""),
        arrayOf("","",""),
        arrayOf("","N",""),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("H","O","R","S","E"),
      HORIZONTAL,
      listOf(0,2),
    )
    
    val word2 = Word (
      listOf("O","S","P","I","T","A","L"),
      VERTICAL,
      listOf(4),
    )
    
    val word3 = Word(
      listOf("E","A","M"),
      HORIZONTAL,
      listOf(),
    )
    
    val word4 = Word(
      listOf("A","N","K"),
      VERTICAL,
      listOf(1),
    )
    
    val word5 = Word(
      listOf("E","X","T"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (5*level.boxHeight) + (10*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (2*level.boxHeight) + (4*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "CABALLO\nHOSPITAL\nEQUIPO\nRANGO\nPRÓXIMO"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(5,7,3,3,3))
    
    return level
}

fun level37(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("","L","","G"),
        arrayOf("","","","",""),
        arrayOf("","","D","","N"),
        arrayOf("","",""),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("F", "L", "A", "G"),
      HORIZONTAL,
      listOf(1,3),
    )
    
    val word2 = Word (
      listOf("A","D", "D", "E", "R"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("A","R","D","E","N"),
      VERTICAL,
      listOf(2,4),
    )
    
    val word4 = Word(
      listOf("E","E","R"),
      HORIZONTAL,
      listOf(),
    )
    
    val word5 = Word(
      listOf("O","S","E"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (4*level.boxWidth) + (8*level.boxPadding),
        (5*level.boxHeight) + (10*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "BANDERA\nESCALERA\nJARDÍN\nCIERVO\nNARIZ"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(4,5,5,3,3))
    
    return level
}

fun level38(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("","A","","A","","E"),
        arrayOf("",""),
        arrayOf("","",""),
        arrayOf("","","","","E"),
        arrayOf("",""),
      )
    }
    
    val word1 = Word(
      listOf("G","A","R","A","G","E"),
      VERTICAL,
      listOf(1,3,5),
    )
    
    val word2 = Word (
      listOf("R","T"),
      HORIZONTAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("R","E","A"),
      HORIZONTAL,
      listOf(),
    )
    
    val word4 = Word(
      listOf("N","G","I","N","E"),
      HORIZONTAL,
      listOf(4),
    )
    
    val word5 = Word(
      listOf("A","G"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        (level.boxWidth) + (2 * level.boxPadding),
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (level.boxWidth) + (2*level.boxPadding),
        (5*level.boxHeight) + (10*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (5*level.boxWidth) + (10*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "COCHERA\nARTE\nÁREA\nMOTOR\nEDAD"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(6,2,3,5,2))
    
    return level
}

fun level39(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("D","","N","","","R"),
        arrayOf("",""),
        arrayOf("",""),
        arrayOf("","","","","T"),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("D","I","N","N","E","R"),
      HORIZONTAL,
      listOf(0,2,5),
    )
    
    val word2 = Word (
      listOf("R","Y"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("O","W"),
      VERTICAL,
      listOf(),
    )
    
    val word4 = Word(
      listOf("O","C","K","E","T"),
      VERTICAL,
      listOf(4),
    )
    
    val word5 = Word(
      listOf("S","O","F"),
      HORIZONTAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (5*level.boxWidth) + (10*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (5*level.boxHeight) + (10*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "CENA\nSECO\nAHORA\nCOHETE\nSUAVE"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(6,2,2,5,3))
    
    return level
}

fun level40(viewModel: AppCompatActivity): Level {
    val level: Level = ViewModelProvider(viewModel).get(Level::class.java)
    level.activity = viewModel
    
    if (level.wordLetters.getValue() == null){
      level.wordLetters.value = listOf(
        arrayOf("W","","N","","",""),
        arrayOf("","",""),
        arrayOf("","","B","",""),
        arrayOf("","","W",""),
        arrayOf("","",""),
      )
    }
    
    val word1 = Word(
      listOf("W","I","N","D","O","W"),
      HORIZONTAL,
      listOf(0,2),
    )
    
    val word2 = Word (
      listOf("O","O","D"),
      VERTICAL,
      listOf(),
    )
    
    val word3 = Word(
      listOf("U","M","B","E","R"),
      VERTICAL,
      listOf(2),
    )
    
    val word4 = Word(
      listOf("R","O","W","N"),
      HORIZONTAL,
      listOf(2),
    )
    
    val word5 = Word(
      listOf("I","N","G"),
      VERTICAL,
      listOf(),
    )
    
    level.paddings = listOf(
      listOf(0,0,0,0),
      listOf(
        0,
        (level.boxHeight) + (2 * level.boxPadding),
        0,
        0,
      ),
      listOf(
        (2*level.boxWidth) + (4*level.boxPadding),
        (level.boxHeight) + (2*level.boxPadding),
        0,
        0,
      ),
      
      listOf(
        (3*level.boxWidth) + (6*level.boxPadding),
        (3*level.boxHeight) + (6*level.boxPadding),
        0,
        0,
      ),
      listOf(
        (5*level.boxWidth) + (10*level.boxPadding),
        (4*level.boxHeight) + (8*level.boxPadding),
        0,
        0,   
      )
    )
    
    level.wordsToBeFind = "VENTANA\nMADERA\nNÚMERO\nMARRÓN\nALA"
    
    level.words = listOf(word1, word2, word3,word4, word5)
    
    level.makeLevel()
    
    level.initWordsColors(listOf(6,3,5,4,3))
    
    return level
}

// define colors of letter boxes (of words) first time
fun Level.initWordsColors(sizes: List<Int>) {
  if (letterBackgrounds.getValue() == null) {
    letterBackgrounds.value = List(5) {
      index ->
        Array(sizes[index]) {
          index2 ->
            initColors(words[index], index2)
        }
    }
  }
}
