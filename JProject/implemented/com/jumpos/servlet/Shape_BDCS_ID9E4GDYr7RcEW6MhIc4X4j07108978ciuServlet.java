
package com.jumpos.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import com.alibaba.fastjson.JSON;
import com.june.common.model.values.AbstractPageValues;
import com.june.generated.view.Shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu;
import com.june.util.Json;

@WebServlet("/shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu")
public class Shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciuServlet extends AbstractFacesServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FacesContext context = getFacesContext(request, response);
		Shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu shape = 
				(Shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu)getBean("shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu", context);
		
		String id = request.getParameter("id");
		System.out.println("Object Id:"+id);
		
		if("1".equals(request.getParameter("show"))){
			Json json = new Json();
			json.setId(id);
			json.setSuccess(true);
			json.setUrl("shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu.htm");
			json.setObj(shape.getPageOutput());
			String callback = request.getParameter("callback");
			if(callback != null){
				response.getWriter().print(callback+"("+JSON.toJSONString(json)+")");	
			}
			else{
				response.getWriter().print(JSON.toJSONString(json));	
			}			
		}else{
			
			AbstractPageValues pagValue = shape.getPageValue();

			Enumeration<String> paramNames = request.getParameterNames();

			Map<String, List> objectMap = new HashMap<String, List>();

			Map<String, String> listValueMap = new HashMap<String, String>();

			try {
				while (paramNames.hasMoreElements()) {
					String paramName = paramNames.nextElement();

					if (paramName.contains(".")) {

						listValueMap.put(paramName,
								request.getParameter(paramName));

					} else {

						if (PropertyUtils.isWriteable(pagValue, paramName)) {
							PropertyUtils.setProperty(pagValue, paramName,
									request.getParameter(paramName));
						}
					}

				}

				for (Iterator<String> iterator = listValueMap.keySet()
						.iterator(); iterator.hasNext();) {

					String paramName = iterator.next();

					String[] str = StringUtils.split(paramName, ".");

					String[] values = StringUtils.splitPreserveAllTokens(listValueMap.get(paramName),",");

					for (int i = 0; i < values.length; i++) {

						if (objectMap.containsKey(str[0]) == false) {

							Class objClass = PropertyUtils.getPropertyType(
									pagValue, str[0]);

							if (ClassUtils.isAssignable(objClass, List.class)) {
								Field field = FieldUtils.getField(
										pagValue.getClass(), str[0],true);

								Type fc = field.getGenericType();

								if (fc instanceof ParameterizedType) // ??3??????????????????
								{
									ParameterizedType pt = (ParameterizedType) fc;

									Class genericClazz = (Class) pt
											.getActualTypeArguments()[0]; // ??4??
																			// ??????????class???????
									List objArray = new ArrayList();

									for (int j = 0; j < values.length; j++) {
										objArray.add(genericClazz.newInstance());

									}

									objectMap.put(str[0], objArray);
								}

							}

						}

						if (PropertyUtils.isWriteable(objectMap.get(str[0])
								.get(i), str[1])) {
							// request.getParameterValues("")
							PropertyUtils.setProperty(objectMap.get(str[0])
									.get(i), str[1], values[i]);
						}
					}
				}

				for (Iterator<String> iterator = objectMap.keySet().iterator(); iterator
						.hasNext();) {
					String key = iterator.next();
					PropertyUtils.setProperty(pagValue, key,
							objectMap.get(key));
				}

			} catch (Exception e) {
				throw new ServletException(e);
			}
			
			String url = shape.getSubmitAction().perform().replace(".xhtml", "");
			url = url.substring(0,url.indexOf("?"));
			if(url.indexOf("_confirm") != -1){
				url = "confirm";
			}
			Json json = new Json();
			json.setId(id);
			json.setSuccess(true);
			json.setUrl(url);
			String callback = request.getParameter("callback");
			response.getWriter().print(callback+"("+JSON.toJSONString(json)+")");		
		}
	}

}


