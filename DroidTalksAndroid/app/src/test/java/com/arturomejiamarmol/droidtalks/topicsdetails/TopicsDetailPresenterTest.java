package com.arturomejiamarmol.droidtalks.topicsdetails;

import com.arturomejiamarmol.droidtalks.data.Callback;
import com.arturomejiamarmol.droidtalks.data.Talk;
import com.arturomejiamarmol.droidtalks.data.TalksRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by Arturo Mejia on 7/31/17.
 */


public class TopicsDetailPresenterTest {

    @Captor
    ArgumentCaptor<Callback<List<Talk>>> mLoadNotesCallbackCaptor;

    @Mock
    TopicsDetailsContract.View mockView;


    @Mock
    TalksRepository mockTalkRepo;

    @Mock
    List<Talk> mockTalks;

    final String TOPIC = "Emulator";

    TopicsDetailsPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new TopicsDetailsPresenter(mockTalkRepo, mockView);


    }

    @Test
    public void shouldGetAllTalksOfThisTopic() {

        presenter.showTalksByTopic(TOPIC);

        verify(mockTalkRepo).getTalksByTopic(anyString(), mLoadNotesCallbackCaptor.capture());
        mLoadNotesCallbackCaptor.getValue().onFinish(mockTalks, null);
        verify(mockView).showTalks(mockTalks);


    }

}
