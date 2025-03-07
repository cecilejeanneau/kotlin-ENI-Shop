package fr.eni.ecole.eni_shop.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.repository.ArticleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ArticleListViewModel(
    private val _articleRepository: ArticleRepository
) : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList());
    //  var articles: StateFlow<List<Article>> = _articles.asStateFlow();
    val articles: StateFlow<List<Article>>
        get() = _articles


    init {
        _articles.value = _articleRepository.getAllArticles();
    }

    val categories: List<String> = listOf(
        "Electronics",
        "Jewelery",
        "Men's clothing",
        "Women's clothing"
    )
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

                return ArticleListViewModel(
//                    instance of ArticleRepository
                    ArticleRepository(),
                ) as T
            }
        }
    }
}