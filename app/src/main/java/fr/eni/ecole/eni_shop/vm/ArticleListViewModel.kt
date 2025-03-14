package fr.eni.ecole.eni_shop.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.dao.ArticleServiceAPI
import fr.eni.ecole.eni_shop.repository.ArticleRepository
import fr.eni.ecole.eni_shop.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleListViewModel(
    private val _articleRepository: ArticleRepository
) : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList());

    //  var articles: StateFlow<List<Article>> = _articles.asStateFlow();
    val articles: StateFlow<List<Article>>
        get() = _articles


    private val _categories = MutableStateFlow<List<String>>(emptyList());

    //  var articles: StateFlow<List<Article>> = _articles.asStateFlow();
    val categories: StateFlow<List<String>>
        get() = _categories


    var isLoading = MutableStateFlow(true);

    init {
// old code       _articles.value = _articleRepository.getAllArticles();

//        access to network so In and Outs = IO
        viewModelScope.launch(Dispatchers.IO) {
//            val a = async { _articles.value = _articleRepository.getAllArticles(); }
            _articles.value = _articleRepository.getAllArticles();
//            val c = async { _categories.value = _articleRepository.getCategories(); }
            _categories.value = _articleRepository.getCategories();

//            awaitAll(a, c);

            isLoading.value = false;
        }
    }

//    old code
//    val categories: List<String> = listOf(
//        "Electronics",
//        "Jewelery",
//        "Men's clothing",
//        "Women's clothing"
//    )
//    private val _categories = MutableStateFlow<List<String>>(emptyList());
//    val categories: StateFlow<List<String>>
//        get() = _categories


    // Define ViewModel factory in a companion object
    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras -> application context, where's the DB for example
//                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
//                val savedStateHandle = extras.createSavedStateHandle()

                val application = checkNotNull(extras[APPLICATION_KEY]);
                return ArticleListViewModel(
//                    instance of ArticleRepository
//                    singleton instance of articleDAO from AppDatabase -> Room
                    ArticleRepository(
                        AppDatabase.getInstance(application.applicationContext).articleDAO(),
                        ArticleServiceAPI.ArticleAPI.retrofitService
                    ),
                ) as T
            }
        }
    }
}