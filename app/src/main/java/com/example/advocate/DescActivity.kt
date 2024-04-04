package com.example.advocate

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desc)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewDesc)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = DescAdapter(getDesc()) { desc ->
            showDetailDialog(desc)
        }
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            onBackPressed()
        }
    }

    private fun showDetailDialog(desc: Desc) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Детальна інформація")

        val view = layoutInflater.inflate(R.layout.dialog_desc, null)
        builder.setView(view)

        val tvDescName = view.findViewById<TextView>(R.id.tvDescName)
        val tvShortDesc = view.findViewById<TextView>(R.id.tvShortDesc)

        tvDescName.text = desc.name
        tvShortDesc.text = desc.shortDesc

        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }

        builder.create().show()
    }

    private fun getDesc(): MutableList<Desc> {
        return mutableListOf(
            Desc("John Jones", "Сталася проблема з відсутністю платежів за оренду магазину, що може призвести до виписки з оренди."),
            Desc("Jane Doe", "Клієнт став жертвою шахрайства через Інтернет під час покупки товарів у великих кількостях."),
            Desc("Michael Johnson", "Проблеми з погашенням кредитів та відсутність можливості відновити платежі за ними."),
            Desc("Alice Smith", "Потерпіла від крадіжки особистих даних, що призвело до фінансових втрат."),
            Desc("Robert Brown", "Зіткнувся зі складнощами у вирішенні спору з сусідом щодо меж земельної ділянки."),
            Desc("Emily Wilson", "Стала жертвою шахрайства з використанням крадених банківських карток."),
            Desc("David Taylor", "Має проблеми з відшкодуванням збитків від автомобільної аварії через відсутність страховки."),
            Desc("Sarah Anderson", "Потребує правової допомоги у вирішенні сімейних конфліктів та розлученні."),
            Desc("Daniel Martinez", "Став жертвою домашнього насильства та потребує захисту від насильницького партнера."),
            Desc("Olivia Garcia", "Має проблеми зі стягненням боргів від клієнтів після надання послуг.")
        )
    }
}