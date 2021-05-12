package trimer.vitor.githubrepofinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import trimer.vitor.githubrepofinder.models.Repo
import trimer.vitor.githubrepofinder.repostlist.ReposAdapter

class MainActivity : AppCompatActivity() {

    private val adapter = ReposAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: RecyclerView = findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        val sampleData = listOf(
            Repo("Repo 1"),
            Repo("Repo 2"),
            Repo("Repo 3"),
            Repo("Repo 4"),
            Repo("Repo 5"),
            Repo("Repo 6"),
            Repo("Repo312412412"),
        )

        adapter.submitList(sampleData)
    }
}