package trimer.vitor.githubrepofinder.api

import trimer.vitor.githubrepofinder.models.Repo

data class SearchResult(
    val items: List<Repo>
)