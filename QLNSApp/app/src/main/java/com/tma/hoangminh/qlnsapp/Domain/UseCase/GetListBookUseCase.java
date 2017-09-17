package com.tma.hoangminh.qlnsapp.Domain.UseCase;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class GetListBookUseCase  {
    public List<Sach> getBookList (){
        List<Sach> sachList = new ArrayList<>();
        for(int i = 0; i<20;i++){
            sachList.add(new Sach("1", "Chuyen Minh", "kn", "abc", "khong hay dau", "Kim Dong", "Hi Hi", "19/09/1996", 1, 1, 1
                    , 1, 1 , true));
        }
        return sachList;
    }
}
