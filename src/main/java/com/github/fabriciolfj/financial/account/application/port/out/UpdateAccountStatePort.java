package com.github.fabriciolfj.financial.account.application.port.out;


import com.github.fabriciolfj.financial.account.domain.Account;

public interface UpdateAccountStatePort {

	void updateActivities(Account account);

}
