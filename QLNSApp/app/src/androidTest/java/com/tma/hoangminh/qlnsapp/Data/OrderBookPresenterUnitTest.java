package com.tma.hoangminh.qlnsapp.Data;


import android.os.AsyncTask;
import android.test.InstrumentationTestCase;

import com.tma.hoangminh.qlnsapp.Domain.Model.CT_DatHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.DatHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.BookService;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.OrderService;

import junit.framework.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class OrderBookPresenterUnitTest extends InstrumentationTestCase {

    private long millis = System.currentTimeMillis();
    private long twoDay = millis + TimeUnit.HOURS.toMillis(1l) * 48;
    java.sql.Date date = new java.sql.Date(millis);
    java.sql.Date dateOrder = new java.sql.Date(twoDay);
    private DatHang datHang = new DatHang("123", "KH0001", "0908059975",
            "55 tan quy", date.toString(),
            dateOrder.toString(), 1000000, true);
    private CT_DatHang ct_datHang = new CT_DatHang(datHang.getMadathang(), "123",
            1, 10000, 100000, 0, null);

    protected void setUp() throws Exception {
        super.setUp();

    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public final void testSetupListBookSuccess() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AsyncTask<Void, Void, String>() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                    }

                    @Override
                    protected String doInBackground(Void... params) {
                        return new BookService().getListBook();
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        signal.countDown();
                    }
                }.execute();
            }
        });
        signal.await(10, TimeUnit.SECONDS);
        Assert.assertNotNull("");
    }

    public final void testOnPressOrderSuccess() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AsyncTask<Object, Object, Boolean>() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                    }

                    @Override
                    protected Boolean doInBackground(Object... params) {
                        return new OrderService().PostOrder(datHang);
                    }

                    @Override
                    protected void onPostExecute(Boolean s) {
                        super.onPostExecute(s);
                        signal.countDown();
                        new AsyncTask<Object, Object, Boolean>() {
                            @Override
                            protected void onPreExecute() {
                                super.onPreExecute();
                            }

                            @Override
                            protected Boolean doInBackground(Object... params) {
                                return new OrderService().PostOrderDetail(ct_datHang);
                            }

                            @Override
                            protected void onPostExecute(Boolean s) {
                                super.onPostExecute(s);
                                signal.countDown();
                            }
                        }.execute();
                        Assert.assertNotNull("");
                    }
                }.execute();
            }
        });
        signal.await(10, TimeUnit.SECONDS);
        Assert.assertNotNull("");
    }
}
