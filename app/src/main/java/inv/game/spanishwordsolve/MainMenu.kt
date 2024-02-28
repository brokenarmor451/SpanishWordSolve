package inv.game.spanishwordsolve

import android.os.Bundle
import android.content.Intent
import android.app.Activity
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.ViewGroup.LayoutParams as VLayoutParams
import android.graphics.Color
import android.util.TypedValue

import androidx.core.content.res.ResourcesCompat
import androidx.gridlayout.widget.GridLayout
import androidx.gridlayout.widget.GridLayout.LayoutParams
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams as LLayoutParams
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.app.AppCompatActivity

import inv.game.spanishwordsolve.data.LevelScreen
import inv.game.spanishwordsolve.data.Solveds
import inv.game.spanishwordsolve.data.selectedLevel
import inv.game.spanishwordsolve.data.Level
import inv.game.spanishwordsolve.data.About

class MainMenu: AppCompatActivity() {

  lateinit var levelsButtons: List<AppCompatTextView>
  lateinit var aboutButton: AppCompatButton
  lateinit var gridOfLevelsButtons: GridLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
    val myFont = ResourcesCompat.getFont(this, R.font.ubuntumonobold)!!
    
    val completedLevelBackground = GradientDrawable().apply {
      setColor(Level.green)
      setCornerRadius((Level.screenWidth / 45).toFloat())
    }
    
    val uncompletedLevelBackground = GradientDrawable().apply {
        setColor(Color.argb(0xFF,0x0a,0x6e,0xbd))
        setCornerRadius((Level.screenWidth / 45).toFloat())
    }
    
    val helpText = AppCompatTextView(this).apply {
      val lp = LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.MATCH_PARENT,
      ).apply {
        weight = 2f
      }
      setText("Objective is typing listed Spanish words letter by letter as English. All levels are unlocked. When you complete a level its corresponding button will be green color.")
      setBackgroundColor(Level.yellow)
      setTextColor(Level.darkGreen)
      setTypeface(myFont)
      setLayoutParams(lp)
      setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
    }
    
    aboutButton = AppCompatButton(this).apply {
      val lp = LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.MATCH_PARENT,
      ).apply {
        weight = 2f
      }
      setText("ABOUT")
      setTypeface(myFont)
      setBackgroundColor(Level.darkBlue)
      setTextColor(Level.silver)
      setLayoutParams(lp)
      setOnClickListener {
        startActivity(Intent(getApplicationContext(), About::class.java))
      }
    }
    
    val solvedList = Solveds(this).solvedListAsString
    
    val mainScreen = LinearLayoutCompat(this).apply {
      val lp = VLayoutParams(
        VLayoutParams.MATCH_PARENT,
        VLayoutParams.MATCH_PARENT,
      )
      setOrientation(LinearLayoutCompat.VERTICAL)
      setLayoutParams(lp)
    }
    val gridLayoutParams = LLayoutParams(
      LLayoutParams.MATCH_PARENT, 
      LLayoutParams.MATCH_PARENT,
    ).apply {
      weight = 1f
      gravity = Gravity.CENTER
    }
    
    gridOfLevelsButtons = GridLayout(this).apply {
      setColumnCount(5)
      setRowCount(8)
      setLayoutParams(gridLayoutParams)
    }
    
    levelsButtons = List(40) {
      AppCompatTextView(this).apply {
        gravity = Gravity.CENTER
      }
    }
    
    levelsButtons.forEachIndexed {
      index, button ->
        val lp = LayoutParams(
          GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL,1f),
          GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL,1f),
        ).apply {
          val margin = Level.screenWidth / 90
          setMargins(margin,margin,margin,margin)
        }
        
        button.setLayoutParams(lp)
        button.setText((index + 1).toString())
        button.setTextColor(Level.silver)
        if (solvedList.get(index) == 'Y') {
          button.setBackground(completedLevelBackground)
        } else {
          button.setBackground(uncompletedLevelBackground)
        }
        
        button.setOnClickListener {
          selectedLevel = index
          val intent = Intent(getApplicationContext(), LevelScreen::class.java)
          startActivity(intent)
          finish()
        }
        gridOfLevelsButtons.addView(button)
    }
    mainScreen.addView(gridOfLevelsButtons)
    mainScreen.addView(aboutButton)
    mainScreen.addView(helpText)
    setContentView(mainScreen)
  }
}