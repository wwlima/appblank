package br.com.w2lima.appblank.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class User {

    private UUID id;

    private String name;

    private LocalDate born;


}
