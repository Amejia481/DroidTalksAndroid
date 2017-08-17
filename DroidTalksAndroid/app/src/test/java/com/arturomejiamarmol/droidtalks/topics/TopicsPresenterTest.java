package com.arturomejiamarmol.droidtalks.topics;

import com.arturomejiamarmol.droidtalks.data.CallBack;
import com.arturomejiamarmol.droidtalks.data.TalksRepository;
import com.arturomejiamarmol.droidtalks.data.Topic;
import com.arturomejiamarmol.droidtalks.data.TopicsRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by Arturo Mejia on 7/31/17.
 */


public class TopicsPresenterTest {

    @Captor
    ArgumentCaptor<CallBack<List<Topic>>> mLoadNotesCallbackCaptor;

    @Mock
    TopicsContract.View mockView;

    @Mock
    TopicsContract.UserActionListener mockUserActions;

    @Mock
    TalksRepository mockTalkRepo;

    @Mock
    TopicsRepository mockTopicsRepo;

    List<Topic> TOPICS;
    TopicsPresenter presenter;

    @Before
    public void setup() {

        TOPICS = Arrays.asList(new Topic[]{new Topic("-KmOJ3kdKnoyhGL68X5x","Accessibility",4), new Topic("-KmOJ3kjxUNlGOXr93na","Android IoT",16)});
        MockitoAnnotations.initMocks(this);
        presenter = new TopicsPresenter(mockView, mockTopicsRepo, mockTalkRepo);

    }

    @Test
    public void shouldGetAllTopics() {

        presenter.loadTopics();
        verify(mockTopicsRepo).getAllTopics(mLoadNotesCallbackCaptor.capture());
        mLoadNotesCallbackCaptor.getValue().onFinish(TOPICS, null);

        verify(mockView).showTopics(TOPICS);


    }

    @Test
    public void shouldShowDetails(){
        final String  topic = "SVG";
        presenter.openTalksOfThisTopic(topic);
        verify(mockView).showTalksOfThisTopic(topic);
    }
}
