package com.github.fabriciolfj.financial.account.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    @Getter
    private final AccountId id;
    @Getter
    private final Money baseLineBalance;
    @Getter
    private final ActivityWindow activityWindow;

    public static Account withoutId(final Money baseLineBalance, final ActivityWindow activityWindow) {
        return new Account(null, baseLineBalance, activityWindow);
    }

    public static Account withId(final AccountId accountId, final Money baseLineBalance, final ActivityWindow activityWindow) {
        return new Account(accountId, baseLineBalance, activityWindow);
    }

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
