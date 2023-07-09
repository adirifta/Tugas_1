package com.example.tugas_1

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var etNama: EditText
    private lateinit var etEmail: EditText
    private lateinit var etJurusan: EditText
    private lateinit var etSemester: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etNama = findViewById(R.id.etNama)
        etEmail = findViewById(R.id.etEmail)
        etJurusan = findViewById(R.id.etJurusan)
        etSemester = findViewById(R.id.etSemester)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val jurusan = etJurusan.text.toString().trim()
            val semester = etSemester.text.toString().trim()

            // Pengecekan apakah semua form sudah terisi
            if (nama.isEmpty() || email.isEmpty() || jurusan.isEmpty() || semester.isEmpty()) {
                Toast.makeText(this, "Mohon isi semua form", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi input email menggunakan Patterns.EMAIL_ADDRESS
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Format email tidak valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Data valid, lakukan proses selanjutnya
            // Misalnya, tampilkan data pengguna
            showData(nama, email, jurusan, semester)
        }
    }

    private fun showData(nama: String, email: String, jurusan: String, semester: String) {
        Toast.makeText(this, "Nama: $nama\nEmail: $email\nJurusan: $jurusan\nSemester: $semester", Toast.LENGTH_LONG).show()
    }
}