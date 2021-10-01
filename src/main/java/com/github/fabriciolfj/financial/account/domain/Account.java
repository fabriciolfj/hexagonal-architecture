package com.github.fabriciolfj.financial.account.domain;

import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
public class Account {

    private AccountId id;
    private Money baseLineBalance;
    private ActivityWindow activityWindow;

    public Money calculateBalance() {
        return Money.add(this.baseLineBalance, this.activityWindow.calculateBalance(id));
    }

    public boolean withdraw(final Money money, final AccountId targetAccountId) {
        if (!mayWithDraw(money)) {
            return false;
        }

        final Activity withdrawal = new Activity(this.id,
                this.id,
                targetAccountId,
                LocalDateTime.now(),
                money);

        this.activityWindow.addActivity(withdrawal);
        return true;
    }

    private boolean mayWithDraw(final Money money) {
        return Money.add(this.calculateBalance(), money.negate())
                .isPositive();
    }

    public boolean deposit(final Money money, final AccountId sourceAccuntId) {
        final Activity deposit = new Activity(
                this.id,
                sourceAccuntId,
                this.id,
                LocalDateTime.now(),
                money);

        this.activityWindow.addActivity(deposit);
        return true;
    }

    public Optional<AccountId> getId(){
        return Optional.ofNullable(this.id);
    }

    @Value
    public static class AccountId {
        private Long value;
    }

}
