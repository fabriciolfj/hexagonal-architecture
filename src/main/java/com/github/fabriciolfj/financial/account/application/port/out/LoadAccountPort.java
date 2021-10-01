package com.github.fabriciolfj.financial.account.application.port.out;

import com.github.fabriciolfj.financial.account.domain.Account;

import java.time.LocalDateTime;

public interface LoadAccountPort {

	Account loadAccount(Account.AccountId accountId, LocalDateTime baselineDate);
}
