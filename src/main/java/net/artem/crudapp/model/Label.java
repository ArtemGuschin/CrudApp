package net.artem.crudapp.model;

import lombok.*;
import net.artem.crudapp.enums.LabelStatus;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Label {
    private long id;
    private String name;
    private LabelStatus labelStatus;


}
