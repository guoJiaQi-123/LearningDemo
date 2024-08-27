package com.itbaizhan.service;


import com.itbaizhan.dao.AccountDao;
import com.itbaizhan.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    public void transfer(int id1,int id2,double price){
        Account account1 = accountDao.findAccountById(id1);
        account1.setBalance(account1.getBalance() - price);//修改余额
        accountDao.update(account1);//更新数据库数据

        Account account2 = accountDao.findAccountById(id2);
        account2.setBalance(account2.getBalance() + price);//修改余额
        accountDao.update(account2);                       //更新数据库数据
    }

}
