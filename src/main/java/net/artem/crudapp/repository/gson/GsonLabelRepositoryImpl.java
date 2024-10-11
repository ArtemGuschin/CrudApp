package net.artem.crudapp.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.artem.crudapp.enums.LabelStatus;
import net.artem.crudapp.model.Label;
import net.artem.crudapp.repository.LabelRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private final String FILE_PATH = "src/main/resources/labels.json";
    private final Gson GSON = new Gson();

    private Long generateNewId(List<Label> labels) {
        return labels.stream()
                .mapToLong(Label::getId).max().orElse(0) + 1;

    }


    private List<Label> loadLabels() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Label>>() {
            }.getType();
            return GSON.fromJson(reader, type);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void saveLabels(List<Label> labels) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            GSON.toJson(labels, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Label getById(Long id) {
        return loadLabels().stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);


    }

    @Override
    public List<Label> getAll() {
        return loadLabels();
    }

    @Override
    public Label save(Label labelToSave) {
        List<Label> currentLabels = loadLabels();

        Long generatedId = generateNewId(currentLabels);
        labelToSave.setId(generatedId);

        currentLabels.add(labelToSave);
        saveLabels(currentLabels);
        return labelToSave;

    }


    @Override
    public Label update(Label labelToUpdate) {
        List<Label> labelsToUpdate = loadLabels().stream()
                .map(currentLabel -> {
                    if (currentLabel.getId().equals(labelToUpdate.getId())) {
                        return labelToUpdate;
                    }
                    return currentLabel;
                }).toList();
        saveLabels(labelsToUpdate);
        return labelToUpdate;

    }

    @Override
    public void deleteById(Long id) {
        List<Label> labelsToUpdate = loadLabels().stream()
                .map(currentLabel -> {
                    if (currentLabel.getId().equals(id)) {
                        currentLabel.setLabelStatus(LabelStatus.DELETED);

                    }
                    return currentLabel;
                }).toList();
        saveLabels(labelsToUpdate);

    }
}
