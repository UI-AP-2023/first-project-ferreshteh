package model.others;

import model.user.Account;

public class Comment {
    private Account account;
    private String id;
    private StringBuilder comment;

    private enum Station {
        WAITING, ACCEPTED, NOTACCEPTED
    }

    private boolean buy;
}
