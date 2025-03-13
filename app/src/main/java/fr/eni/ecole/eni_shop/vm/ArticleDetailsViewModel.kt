package fr.eni.ecole.eni_shop.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.dao.DaoType
import fr.eni.ecole.eni_shop.repository.ArticleRepository
import fr.eni.ecole.eni_shop.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleDetailsViewModel(
    private val articleRepository: ArticleRepository,
) : ViewModel() {

    private val _article = MutableStateFlow<Article>(Article());
    val article: StateFlow<Article>
        get() = _article;

    private val _checked: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)
    val checked: StateFlow<Boolean>
        get() = _checked;

    fun initArticle(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val article = articleRepository.getArticle(id, DaoType.ROOM);
            if (article != null) _checked.value = true;
        }
//        layer presentation, one thread for views, avoid to be kill/block = coroutine to load values for views in background
        val currentArticle = articleRepository.getArticle(id);
//        val currentArticle = _articleDao.findById(id);
        if (currentArticle != null) {
//            useless by constructor auto init
            _article.value = currentArticle;
        }
    }

    fun updateCheck(checked: Boolean): Unit {
        viewModelScope.launch(Dispatchers.IO) {
            if (!checked) {
                deleteArticle(article.value);
            } else {
                addArticle(article.value);
            }
        }
        _checked.value = checked;
    }

    private fun addArticle(article: Article) {
        articleRepository.addArticle(article, DaoType.ROOM);
    }

    private fun deleteArticle(article: Article) {
        articleRepository.deleteArticle(article, DaoType.ROOM);
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY]);
                return ArticleDetailsViewModel(
                    ArticleRepository(
                        AppDatabase.getInstance(application.applicationContext).articleDAO()
                    ),
                ) as T
            }
        }
    }
}