package org.luopanbi.mybatis;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.function.ConverterFileName;

import java.io.File;
import java.sql.Types;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CodeGenerator {
    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        String srcCodeDir = currentDirectory + File.separator + "src";
        String codeParentDir = String.join(File.separator, srcCodeDir, "main", "java");
        String packageDir = String.join(File.separator, "org", "luopanbi", "dal");
        String xmlMapperDir = String.join(File.separator, srcCodeDir, "main", "resources", "mapper");
        Map<OutputFile, String> pathInfo = new HashMap<OutputFile, String>() {{
            put(OutputFile.xml, xmlMapperDir);
            put(OutputFile.entity, String.join(File.separator, codeParentDir, packageDir, "entity"));
            put(OutputFile.mapper, String.join(File.separator, codeParentDir, packageDir, "mapper"));
            put(OutputFile.controller, String.join(File.separator, codeParentDir, packageDir, "controller"));
            put(OutputFile.service, String.join(File.separator, codeParentDir, packageDir, "dao"));
            put(OutputFile.serviceImpl, String.join(File.separator, codeParentDir, packageDir, "dao", "impl"));
        }};

        FastAutoGenerator autoGenerator = FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/luopan", "root", "123456");
        autoGenerator.globalConfig(builder -> {
            builder.author("luopan");
        });
        autoGenerator.packageConfig(builder -> {
            builder.parent("org.luopanbi.dal") // 设置父包名
                    .service("dao")
                    .serviceImpl("dao.impl")
                    .pathInfo(pathInfo); // 设置mapperXml生成路径

        });
        autoGenerator.templateConfig(builder -> {
            builder.disable(TemplateType.CONTROLLER);
        });
        autoGenerator.strategyConfig(builder -> {
            builder.addInclude("dataset", "column_info"); // 设置需要生成的表名
            builder.serviceBuilder().convertServiceFileName(entityName -> entityName + "DAO");
            builder.serviceBuilder().convertServiceImplFileName(entityName -> entityName + "DAOImpl");
            builder.entityBuilder().enableLombok();
        });
        autoGenerator.execute();
    }
}
