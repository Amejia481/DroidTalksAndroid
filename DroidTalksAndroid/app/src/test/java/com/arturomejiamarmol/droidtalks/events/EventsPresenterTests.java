package com.arturomejiamarmol.droidtalks.events;

import com.arturomejiamarmol.droidtalks.data.Callback;

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
 * Created by Arturo Mejia on 8/17/17.
 */


public class EventsPresenterTests {

    @Captor
    ArgumentCaptor<Callback<List<Event>>> mLoadEventsCallbackCaptor;

    @Mock
    public EventsRepository mockRepository;

    @Mock
    public EventsContract.View mockView;

    List<Event> EVENTS;

    @Before
    public void setup() {


        EVENTS = Arrays.asList(
                new Event[]{
                        new Event("-KmOKNpEAmZ52XOzQhUH", "360|Andev",
                                Arrays.asList(new EventVersion[]
                                        {
                                                new EventVersion("2016", "https://www.youtube.com/playlist?list=PLnD_TKDSaFyXP2teNBmNJkdKDWlLrN8N_")
                                        }))}
        );

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void loadEventShouldShowTalks() {
        EventsPresenter presenter = new EventsPresenter(mockView, mockRepository);

        presenter.loadEvents();
        verify(mockRepository).getAllEvents(mLoadEventsCallbackCaptor.capture());
        mLoadEventsCallbackCaptor.getValue().onFinish(EVENTS, null);
        verify(mockView).showEvents(EVENTS);

    }
}
