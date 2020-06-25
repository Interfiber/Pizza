package io.interfiber.Pizza.parsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import io.interfiber.Pizza.coreFunctions.Variable;

public class YamlParser {
		public Map<String, Object> obj;
		/**
		 * A Class That is used to parse yaml files with snakeyaml
		 * and test if yaml varibles exist
		 * @param varName
		 * @param yamlFile
		 * @return
		 * @throws FileNotFoundException
		 */
	public String getValue(String varName, String yamlFile) throws FileNotFoundException {
		
		Yaml yaml = new Yaml();
		InputStream inputStream = new FileInputStream(yamlFile);
		obj = yaml.load(inputStream);
		return obj.get(varName).toString();
	
	}
	public boolean valueExists(String var, String yamlFile) throws FileNotFoundException {
		Yaml yaml = new Yaml();
		InputStream inputStream = new FileInputStream(yamlFile);
		obj = yaml.load(inputStream);
		return obj.containsKey(var);
	}
}
