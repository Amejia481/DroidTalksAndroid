package com.arturomejiamarmol.droidtalks

import com.arturomejiamarmol.droidtalks.data.CallBack
import com.arturomejiamarmol.droidtalks.data.TalksRepository
import com.arturomejiamarmol.droidtalks.data.TopicsRepository
import com.arturomejiamarmol.droidtalks.topics.TopicsContract
import com.arturomejiamarmol.droidtalks.topics.TopicsPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as mockitoWhen
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.MockitoAnnotations


/**
* Created by Arturo Mejia on 7/24/17.
*/
class FailingTestKotlin {

    lateinit var mockUserActions: TopicsContract.UserActionListener
    lateinit var presenter: TopicsPresenter
    lateinit var mockView: TopicsContract.View
    lateinit var mockTalkRepo: TalksRepository
    lateinit var mockTopicsRepo: TopicsRepository
    lateinit var TOPICS: List<String>

    @Captor
    lateinit var mLoadNotesCallbackCaptor: ArgumentCaptor<CallBack<List<String>>>



    @Before
    fun setup(){

        mockView =  mock(TopicsContract.View::class.java)
        mockUserActions =  mock(TopicsContract.UserActionListener::class.java)
        mockTalkRepo =  mock(TalksRepository::class.java)
        mockTopicsRepo =  mock(TopicsRepository::class.java)
        TOPICS = listOf("Topic 1","Topic 2","Topic 3")

        presenter = TopicsPresenter(mockView,mockTopicsRepo,mockTalkRepo)
        MockitoAnnotations.initMocks(this)

    }

    inline fun <reified T : Any> argumentCaptor() = ArgumentCaptor.forClass(T::class.java)

    @Test
    fun shouldGetAllTopics(){

        presenter.loadTopics()

        val captor = argumentCaptor<CallBack<List<String>>>()



        verify(mockTopicsRepo).getAllTopics(captor.capture())
        mLoadNotesCallbackCaptor.value.onFinish(TOPICS,null)

        verify(mockView).showTopics(TOPICS)





    }
}