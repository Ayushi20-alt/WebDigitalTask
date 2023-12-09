package com.example.webdigitaltask.domain.usecase

data class NewsUseCases(
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectedArticle : SelectArticle
)