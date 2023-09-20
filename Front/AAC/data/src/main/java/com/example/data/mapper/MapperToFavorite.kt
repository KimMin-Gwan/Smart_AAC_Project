package com.example.data.mapper

import com.example.data.source.remote.local.FavoriteEntity
import com.example.domain.model.favorite

fun MapperToFavorite(favoriteEntity: List<FavoriteEntity>) : List<favorite> {
    return favoriteEntity.map {
        favorite(
            id = it.id,
            sentence = it.sentence
        )
    }
}