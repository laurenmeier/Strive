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
json.append("			\"name\" : \"user\",");
json.append("			\"type\" : \"com.google.appengine.api.datastore.Key\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"description\",");
json.append("			\"type\" : \"java.lang.String\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"cost\",");
json.append("			\"type\" : \"java.lang.Double\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"image\",");
json.append("			\"type\" : \"java.lang.String\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"monday\",");
json.append("			\"type\" : \"java.lang.Boolean\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"tuesday\",");
json.append("			\"type\" : \"java.lang.Boolean\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"wednesday\",");
json.append("			\"type\" : \"java.lang.Boolean\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"thursday\",");
json.append("			\"type\" : \"java.lang.Boolean\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"friday\",");
json.append("			\"type\" : \"java.lang.Boolean\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"saturday\",");
json.append("			\"type\" : \"java.lang.Boolean\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		},");
json.append("		{");
json.append("			\"name\" : \"sunday\",");
json.append("			\"type\" : \"java.lang.Boolean\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false");
json.append("		}");
json.append("	],");
json.append("	\"actions\" : [");
json.append("		{");
json.append("			\"name\" : \"book\",");
json.append("			\"isPublic\" : true,");
json.append("			\"isStatic\" : false,");
json.append("			\"isAsync\" : null,");
json.append("			\"accessible\" : [\"USER\"],");
json.append("			\"params\" : [");
json.append("			],");
json.append("			\"returnType\" : \"void\"");
json.append("		}");
json.append("	]");
json.append("}");

return (new Gson()).fromJson(json.toString(), EntityDef.class);
}
}
