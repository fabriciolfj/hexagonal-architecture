package com.github.fabriciolfj.financial.account.application.port.in;

import com.github.fabriciolfj.financial.account.domain.Account.AccountId;
import com.github.fabriciolfj.financial.account.domain.Money;

public interface GetAccountBalanceQuery {

	Money getAccountBalance(final AccountId accountId);

}
