package mobile.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountTitle {
    NEW_USER_DATA("Nick Tester"),
    MY_ORDERS_TITLE("My orders");

    private final String value;
}
