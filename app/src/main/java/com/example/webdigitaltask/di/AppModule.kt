package com.example.webdigitaltask.di

import android.app.Application
import androidx.room.Room
import com.example.webdigitaltask.data.local.CarDao
import com.example.webdigitaltask.data.local.CarDatabase
import com.example.webdigitaltask.data.remote.CarApi
import com.example.webdigitaltask.data.repository.CarRepositoryImp
import com.example.webdigitaltask.domain.repository.CarRepository
import com.example.webdigitaltask.domain.usecase.DeleteArticle
import com.example.webdigitaltask.util.Constants.BASE_URL
import com.example.webdigitaltask.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.example.webdigitaltask.domain.usecase.NewsUseCases
import com.example.webdigitaltask.domain.usecase.UpsertArticle

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun ProvidesCarApi() : CarApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // to convert json to kotlin object
            .build()
            .create(CarApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCarDao(carDatabase: CarDatabase) : CarDao = carDatabase.carDao()

    @Provides
    @Singleton
    fun proviesCarRepository(
        carApi : CarApi,
        carDao : CarDao
    ): CarRepository = CarRepositoryImp(carApi,carDao)

    @Provides
    @Singleton
    fun provideNewsDatabase(application: Application): CarDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = CarDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

//    @Provides
//    @Singleton
//    fun providesNewsDao(carDatabase: CarDatabase) : CarDao = carDatabase.carDao()

//    @Provides
//    @Singleton
//    fun provideNewsUseCases(
//        newsRepository: CarRepository) : NewsUseCases{
//        return NewsUseCases(
//            upsertArticle = UpsertArticle(newsRepository),
//            deleteArticle = DeleteArticle(newsRepository)
//        )
//    }
}