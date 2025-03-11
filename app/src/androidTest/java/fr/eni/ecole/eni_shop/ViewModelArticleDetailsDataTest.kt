package fr.eni.ecole.eni_shop

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.ui.screen.ArticleDetails
//import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.ui.screen.ArticleDetailsScreen
import org.junit.Rule
import org.junit.Test
import java.util.Date

class ViewModelArticleDetailsDataTest {

    @get:Rule
    val composeTestRule = createComposeRule();

    @Test
    fun articleDetail_show_OK(){
//        mock
        val articleTest = Article(
            _id = 1,
            _title = "test",
            _description = "desc",
            _price = 20.0,
            _urlImage = "blah.com/image.png",
            _date = Date(),
        );

        composeTestRule.setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                ArticleDetails(articleTest);
            }
        }
        composeTestRule.onNodeWithText("test").assertIsDisplayed();
        composeTestRule.onNodeWithText("desc").assertIsDisplayed();
    }

}