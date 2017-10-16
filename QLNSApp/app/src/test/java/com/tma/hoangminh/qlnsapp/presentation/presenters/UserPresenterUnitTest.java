package com.tma.hoangminh.qlnsapp.presentation.presenters;

import com.tma.hoangminh.qlnsapp.Presentation.Presenters.UserPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.UserView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserPresenterUnitTest {

    @Mock
    private UserView view;

    @Mock
    private UserPresenter presenter;

    private String phoneInValid = "0123";
    private String phoneValid = "0944035440";
    private String passwordInValid = "1111";
    private String password = "123123";
    private String nameInValid = "minh";
    private String nameValid = "minhhhh";

    @Before
    public void setUp() throws Exception {
        presenter = new UserPresenter(view);
    }

    @Test
    public void Login_UnitTest1() throws Exception {//shouldShowErrorMessageWhenPhoneIsEmpty
        when(view.getPhonenumber()).thenReturn("");
        when(view.getPassword()).thenReturn(password);
        presenter.onPressLogin();
        verify(view).showErrorPhone("Không được trống");
    }

    @Test
    public void Login_UnitTest2() throws Exception {//shouldShowErrorMessageWhenPasswordIsEmpty
        when(view.getPhonenumber()).thenReturn(phoneValid);
        when(view.getPassword()).thenReturn("");
        presenter.onPressLogin();
        verify(view).showErrorPassword("Không được trống");
    }

    @Test
    public void Login_UnitTest3() throws Exception {//shouldShowErrorMessageWhenPasswordInValid
        when(view.getPhonenumber()).thenReturn(phoneValid);
        when(view.getPassword()).thenReturn(passwordInValid);
        presenter.onPressLogin();
        verify(view).showErrorPassword("Mật khẩu không ít hơn 6 kí tự");
    }

    @Test
    public void Login_UnitTest4() throws Exception {//shouldShowErrorMessageWhenPhoneIsInvalid
        when(view.getPhonenumber()).thenReturn(phoneInValid);
        when(view.getPassword()).thenReturn(password);
        presenter.onPressLogin();
        verify(view).showErrorPhone("Độ dài không phù hợp (10 - 12)");
    }

    @Test
    public void Login_UnitTest5() throws Exception {//shouldBackNormalTextPhone
        presenter.onBackNormalText(true);
        verify(view).hideErrorPhone();
    }

    @Test
    public void Login_UnitTest6() throws Exception {//shouldBackNormalTextPassword
        presenter.onBackNormalText(false);
        verify(view).hideErrorPassword();
    }

    //Register
    @Test
    public void Register_UnitTest7() throws Exception {//shouldShowErrorMessageWhenPhoneRIsEmpty
        when(view.getRPhonenumber()).thenReturn("");
        when(view.getRPassword()).thenReturn(password);
        when(view.getRName()).thenReturn(nameValid);
        presenter.onPressRegister();
        verify(view).showErrorRPhone("Không được trống");
    }

    @Test
    public void Register_UnitTest8() throws Exception {//shouldShowErrorMessageWhenPasswordRIsEmpty
        when(view.getRPhonenumber()).thenReturn(phoneValid);
        when(view.getRPassword()).thenReturn("");
        when(view.getRName()).thenReturn(nameValid);
        presenter.onPressRegister();
        verify(view).showErrorRPassword("Không được trống");
    }

    @Test
    public void Register_UnitTest9() throws Exception {//shouldShowErrorMessageWhenNameRIsEmpty
        when(view.getRPhonenumber()).thenReturn(phoneValid);
        when(view.getRPassword()).thenReturn(password);
        when(view.getRName()).thenReturn("");
        presenter.onPressRegister();
        verify(view).showErrorRName("Không được trống");
    }

    @Test
    public void Register_UnitTest10() throws Exception {//shouldShowErrorMessageWhenRPasswordInValid
        when(view.getRPhonenumber()).thenReturn(phoneValid);
        when(view.getRPassword()).thenReturn(passwordInValid);
        when(view.getRName()).thenReturn(nameValid);
        presenter.onPressRegister();
        verify(view).showErrorRPassword("Mật khẩu không ít hơn 6 kí tự");
    }

    @Test
    public void Register_UnitTest11() throws Exception {//shouldShowErrorMessageWhenRPhoneInValid
        when(view.getRPhonenumber()).thenReturn(phoneInValid);
        when(view.getRPassword()).thenReturn(password);
        when(view.getRName()).thenReturn(nameValid);
        presenter.onPressRegister();
        verify(view).showErrorRPhone("Độ dài không phù hợp (10 - 12)");
    }

    @Test
    public void Register_UnitTest12() throws Exception {//shouldShowErrorMessageWhenRNameIsInvalid
        when(view.getRPhonenumber()).thenReturn(phoneValid);
        when(view.getRPassword()).thenReturn(password);
        when(view.getRName()).thenReturn(nameInValid);
        presenter.onPressRegister();
        verify(view).showErrorRName("Tên không ít hơn 6 kí tự");
    }

    @Test
    public void Register_UnitTest13() throws Exception {//shouldBackNormalTextRPhone
        presenter.onBackNormalTextRegister(2);
        verify(view).hideErrorRPhone();
    }

    @Test
    public void Register_UnitTest14() throws Exception {//shouldBackNormalTextRName
        presenter.onBackNormalTextRegister(1);
        verify(view).hideErrorRName();
    }

    @Test
    public void Register_UnitTest15() throws Exception {//shouldBackNormalTextRPassword
        presenter.onBackNormalTextRegister(3);
        verify(view).hideErrorRPassword();
    }
}
