package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var blankFragment: BlankFragment
    private lateinit var blankFragment2: BlankFragment2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
      /**  val blankFragment = BlankFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
//  .addToBackStack(blankFragment.toString()) -> Stekga qoshadi ya'niy orqaga qaytganda MainActivitiga qaytadi
            .add(R.id.my_root, blankFragment)
            .commit()
*/
        blankFragment = BlankFragment()
        blankFragment2 = BlankFragment2()
        var fragmentManager = supportFragmentManager

        binding.apply {
            add.setOnClickListener {
                fragmentManager.beginTransaction()
                    .add(R.id.my_root,blankFragment)
                    .commit()
            }
            remove.setOnClickListener {
                fragmentManager.beginTransaction()
                    .remove(blankFragment)
                    .commit()
            }
            replace.setOnClickListener {
                fragmentManager.beginTransaction()
                    .replace(R.id.my_root,blankFragment2)
                    .addToBackStack(blankFragment2.toString())
                    .commit()
            }
            hide.setOnClickListener {
                fragmentManager.beginTransaction()
                    .hide(blankFragment)
                    .commit()
            }
            show.setOnClickListener {
                fragmentManager.beginTransaction()
                    .show(blankFragment)
                    .commit()
            }
        }
    }
}