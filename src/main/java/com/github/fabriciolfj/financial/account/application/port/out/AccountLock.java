package com.github.fabriciolfj.financial.account.application.port.out;


import com.github.fabriciolfj.financial.account.domain.Account;

public interface AccountLock {

	void lockAccount(Account.AccountId accountId);

	void releaseAccount(Account.AccountId accountId);

}
