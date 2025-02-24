package com.arc.tcg.screens.cardlist

import com.arc.tcg.data.model.CardBrief
import com.arc.tcg.data.repository.MainRepository
import com.arc.tcg.ui.screens.cardslist.CardListViewModel
import com.arc.tcg.utils.NetworkHelper
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.rules.Timeout
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class CardListViewModelTest {

    private lateinit var viewModel: CardListViewModel
    private val repository: MainRepository = mockk()
    private val networkHelper: NetworkHelper = mockk()
    private val testDispatcher = StandardTestDispatcher(TestCoroutineScheduler())

    @get:Rule
    var globalTimeout: TestRule = Timeout.seconds(10)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = CardListViewModel(repository, networkHelper)
    }

    @Test
    fun `getCards should update state with card list when network is connected`() = runBlocking {
        val testCards = listOf(CardBrief(
            "1", "Test Card", "test_url", image = "https://assets.tcgdex.net/en/swsh/swsh3/136"
        ))
        coEvery { networkHelper.isNetworkConnected() } returns true
        coEvery { repository.getCards("") } returns Response.success(testCards)

        viewModel = CardListViewModel(repository, networkHelper)
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(testCards, viewModel.state.cards)
        assertEquals(false, viewModel.state.isLoading)
    }

    @Test
    fun `getCards should set empty list when network is disconnected`() = runBlocking {
        coEvery { networkHelper.isNetworkConnected() } returns false

        viewModel = CardListViewModel(repository, networkHelper)
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(emptyList<CardBrief>(), viewModel.state.cards)
        assertEquals(false, viewModel.state.isLoading)
    }
}