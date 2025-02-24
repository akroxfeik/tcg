package com.arc.tcg.screens.carddetails

import androidx.lifecycle.SavedStateHandle
import com.arc.tcg.data.model.CardBriefDetails
import com.arc.tcg.data.repository.MainRepository
import com.arc.tcg.ui.screens.carddetails.CardDetailsViewModel
import com.arc.tcg.utils.NetworkHelper
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class CardDetailsViewModelTest {

    private lateinit var viewModel: CardDetailsViewModel
    private val repository: MainRepository = mockk()
    private val networkHelper: NetworkHelper = mockk()
    private val testDispatcher = StandardTestDispatcher(TestCoroutineScheduler())
    private val savedStateHandle = SavedStateHandle(mapOf("id" to "1"))

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = CardDetailsViewModel(savedStateHandle, repository, networkHelper)
    }

    @Test
    fun `getCard should update state with card details when network is connected`() = runTest {
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
        coEvery { networkHelper.isNetworkConnected() } returns true
        coEvery { repository.getCard("1") } returns Response.success(testCard)

        viewModel = CardDetailsViewModel(savedStateHandle, repository, networkHelper)
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(testCard, viewModel.state.card)
        assertEquals(false, viewModel.state.isLoading)
    }

    @Test
    fun `getCard should not update card details when network is disconnected`() = runTest {
        coEvery { networkHelper.isNetworkConnected() } returns false

        viewModel = CardDetailsViewModel(savedStateHandle, repository, networkHelper)
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(null, viewModel.state.card)
        assertEquals(false, viewModel.state.isLoading)
    }
}
