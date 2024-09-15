import android.content.Intent
import android.os.Bundle
import android.util.Log  // Asegúrate de importar Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp_main.R
import com.example.heroesapp_main.activities.HeroDetailActivity
import com.example.heroesapp_main.adapters.HeroAdapter
import com.example.heroesapp_main.models.Hero

class HeroesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        val heroesRecyclerView = findViewById<RecyclerView>(R.id.heroes_recycler_view)
        heroesRecyclerView.layoutManager = LinearLayoutManager(this) // Disposición vertical

        // Cargar héroes
        val publisherId = intent.getIntExtra("publisherId", -1)
        val heroes = getHeroesForPublisher(publisherId)

        Log.d("HeroesActivity", "Publisher ID: $publisherId")
        Log.d("HeroesActivity", "Lista de héroes: ${heroes.size}")

        val adapter = HeroAdapter(heroes) { hero ->
            // Código para navegar a los detalles del héroe
        }
        heroesRecyclerView.adapter = adapter
    }

    private fun getHeroesForPublisher(publisherId: Int): List<Hero> {
        return if (publisherId == 1) {
            listOf(
                Hero(1, "Spider-Man", "Friendly neighborhood superhero", "https://preview.redd.it/2f97an638ty71.png?auto=webp&s=86daa412084340c70f70ef49a0ad06487a7fc49a", 1),
                Hero(2, "Iron Man", "Genius billionaire", "https://i.pinimg.com/originals/e2/7f/e5/e27fe5b06bc777a7832b9b9e8e5ce291.png", 1),
                Hero(3, "Doctor Strange", "Master of mystic arts", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/9195e7d5-496f-494a-bfc1-e07485fd706c/df5v1mw-b8486811-51a8-42dc-a195-3eefdd228533.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzkxOTVlN2Q1LTQ5NmYtNDk0YS1iZmMxLWUwNzQ4NWZkNzA2Y1wvZGY1djFtdy1iODQ4NjgxMS01MWE4LTQyZGMtYTE5NS0zZWVmZGQyMjg1MzMucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.tl0jARgjItVhx-FKZ7AjPjHp81NTaG5kr4yAhTfI9Bc", 1),
                Hero(4, "Thor", "God of Thunder", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/3a1b02a9-0ca7-4130-810e-c6db42004a20/d8knlef-e3e3c238-6ccb-417e-9466-065c48d396fd.png/v1/fill/w_600,h_950/thor_from_marvel_s_the_avengers_aou_png_render_by_joaohbd_d8knlef-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9OTUwIiwicGF0aCI6IlwvZlwvM2ExYjAyYTktMGNhNy00MTMwLTgxMGUtYzZkYjQyMDA0YTIwXC9kOGtubGVmLWUzZTNjMjM4LTZjY2ItNDE3ZS05NDY2LTA2NWM0OGQzOTZmZC5wbmciLCJ3aWR0aCI6Ijw9NjAwIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.WA8mz52i9q29mGwUmyTr4VH1p05_AGo8eWjwOMkqgTs", 1),
                Hero(5, "Captain America", "Super soldier", "https://i.pinimg.com/originals/ba/51/8d/ba518d47ab84170b087b6a64ae87703a.png", 1),


            )
        } else {
            listOf(
                Hero(6, "Batman", "Dark Knight", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEifyUt4Yhu1SunIbOyjArSjuWvghsDsmq_IMiM8d5BaKYa1iiz5EVOiWkeCC69hq95qZtDu8uUk5ve7eqo2Edk07DE9bmc0mWsgLRdWYLnAiBeov0hjaa26FDpCx66OCYILW2CBXCIXEmuE8muFi-WTSOtDjrgu8UyIpjfAUmfmF7d_2Zv8XpTGGYxPePI/s1600/Batman-PNG-Descarga-gratis%20%2822%29.png", 2),
                Hero(7, "Detective Marciano", "Martian warrior", "https://static.wikia.nocookie.net/vsbattles/images/5/5b/Martian_Manhunter_%28New_52%29_1.png/revision/latest?cb=20210902183734", 2),
                Hero(8, "Flash", "Fastest man alive", "https://pngfre.com/wp-content/uploads/the-flash-42-240x300.png", 2),
                Hero(9, "Mujer Maravilla", "Amazonian warrior", "https://static.wikia.nocookie.net/death-battle-fanon-wiki-en-espanol/images/9/96/Mujer_Maravilla.png/revision/latest/thumbnail/width/360/height/360?cb=20190323022056&path-prefix=es", 2),
                Hero(10, "Victor Stone", "Cyborg", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/f551ed82-19db-4ec0-a41f-8134ef2bebd2/dfypg8f-46a1c86d-d590-48f8-8ef9-7e7994220148.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2Y1NTFlZDgyLTE5ZGItNGVjMC1hNDFmLTgxMzRlZjJiZWJkMlwvZGZ5cGc4Zi00NmExYzg2ZC1kNTkwLTQ4ZjgtOGVmOS03ZTc5OTQyMjAxNDgucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.4BeO0GBj2mFj5DKxJ4KGYJnRQr-oCbUPO6JZDd6UwlE", 2)
            )
        }
    }
}