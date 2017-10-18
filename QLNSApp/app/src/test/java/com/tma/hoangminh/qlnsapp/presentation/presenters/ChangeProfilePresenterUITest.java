package com.tma.hoangminh.qlnsapp.presentation.presenters;

import com.tma.hoangminh.qlnsapp.Presentation.Presenters.ChangeProfilePresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.ChangeProfileView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChangeProfilePresenterUITest {

    @Mock
    private ChangeProfileView view;

    @Mock
    private ChangeProfilePresenter presenter;

    private String oldPasswordInValid = "0123";
    private String oldPasswordValid = "123123";
    private String newPasswordInValid = "1111";
    private String newPassword = "123123";
    private String cfNewPasswordInValid = "1111";
    private String cfNewPassword = "123123";
    private String nameInValid = "minh";
    private String nameValid = "minhhhh";

    @Before
    public void setUp() throws Exception {
        presenter = new ChangeProfilePresenter(view);
    }

    @Test
    public void ChangeProfile_UnitTest1() throws Exception {//shouldShowErrorMessageWhenNameIsEmpty
        when(view.getStateCB()).thenReturn(true);
        when(view.getName()).thenReturn("");
        when(view.getOldPassword()).thenReturn(oldPasswordValid);
        when(view.getTruePass()).thenReturn(oldPasswordValid);
        when(view.getNewPassword()).thenReturn(newPassword);
        when(view.getCfNewPassword()).thenReturn(cfNewPassword);
        presenter.onPressChange();
        verify(view).showErrorName("Không được trống");
    }

    @Test
    public void ChangeProfile_UnitTest2() throws Exception {//shouldShowErrorMessageWhenNameInValid
        when(view.getStateCB()).thenReturn(true);
        when(view.getName()).thenReturn(nameInValid);
        when(view.getOldPassword()).thenReturn(oldPasswordValid);
        when(view.getTruePass()).thenReturn(oldPasswordValid);
        when(view.getNewPassword()).thenReturn(newPassword);
        when(view.getCfNewPassword()).thenReturn(cfNewPassword);
        presenter.onPressChange();
        verify(view).showErrorName("Tên không ít hơn 6 kí tự");
    }

    @Test
    public void ChangeProfile_UnitTest3() throws Exception {//shouldShowErrorMessageWhenOldPasswordIsEmpty
        when(view.getStateCB()).thenReturn(true);
        when(view.getName()).thenReturn(nameValid);
        when(view.getOldPassword()).thenReturn("");
        when(view.getTruePass()).thenReturn(oldPasswordValid);
        when(view.getNewPassword()).thenReturn(newPassword);
        when(view.getCfNewPassword()).thenReturn(cfNewPassword);
        presenter.onPressChange();
        verify(view).showErrorPasswordOld("Không được trống");
    }

    @Test
    public void ChangeProfile_UnitTest4() throws Exception {//shouldShowErrorMessageWhenOldPasswordInValid
        when(view.getStateCB()).thenReturn(true);
        when(view.getName()).thenReturn(nameValid);
        when(view.getOldPassword()).thenReturn(oldPasswordInValid);
        when(view.getTruePass()).thenReturn(oldPasswordValid);
        when(view.getNewPassword()).thenReturn(newPassword);
        when(view.getCfNewPassword()).thenReturn(cfNewPassword);
        presenter.onPressChange();
        verify(view).showErrorPasswordOld("Mật khẩu không ít hơn 6 kí tự");
    }

    @Test
    public void ChangeProfile_UnitTest5() throws Exception {//shouldShowErrorMessageWhenOldPasswordInValid
        when(view.getStateCB()).thenReturn(true);
        when(view.getName()).thenReturn(nameValid);
        when(view.getOldPassword()).thenReturn(oldPasswordValid);
        when(view.getTruePass()).thenReturn(oldPasswordValid+"1");
        when(view.getNewPassword()).thenReturn(newPassword);
        when(view.getCfNewPassword()).thenReturn(cfNewPassword);
        presenter.onPressChange();
        verify(view).showErrorPasswordOld("Mật khẩu không đúng");
    }

    @Test
    public void ChangeProfile_UnitTest6() throws Exception {//shouldShowErrorMessageWhenNewPasswordIsEmpty
        when(view.getStateCB()).thenReturn(true);
        when(view.getName()).thenReturn(nameValid);
        when(view.getOldPassword()).thenReturn(oldPasswordValid);
        when(view.getTruePass()).thenReturn(oldPasswordValid);
        when(view.getNewPassword()).thenReturn("");
        when(view.getCfNewPassword()).thenReturn(cfNewPassword);
        presenter.onPressChange();
        verify(view).showErrorPasswordNew("Không được trống");
    }

    @Test
    public void ChangeProfile_UnitTest7() throws Exception {//shouldShowErrorMessageWhenNewPasswordInValid
        when(view.getStateCB()).thenReturn(true);
        when(view.getName()).thenReturn(nameValid);
        when(view.getOldPassword()).thenReturn(oldPasswordValid);
        when(view.getTruePass()).thenReturn(oldPasswordValid);
        when(view.getNewPassword()).thenReturn(newPasswordInValid);
        when(view.getCfNewPassword()).thenReturn(cfNewPassword);
        presenter.onPressChange();
        verify(view).showErrorPasswordNew("Mật khẩu không ít hơn 6 kí tự");
    }

    @Test
    public void ChangeProfile_UnitTest8() throws Exception {//shouldShowErrorMessageWhenCfPasswordIsEmpty
        when(view.getStateCB()).thenReturn(true);
        when(view.getName()).thenReturn(nameValid);
        when(view.getOldPassword()).thenReturn(oldPasswordValid);
        when(view.getTruePass()).thenReturn(oldPasswordValid);
        when(view.getNewPassword()).thenReturn(newPassword);
        when(view.getCfNewPassword()).thenReturn("");
        presenter.onPressChange();
        verify(view).showErrorCfPasswordNew("Không được trống");
    }

    @Test
    public void ChangeProfile_UnitTest9() throws Exception {//shouldShowErrorMessageWhenCfPasswordInValid
        when(view.getStateCB()).thenReturn(true);
        when(view.getName()).thenReturn(nameValid);
        when(view.getOldPassword()).thenReturn(oldPasswordValid);
        when(view.getTruePass()).thenReturn(oldPasswordValid);
        when(view.getNewPassword()).thenReturn(newPassword);
        when(view.getCfNewPassword()).thenReturn(cfNewPassword+"1");
        presenter.onPressChange();
        verify(view).showErrorCfPasswordNew("Mật khẩu xác nhận không đúng");
    }
}
