package com.tma.hoangminh.qlnsapp.Data;


import android.os.AsyncTask;
import android.test.InstrumentationTestCase;

import com.tma.hoangminh.qlnsapp.Domain.Model.KhachHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.UserService;

import junit.framework.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ChangeProfilePresenterUnitTest extends InstrumentationTestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public final void testChangeProfileSuccess() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);
        final KhachHang user = new KhachHang("KH01", "vuhoangminh", "55 tan quy", "0908059975", "vhminh@domail.com", "123123");
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
                        return new UserService().PutUser("KH01",user);
                    }

                    @Override
                    protected void onPostExecute(Boolean s) {
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
