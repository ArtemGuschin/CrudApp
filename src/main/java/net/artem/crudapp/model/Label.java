package net.artem.crudapp.model;

import lombok.*;
import net.artem.crudapp.enums.LabelStatus;

import java.util.Objects;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Label {
    private Long id;
    private String name;
    private LabelStatus labelStatus;

    public Label(long id, String name, LabelStatus labelStatus) {
        this.id = id;
        this.name = name;
        this.labelStatus = labelStatus;
    }


    public Label(String name, LabelStatus labelStatus) {

    }
}
