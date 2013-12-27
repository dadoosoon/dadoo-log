/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.log;

import im.dadoo.log.type.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    content.put("message", ex.getMessage());
		content.put("description", description);
    StringBuilder sb = new StringBuilder();
    List<String> trace = new ArrayList<String>();
    for (StackTraceElement e : ex.getStackTrace()) {
      trace.add(e.toString());
		}
    content.put("trace", trace);
    return new Log(serviceName, Type.EXCEPTION, System.currentTimeMillis(), content);
  }
  
  public static Log makeVisitLog(String serviceName, String ip, int port, String method,
          Map<String,String> headers) {
    Map<String, Object> content = new HashMap<String, Object>();
    content.put("ip", ip);
    content.put("port", port);
    content.put("method", method);
    content.put("headers", headers);
    return new Log(serviceName, Type.VISIT, System.currentTimeMillis(), content);
  }
  public static Log makeTestLog(String serviceName, Object fill) {
    Map<String, Object> content = new HashMap<String, Object>();
    content.put("fill", fill);
    return new Log(serviceName, Type.TEST, System.currentTimeMillis(), content);
  }
  
}
