# PPB-5-Calculator
 

# Dokumentasi Kalkulator Sederhana

## MainActivity.kt
File utama yang berisi logika kalkulator

### Bagian Deklarasi:
```kotlin
// Deklarasi komponen UI
private lateinit var etNumber1: EditText
private lateinit var etNumber2: EditText
private lateinit var tvResult: TextView
private lateinit var btnAdd: Button
private lateinit var btnSubtract: Button
private lateinit var btnMultiply: Button
private lateinit var btnDivide: Button
```
- `etNumber1` dan `etNumber2`: Input angka
- `tvResult`: Menampilkan hasil
- `btnAdd`, `btnSubtract`, `btnMultiply`, `btnDivide`: Tombol operasi

### Fungsi onCreate():
```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main) // Set layout XML
    
    // Hubungkan variabel dengan komponen di layout
    etNumber1 = findViewById(R.id.etNumber1)
    etNumber2 = findViewById(R.id.etNumber2)
    tvResult = findViewById(R.id.tvResult)
    btnAdd = findViewById(R.id.btnAdd)
    btnSubtract = findViewById(R.id.btnSubtract)
    btnMultiply = findViewById(R.id.btnMultiply)
    btnDivide = findViewById(R.id.btnDivide)
    
    // Set listener untuk tombol
    btnAdd.setOnClickListener { calculate('+') }
    btnSubtract.setOnClickListener { calculate('-') }
    btnMultiply.setOnClickListener { calculate('*') }
    btnDivide.setOnClickListener { calculate('/') }
}
```
- `setContentView()`: Menentukan layout yang digunakan
- `findViewById()`: Menghubungkan variabel dengan komponen UI di XML
- `setOnClickListener`: Menentukan aksi saat tombol diklik

### Fungsi calculate():
```kotlin
private fun calculate(op: Char) {
    // Ambil nilai dari input
    val num1 = etNumber1.text.toString().toDoubleOrNull()
    val num2 = etNumber2.text.toString().toDoubleOrNull()
    
    // Validasi input
    if (num1 == null || num2 == null) {
        Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
        return
    }
    
    // Lakukan perhitungan
    val result = when (op) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '*' -> num1 * num2
        '/' -> if (num2 != 0.0) num1 / num2 else "Tidak bisa dibagi 0"
        else -> "Error"
    }
    
    // Tampilkan hasil
    tvResult.text = "Hasil: $result"
}
```
- `toDoubleOrNull()`: Konversi input ke angka (null jika invalid)
- `when`: Operator untuk memilih operasi matematika
- Penanganan kasus pembagian dengan 0
- `Toast`: Notifikasi popup untuk input tidak valid
- `tvResult.text`: Menampilkan hasil perhitungan



## Cara Kerja Aplikasi
1. User memasukkan angka di kedua input
2. Memilih operasi dengan menekan tombol:
   - `+` untuk penjumlahan
   - `-` untuk pengurangan
   - `×` untuk perkalian
   - `÷` untuk pembagian
3. Sistem akan:
   - Validasi input
   - Lakukan perhitungan
   - Tampilkan hasil
4. Jika input tidak valid, muncul pesan error

