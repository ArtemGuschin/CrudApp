package net.artem.crudapp.model;

import lombok.*;
import net.artem.crudapp.enums.LabelStatus;

import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@ToString

public class Label {
    private long id;
    private String name;
    private LabelStatus labelStatus;

    public Label(long id, String name, LabelStatus labelStatus) {
        this.id = id;
        this.name = name;
        this.labelStatus = labelStatus;
    }




}
