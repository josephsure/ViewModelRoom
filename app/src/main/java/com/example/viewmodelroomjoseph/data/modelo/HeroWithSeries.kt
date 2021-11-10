package com.example.viewmodelroomjoseph.data.modelo

import androidx.room.Embedded
import androidx.room.Relation

data class HeroWithSeries(
    @Embedded val hero: HeroEntity,
    @Relation(
        parentColumn = "heroId",
        entityColumn = "heroSereieId"
    )
    val series: List<SerieEntity>?
)
