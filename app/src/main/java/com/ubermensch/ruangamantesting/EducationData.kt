package com.ubermensch.ruangamantesting

data class EducationArticle(
    val title: String,
    val shortDesc: String,
    val content: String,
    val author: String,
    val date: String
)

object EducationData {
    fun getArticles(): List<EducationArticle> = listOf(
        EducationArticle(
            title = "Apa itu Bullying?",
            shortDesc = "Bullying adalah perilaku agresif yang dilakukan secara berulang terhadap seseorang yang lebih lemah.",
            content = "Bullying adalah perilaku agresif yang disengaja dan dilakukan secara berulang-ulang terhadap seseorang yang dianggap lebih lemah. Bullying dapat terjadi dalam berbagai bentuk, termasuk fisik (memukul, menendang), verbal (mengejek, mengancam), sosial (mengucilkan, menyebarkan gosip), dan cyberbullying (melalui media sosial atau pesan digital).\n\nDampak bullying sangat serius bagi korban, antara lain:\n• Gangguan kesehatan mental seperti depresi dan kecemasan\n• Penurunan prestasi akademik\n• Kehilangan rasa percaya diri\n• Pada kasus ekstrem, dapat berujung pada pikiran untuk menyakiti diri sendiri\n\nPenting untuk mengenali tanda-tanda seseorang yang menjadi korban bullying dan segera mencari bantuan.",
            author = "Tim RuangAman",
            date = "14 April 2026"
        ),
        EducationArticle(
            title = "Cara Melaporkan Bullying",
            shortDesc = "Langkah-langkah yang bisa kamu lakukan jika mengalami atau menyaksikan tindakan bullying.",
            content = "Melaporkan bullying adalah langkah penting yang harus dilakukan. Banyak korban yang takut atau malu untuk melapor, padahal pelaporan adalah kunci untuk menghentikan siklus bullying.\n\nLangkah-langkah melaporkan bullying:\n1. Dokumentasikan kejadian – catat waktu, tempat, dan pelaku\n2. Ceritakan kepada orang yang dipercaya – guru, orang tua, atau konselor\n3. Gunakan aplikasi RuangAman untuk melaporkan secara resmi\n4. Jangan balas dengan kekerasan\n5. Minta dukungan dari teman-teman\n\nIngat: Melaporkan bukan berarti lemah. Itu adalah tindakan pemberani!",
            author = "Tim RuangAman",
            date = "12 April 2026"
        ),
        EducationArticle(
            title = "Cyberbullying di Era Digital",
            shortDesc = "Kenali bentuk-bentuk cyberbullying dan cara melindungi diri di dunia maya.",
            content = "Cyberbullying adalah bullying yang dilakukan melalui perangkat digital seperti ponsel, tablet, dan komputer. Ini bisa terjadi di media sosial, platform game, dan pesan teks.\n\nBentuk-bentuk cyberbullying:\n• Mengirim pesan kasar atau mengancam\n• Menyebarkan foto atau video memalukan tanpa izin\n• Membuat akun palsu untuk mempermalukan seseorang\n• Mengucilkan seseorang dari grup online\n• Menyebarkan rumor atau informasi palsu\n\nCara melindungi diri:\n• Jangan bagikan informasi pribadi secara online\n• Blokir dan laporkan pelaku\n• Simpan bukti (screenshot) sebelum menghapus pesan\n• Ceritakan kepada orang tua atau guru\n• Gunakan pengaturan privasi di media sosial",
            author = "Tim RuangAman",
            date = "10 April 2026"
        ),
        EducationArticle(
            title = "Peran Saksi dalam Menghentikan Bullying",
            shortDesc = "Kamu bisa menjadi pahlawan dengan berdiri di pihak yang benar saat menyaksikan bullying.",
            content = "Saksi (bystander) memiliki peran yang sangat penting dalam menghentikan bullying. Penelitian menunjukkan bahwa bullying sering berhenti dalam hitungan detik ketika saksi ikut turun tangan.\n\nApa yang bisa dilakukan saksi:\n• Jangan ikut-ikutan menertawakan atau mendukung pelaku\n• Tunjukkan empati kepada korban – hibur dan temani mereka\n• Laporkan kejadian kepada guru atau orang dewasa yang dipercaya\n• Ajak teman lain untuk bersama-sama mendukung korban\n• Jika aman, tegur pelaku secara langsung\n\nMenjadi saksi yang berani bukan berarti harus mengambil risiko. Pilih tindakan yang aman namun tetap mendukung korban.",
            author = "Tim RuangAman",
            date = "8 April 2026"
        ),
        EducationArticle(
            title = "Dampak Bullying terhadap Kesehatan Mental",
            shortDesc = "Bullying bukan hanya menyakitkan secara fisik – dampak mentalnya bisa jauh lebih dalam.",
            content = "Dampak bullying terhadap kesehatan mental korban bisa berlangsung sangat lama, bahkan hingga dewasa jika tidak ditangani dengan tepat.\n\nDampak psikologis yang umum terjadi:\n• Depresi dan perasaan sedih yang berkepanjangan\n• Kecemasan dan rasa takut berlebihan, terutama di lingkungan sekolah\n• Harga diri yang rendah dan kurang percaya diri\n• Sulit berkonsentrasi dan penurunan nilai akademik\n• Menarik diri dari pergaulan sosial\n• Pada kasus serius: pikiran menyakiti diri sendiri\n\nJika kamu atau temanmu mengalami dampak ini, segera cari bantuan profesional. Jangan ragu untuk berbicara dengan konselor sekolah atau psikolog.",
            author = "Tim RuangAman",
            date = "6 April 2026"
        )
    )
}
