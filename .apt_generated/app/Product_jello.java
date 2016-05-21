package app;

import com.google.gson.Gson;
import jello.model.EntityDef;
import jello.model.EntityDefFactory;

public class Product_jello implements EntityDefFactory {

@Override
public EntityDef getEntityDef() {

StringBuffer json = new StringBuffer();

json.append("{");
json.append("	\"name\" : \"app.Product\",");
json.append("	\"fields\" : [");
json.append("		{");
json.append("			\"name\" : \"serialNumber\",");
json.append("			\"type\" : \"java.lang.String\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"name\",");
json.append("			\"type\" : \"java.lang.String\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"category\",");
json.append("			\"type\" : \"com.google.appengine.api.datastore.Key\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"price\",");
json.append("			\"type\" : \"java.lang.Integer\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		}");
json.append("	],");
json.append("	\"actions\" : [");
json.append("		{");
json.append("			\"name\" : \"createCatalog\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : true,");
json.append("			\"isAsync\" : null,");
json.append("			\"accessible\" : [],");
json.append("			\"params\" : [");
json.append("			],");
json.append("			\"returnType\" : \"java.util.List<app.Product>\"");
json.append("		}");
json.append("	]");
json.append("}");

return (new Gson()).fromJson(json.toString(), EntityDef.class);
}
}
