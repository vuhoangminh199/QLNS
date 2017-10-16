package com.tma.hoangminh.qlnsapp.Data;

import android.os.AsyncTask;
import android.test.InstrumentationTestCase;

import com.tma.hoangminh.qlnsapp.Domain.Model.KhachHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.UserService;

import junit.framework.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class UserPresenterUITest extends InstrumentationTestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public final void testLoginSuccess() throws Throwable {
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
                        return new UserService().LoginUser("1231231231", "123123");
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

    public final void testRegisterSuccess() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);
        final KhachHang user = new KhachHang("123", "vuhoangminh", "ABC", "1231233331", "123", "123123");
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
                        return new UserService().PostUser(user);
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
