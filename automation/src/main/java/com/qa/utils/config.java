package com.qa.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.yaml.snakeyaml.Yaml;

public class config {
	public HashMap<String, Object> envconfig = new HashMap<String, Object>();
	public Map<String, Object> yamlconfig = new HashMap<String, Object>();


	

	public void readYaml()

	{
		System.out.println("loading data from yaml");
		Yaml yaml = new Yaml();
		Set<String> keyset = new HashSet<String>();

		try {

			String path = System.getProperty("user.dir") + "\\resources\\" + "data" + ".yaml";
			FileInputStream in = new FileInputStream(path);

			envconfig = yaml.load(in);
			keyset = envconfig.keySet();
			for (String a : keyset) {
				yamlconfig.put(a, envconfig.get(a));
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getyaml(String key) {
		return yamlconfig.get(key);
	}

}