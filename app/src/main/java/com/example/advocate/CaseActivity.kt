package com.example.advocate

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CaseActivity : AppCompatActivity() {
    lateinit var adapter: CaseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case)
        findViewById<Button>(R.id.btnADD).setOnClickListener {
            showAddCaseDialog()
        }


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCase)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CaseAdapter(getCase())
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

    }

    private fun showAddCaseDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Додати пару")

        val view = layoutInflater.inflate(R.layout.dialog_case, null)
        builder.setView(view)

        val CaseName = view.findViewById<EditText>(R.id.tvCaseName)
        val ShortDesc = view.findViewById<EditText>(R.id.tvSubject)


        builder.setPositiveButton("Додати") { dialog, _ ->
            val CaseName = CaseName.text.toString()
            val ShortDesc = ShortDesc.text.toString()

            if (CaseName.isNotEmpty() && ShortDesc.isNotEmpty()) {
                val newCase = Case(CaseName, ShortDesc)
                adapter.addItem(newCase)
            } else {
                Toast.makeText(this, "Будь ласка, заповніть всі поля", Toast.LENGTH_SHORT).show()
            }
            dialog.dismiss()
        }


        builder.setNegativeButton("Відмінити") { dialog, _ ->
            dialog.dismiss()
        }

        builder.create().show()
    }

    private fun getCase(): MutableList<Case> {
        return mutableListOf(
            Case("Справа про крадіжку в супермаркеті", "Клієнт був зловлений на камеру прихованого спостереження, як він крав товари з полиць."),
            Case("Справа про шахрайство з кредитними картками", "Клієнт використовував вкрадені кредитні картки для здійснення покупок на великі суми грошей."),
            Case("Справа про пограбування на вулиці", "Клієнт став жертвою пограбування, коли невідомі особи підійшли до нього на вулиці та забрали гроші та цінності."),
            Case("Справа про побиття в нічному клубі", "Клієнт був побитий іншими гостями нічного клубу під час конфлікту."),
            Case("Справа про шахрайство через Інтернет", "Клієнт був обманутий через Інтернет під час спроби придбати товари, які ніколи не були доставлені."),
            Case("Справа про пограбування автомобіля", "Клієнт повідомив про те, що його автомобіль був пограбований з парковки."),
            Case("Справа про побиття на вулиці", "Клієнт став жертвою фізичного нападу на вулиці."),
            Case("Справа про шахрайство з нерухомістю", "Клієнт був обманутий під час угоди з купівлі-продажу нерухомості."),
            Case("Справа про крадіжку з будинку", "Клієнт повідомив про крадіжку з його будинку, під час його відсутності."),
            Case("Справа про побиття в школі", "Клієнт був побитий іншими учнями в школі.")
        )
    }
}
