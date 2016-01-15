package com.peirr.yodaspeak;

import com.peirr.yodaspeak.model.YodaModel;
import com.peirr.yodaspeak.view.YodaView;
import com.peirr.yodaspeak.viewmodel.YodaViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;


public class YodaViewModelTest {

    @Mock
    YodaView view;
    YodaViewModel viewModel;
    @Mock
    YodaModel model;
    final String SAMPLE_TEXT = "do, there is no try";

    @Before
    public void setupYodaViewModel() {
        MockitoAnnotations.initMocks(this);
//        model = ModelFactory.getModel(null,true);
        viewModel = new YodaViewModel(view,model);
    }

    @Test
    public void requestTextModel_showsTextLoadingIndicator() {
        // When the viewmodel is asked to get the converted text
        viewModel.requestText(SAMPLE_TEXT);
        // Then a request made by model,
        verify(model).requestText(anyString(),any(YodaModel.RequestCallback.class));
        verify(view).showTextLoading(true); // shown in the UI
    }

}