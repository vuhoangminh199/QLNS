package com.tma.hoangminh.qlnsapp.presentation.presenters;

import android.content.Context;

import com.tma.hoangminh.qlnsapp.Domain.Model.CT_DatHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.DatHang;
import com.tma.hoangminh.qlnsapp.Presentation.Activities.OrderBookActivity;
import com.tma.hoangminh.qlnsapp.Presentation.Presenters.OrderBookPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.OrderBookView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderBookPresenterUITest {
    @Mock
    private OrderBookView view;

    @Mock
    private OrderBookPresenter presenter;

    private long millis = System.currentTimeMillis();
    private long twoDay = millis + TimeUnit.HOURS.toMillis(1l) * 48;
    java.sql.Date date = new java.sql.Date(millis);
    java.sql.Date dateOrder = new java.sql.Date(twoDay);
    private DatHang datHang = new DatHang("123", "KH0001", "0908059975",
            "55 tan quy", date.toString(),
            dateOrder.toString(), 1000000, true);
    private CT_DatHang ct_datHang = new CT_DatHang(datHang.getMadathang(), "123",
            1, 10000, 100000, 0, null);
    private String addressValid = "55 tan quy";
    private String phoneInValid = "123";
    private String phoneValid = "1231231231";
    private String nameInValid = "minh";
    private String nameValid = "minhhhh";
    private Context context = new OrderBookActivity();

    @Before
    public void setUp() throws Exception {
        presenter = new OrderBookPresenter(view);
    }

    @Test
    public void OrderBook_UnitTest1() throws Exception {//shouldShowErrorMessageWhenNameIsEmpty
        when(view.getName()).thenReturn("");
        when(view.getAddress()).thenReturn(addressValid);
        when(view.getContext()).thenReturn(context);
        when(view.getPhone()).thenReturn(phoneValid);
        presenter.onPressOrder(datHang, ct_datHang);
        verify(view).showErrorName("Không được trống");
    }

    @Test
    public void OrderBook_UnitTest2() throws Exception {//shouldShowErrorMessageWhenNameInValid
        when(view.getName()).thenReturn(nameInValid);
        when(view.getAddress()).thenReturn(addressValid);
        when(view.getContext()).thenReturn(context);
        when(view.getPhone()).thenReturn(phoneValid);
        presenter.onPressOrder(datHang, ct_datHang);
        verify(view).showErrorName("Tên không ít hơn 6 kí tự");
    }

    @Test
    public void OrderBook_UnitTest3() throws Exception {//shouldShowErrorMessageWhenPhoneIsEmpty
        when(view.getName()).thenReturn(nameValid);
        when(view.getAddress()).thenReturn(addressValid);
        when(view.getContext()).thenReturn(context);
        when(view.getPhone()).thenReturn("");
        presenter.onPressOrder(datHang, ct_datHang);
        verify(view).showErrorPhone("Không được trống");
    }

    @Test
    public void OrderBook_UnitTest4() throws Exception {//shouldShowErrorMessageWhenPhoneInValid
        when(view.getName()).thenReturn(nameInValid);
        when(view.getAddress()).thenReturn(addressValid);
        when(view.getContext()).thenReturn(context);
        when(view.getPhone()).thenReturn(phoneInValid);
        presenter.onPressOrder(datHang, ct_datHang);
        verify(view).showErrorPhone("Độ dài không phù hợp(10-12)");
    }

    @Test
    public void OrderBook_UnitTest5() throws Exception {//shouldShowErrorMessageWhenAddressIsEmpty
        when(view.getName()).thenReturn(nameValid);
        when(view.getAddress()).thenReturn("");
        when(view.getContext()).thenReturn(context);
        when(view.getPhone()).thenReturn(phoneValid);
        presenter.onPressOrder(datHang, ct_datHang);
        verify(view).showErrorAddress("Không được trống");
    }

}
