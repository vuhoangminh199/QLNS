package com.tma.hoangminh.qlnsapp.presentation.presenters;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Presentation.Presenters.BookDetailPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.BookDetailView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookDetailPresenterUITest {
    @Mock
    private BookDetailView view;

    @Mock
    private BookDetailPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new BookDetailPresenter(view);
    }

    @Test
    public void BookDetail_UnitTest1() throws Exception {//shouldShowErrorMessageWhenBack
        presenter.onPressBack();
        verify(view).navigationBack();
    }

    @Test
    public void BookDetail_UnitTest2() throws Exception {//shouldShowErrorMessageWhenBack
        Sach sach = new Sach("S000001","mua hoa sua nam ay","TL00001","C:/",Mockito.anyString(),"XB0001",
                "TG00001","NXB000001",1,1,1,1,1,true);
        presenter.onPressOrder(sach);
        verify(view).navigateToOrder(sach);
    }

}
