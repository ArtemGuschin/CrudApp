package net.artem.crudapp.controller;

import net.artem.crudapp.enums.LabelStatus;
import net.artem.crudapp.model.Label;
import net.artem.crudapp.repository.LabelRepository;
import net.artem.crudapp.repository.gson.GsonLabelRepositoryImpl;

public class LabelController {
    private final LabelRepository labelRepository;

    public LabelController(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public LabelController() {
        this.labelRepository = new GsonLabelRepositoryImpl();

    }

    public Label createLabel(String labelName) {
        Label label = Label.builder()
                .name(labelName)
                .labelStatus(LabelStatus.ACTIVE)
                .build();
        return labelRepository.save(label);
    }

    public Label updateLabel(Long id, String name, LabelStatus labelStatus) {
        Label updateLabel = new Label(name, labelStatus);
        updateLabel.setId(id);
        updateLabel.setName(name);
        updateLabel.setLabelStatus(LabelStatus.UNDER_REVIEW);
        return labelRepository.update(updateLabel);

    }

    public void deleteLabel(Long id) {
        labelRepository.deleteById(id);
    }

}
