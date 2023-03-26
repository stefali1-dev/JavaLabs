package homework;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

class ReportCommand implements Command {
    private String templatePath;
    private String outputPath;

    public ReportCommand(String templatePath, String outputPath) {
        this.templatePath = templatePath;
        this.outputPath = outputPath;
    }

    public void execute(Catalog catalog) throws InvalidDataException {

        // create data model for the template engine
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", catalog.getName());
        dataModel.put("documents", catalog.getDocuments());

        // load the template
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        Template template;
        try {
            template = cfg.getTemplate(templatePath);
        } catch (IOException e) {
            throw new InvalidDataException("Error loading template: " + e.getMessage());
        }

        // generate the report
        Writer out;
        try {
            out = new FileWriter(outputPath);
            template.process(dataModel, out);
            out.flush();
            out.close();
        } catch (IOException | TemplateException e) {
            throw new InvalidDataException("Error generating report: " + e.getMessage());
        }

        // open the report
        try {
            Desktop.getDesktop().open(new File(outputPath));
        } catch (IOException e) {
            throw new InvalidDataException("Error opening report: " + e.getMessage());
        }
    }
}