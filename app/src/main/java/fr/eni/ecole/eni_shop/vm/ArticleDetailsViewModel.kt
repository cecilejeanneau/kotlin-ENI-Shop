package fr.eni.ecole.eni_shop.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.repository.ArticleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticleDetailsViewModel(
    private val articleRepository: ArticleRepository
) : ViewModel() {

    private val _article = MutableStateFlow<Article>(Article());
    val article : StateFlow<Article>
        get() = _article;

    fun initArticle(id: Long) {
//        layer presentation, one thread for views, avoid to be kill/block = coroutine to load values for views in background
        val currentArticle = articleRepository.getArticle(id);
        if (currentArticle != null) {
//            useless by constructor auto init
            _article.value = currentArticle;
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return ArticleDetailsViewModel(
                    ArticleRepository(),
                ) as T
            }
        }
    }
}