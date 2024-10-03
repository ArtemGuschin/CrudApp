package net.artem.crudapp.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.artem.crudapp.model.Label;
import net.artem.crudapp.repository.LabelRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private final String FILE_PATH = "src/main/resources/labels.json";
    private final Gson gson = new Gson();

    public GsonLabelRepositoryImpl() {

        loadLabels();
    }

    private List<Label> loadLabels() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Label>>() {
            }.getType();
            List<Label> labels = gson.fromJson(reader,type);
            return labels;

        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void saveLabels(List<Label> labels) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(labels, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Label getById(Long id) {
        return null;
//         loadLabels().stream()
//                .filter(label -> label.getId())

    }

    @Override
    public List<Label> getAll() {
        return loadLabels();
    }

    @Override
    public Label save(Label label) {
        return null;

    }


    @Override
    public Label update(Label label) {
        return null;

    }

    @Override
    public void deleteById(Long id) {

    }
}
