package com.arturomejiamarmol.droidtalks.creators;

import com.arturomejiamarmol.droidtalks.data.Callback;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by Arturo Mejia on 8/21/17.
 */


public class CreatorsPresenterTest {

    @Captor
    ArgumentCaptor<Callback<List<Creator>>> mLoaCallbackArgumentCaptor;

    @Mock
    CreatorsContract.View  mockView;

    @Mock
    CreatorsRepository mockRepository;

    CreatorsPresenter presenter;

    List<Creator> CREATORS;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new CreatorsPresenter(mockView,mockRepository);
        CREATORS = Arrays.asList(new Creator[]{new Creator(),new Creator()});
    }


    @Test
    public void loadCreatorsShouldShowCreators(){
        presenter.loadCreators();
        verify(mockRepository).getAllCreators(mLoaCallbackArgumentCaptor.capture());
        mLoaCallbackArgumentCaptor.getValue().onFinish(CREATORS,null);
        verify(mockView).showCreators(CREATORS);
    }

    @Test
    public void shouldShowTheCreatorsDetails(){
        presenter.showCreatorDetails(anyString(),anyString());
        verify(mockView).showCreatorDetails(anyString(),anyString());
    }

}
