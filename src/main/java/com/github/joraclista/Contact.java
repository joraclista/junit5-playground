package com.github.joraclista;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by Alisa
 * version 1.0.
 */
@Data
@Builder
public class Contact {
    private final String name;
    private final String surname;
    private final String email;
    private final List<Contact> contacts;

    public void greet(Contact other) {
        throw new UnsupportedOperationException("not supported");
    }

}
