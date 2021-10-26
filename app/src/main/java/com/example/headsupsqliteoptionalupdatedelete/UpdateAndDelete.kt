
package com.example.headsupsqliteoptionalupdatedelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.headsupsqliteoptionalupdatedelete.databinding.ActivityUpdateAndDeleteBinding
import java.lang.Exception

class UpdateAndDelete : AppCompatActivity() {
    lateinit var binding: ActivityUpdateAndDeleteBinding
    lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUpdateAndDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateList()

        binding.btnDelete.setOnClickListener {
            try {
                val id = binding.edIDDelete.text.toString().toInt()
                dbHelper.delete(id)
                updateList()
            }catch (e:Exception){
                Toast.makeText(applicationContext, "please enter number in id", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnUpdate.setOnClickListener {
           try {
               val id=binding.edIDUpdate.text.toString().toInt()
               val name=binding.edNameUpdate.text.toString()
               val t1=binding.edTaboo1Update.text.toString()
               val t2=binding.edTaboo2Update.text.toString()
               val t3=binding.edTaboo3Update.text.toString()
               dbHelper.update(id,name,t1,t2,t3)
               updateList()

           }catch (e:Exception){
               Toast.makeText(applicationContext, "please enter number in id", Toast.LENGTH_SHORT).show()
           }

        }

    }
    fun updateList(){
        dbHelper=DBHelper(applicationContext)
       val info=dbHelper.getData()

        var text=""
        for (i in info){
            text+="\nid: ${i.id}\nname: ${i.name}\ntaboo1: ${i.taboo1}\n taboo2: ${i.taboo2}\ntaboo3: ${i.taboo3}\n----------"
        }
        binding.textView.setText(text)

    }
}