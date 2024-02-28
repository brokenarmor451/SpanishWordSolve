package inv.game.spanishwordsolve.data

import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams as LLayoutParams
import androidx.gridlayout.widget.GridLayout
import androidx.gridlayout.widget.GridLayout.HORIZONTAL
import androidx.gridlayout.widget.GridLayout.VERTICAL
import androidx.gridlayout.widget.GridLayout.LayoutParams as GLayoutParams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.LifecycleOwner
import androidx.core.content.res.ResourcesCompat

import android.view.ViewTreeObserver
import android.content.res.Resources
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.content.DialogInterface
import android.widget.Space
import android.widget.FrameLayout
import android.widget.FrameLayout.LayoutParams as FLayoutParams
import android.util.TypedValue
import android.app.Activity
import android.view.View
import android.app.Dialog
import android.view.ViewGroup.LayoutParams as VLayoutParams

import inv.game.spanishwordsolve.MainMenu
import inv.game.spanishwordsolve.R


import android.util.Log

class Level: ViewModel() {
  companion object {
    val silver = Color.argb(0xff, 0xf3, 0xf3, 0xf3)
    val darkBlue = Color.argb(0xff, 0x38, 0x41, 0x9d)
    val pastelBlue = Color.argb(0xff,0x92, 0xcc, 0xdd)
    val darkGreen = Color.argb(0xFF,0x60,0x72,0x74)
    val yellow = Color.argb(0xFF,0xDE,0xD0,0xB6)
    val green = Color.argb(0xFF,0x5F,0x86,0x70)
    val red = Color.parseColor("#FFD04848")

    val darkBlueBackground = GradientDrawable().apply{
        setColor(
          darkBlue,
        )
        setCornerRadius((screenWidth / 45).toFloat())
      }
  
    var screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels
    var screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels
    
    fun sizeAsRatio(ratios: Array<Int>, isWidth: Boolean): Int {
      when (ratios.size) {
      1 ->  return if (isWidth) screenWidth / ratios[0] else screenHeight / ratios[0]
      2 ->  return if(isWidth) screenWidth / ratios[0] / ratios[1] else screenHeight / ratios[0] / ratios[1]
      3 -> return if(isWidth) screenWidth / ratios[0] / ratios[1] / ratios[2] else screenHeight / ratios[0] / ratios[1] / ratios[2]
      }
    
      return 0
    }
  }
  
  val boxWidth = sizeAsRatio(arrayOf(10),true)
  val boxHeight = sizeAsRatio(arrayOf(2,10), false)
  val boxPadding = sizeAsRatio(arrayOf(2,10,9), true)
  val noAnswerBackground = Color.argb(0xFF,0x0A,0x6E,0xBD)
  var isDialogShowing = MutableLiveData(false)
  var letterBackgrounds: MutableLiveData<List<Array<Int>>> = MutableLiveData()
  var wordLetters: MutableLiveData<List<Array<String>>> = MutableLiveData()
  val onSelectedX = MutableLiveData(-1000f)
  val onSelectedY = MutableLiveData(-1000f)
  var wordsToBeFind = ""
  var selectedWordIndex = -1
  var selectedBox = -1
  val onSelectedDrawable = GradientDrawable().apply {
    setColor(Color.argb(0xFF, 0X00, 0X00, 0X00))
    setCornerRadius((screenWidth / 45).toFloat())
    setAlpha(125)
  }
  
  lateinit var myFont: Typeface
  lateinit var topArea: FrameLayout
  lateinit var bottomArea: LinearLayoutCompat
  lateinit var exitButtonWordsTableAndCurrentLevelLayout: LinearLayoutCompat
  lateinit var wordsToBeFindTextView: AppCompatTextView
  lateinit var currentLevelIndicator: AppCompatTextView
  lateinit var exitButton: AppCompatButton
  lateinit var exitConfirmationDialog: Dialog
  lateinit var alphabetButtonsLayouts: List<LinearLayoutCompat>
  lateinit var onSelectedPointer: View
  lateinit var activity: Context
  lateinit var mainLayout: LinearLayoutCompat
  var words: List<Word> = listOf()
  var paddings: List<List<Int>> = listOf()
  
  fun makeFont() {
    myFont = ResourcesCompat.getFont(activity, R.font.ubuntumonobold)!!
  }
  
  fun makeExitButton() {
    val lp = LLayoutParams(
      LLayoutParams.MATCH_PARENT,
      LLayoutParams.WRAP_CONTENT,
    ).apply {
      weight = 1f
      gravity = Gravity.BOTTOM
    }
    exitButton = AppCompatButton(activity).apply {
      setText("EXIT")
      setId(View.generateViewId())
      setOnClickListener {
        isDialogShowing.value = true
      }
      setBackground(darkBlueBackground)
      setTextColor(silver)
      setLayoutParams(lp)
    }
  }
  
  fun makeDialog() {
    val ll = LinearLayoutCompat(activity).also {
    /*  val lp = LLayoutParams(LLayoutParams.WRAP_CONTENT, LLayoutParams.WRAP_CONTENT)
      lp.weight = 1.0f
      it.setLayoutParams(lp)*/
    }
    val ll2 = LinearLayoutCompat(activity).also {
      it.setOrientation(LinearLayoutCompat.VERTICAL)
    }
    val confirmButton = AppCompatButton(activity).apply {
      val lp = LLayoutParams(LLayoutParams.WRAP_CONTENT, LLayoutParams.WRAP_CONTENT)
      lp.weight = 1.0f
      setLayoutParams(lp)
      setText("Ok")
      setTextColor(silver)
      setTypeface(myFont)
      setBackground(darkBlueBackground)
      
      setOnClickListener {
        val intent = Intent(activity.getApplicationContext(), MainMenu::class.java)
          activity.startActivity(intent)
          val getActivity = activity as Activity
          getActivity.finish()
      }
    }
    val cancelButton = AppCompatButton(activity).apply {
      val lp = LLayoutParams(LLayoutParams.WRAP_CONTENT, LLayoutParams.WRAP_CONTENT)
      lp.weight = 1.0f
      setLayoutParams(lp)
      setText("Cancel")
      setTextColor(silver)
      setTypeface(myFont)
      setBackground(darkBlueBackground)
    }
    
    val message = AppCompatTextView(activity).apply {
      setText("All progress will be lost, do you want to exit to the main menu ?")
      setTextColor(darkGreen)
      setTypeface(myFont)
      val lp = LLayoutParams(LLayoutParams.WRAP_CONTENT, LLayoutParams.WRAP_CONTENT)
      lp.setMargins(0,0,0,20f.toDp(activity))
      setLayoutParams(lp)
    }
    
    val space = makeSpace(
      LLayoutParams(LLayoutParams.WRAP_CONTENT, LLayoutParams.WRAP_CONTENT).apply {
        weight = 2f
      }
    )
    
    ll.addView(confirmButton)
    ll.addView(space)
    ll.addView(cancelButton)
    ll2.addView(message)
    ll2.addView(ll)
  
    exitConfirmationDialog = Dialog(activity).apply {
      window?.setBackgroundDrawable(
        GradientDrawable().apply{
          setColor(yellow)
          setCornerRadius((screenWidth / 45).toFloat())
        }
      )
      
      setOnDismissListener(
        object: DialogInterface.OnDismissListener {
          override fun onDismiss(dialog: DialogInterface) {
            isDialogShowing.value = false
          }
        }
      )
      setContentView(ll2)
    }
    
    // show dialog depending value of  the isDialogShowing
    isDialogShowing.observe(activity as LifecycleOwner, Observer {
      if (it) {
        exitConfirmationDialog.show()
      }
    })
    
    cancelButton.setOnClickListener {
      isDialogShowing.value = false
      exitConfirmationDialog.dismiss()
    }
    
  }

  fun makeSpace(lp: VLayoutParams): Space {
    return Space(activity).apply {
      setLayoutParams(lp)
    }
  }
  
  fun changeBoxColors(color: Int) {
    letterBackgrounds.value!![selectedWordIndex].forEachIndexed {
          index2, _ ->
      // dont change hint boxes' color
      // they are already colored
      if (!(index2 in words[selectedWordIndex].cantClickableIndices)) {
        letterBackgrounds.value!![selectedWordIndex][index2] = color
      }
    }
  }
  
  fun checkAnswer() {
    if (!("" in wordLetters.value!![selectedWordIndex])) {
      if (wordLetters.value!![selectedWordIndex].toList() == words[selectedWordIndex].correctWord) {
      
          changeBoxColors(green)
          
          // disappear onSelectedPointer
          moveOnSelectedPointer(-1000f, -1000f)
        
          // dont make alphabet buttons change boxes text
          selectedWordIndex = -1
          selectedBox = -1
          
        } else {
          changeBoxColors(red)
        }
        
        // trigger observer
        letterBackgrounds.value = letterBackgrounds.value
        
      }
      
      val collectLetters: MutableList<String> = mutableListOf()
      
      // collect chars to check if all boxes inputted
      for (word in wordLetters.value!!) {
        for (c in word) {
          collectLetters.add(c)
        }
      }
      
      if (!("" in collectLetters)) {
        val collectColors: MutableList<Int> = mutableListOf()
        for (lb in letterBackgrounds.value!!) {
          for (color in lb) {
            collectColors.add(color)
          }
        }
        
        // if all words are correct, change
        // its corresponding main menu box to
        // green color
        if (!(noAnswerBackground in collectColors) and !(red in collectColors)) {
          val solveds = Solveds(activity)
          if (
            !(solveds.solvedListAsString.get(selectedLevel) == 'Y')
          ){
            solveds.writeToSolveds(selectedLevel)
          }
        }
      }
  }
  
  fun initOnSelectedPointer() {
    onSelectedPointer = View(activity).apply {
      setBackground(onSelectedDrawable)
      val lp = VLayoutParams(boxWidth, boxHeight)
      setLayoutParams(lp)
    }
    topArea.addView(onSelectedPointer)
    
    onSelectedX.observe(activity as LifecycleOwner, Observer {
      onSelectedPointer.setX(it)
    })
    onSelectedY.observe(activity as LifecycleOwner, Observer {
      onSelectedPointer.setY(it)
    })
  }
  
  fun moveOnSelectedPointer(x: Float, y: Float) {
    onSelectedX.value = x
    onSelectedY.value = y
  }
  
  fun changeIndicesAndMoveOnSelectedPointer(wordIndex: Int, boxIndex: Int, x: Float, y: Float) {
    selectedWordIndex = wordIndex
    selectedBox = boxIndex
    moveOnSelectedPointer(x, y)
  }
  
  fun constructWords() {
    topArea = FrameLayout(activity).apply {
      val lp = LLayoutParams(LLayoutParams.MATCH_PARENT, (screenHeight / 2).toInt())
      setLayoutParams(lp)
    }
    mainLayout.addView(topArea)
    words.forEachIndexed {
      index, word ->
        val wordAsGrid = GridLayout(activity).apply {
          val lp = FLayoutParams(
            FLayoutParams.WRAP_CONTENT,
            FLayoutParams.WRAP_CONTENT
          )

          setId(View.generateViewId())
          setOrientation(word.orientation)
          setLayoutParams(lp)
          setPadding(
            paddings[index][0],
            paddings[index][1],
            paddings[index][2],
            paddings[index][3],
          )
        }
        
        topArea.addView(wordAsGrid)
      
        word.letterBoxes = List(wordLetters.value!![index].size){
          index2 ->
          AppCompatTextView(activity).apply {
            val lp = GLayoutParams()
            lp.width = boxWidth
            lp.height = boxHeight
            lp.setMargins(boxPadding,boxPadding,boxPadding,boxPadding)
            
            setLayoutParams(lp)
            setGravity(Gravity.CENTER)
            setTextColor(silver)
            if (!(index2 in word.cantClickableIndices)) {
              //it.setClickable(true)
              setOnClickListener {
                  // change box index and word index and move onSelectedPointer box to over selected letter box
              changeIndicesAndMoveOnSelectedPointer(index, index2, it.getX(), it.getY())
              }
            }
          }
       }
       
       for (box in word.letterBoxes) {
         wordAsGrid.addView(box)
       }
    }
    
    wordLetters.observe(activity as LifecycleOwner, Observer {
        it.forEachIndexed {
          index, texts ->
            texts.forEachIndexed {
              index2, text ->
                words[index].letterBoxes[index2].text = text
            }
        }
      }
    )
    
    letterBackgrounds.observe(activity as LifecycleOwner, Observer {
      it.forEachIndexed {
        index, colors ->
          colors.forEachIndexed {
            index2, color ->
            val gradient = GradientDrawable().apply {
              setCornerRadius((screenWidth / 45).toFloat())
              setColor(color)
            }
            words[index].letterBoxes[index2].setBackground(gradient)
            // make unclickable that green backgrounded boxes
            if (color == green) {
              words[index].letterBoxes[index2].setClickable(false)
            }
          }
      }
    })
  }
  
  fun setupAlphabetButtonsGrid() {

    alphabetButtonsLayouts = List(3) {
      _ -> LinearLayoutCompat(activity).apply {
        val lp = LLayoutParams(
          LLayoutParams.MATCH_PARENT,
          LLayoutParams.MATCH_PARENT,
        ). apply {
          weight = 1f
        }

        setLayoutParams(lp)
      }
    }
  }
  
  fun makeAlphabetButtons() {
    val letters = listOf(
        "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
        "A", "S", "D", "F", "G", "H", "J", "K", "L",
        "Z", "X", "C", "V", "B", "N", "M",
    )

    val alphabetButtons = List(26) {
      index ->  AppCompatTextView(activity).apply {
          val lp = LLayoutParams(
            LLayoutParams.MATCH_PARENT,
            LLayoutParams.MATCH_PARENT,
          ).apply {
            weight = 1f
            val margin =  screenWidth / 360
            setMargins(margin,margin,margin,margin)
          }
          setLayoutParams(lp)
          setGravity(Gravity.CENTER)
          setText(letters[index])
          setTextColor(silver)
          setBackgroundColor(darkBlue)
      }

    }

    val buttonXs = Array(26) {_ -> 0f}

    alphabetButtons.forEachIndexed {
      index, button ->
        button.getViewTreeObserver().addOnGlobalLayoutListener(
          object:ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
              buttonXs[index] = button.getX()
              button.getViewTreeObserver().removeOnGlobalLayoutListener(this)
            }
          }
        )

        button.setOnClickListener {
          SpringAnimation(button, DynamicAnimation.X,buttonXs[index]).setStartVelocity(5000f).start()

          if (
            (selectedBox != -1)
            and
            (selectedWordIndex != -1)
          ){
            wordLetters.value!![selectedWordIndex][selectedBox] = button.text.toString()
            wordLetters.value = wordLetters.value
            checkAnswer()
          }
        }
    }

    setupAlphabetButtonsGrid()

    // make alphabet buttons as qwerty keyboard
    alphabetButtonsLayouts.forEachIndexed {
      index, layout ->
        when(index) {
          1 -> {
            for(i in 10..18) {

              if(i == 10) {
                addSpaceToAlphabetLayout(layout)
              }

              layout.addView(alphabetButtons[i])

              if(i == 18) {
                addSpaceToAlphabetLayout(layout)
              }

            }
          }

          2 -> {
           for(i in 19..25) {

              if(i == 19) {
                addSpaceToAlphabetLayout(layout)
                addSpaceToAlphabetLayout(layout)
              }

              layout.addView(alphabetButtons[i])

              if(i == 25) {
                addSpaceToAlphabetLayout(layout)
                addSpaceToAlphabetLayout(layout)
              }

            }
          }

          else -> {
            for(i in 0..9) {
              layout.addView(alphabetButtons[i])
            }
          }
        }
    }

  }

  fun addSpaceToAlphabetLayout(layout: LinearLayoutCompat) {
    layout.addView(
      makeSpace(
        LLayoutParams(
          LLayoutParams.MATCH_PARENT,
          LLayoutParams.MATCH_PARENT,
        ).apply {
          weight = 1f
        }
      )
    )
  }
  
  fun initWordsToBeFind() {
    wordsToBeFindTextView = AppCompatTextView(activity).apply {
      val lp = LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.WRAP_CONTENT,
      ).apply {
        weight = 1f
        gravity = Gravity.BOTTOM
      }
      setLayoutParams(lp)
      setId(View.generateViewId())
      setText(wordsToBeFind)
      setTypeface(myFont)
      setTextColor(darkGreen)
      setGravity(Gravity.CENTER)
      setBackground(
        GradientDrawable().apply{
          setColor(yellow)
          setCornerRadius((screenWidth / 45).toFloat())
        }
      )
    }
  }
  
  fun makeCurrentLevelIndicator() {
    currentLevelIndicator = AppCompatTextView(activity).apply {
      val lp = LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.WRAP_CONTENT,
      ).apply {
        weight = 1f
        gravity = Gravity.BOTTOM
      }
      setLayoutParams(lp)
      setText("Current Level\n ${selectedLevel + 1}")
      setTextColor(darkGreen)
      setGravity(Gravity.CENTER)
      setTypeface(myFont)
      setBackground(
        GradientDrawable().apply{
          setColor(yellow)
          setCornerRadius((screenWidth / 45).toFloat())
        }
      )
    }
  }
  
  fun makeBottomArea() {
    
    val space = makeSpace(
      LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.WRAP_CONTENT,
      ).apply {
        weight = 5f
      }
    )

    exitButtonWordsTableAndCurrentLevelLayout = LinearLayoutCompat(activity).apply {
      val lp = LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.MATCH_PARENT,
      ).apply {
        weight = 1f
      }
      setLayoutParams(lp)
      addView(exitButton)
      addView(wordsToBeFindTextView)
      addView(currentLevelIndicator)
    }
    bottomArea = LinearLayoutCompat(activity).apply {
      val lp = LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.MATCH_PARENT,
      ).apply {
        weight = 1f
      }
      setLayoutParams(lp)
      setOrientation(LinearLayoutCompat.VERTICAL)
      for (alphabetButtonsLayout in alphabetButtonsLayouts) {
        addView(alphabetButtonsLayout)
      }
      addView(exitButtonWordsTableAndCurrentLevelLayout)
    }
    mainLayout.addView(bottomArea)
  }
  
  // if index equals cantclickable one return green else return blue
  fun initColors(word: Word, index: Int): Int {
    if (index in word.cantClickableIndices) {
      return green
    } else {
      return noAnswerBackground
    }
  }
  
  fun makeLevel() {
    
    mainLayout = LinearLayoutCompat(activity).apply{
        setOrientation(LinearLayoutCompat.VERTICAL)
        setBackgroundColor(pastelBlue)
    }
    makeFont()
    constructWords()
    initOnSelectedPointer()
    makeAlphabetButtons()
    initWordsToBeFind()
    makeDialog()
    makeExitButton()
    makeCurrentLevelIndicator()
    makeBottomArea()
  }
}

fun Float.toDp(activity: Context): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, activity.resources.displayMetrics).toInt()
