package com.arc.tcg.screens.cardlist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.arc.tcg.data.model.CardBrief
import com.arc.tcg.ui.screens.cardslist.ItemCard
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun itemCard_DisplaysCardInformationAndHandlesClick() {
        val testCard = CardBrief(
            id = "1",
            name = "Test Card",
            image = "test_image_url",
            localId = "localId"
        )

        var clickedItemId: String? = null

        composeTestRule.setContent {
            ItemCard(item = testCard, onItemClicked = { clickedItemId = it })
        }

        composeTestRule.onNodeWithText("Test Card").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test Card").performClick()
        assert(clickedItemId == "1")
    }
}