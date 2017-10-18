package com.tma.hoangminh.qlnsapp.Data;


import android.os.AsyncTask;
import android.test.InstrumentationTestCase;

import com.tma.hoangminh.qlnsapp.Domain.Model.Service.BookService;

import junit.framework.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TypeBookPresenterUnitTest extends InstrumentationTestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public final void testSetUpBookSuccess() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AsyncTask<Object, Object, String>() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                    }

                    @Override
                    protected String doInBackground(Object... params) {
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
}
