package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--output", "-o"})
    String output;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--count", "-n"})
    int count;

    public static void main(String[] args) throws IOException {
        var generator = new Generator();
        // Cоздается парсер коммандной строки, который будет анализировать параметры,
        // описанные в объекте generator, а потом на вход этому парсеру передаются аргументы args.
        // После того как этот парсер отработает, в объекте generator в соответствующих свойствах будут
        // прописаны те значения, чтоы были переданы в параметрах запуска
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();
    }

    private void run() throws IOException {

        var data = generate();
        save(data);
    }

    private void saveOldJackson(Object data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File("groups.json"), data);
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных" + format);
        }
    }

    private void saveOldFileWriter(Object data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json = mapper.writeValueAsString(data);
            var writer = new FileWriter(output);
            // эта операция записывает данные не сразу на диск, они где-то хранятся в кэше, буферизуются
            // и реальная запись происходит когда накапливается много данных, либо когда вызывается метот close
            writer.write(json);
            // нужно обязательно закрывать открытые файлы иначе часть данных может потеряться
            // плюс джава не знает когда мы перестаем работать с файлом
            writer.close();
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных " + format);
        }
    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json = mapper.writeValueAsString(data);
            // try with resources, автоматически закрывает ресурс указанный в круглых скобках
            // после того как выполнится код внутри фигурных
            // Класс стандартной библиотеки
            try (var writer = new FileWriter(output)) {
                writer.write(json);
            }
        } else if ("yaml".equals(format)) {
            var mapper = new YAMLMapper();
            mapper.writeValue(new File(output), data);
        } else if ("xml".equals(format)) {
            var mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(output), data);
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных " + format);
        }
    }
    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных " + type);
        }
    }

    private Object generateContacts() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "firstname", CommonFunctions.randomString(10))) {
            for (var lastName : List.of("", "lastname", CommonFunctions.randomString(10))) {
                result.add(new ContactData()
                        .withFirstName(firstName)
                        .withLastName(lastName));
            }
        }
        return result;
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>();

        for (int i = 0; i < 5; i++) {
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i * 10))
                    .withHeader(CommonFunctions.randomString(i * 10))
                    .withFooter(CommonFunctions.randomString(i * 10)));
        }
        return result;
    }
}
