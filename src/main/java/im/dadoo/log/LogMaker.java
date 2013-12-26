/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.log;

import im.dadoo.log.type.Type;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author codekitten
 */
public final class LogMaker {
  
  public static Log makeFunctionLog(String serviceName, String functionName, 
          Object[] args, Object ret, Long time) {
    Map<String, Object> content = new HashMap<String, Object>();
		content.put("functionName", functionName);
		content.put("args", args);
		content.put("ret", ret);
		content.put("time", time);
    return new Log(serviceName, Type.FUNCTION, System.currentTimeMillis(), content);
  }
  
  public static Log makeExceptionLog(String serviceName, String description, Exception ex) {
    Map<String, Object> content = new HashMap<String, Object>();
		content.put("class", ex.getClass().getName());
		content.put("description", description);
    StringBuilder sb = new StringBuilder();
    for (StackTraceElement e : ex.getStackTrace()) {
			sb.append(e.toString()).append(System.getProperty("line.separator"));
		}
    content.put("trace", sb.toString());
    return new Log(serviceName, Type.EXCEPTION, System.currentTimeMillis(), content);
  }
  
  public static Log makeTestLog(String serviceName, Object fill) {
    Map<String, Object> content = new HashMap<String, Object>();
    content.put("fill", fill);
    return new Log(serviceName, Type.TEST, System.currentTimeMillis(), content);
  }
}
