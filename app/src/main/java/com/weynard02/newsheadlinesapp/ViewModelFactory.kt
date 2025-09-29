package com.weynard02.newsheadlinesapp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weynard02.newsheadlinesapp.data.Injection
import com.weynard02.newsheadlinesapp.data.NewsRepository
import com.weynard02.newsheadlinesapp.ui.NewsViewModel
import kotlin.jvm.java

class ViewModelFactory(
    private val repository: NewsRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(repository) as T // Assuming MainViewModel also needs UserPreference or just repository
        }
        else throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)

    }
    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    // Get UserPreference from Injection and pass it to ViewModelFactory constructor
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }


}