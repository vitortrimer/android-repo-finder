package trimer.vitor.githubrepofinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import trimer.vitor.githubrepofinder.api.SearchResult
import trimer.vitor.githubrepofinder.api.createGithubApiService
import trimer.vitor.githubrepofinder.models.Repo
import trimer.vitor.githubrepofinder.repostlist.ReposAdapter
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ReposAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ReposAdapter {repo ->
            Toast.makeText(this, repo.name, Toast.LENGTH_SHORT).show()
        }

        val list: RecyclerView = findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        val service = createGithubApiService()
        service.searchRepositories("android").enqueue(object : Callback<SearchResult> {
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                val repos = response.body()?.items.orEmpty()
                adapter.submitList(repos)
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                //Handle failure
            }

        })

    }
}