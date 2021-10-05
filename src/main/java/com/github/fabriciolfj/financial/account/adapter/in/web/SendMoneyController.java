package com.github.fabriciolfj.financial.account.adapter.in.web;

import com.github.fabriciolfj.financial.account.application.port.in.SendMoneyCommand;
import com.github.fabriciolfj.financial.account.application.port.in.SendMoneyUseCase;
import com.github.fabriciolfj.financial.account.domain.Account;
import com.github.fabriciolfj.financial.account.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    public void sendMoney(@PathVariable("sourceAccountId") final Long sourceAccountId,
                          @PathVariable("targetAccountId") final Long targetAccountId,
                          @PathVariable("amount") final Long amount) {

        final SendMoneyCommand command = new SendMoneyCommand(
                new Account.AccountId(sourceAccountId),
                new Account.AccountId(targetAccountId),
                Money.of(amount));

        sendMoneyUseCase.sendMoney(command);

    }

}
