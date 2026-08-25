package com.black.jakarta_test2.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@NoArgsConstructor
@Data
@SuperBuilder
public class Person implements Serializable {
    private int id;
    private String name;
    private String family;
}
