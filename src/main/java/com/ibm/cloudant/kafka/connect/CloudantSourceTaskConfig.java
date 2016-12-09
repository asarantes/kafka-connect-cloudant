/*******************************************************************************
* Copyright (c) 2016 IBM Corp.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/
package com.ibm.cloudant.kafka.connect;

import java.util.Map;

import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;

public class CloudantSourceTaskConfig extends CloudantSourceConnectorConfig {

	// Expand this ConfigDef with task specific parameters
	public static final String TASK_NUMBER = "task.number";
	public static final String TASK_MAX = "task.max";
	public static final String BATCH_SIZE = "batch.size";
	
	public static final int DEFAULT_TASK_MAX = 1;
	public static final int DEFAULT_TASK_NUMBER = 0;
	public static final int DEFAULT_BATCH_SIZE = 1000;

	static org.apache.kafka.common.config.ConfigDef config = baseConfigDef()
		      .define(TASK_NUMBER, 
		    		  Type.INT, DEFAULT_TASK_NUMBER, Importance.HIGH, TASK_NUMBER)
		      .define(TASK_MAX,
		    		  Type.INT, DEFAULT_TASK_MAX, Importance.LOW, TASK_MAX)
		      .define(BATCH_SIZE, Type.INT, DEFAULT_BATCH_SIZE, 
		    		  Importance.LOW, BATCH_SIZE);

	public CloudantSourceTaskConfig(Map<String, String> originals) {
		super(config, originals);
	}

}
