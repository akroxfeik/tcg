package com.arc.tcg.screens.carddetails

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.arc.tcg.data.model.CardBriefDetails
import com.arc.tcg.ui.screens.carddetails.CardDetails
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardDetailsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun cardDetails_DisplaysCardInformation() {
        val testCard = CardBriefDetails(
            name = "Test Card",
            image = "test_image_url",
            description = "Test description",
            rarity = "Rare",
            evolveFrom = "Previous Evolution",
            illustrator = "Test Illustrator",
            category = "category",
            id = "id",
            localId = "localId",
            set = null,
            variants = null,
            hp = "hp",
            types = null,
            stage = "stage",
            attacks = null,
            weaknesses = null,
            resistances = null,
            retreat = 1,
            regulationMark = "regulationMark",
            legal = null,
            updated = "updated"
        )

        composeTestRule.setContent {
            CardDetails(item = testCard)
        }

        composeTestRule.onNodeWithText("Test Card").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test description").assertIsDisplayed()
        composeTestRule.onNodeWithText("Rare").assertIsDisplayed()
        composeTestRule.onNodeWithText("Previous Evolution").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test Illustrator").assertIsDisplayed()
    }
}
