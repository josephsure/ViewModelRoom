package com.example.viewmodelroomjoseph.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.viewmodelroomjoseph.data.modelo.ComicEntity
import com.example.viewmodelroomjoseph.data.modelo.HeroEntity
import com.example.viewmodelroomjoseph.data.modelo.SerieEntity

@Database(entities = [HeroEntity::class,ComicEntity::class,SerieEntity::class],version = 13,exportSchema = true)
@TypeConverters(Converters::class)
abstract class HeroRoomDatabase: RoomDatabase(){
    abstract fun heroDao() : HeroDao

    companion object {
        @Volatile
        private var INSTANCE : HeroRoomDatabase? = null

        fun getDatabase(context: Context): HeroRoomDatabase {
            return INSTANCE?: synchronized(this){
                val instace = Room.databaseBuilder(
                    context.applicationContext,
                    HeroRoomDatabase::class.java,
                    "item_database"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instace
                instace
            }
        }
    }

}