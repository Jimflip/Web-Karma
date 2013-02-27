/*******************************************************************************
 * Copyright 2012 University of Southern California
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * This code was developed by the Information Integration Group as part 
 * of the Karma project at the Information Sciences Institute of the 
 * University of Southern California.  For more information, publications, 
 * and related projects, please see: http://www.isi.edu/integration
 ******************************************************************************/

package edu.isi.karma.cleaning;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigParameters {
	Properties properties = new Properties();
	public ConfigParameters()
	{
	}
	public void initeParameters() {
		// load property file and initialize the parameters;
		try {
			// load a properties file
			properties.load(new FileInputStream(
					"./config/transformation.properties"));

			// get the property value and print it out
			Segment.cxtsize_limit = Integer.parseInt(properties.getProperty("cxt_size").trim());
			Template.temp_limit = Integer.parseInt(properties.getProperty("temp_cap").trim());
			Traces.trace_limit = Integer.parseInt(properties.getProperty("trace_limit").trim());
			//System.out.println(properties.getProperty("iter_end"));
			ExampleSelection.way = Integer.parseInt(properties.getProperty("exmp_sel").trim());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
