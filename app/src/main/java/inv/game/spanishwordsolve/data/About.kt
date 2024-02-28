package inv.game.spanishwordsolve.data

import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

import inv.game.spanishwordsolve.R

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import android.widget.ScrollView
import android.view.Gravity
import android.content.Context
import android.content.DialogInterface
import android.app.Dialog
import android.view.ViewGroup.LayoutParams as VLayoutParams

import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams as LLayoutParams
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider

class About: AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
    val licenseDialog = ViewModelProvider(this).get(LicenseDialog::class.java)
    
    licenseDialog.myContext = this
    
    licenseDialog.makeDialog()
    
    val mainLayout = LinearLayoutCompat(this).apply {
      setOrientation(LinearLayoutCompat.VERTICAL)
      setBackgroundColor(Level.pastelBlue)
    }
    
    val space = Space(this).apply {
      val lp = LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.WRAP_CONTENT,
      ).apply {
        weight = 1f
      }
      setLayoutParams(lp)
    }
    
    val space2 = Space(this).apply {
      val lp = LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.WRAP_CONTENT,
      ).apply {
        weight = 1f
      }
      setLayoutParams(lp)
    }
    
    val backButton = AppCompatButton(this).apply {
      val lp = LLayoutParams(
        LLayoutParams.WRAP_CONTENT,
        LLayoutParams.WRAP_CONTENT,
      ).apply {
        gravity = Gravity.CENTER
      }
      setOnClickListener {
        onBackPressedDispatcher.onBackPressed()
      }
      setLayoutParams(lp)
      setBackgroundResource(R.drawable.arrow_back_24px)
    }
    val version = AppCompatTextView(this).apply {
      val lp = LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.WRAP_CONTENT,
      )
      
      setLayoutParams(lp)
      setText("Version: ${getString(R.string.version)}")
    }
    
    val licensesButton = AppCompatButton(this).apply {
      val lp = LLayoutParams(
        LLayoutParams.WRAP_CONTENT,
        LLayoutParams.WRAP_CONTENT,
      ).apply {
        gravity = Gravity.CENTER
      }
      
      setLayoutParams(lp)
      setTextColor(Level.silver)
      setBackgroundColor(Level.darkBlue)
      setText("LICENSES")
      
      setOnClickListener {
      
        startActivity(Intent(getApplicationContext(), OssLicensesMenuActivity::class.java))
      }
    }
    
    mainLayout.addView(backButton)
    mainLayout.addView(space)
    mainLayout.addView(licensesButton)
    mainLayout.addView(licenseDialog.showFontLicenseButton)
    mainLayout.addView(space2)
    mainLayout.addView(version)
    
    setContentView(mainLayout)
  }
}

class LicenseDialog: ViewModel() {
  lateinit var myContext: Context
  lateinit var licenseDialog: Dialog
  lateinit var showFontLicenseButton: AppCompatButton
  lateinit var licenseText: AppCompatTextView
  lateinit var backButton: AppCompatButton
  lateinit var mainLayout: LinearLayoutCompat
  val isDialogShowing = MutableLiveData(false)

  private fun makeBackButton() {
    backButton = AppCompatButton(myContext).apply {
      val lp = LLayoutParams(
        LLayoutParams.MATCH_PARENT,
        LLayoutParams.WRAP_CONTENT,
      ).apply {
        gravity = Gravity.CENTER
        weight = 1f
      }

      setLayoutParams(lp)
      setTextColor(Level.silver)
      setBackgroundColor(Level.darkBlue)
      setText("BACK")
      //setBackgroundResource(R.drawable.arrow_back_24px)
      setOnClickListener {
        isDialogShowing.value = false
        licenseDialog.dismiss()
      }
    }
  }

  private fun makeMainLayout() {
    makeLicenseText()
    makeBackButton()
    mainLayout = LinearLayoutCompat(myContext).apply {
      val lp = VLayoutParams(
        VLayoutParams.MATCH_PARENT,
        VLayoutParams.WRAP_CONTENT,
      )

      setOrientation(LinearLayoutCompat.VERTICAL)
      setLayoutParams(lp)
      val scrollView = ScrollView(myContext).apply {
        val lp = LLayoutParams(
          LLayoutParams.MATCH_PARENT,
          LLayoutParams.WRAP_CONTENT,
        ).apply {
          weight = 2f
        }

        setLayoutParams(lp)

        addView(licenseText)
      }

      addView(scrollView)
      addView(backButton)


    }
  }

  private fun makeLicenseText() {
    licenseText = AppCompatTextView(myContext).apply{
      setText(
        ubuntufontlicence
      )
    }
  }
  
  private fun declareObserverOfIsDialogShowing() {
    isDialogShowing.observe(myContext as LifecycleOwner, Observer {
      if (it) {
        licenseDialog.show()
      }
    })
  }
  
  private fun makeShowDialogButton() {
    showFontLicenseButton = AppCompatButton(myContext).apply {
      val lp = LLayoutParams(
        LLayoutParams.WRAP_CONTENT,
        LLayoutParams.WRAP_CONTENT,
      ).apply {
        gravity = Gravity.CENTER
        val margin = Level.screenWidth / 45
        setMargins(margin,margin,margin,margin)
      }
      setLayoutParams(lp)
      setTextColor(Level.silver)
      setBackgroundColor(Level.darkBlue)
      setText("SHOW FONT LICENSE")
      setOnClickListener{
        isDialogShowing.value = true
      }
    }
  }
  
  fun makeDialog() {
    makeMainLayout()
    declareObserverOfIsDialogShowing()
    makeShowDialogButton()
    licenseDialog = Dialog(myContext).apply {

      setContentView(mainLayout)
        
      setOnDismissListener {
        _ ->
          isDialogShowing.value = false
      }
    }
  }
}

val ubuntufontlicence = """
Copyright 2010,2011 Canonical Ltd.

This Font Software is licensed under the Ubuntu Font Licence, Version
1.0.  https://launchpad.net/ubuntu-font-licence

-------------------------------
UBUNTU FONT LICENCE Version 1.0
-------------------------------

PREAMBLE
This licence allows the licensed fonts to be used, studied, modified and
redistributed freely. The fonts, including any derivative works, can be
bundled, embedded, and redistributed provided the terms of this licence
are met. The fonts and derivatives, however, cannot be released under
any other licence. The requirement for fonts to remain under this
licence does not require any document created using the fonts or their
derivatives to be published under this licence, as long as the primary
purpose of the document is not to be a vehicle for the distribution of
the fonts.

DEFINITIONS
"Font Software" refers to the set of files released by the Copyright
Holder(s) under this licence and clearly marked as such. This may
include source files, build scripts and documentation.

"Original Version" refers to the collection of Font Software components
as received under this licence.

"Modified Version" refers to any derivative made by adding to, deleting,
or substituting -- in part or in whole -- any of the components of the
Original Version, by changing formats or by porting the Font Software to
a new environment.

"Copyright Holder(s)" refers to all individuals and companies who have a
copyright ownership of the Font Software.

"Substantially Changed" refers to Modified Versions which can be easily
identified as dissimilar to the Font Software by users of the Font
Software comparing the Original Version with the Modified Version.

To "Propagate" a work means to do anything with it that, without
permission, would make you directly or secondarily liable for
infringement under applicable copyright law, except executing it on a
computer or modifying a private copy. Propagation includes copying,
distribution (with or without modification and with or without charging
a redistribution fee), making available to the public, and in some
countries other activities as well.

PERMISSION & CONDITIONS
This licence does not grant any rights under trademark law and all such
rights are reserved.

Permission is hereby granted, free of charge, to any person obtaining a
copy of the Font Software, to propagate the Font Software, subject to
the below conditions:

1) Each copy of the Font Software must contain the above copyright
notice and this licence. These can be included either as stand-alone
text files, human-readable headers or in the appropriate machine-
readable metadata fields within text or binary files as long as those
fields can be easily viewed by the user.

2) The font name complies with the following:
(a) The Original Version must retain its name, unmodified.
(b) Modified Versions which are Substantially Changed must be renamed to
avoid use of the name of the Original Version or similar names entirely.
(c) Modified Versions which are not Substantially Changed must be
renamed to both (i) retain the name of the Original Version and (ii) add
additional naming elements to distinguish the Modified Version from the
Original Version. The name of such Modified Versions must be the name of
the Original Version, with "derivative X" where X represents the name of
the new work, appended to that name.

3) The name(s) of the Copyright Holder(s) and any contributor to the
Font Software shall not be used to promote, endorse or advertise any
Modified Version, except (i) as required by this licence, (ii) to
acknowledge the contribution(s) of the Copyright Holder(s) or (iii) with
their explicit written permission.

4) The Font Software, modified or unmodified, in part or in whole, must
be distributed entirely under this licence, and must not be distributed
under any other licence. The requirement for fonts to remain under this
licence does not affect any document created using the Font Software,
except any version of the Font Software extracted from a document
created using the Font Software may only be distributed under this
licence.

TERMINATION
This licence becomes null and void if any of the above conditions are
not met.

DISCLAIMER
THE FONT SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO ANY WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT OF
COPYRIGHT, PATENT, TRADEMARK, OR OTHER RIGHT. IN NO EVENT SHALL THE
COPYRIGHT HOLDER BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
INCLUDING ANY GENERAL, SPECIAL, INDIRECT, INCIDENTAL, OR CONSEQUENTIAL
DAMAGES, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF THE USE OR INABILITY TO USE THE FONT SOFTWARE OR FROM OTHER
DEALINGS IN THE FONT SOFTWARE.
"""
