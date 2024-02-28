package inv.game.spanishwordsolve.data

import androidx.appcompat.app.AppCompatActivity

import android.widget.Toast

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.OnBackPressedCallback
//import androidx.activity.addCallback

import java.lang.Runnable

class LevelScreen: AppCompatActivity(){
  private var doubleBackToExitPressedOnce = false
  lateinit private var level: Level
  lateinit private var exitConfirmationToast: Toast
  override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)

    exitConfirmationToast = Toast.makeText(this, "Please click BACK again to exit.", Toast.LENGTH_SHORT)

    when (selectedLevel) {
      0 -> level = level1(this)
      1 -> level = level2(this)
      2 -> level = level3(this)
      3 -> level = level4(this)
      4 -> level = level5(this)
      5 -> level = level6(this)
      6 -> level = level7(this)
      7 -> level = level8(this)
      8 -> level = level9(this)
      9 -> level = level10(this)
      10 -> level = level11(this)
      11 -> level = level12(this)
      12 -> level = level13(this)
      13 -> level = level14(this)
      14 -> level = level15(this)
      15 -> level = level16(this)
      16 -> level = level17(this)
      17 -> level = level18(this)
      18 -> level = level19(this)
      19 -> level = level20(this)
      20 -> level = level21(this)
      21 -> level = level22(this)
      22 -> level = level23(this)
      23 -> level = level24(this)
      24 -> level = level25(this)
      25 -> level = level26(this)
      26 -> level = level27(this)
      27 -> level = level28(this)
      28 -> level = level29(this)
      29 -> level = level30(this)
      30 -> level = level31(this)
      31 -> level = level32(this)
      32 -> level = level33(this)
      33 -> level = level34(this)
      34 -> level = level35(this)
      35 -> level = level36(this)
      36 -> level = level37(this)
      37 -> level = level38(this)
      38 -> level = level39(this)
      39 -> level = level40(this)
      
    }
    
    setContentView(level.mainLayout)
    
    
    onBackPressedDispatcher.addCallback(
      this, 
      object : OnBackPressedCallback(true) {
      override fun handleOnBackPressed() {
        exit()
      }
    })
  }
  
  fun exit() {
    if (doubleBackToExitPressedOnce) {
      exitConfirmationToast.cancel()
      finish()
      return
    }
    
    doubleBackToExitPressedOnce = true
    exitConfirmationToast.show()
    
    Handler(Looper.getMainLooper()).postDelayed(Runnable {doubleBackToExitPressedOnce = false}, 2000)
  }
}
